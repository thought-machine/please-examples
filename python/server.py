import sys
import time
from third_party.python import gflags as flags
from proto import kitten_pb2
from python.kitten_lib import provide_kitten


flags.DEFINE_integer('port', 9232, 'The port to serve on')
FLAGS = flags.FLAGS


class PetShop(kitten_pb2.BetaPetShopServicer):

    def GetKitten(self, request, context):
        return kitten_pb2.GetKittenResponse(kitten=provide_kitten())


def main():
    server = kitten_pb2.beta_create_PetShop_server(PetShop())
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
