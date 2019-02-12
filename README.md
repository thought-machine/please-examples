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

You can build everything and run all the tests by simply running
`./pleasew test`, although see below for notes on language support.

Dependencies
------------

Note that you will need to have the gRPC codegen plugins installed
for C++ and Python in order to run those tests. Currently that requires
compiling and installing it (see [their instructions](https://github.com/grpc/grpc/blob/v1.18.0/src/cpp/README.md)
for details) which can be a bit involved.

If you'd like to get a feeling for Please without that, it's possible
to run just the Go and Java tests without global dependencies (other than
having Go and a JDK installed, of course) by running the following:
```
./pleasew test -i go -i java -o proto.language:go,java
```
or if you want to run just a single language at a time:
```
./pleasew test -i go -o proto.language:go
./pleasew test -i java -o proto.language:java
```
