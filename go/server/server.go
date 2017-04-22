package main

import (
	"fmt"
	"log"
	"net"
	"os"

	"github.com/jessevdk/go-flags"
	"google.golang.org/grpc"

	"go/kittenlib"
	pb "proto/kitten"
)

var opts struct {
	Port int `short:"p" long:"port" default:"9232" description:"Port to serve on"`
}

func main() {
	if _, err := flags.ParseArgs(&opts, os.Args); err != nil {
		os.Exit(1)
	}
	lis, err := net.Listen("tcp", fmt.Sprintf("localhost:%d", opts.Port))
	if err != nil {
		log.Fatalf("Failed to bind to port %d: %s", opts.Port, err)
	}
	s := grpc.NewServer()
	pb.RegisterPetShopServer(s, &kittenlib.PetShopServer{})
	fmt.Printf("Serving on port %d\n", opts.Port)
	s.Serve(lis)
}
