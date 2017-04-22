package lib

import (
	"testing"

	"github.com/stretchr/testify/assert"

	pb "proto/kitten"
)

func TestProvideKitten(t *testing.T) {
	kitten := ProvideKitten()
	assert.Equal(t, pb.Breed_RUSSIAN_BLUE, kitten.Breed)
	assert.Equal(t, "Mighty Paws", kitten.Name)
}
