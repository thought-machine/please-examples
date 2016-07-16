package net.thoughtmachine.please.examples;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class KittensTest {

  private static final int PORT = 80;  // doesn't matter.

  private Kittens kittens;

  @Before
  public void setUp() {
    // Mock this so we don't connect to a server.
    kittens = mock(Kittens.class);
    when(kittens.fetchKitten(any(KittenProto.GetKittenRequest.class), anyInt()))
        .thenReturn(KittenProto.GetKittenResponse.newBuilder()
            .setKitten(Kittens.provideKitten())
            .build());
    when(kittens.getKitten(anyInt(), any(KittenProto.Breed.class)))
        .thenCallRealMethod();
    when(kittens.getKitten(anyInt()))
        .thenCallRealMethod();
  }

  @Test
  public void testGetKitten() {
    KittenProto.Kitten kitten = kittens.getKitten(PORT);
    assertEquals("Speedy Hunter", kitten.getName());
    assertEquals(KittenProto.Breed.PERSIAN, kitten.getBreed());
  }

  @Test(expected = RuntimeException.class)
  public void testGetKittenOfWrongBreed() {
    kittens.getKitten(PORT, KittenProto.Breed.CORNISH_REX);
  }
}
