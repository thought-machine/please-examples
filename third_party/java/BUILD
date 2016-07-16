package(default_visibility = ['PUBLIC'])

maven_jar(
    name = 'protobuf',
    id = 'com.google.protobuf:protobuf-java:3.0.0-beta-3',
    hash = 'ed118aa0276005ca49b18a3a2b77eaacdec95680',  # Verify that we get what we're expecting.
    sources = False,  # Not available
)

maven_jar(
    name = 'protobuf-java-util',
    id = 'com.google.protobuf:protobuf-java-util:3.0.0-beta-3',
    hash = 'e7fb40f29053441632277d75952874b3e03bf68a',
    deps = [
        ':protobuf',
    ],
    sources = False,
)

maven_jars(
    name = 'grpc-all',
    id = 'io.grpc:grpc-all:0.15.0',
    exclude = [
        'protobuf-java',
        'protobuf-java-util',
    ],
    deps = [
        ':protobuf-java-util',
    ],
)
