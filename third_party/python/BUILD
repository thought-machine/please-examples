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
    deps = [
        ':six',
    ],
)

pip_library(
    name = 'grpc',
    package_name = 'grpcio',
    version = '1.9.0',
    deps = [
        ':pkg_resources',
        ':six',
    ],
)

pip_library(
    name = 'pkg_resources',
    package_name = 'setuptools',
    version = '33.1.1',
)

pip_library(
    name = 'six',
    version = '1.10.0',
)

pip_library(
    name = 'gflags',
    package_name = 'python-gflags',
    version = '3.1.1',
)
