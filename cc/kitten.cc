#include "cc/kitten.h"

#include <memory>
#include <string>
#include <grpc++/grpc++.h>
#include "proto/kitten.grpc.pb.h"

using grpc::Channel;
using grpc::ClientContext;
using grpc::Status;

namespace thought_machine {

Kitten ProvideKitten() {
  Kitten kitten;
  kitten.set_name("Fluffy");
  kitten.set_breed(BENGAL);
  kitten.set_weight(1.5);
  kitten.set_age(2);
  return kitten;
}

Kitten GetKitten(const std::string& port, Breed breed) {
  GetKittenRequest request;
  if (breed) {
    request.set_breed(breed);
  }

  std::shared_ptr<Channel> channel = grpc::CreateChannel(
      "localhost:" + port, grpc::InsecureChannelCredentials());
  std::unique_ptr<PetShop::Stub> stub(PetShop::NewStub(channel));

  GetKittenResponse response;
  ClientContext context;
  Status status = stub->GetKitten(&context, request, &response);
  if (!status.ok()) {
    fprintf(stderr, "Failed to get kitten :(\n");
    exit(1);
  }
  return response.kitten();
}

}  // namespace thought_machine
