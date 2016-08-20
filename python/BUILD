# A python_library defines a reusable piece of Python code; this one we
# will share between the client and server, and test it below.
python_library(
    name = 'kitten_lib',
    srcs = ['kitten_lib.py'],
    deps = [
        '//proto:kitten',
        '//third_party/python:grpc',
    ],
)

# A python_binary builds a pex, a self-contained Python archive with
# third-party dependencies included. These can be deployed and run easily.
# See https://github.com/pantsbuild/pex for more general information about
# pexes and how they work and what they're useful for.
python_binary(
    name = 'client',
    main = 'client.py',
    deps = [
        ':kitten_lib',
        '//proto:kitten',
        '//third_party/python:gflags',
    ],
    visibility = ['PUBLIC'],
)

python_binary(
    name = 'server',
    main = 'server.py',
    deps = [
        ':kitten_lib',
        '//proto:kitten',
        '//third_party/python:gflags',
    ],
    visibility = ['PUBLIC'],
)

# A python_test also builds a pex, but is typically executed through
# plz test which runs all the tests in it and produces the results.
python_test(
    name = 'kitten_test',
    srcs = ['kitten_test.py'],
    deps = [
        ':kitten_lib',
    ],
)
