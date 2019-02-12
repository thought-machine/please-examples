# A cc_library compiles a reusable piece of C++ code into an object file
# (or files) and archives them.
cc_library(
    name='kitten_lib',
    srcs=[
        'flags.cc',
        'kitten.cc',
    ],
    hdrs=[
        'flags.h',
        'kitten.h',
    ],
    deps=[
        '//proto:kitten',
    ],
)

# A cc_binary links dependent C++ libraries into a standalone binary.
# The process of building C++ code is complex and there are a number of options
# on these rules to support it; we won't go into detail here, but note that
# we don't have to pass any linker flags like -lprotobuf or -lgrpc; those are set
# inside //proto:kitten and inherited by this rule.
cc_binary(
    name='client',
    srcs=['client.cc'],
    deps=[
        ':kitten_lib',
        '//proto:kitten',
    ],
    visibility = ['PUBLIC'],
)

cc_binary(
    name='server',
    srcs=['server.cc'],
    deps=[
        ':kitten_lib',
        '//proto:kitten',
    ],
    visibility=['PUBLIC'],
)

# A cc_test defines a C++ test using UnitTest++ for the test cases.
# If you'd prefer not to use UnitTest++ you can supply your own test_main
# and link against whatever test library you'd like.
cc_test(
    name='kitten_test',
    srcs=[
        'flags_test.cc',
        'kitten_test.cc',
    ],
    # Build rules can have arbitrary labels applied to them.
    # Most of them are up to the user to define, but 'manual' is special;
    # it means the test is only run when explicitly requested.
    # We do that here because the various packages of UnitTest++ are very
    # inconsistent about their install locations, and we don't want this
    # entire repo to have a dependency on it. If you've got it installed
    # and want to try it out, just run `plz test //cc:kitten_test`
    labels=['manual'],
    deps=[
        ':kitten_lib',
        '//proto:kitten',
    ],
)
