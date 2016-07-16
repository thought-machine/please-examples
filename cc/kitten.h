#ifndef _CC_KITTEN_H
#define _CC_KITTEN_H

#include <string>
#include "proto/kitten.pb.h"

namespace thought_machine {

// Provides the standard kitten that this server has.
Kitten ProvideKitten();

// Retrieves a kitten from the remote server.
Kitten GetKitten(const std::string& port, Breed breed);

}  // namespace thought_machine

#endif  // _CC_KITTEN_H
