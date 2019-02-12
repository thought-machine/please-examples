# A go_binary builds a self-contained Go executable.
# It is possible to put these in the same directory as the go_library rule,
# but keeping them separate plays a little nicer with normal Go tools.
go_binary(
    name='server',
    srcs=['server.go'],
    deps=[
        '//go/lib',
        '//proto:kitten',
        '//third_party/go:go-flags',
        '//third_party/go:grpc',
    ],
    visibility=['PUBLIC'],
)
