go_library(
    name = 'kittenlib',
    srcs = ['kitten.go'],
    deps = [
        '//proto:kitten',
        '//third_party/go:grpc',
    ],
)

go_test(
    name = 'kitten_test',
    srcs = ['kitten_test.go'],
    deps = [
        ':kittenlib',
        '//third_party/go:testify',
    ],
)

go_binary(
    name = 'client',
    main = 'client.go',
    deps = [
        ':kittenlib',
        '//proto:kitten',
        '//third_party/go:go-flags',
    ],
    visibility = ['PUBLIC'],
)

go_binary(
    name = 'server',
    main = 'server.go',
    deps = [
        ':kittenlib',
        '//proto:kitten',
        '//third_party/go:grpc',
        '//third_party/go:go-flags',
    ],
    visibility = ['PUBLIC'],
)
