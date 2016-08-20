from third_party.python.grpc.beta.implementations import insecure_channel
from proto import kitten_pb2


def fetch_kitten(request, port):
    """Fetches a kitten from the server.

    :param kitten_pb2.GetKittenRequest request: Request proto for the kitten.
    :param int port: Port to communicate with the server on.
    :return: The response proto describing the kitten.
    :rtype: kitten_pb2.GetKittenResponse
    """
    channel = insecure_channel('localhost', port)
    with kitten_pb2.beta_create_PetShop_stub(channel) as stub:
        return stub.GetKitten(request, 3)


def get_kitten(port, breed=None):
    """Returns a kitten, optionally specifying a required breed.

    :param int port: Port to communicate with the server on.
    :param kitten_pb2.Breed breed: Required breed of the kitten.
    :return: The kitten retrieved.
    :rtype: kitten_pb2.Kitten
    """
    request = kitten_pb2.GetKittenRequest()
    if breed:
        request.breed = kitten_pb2.Breed.Value(breed)
    response = fetch_kitten(request, port)
    if breed and response.kitten.breed != request.breed:
        raise Exception('Unacceptable kitten breed: %s' % response.kitten.breed)
    return response.kitten


def provide_kitten():
    """Returns a kitten of the breed we have available."""
    return kitten_pb2.Kitten(
        name='Mr Tibbles',
        breed=kitten_pb2.CORNISH_REX,
        weight=2.0,
        age=3,
    )
