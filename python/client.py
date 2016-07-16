import sys
from third_party.python import gflags as flags
from proto import kitten_pb2
from python.kitten_lib import get_kitten


flags.DEFINE_integer('port', 9232, 'The port to connect to')
flags.DEFINE_enum('breed', None, kitten_pb2.Breed.keys(),
                  'Breed of kitten to request')
FLAGS = flags.FLAGS


def main():
    kitten = get_kitten(FLAGS.port, breed=FLAGS.breed)
    print('Received a kitten:\n%s' % kitten)


if __name__ == '__main__':
    FLAGS(sys.argv)
    main()
