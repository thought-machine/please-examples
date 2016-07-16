package(default_visibility = ['PUBLIC'])

go_get(
    name = 'grpc',
    get = 'google.golang.org/grpc',
    revision = '461dac99975b211ed3eda7eb45b997d82da4345a',
    install = ['google.golang.org/grpc/health'],
    deps = [
        ':protobuf',
    ],
)

go_get(
    name = 'protoc-gen-go',
    get = 'github.com/golang/protobuf/protoc-gen-go',
    revision = '3852dcfda249c2097355a6aabb199a28d97b30df',
    binary = True,
)

go_get(
    name = 'protobuf',
    get = 'github.com/golang/protobuf/proto',
    revision = '3852dcfda249c2097355a6aabb199a28d97b30df',
)

go_get(
    name = 'testify',
    get = 'github.com/stretchr/testify',
    revision = 'f390dcf405f7b83c997eac1b06768bb9f44dec18',
)

go_get(
    name = 'go-flags',
    get = 'github.com/jessevdk/go-flags',
    revision = '0a28dbe50f23d8fce6b016975b964cfe7b97a20a',
)
