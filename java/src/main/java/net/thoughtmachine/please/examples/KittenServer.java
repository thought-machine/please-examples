package net.thoughtmachine.please.examples;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

class KittenServer {

  @Option(name = "--port", usage = "Port to serve on")
  private int port = 9232;

  Server server;

  private void serve() throws Exception {
    server = ServerBuilder.forPort(port)
        .addService(PetShopGrpc.bindService(new PetShopService()))
        .build()
        .start();
    System.out.printf("Server started, listening on %d\n", port);
    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        System.err.println("*** shutting down gRPC server since JVM is shutting down");
        KittenServer.this.stop();
        System.err.println("*** server shut down");
      }
    });
    server.awaitTermination();
  }

  private void stop() {
    if (server != null) {
      server.shutdown();
    }
  }

  public static void main(String[] args) throws Exception {
    KittenServer server = new KittenServer();
    CmdLineParser parser = new CmdLineParser(server);
    parser.parseArgument(args);
    server.serve();
  }

  private class PetShopService implements PetShopGrpc.PetShop {
    @Override
    public void getKitten(KittenProto.GetKittenRequest req,
        StreamObserver<KittenProto.GetKittenResponse> responseObserver) {
      KittenProto.GetKittenResponse response = KittenProto.GetKittenResponse.newBuilder()
          .setKitten(Kittens.provideKitten())
          .build();
      responseObserver.onNext(response);
      responseObserver.onCompleted();
    }
  }

}
