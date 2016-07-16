# This says that all targets in this package that don't specify otherwise
# will be visible to the whole repo.
# This is often useful for third-party packages like this where we expect
# anyone to use them.
package(default_visibility = ['PUBLIC'])

# maven_jar fetches a single .jar file from Maven.
# Note that it doesn't fetch dependencies, we have to specify them explicitly.
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

# maven_jars fetches a library and its transitive dependencies from Maven.
# A little fiddling is needed here to handle dependencies that have no
# sources available.
# TODO(pebers): Revisit this once issue #120 is resolved.
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
