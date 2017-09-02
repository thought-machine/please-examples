# This says that all targets in this package that don't specify otherwise
# will be visible to the whole repo.
# This is often useful for third-party packages like this where we expect
# anyone to use them.
package(default_visibility = ['PUBLIC'])

# go_get invokes, not unsurprisingly, 'go get' to fetch a third-party package.
# Note that we can specify Git revisions or tags to pin them to a particular version.
go_get(
    name = 'grpc',
    get = 'google.golang.org/grpc',
    revision = 'v1.5.0',
    deps = [
        ':protobuf',
    ],
)

go_get(
    name = 'protoc-gen-go',
    # This produces an executable tool that we use elsewhere;
    # marking this makes it easy to use in other rules or through
    # plz run since it will only produce a single output.
    # Other rules would invoke it via a command like
    # $(exe //third_party/go:protoc-gen-go) which Please will
    # expand into the appropriate location.
    binary = True,
    get = 'github.com/golang/protobuf/protoc-gen-go',
    revision = 'v1.5.0',
)

go_get(
    name = 'protobuf',
    get = 'github.com/golang/protobuf/proto',
    revision = '17ce1425424ab154092bbb43af630bd647f3bb0d',
)

go_get(
    name = 'testify',
    get = 'github.com/stretchr/testify',
    revision = 'f390dcf405f7b83c997eac1b06768bb9f44dec18',
    # This means that this library will only be able to be used by tests
    # (go_test rules and so forth). We'd be unlikely to use testify in
    # production code, but it can be useful to enforce these
    # things so nobody introduces such a dependency by accident.
    test_only = True,
)

go_get(
    name = 'go-flags',
    get = 'github.com/jessevdk/go-flags',
    revision = '0a28dbe50f23d8fce6b016975b964cfe7b97a20a',
)
