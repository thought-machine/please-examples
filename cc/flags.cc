#include <algorithm>
#include <string>

namespace thought_machine {

const char* GetFlag(const char** begin, const char** end, const std::string& flag) {
    const char** it = std::find(begin, end, flag);
    if (it != end && ++it != end) {
        return *it;
    }
    return NULL;
}

}  // namespace thought_machine
