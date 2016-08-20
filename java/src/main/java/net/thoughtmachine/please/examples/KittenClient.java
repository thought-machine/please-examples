package net.thoughtmachine.please.examples;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

class KittenClient {

  @Option(name = "--port", usage = "Port to connect to")
  private int port = 9232;

  @Option(name = "--breed", usage = "Breed of kitten to request")
  private KittenProto.Breed breed;

  void run(String[] args) throws Exception {
    CmdLineParser parser = new CmdLineParser(this);
    parser.parseArgument(args);
    KittenProto.Kitten kitten = new Kittens().getKitten(port, breed);
    System.out.printf("Received a kitten:\n%s\n", kitten.toString());
  }

  public static void main(String[] args) throws Exception {
    new KittenClient().run(args);
  }
}
