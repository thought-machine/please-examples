python_library(
    name = 'kitten_lib',
    srcs = ['kitten_lib.py'],
    deps = [
        '//proto:kitten',
        '//third_party/python:grpc',
    ],
)

python_binary(
    name = 'client',
    main = 'client.py',
    deps = [
        ':kitten_lib',
        '//proto:kitten',
        '//third_party/python:gflags',
    ],
    zip_safe = False,  # Should not be needed after #119 is fixed
)

python_binary(
    name = 'server',
    main = 'server.py',
    deps = [
        ':kitten_lib',
        '//proto:kitten',
        '//third_party/python:gflags',
    ],
    zip_safe = False,
)

python_test(
    name = 'kitten_test',
    srcs = ['kitten_test.py'],
    deps = [
        ':kitten_lib',
    ],
)
