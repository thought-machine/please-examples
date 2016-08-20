#ifndef _CC_FLAGS_H
#define _CC_FLAGS_H

#include <string>

namespace thought_machine {

// Poor man's flag parsing, so we don't have to rely on gflags or similar being present.
// Obviously it would be nicer to use a real library, but we don't want to make that
// a hard requirement to build this repo since there isn't a very convenient way of
// fetching C++ libraries.
// Returns NULL if the flag can't be found.
// Only works with separated options, doesn't support --flag=value format.
const char* GetFlag(const char** begin, const char** end, const std::string& flag);

}  // namespace thought_machine

#endif  // _CC_FLAGS_H
