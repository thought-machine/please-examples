# This says that all targets in this package that don't specify otherwise
# will be visible to the whole repo.
# This is often useful for third-party packages like this where we expect
# anyone to use them.
package(default_visibility = ['PUBLIC'])

# pip_library invokes pip to install a third-party library for us.
# Note that dependencies have to be specified explicitly.
pip_library(
    name = 'protobuf',
    version = '3.4.0',
    outs = ['google'],
    deps = [
        ':six',
    ],
)

pip_library(
    name = 'grpc',
    package_name = 'grpcio',
    version = '1.6.0',
)

pip_library(
    name = 'six',
    version = '1.10.0',
    # If the library doesn't output into a directory the same as the
    # rule name, we have to tell Please what it's supposed to output here.
    outs = ['six.py'],
)

pip_library(
    name = 'gflags',
    package_name = 'python-gflags',
    version = '3.1.1',
)
