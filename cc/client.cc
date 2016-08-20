#include "cc/flags.h"
#include "cc/kitten.h"
#include "proto/kitten.grpc.pb.h"

using thought_machine::GetFlag;

int main(int argc, const char** argv) {
  const char* port = GetFlag(argv, argv + argc, "--port");
  port = port ? port : "9232";
  const char* breed_flag = GetFlag(argv, argv + argc, "--breed");
  Breed breed = HALP;
  if (breed_flag && !Breed_Parse(breed_flag, &breed)) {
    fprintf(stderr, "Unknown breed: %s\n", breed_flag);
    exit(-1);
  }
  Kitten kitten = thought_machine::GetKitten(port, breed);
  printf("Received kitten:\n%s\n", kitten.DebugString().c_str());
  return 0;
}
