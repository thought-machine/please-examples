package net.thoughtmachine.please.examples;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;

class Kittens {

  public static KittenProto.Kitten provideKitten() {
    return KittenProto.Kitten.newBuilder()
        .setName("Speedy Hunter")
        .setBreed(KittenProto.Breed.PERSIAN)
        .setWeight(3.0f)
        .setAge(7)
        .build();
  }

  KittenProto.GetKittenResponse fetchKitten(KittenProto.GetKittenRequest request, int port) {
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", port)
        .usePlaintext(true)
        .build();
    PetShopGrpc.PetShopBlockingStub stub = PetShopGrpc.newBlockingStub(channel);
    try {
      return stub.getKitten(request);
    } catch (StatusRuntimeException ex) {
      throw new RuntimeException(ex);
    } finally {
      try {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
      } catch (InterruptedException ex) {
      }
    }
  }

  public KittenProto.Kitten getKitten(int port, KittenProto.Breed breed) {
    KittenProto.GetKittenRequest.Builder builder = KittenProto.GetKittenRequest.newBuilder();
    if (breed != null) {
      builder.setBreed(breed);
    }
    KittenProto.GetKittenResponse response = fetchKitten(builder.build(), port);
    if (breed != null && breed != response.getKitten().getBreed()) {
      throw new RuntimeException("Unexpected kitten breed: " + response.getKitten().getBreed().toString());
    }
    return response.getKitten();
  }

  public KittenProto.Kitten getKitten(int port) {
    return getKitten(port, null);
  }

}
