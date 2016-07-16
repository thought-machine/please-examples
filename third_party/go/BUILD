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
