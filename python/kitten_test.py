import unittest

from proto import kitten_pb2
from python import kitten_lib


class KittenTest(unittest.TestCase):

    def setUp(self):
        # Mock out stub call for testing.
        kitten_lib.fetch_kitten = lambda *args, **kwargs: kitten_pb2.GetKittenResponse(
            kitten=kitten_lib.provide_kitten())
        self.port = 80  # Doesn't matter.

    def test_any_breed(self):
        """Test us requesting a kitten of any breed."""
        kitten = kitten_lib.get_kitten(self.port)
        self.assertEqual('Mr Tibbles', kitten.name)
        self.assertEqual(kitten_pb2.CORNISH_REX, kitten.breed)

    def test_breed_request(self):
        """Test that an exception is thrown when we request a kitten of another breed."""
        with self.assertRaises(Exception):
            kitten_lib.get_kitten(self.port, breed=kitten_pb2.PERSIAN)


if __name__ == '__main__':
    unittest.main()
