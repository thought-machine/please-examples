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
    hash = "fb66d913ff0578553b2e28a3338cbbbe2657e6cfe0e98d939f23aea219daf508",
    sources = False,  # Not available
)

maven_jar(
    name = "protoc-gen-grpc-java",
    id = "io.grpc:protoc-gen-grpc-java:1.19.0",
    binary = True,
    hash = "9ded31f267def99004c27b96ea53c7d5e6d681741277fea8684edf6d4e4b9b3c",
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
    hash = "59721f0805e223d84b90677887d9ff567dc534d7c502ca903c0c2b17f05c116a",
    # This means that this library will only be able to be used by tests
    # (go_test rules and so forth). Obviously we'd be unlikely to use
    # junit in production code, but it can be useful to enforce these
    # things so nobody introduces such a dependency by accident.
    test_only = True,
)

maven_jar(
    name = "mockito",
    id = "org.mockito:mockito-all:1.10.19",
    hash = "d1a7a7ef14b3db5c0fc3e0a63a81b374b510afe85add9f7984b97911f4c70605",
    test_only = True,
)

maven_jar(
    name = "args4j",
    id = "args4j:args4j:2.32",
    hash = "85781fe21bd389c2d1e0d67c901dc19547a8840af87b9c7950bddb5847207cea",
)
