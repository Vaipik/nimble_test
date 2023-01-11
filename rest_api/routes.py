from flask_restful import Resource

from . import api


@api.resource("/api/<uuid:uuid>")
class RESTApi(Resource):

    def get(self):
        pass

    def put(self):
        pass
