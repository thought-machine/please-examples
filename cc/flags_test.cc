#include <UnitTest++/UnitTest++.h>
#include "cc/flags.h"

namespace thought_machine {

TEST(flags) {
  const char* flags[] = {"--port", "9232", "--breed", "siamese"};
  CHECK_EQUAL("9232", GetFlag(flags, flags + 4, "--port"));
  CHECK_EQUAL("siamese", GetFlag(flags, flags + 4, "--breed"));
  CHECK_EQUAL((const char*)NULL, GetFlag(flags, flags + 4, "--wibble"));
}

}  // namespace thought_machine
