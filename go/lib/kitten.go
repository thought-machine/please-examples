package lib

import (
	"fmt"
	"log"
	"time"

	"golang.org/x/net/context"
	"google.golang.org/grpc"

	pb "proto/kitten"
)

// PetShopServer is the server implementation.
type PetShopServer struct{}

// GetKitten implements the proto RPC call.
func (s *PetShopServer) GetKitten(ctx context.Context, req *pb.GetKittenRequest) (*pb.GetKittenResponse, error) {
	return &pb.GetKittenResponse{Kitten: ProvideKitten()}, nil
}

// FetchKitten contacts the remote server to retrieve a kitten.
func FetchKitten(request *pb.GetKittenRequest, port int) *pb.GetKittenResponse {
	address := fmt.Sprintf("localhost:%d", port)
	conn, err := grpc.Dial(address, grpc.WithInsecure())
	if err != nil {
		log.Fatalf("Failed to connect to %s: %s", address, err)
	}
	defer conn.Close()
	client := pb.NewPetShopClient(conn)
	ctx, cancel := context.WithTimeout(context.Background(), 5*time.Second)
	defer cancel()
	// Don't fail fast, it's awkward in the integration tests if servers aren't
	// ready yet, especially since Go tends to be faster initialising than at
	// least some of the others.
	response, err := client.GetKitten(ctx, request, grpc.FailFast(false))
	if err != nil {
		log.Fatalf("Failed to fetch kitten: %s", err)
	}
	return response
}

// GetKitten returns a kitten, optionally of the given breed.
func GetKitten(port int, breed pb.Breed) *pb.Kitten {
	request := pb.GetKittenRequest{}
	if breed != pb.Breed_HALP {
		request.Breed = breed
	}
	response := FetchKitten(&request, port)
	if breed != pb.Breed_HALP && response.Kitten.Breed != breed {
		log.Fatalf("Unexpected breed returned: %s", response.Kitten.Breed)
	}
	return response.Kitten
}

func ProvideKitten() *pb.Kitten {
	return &pb.Kitten{
		Name:   "Mighty Paws",
		Breed:  pb.Breed_RUSSIAN_BLUE,
		Age:    5,
		Weight: 2.4,
	}
}
