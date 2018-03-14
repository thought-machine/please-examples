# This says that all targets in this package that don't specify otherwise
# will be visible to the whole repo.
# This is often useful for third-party packages like this where we expect
# anyone to use them.
package(default_visibility = ['PUBLIC'])

# go_get invokes, not unsurprisingly, 'go get' to fetch a third-party package.
# Note that we can specify Git revisions or tags to pin them to a particular version.
go_get(
    name = 'grpc',
    exported_deps = [':net'],
    get = 'google.golang.org/grpc',
    install = [
        '',
        'balancer',
        'balancer/base',
        'balancer/roundrobin',
        'codes',
        'connectivity',
        'credentials',
        'encoding',
        'encoding/gzip',
        'encoding/proto',
        'grpclb/grpc_lb_v1/messages',
        'grpclog',
        'health',
        'health/grpc_health_v1',
        'internal',
        'keepalive',
        'metadata',
        'naming',
        'peer',
        'resolver',
        'resolver/dns',
        'resolver/passthrough',
        'stats',
        'status',
        'tap',
        'transport',
    ],
    revision = 'v1.10.0',
    deps = [
        ':protobuf',
        ':rpcstatus',
    ],
)

go_get(
    name = 'net',
    get = 'golang.org/x/net/...',
    revision = '136a25c244d3019482a795d728110278d6ba09a4',
    deps = [
        ':terminal',
        ':text',
    ],
)

go_get(
    name = 'terminal',
    get = 'golang.org/x/crypto/ssh/terminal',
    revision = '7b85b097bf7527677d54d3220065e966a0e3b613',
)

go_get(
    name = 'text',
    get = 'golang.org/x/text/...',
    revision = '4e4a3210bb54bb31f6ab2cdca2edcc0b50c420c1',
    deps = [
        ':tools',
    ],
)

go_get(
    name = 'tools',
    get = 'golang.org/x/tools',
    install = [
        'cover',
    ],
    revision = '2ae76fd1560b622911f444c1e66b70a857e1de67',
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
    revision = '130e6b02ab059e7b717a096f397c5b60111cae74',
    deps = [
        ':protobuf',
    ],
)

go_get(
    name = 'protobuf',
    get = 'github.com/golang/protobuf/...',
    revision = '130e6b02ab059e7b717a096f397c5b60111cae74',
)

go_get(
    name = 'rpcstatus',
    get = 'google.golang.org/genproto/googleapis/rpc/status',
    revision = '2b5a72b8730b0b16380010cfe5286c42108d88e7',
    deps = [':protobuf'],
)

go_get(
    name = 'testify',
    get = 'github.com/stretchr/testify',
    install = [
        'assert',
        'require',
        'vendor/github.com/davecgh/go-spew/spew',
        'vendor/github.com/pmezard/go-difflib/difflib',
    ],
    revision = 'f390dcf405f7b83c997eac1b06768bb9f44dec18',
    # This means that this library will only be able to be used by tests
    # (go_test rules and so forth). We'd be unlikely to use testify in
    # production code, but it can be useful to enforce these
    # things so nobody introduces such a dependency by accident.
    test_only = True,
    deps = [':spew'],
)

go_get(
    name = 'spew',
    get = 'github.com/davecgh/go-spew/spew',
    revision = 'ecdeabc65495df2dec95d7c4a4c3e021903035e5',
    test_only = True,
)

go_get(
    name = 'go-flags',
    get = 'github.com/jessevdk/go-flags',
    revision = 'v1.3.0',
)
