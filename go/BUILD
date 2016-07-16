# A go_library is a collection of Go files compiled into one package.
# Typically you'd have one of these per directory, corresponding to the
# Go package structure.
go_library(
    name = 'kittenlib',
    srcs = ['kitten.go'],
    deps = [
        '//proto:kitten',
        '//third_party/go:grpc',
    ],
)

# A go_binary builds a self-contained Go executable.
# Note that unlike normal 'go build', there is no requirement to
# necessarily have these in their own packages.
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

# A go_test is similar to a go_binary in that it builds a self-contained
# executable, but it's typically run through 'plz test' to run all its
# tests and report their results.
go_test(
    name = 'kitten_test',
    srcs = ['kitten_test.go'],
    deps = [
        ':kittenlib',
        '//third_party/go:testify',
    ],
)
