FROM thoughtmachine/please_ubuntu:latest
MAINTAINER peter.ebden@gmail.com

# Install the gRPC C++ plugin. Currently there is no binary distribution
# so the only option is to compile from source, and the only way to really
# make that work is from git (it seems very hard to get a version of c-ares that
# will satisfy gRPC otherwise).
WORKDIR /tmp
RUN apt-get update && apt-get install -y build-essential autoconf libtool
RUN git clone -qb $(curl -fsSL https://grpc.io/release) https://github.com/grpc/grpc && \
    cd grpc && \
    git submodule update --init && \
    make && \
    make install && \
    rm -rf /tmp/grpc

# Need protobuf as well.
RUN curl -fsSL https://github.com/google/protobuf/releases/download/v3.4.0/protobuf-cpp-3.4.0.tar.gz | tar -xz && \
    cd protobuf-3.4.0 && \
    ./configure --prefix=/usr && \
    make && \
    make install && \
    rm -rf /tmp/protobuf-3.4.0
