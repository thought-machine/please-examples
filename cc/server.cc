#include <memory>
#include <string>
#include <grpc++/grpc++.h>
#include "cc/flags.h"
#include "cc/kitten.h"
#include "proto/kitten.grpc.pb.h"

using grpc::Server;
using grpc::ServerBuilder;
using grpc::ServerContext;
using grpc::Status;
using thought_machine::GetFlag;

class PetShopService : public PetShop::Service {
  Status GetKitten(ServerContext*,
                   const GetKittenRequest*,
                   GetKittenResponse* reply) {
    reply->mutable_kitten()->CopyFrom(thought_machine::ProvideKitten());
    return Status::OK;
  }
};

int main(int argc, const char** argv) {
  const char* port_flag = GetFlag(argv, argv + argc, "--port");
  std::string server_address("localhost:");
  server_address += port_flag ? port_flag : "9232";

  PetShopService service;
  ServerBuilder builder;
  builder.AddListeningPort(server_address, grpc::InsecureServerCredentials());
  builder.RegisterService(&service);
  std::unique_ptr<Server> server(builder.BuildAndStart());
  fprintf(stderr, "Serving on %s\n", server_address.c_str());
  server->Wait();  // Probably won't ever return.
  return 0;
}
