# A filegroup is a rule that simply collects files and makes them available
# to other rules. You can't use files that are 'owned' by another BUILD file
# without one.
filegroup(
    name = 'integration_test',
    srcs = ['integration_test.build_defs'],
    visibility = ['PUBLIC'],
)
