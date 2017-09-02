# Please examples [![Build Status](https://circleci.com/gh/thought-machine/please-examples.svg?style=shield)](https://circleci.com/gh/thought-machine/please-examples)
A small set of example projects for the Please build system.

There are examples for all natively supported languages (Go, Python, C++ and Java),
implementing a [gRPC](https://grpc.io) client and server for each language,
a library implementing their functionality and a test on it. Each of
them have the required set of third-party libraries which show how
those are written for each language.

There's also a set of integration tests pitting each client against
each server, which illustrate a more advanced use of custom build
rules and the ability to script things in BUILD files.
