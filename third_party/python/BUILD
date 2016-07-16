package(default_visibility = ['PUBLIC'])

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
)

pip_library(
    name = 'six',
    version = '1.10.0',
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
