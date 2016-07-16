# A java_library compiles a number of Java files into .class
# files and binds them up in a small .jar.
java_library(
    name = 'lib',
    # glob() is useful for cases like this where we want to collect
    # multiple source files of a type, often in a directory, and we
    # don't want to have to list them all explicitly.
    srcs = glob(['src/main/java/**/*.java']),
    deps = [
        '//proto:kitten',
        '//third_party/java:args4j',
        '//third_party/java:grpc-all',
    ],
)

# A java_binary concatenates together all the libraries it depends on
# into one uber-jar that can be deployed & run easily.
java_binary(
    name = 'client',
    # This tells it what it should use for the Main-Class attribute in the manifest.
    main_class = 'net.thoughtmachine.please.examples.KittenClient',
    deps = [
        ':lib',
    ],
    # Setting this marks the .jar as executable and puts a shebang on the beginning
    # so you can run it directly in a shell. It's not the default for historical
    # reasons which really aren't very interesting.
    self_executable = True,
    visibility = ['PUBLIC'],
)

java_binary(
    name = 'server',
    main_class = 'net.thoughtmachine.please.examples.KittenServer',
    deps = [
        ':lib',
    ],
    self_executable = True,
    visibility = ['PUBLIC'],
)

# A java_test is similar to a java_binary but is run through 'plz test'
# which runs all its tests and collects the results.
java_test(
    name = 'kitten_test',
    srcs = glob(['src/test/java/**/*.java']),
    deps = [
        ':lib',
        '//proto:kitten',
        '//third_party/java:junit',
        '//third_party/java:mockito',
    ],
)
