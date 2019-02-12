# grpc_library compiles a .proto file with rpc endpoints into
# language-specific implementations. It creates a series of internal rules
# for each language so you don't need to add another go_library etc to make
# use of the output, and each language will automatically depend on the
# appropriate implementation.
#
# See https://developers.google.com/protocol-buffers and http://grpc.io for
# general information about gRPC and protobufs.
grpc_library(
    name='kitten',
    srcs=['kitten.proto'],
    visibility=['PUBLIC'],
)
