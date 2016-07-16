# This says that all targets in this package that don't specify otherwise
# will be visible to the whole repo.
# This is often useful for third-party packages like this where we expect
# anyone to use them.
package(default_visibility = ['PUBLIC'])

# pip_library invokes pip to install a third-party library for us.
# Note that dependencies have to be specified explicitly.
pip_library(
    name = 'protobuf',
    outs = ['google'],
    version = '3.0.0b3',
    deps = [
        ':six',
    ],
)

pip_library(
    name = 'grpc',
    package_name = 'grpcio',
    version = '0.15.0',
    deps = [':enum', ':futures'],
    zip_safe = False,  # cygrpc.so can't be imported from inside a .pex.
)

pip_library(
    name = 'six',
    version = '1.10.0',
    # If the library doesn't output into a directory the same as the
    # rule name, we have to tell Please what it's supposed to output here.
    outs = ['six.py'],
)

pip_library(
    name = 'enum',
    version = '1.1.6',
    package_name = 'enum34',
)

pip_library(
    name = 'futures',
    version = '3.0.5',
    outs = ['concurrent']
)

pip_library(
    name = 'gflags',
    version = '3.0.5',
    package_name = 'python-gflags',
)
