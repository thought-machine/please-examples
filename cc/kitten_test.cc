#include <UnitTest++/UnitTest++.h>
#include "cc/kitten.h"

namespace thought_machine {

TEST(provide_kitten) {
  Kitten kitten = ProvideKitten();
  CHECK_EQUAL("Fluffy", kitten.name());
  CHECK_EQUAL(BENGAL, kitten.breed());
}

}  // namespace thought_machine
