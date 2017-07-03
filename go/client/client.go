package main

import (
	"fmt"
	"log"
	"os"

	"github.com/jessevdk/go-flags"

	"go/lib"
	pb "proto/kitten"
)

var opts struct {
	Port  int    `short:"p" long:"port" default:"9232" description:"Port to communicate with server on"`
	Breed string `short:"b" long:"breed" default:"HALP" description:"Breed of kitten to request"`
}

func main() {
	if _, err := flags.ParseArgs(&opts, os.Args); err != nil {
		os.Exit(1)
	}
	breed, present := pb.Breed_value[opts.Breed]
	if !present {
		log.Fatalf("Unknown breed: %s", breed)
	}
	kitten := lib.GetKitten(opts.Port, pb.Breed(breed))
	fmt.Printf("Received a kitten:\n%s\n", kitten)
}
