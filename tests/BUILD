# subinclude loads build rules from another file (specifically, from the
# output of another build rule). The rules appear directly in
# the current global namespace, so it's a bit more akin to a C include
# than a Python import.
subinclude('//build_defs:integration_test')

# This file demonstrates how to do some slightly more powerful things
# with Please; here we generate a set of integration tests between
# all the client-server pairs.

# Each server will only supply one kitten, so we match up breeds here.
BREEDS = {
    'python': 'CORNISH_REX',
    'java': 'PERSIAN',
    'cc': 'BENGAL',
    'go': 'RUSSIAN_BLUE',
}

# Better make sure they all choose a different port...
port = 9000

for server, breed in sorted(BREEDS.items()):
    for client in sorted(BREEDS.keys()):
        # This is a new build rule that was loaded in the subinclude() call earlier.
        # See build_defs/integration_test.build_defs if you're curious about how
        # it's defined.
        integration_test(
            client=client,
            server=server,
            port=port,
            breed=breed,
        )
        port += 1
