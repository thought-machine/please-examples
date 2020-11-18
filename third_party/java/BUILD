# This says that all targets in this package that don't specify otherwise
# will be visible to the whole repo.
# This is often useful for third-party packages like this where we expect
# anyone to use them.
package(default_visibility = ["PUBLIC"])

# This fetches new build rules from an external source.
# In this case maven_jars, which we use below to fetch all transitive dependencies
# of a Maven package.
subinclude("///pleasings//java:maven_jars")

# This is temporarily necessary to work around a small bug.
package(maven_tool = "///pleasings//java/maven:please_maven")

# maven_jar fetches a single .jar file from Maven.
# Note that it doesn't fetch dependencies, we have to specify them explicitly.
maven_jar(
    name = "protobuf",
    id = "com.google.protobuf:protobuf-java:3.6.1",
    # Please can hash-verify downloaded artifacts so you're sure you get
    # what you're expecting. This is particularly useful when fetching things
    # from external repositories.
    hash = "36cca737d773510e477e5717c86a6383e3e3bd08",
    sources = False,  # Not available
)

maven_jar(
    name = "protoc-gen-grpc-java",
    id = "io.grpc:protoc-gen-grpc-java:1.19.0",
    binary = True,
    hash = "c0b835f7f669dea60e91b01adcbef466290052af",
)

# maven_jars fetches a library and its transitive dependencies from Maven.
maven_jars(
    name = "grpc-all",
    id = "io.grpc:grpc-all:1.19.0",
    # This excludes a couple of dependencies that are marked with the wrong scope.
    exclude = [
        "junit",
        "mockito-core",
    ],
)

maven_jar(
    name = "junit",
    id = "junit:junit:4.12",
    hash = "sha1: a791201ac8a3d2a251045a52e264de01343ad2df",
    # This means that this library will only be able to be used by tests
    # (go_test rules and so forth). Obviously we'd be unlikely to use
    # junit in production code, but it can be useful to enforce these
    # things so nobody introduces such a dependency by accident.
    test_only = True,
)

maven_jar(
    name = "mockito",
    id = "org.mockito:mockito-all:1.10.19",
    hash = "e93ceaea4cf704350fbb2a450ddbb7b4e3e062e3",
    test_only = True,
)

maven_jar(
    name = "args4j",
    id = "args4j:args4j:2.32",
    hash = "a08fb9a7217df438872f27936058f594eab29396",
)
