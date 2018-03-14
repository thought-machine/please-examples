import sys
import time
from concurrent import futures

from third_party.python import gflags as flags
from third_party.python import grpc
from proto import kitten_pb2, kitten_pb2_grpc
from python.kitten_lib import provide_kitten


flags.DEFINE_integer('port', 9232, 'The port to serve on')
FLAGS = flags.FLAGS


class PetShop(kitten_pb2_grpc.PetShopServicer):

    def GetKitten(self, request, context):
        return kitten_pb2.GetKittenResponse(kitten=provide_kitten())


def main():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    kitten_pb2_grpc.add_PetShopServicer_to_server(PetShop(), server)
    server.add_insecure_port("localhost:%s" % FLAGS.port)
    server.start()
    print('Serving on port %d' % FLAGS.port)
    try:
        while True:
            time.sleep(100000)
    except KeyboardInterrupt:
        server.stop(0)


if __name__ == '__main__':
    FLAGS(sys.argv)
    main()
