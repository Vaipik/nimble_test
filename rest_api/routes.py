import sqlalchemy.exc
from flask_restful import Resource, reqparse, abort

from . import db, models


class DataByUUID(Resource):

    def get(self, uuid: str):
        """
        Requesting to db for entity data and returns it JSON
        :param uuid: desired entity id.
        :return: json object with entity data or 404 if entity does not exist or 400 if wront uuid format
        """
        instance = self.__get_existing_instance(uuid)

        if instance is None:
            response = {
                "error": "no uuid-key was found",
                "status": "404"
            }
            abort(404, **response)

        decoded_value = instance.value.decode("utf-8")  # decoding stored value

        return {
            "value": decoded_value,
            "timestamp": f"{instance.timestamp.timestamp()}",
            "status": "200"
        }, 200

    def put(self, uuid: str):

        parser = reqparse.RequestParser()
        parser.add_argument("value", type=str)
        request_args = parser.parse_args()
        instance = self.__get_existing_instance(uuid)

        decoded_value = request_args["value"]
        if decoded_value is None:
            response = {
                "error": "no value was given",
                "status": "400"
            }
            abort(400, **response)

        encoded_value = decoded_value.encode()  # encoding value to store in db

        if instance is None:
            instance = models.BinaryData(
                id=uuid,
                value=encoded_value
            )
            db.session.add(instance)
            db.session.commit()
            return {
                "value": decoded_value,
                "timestamp": f"{instance.timestamp.timestamp()}",
                "status": "201"
            }, 201

        instance.value = encoded_value
        db.session.commit()
        return {
            "value": decoded_value,
            "timestamp": f"{instance.timestamp.timestamp()}",
            "status": "200"
        }, 200

    @staticmethod
    def __get_existing_instance(uuid: str) -> models.BinaryData | None:
        try:
            instance = models.BinaryData.query.filter_by(id=uuid).first()
        except sqlalchemy.exc.DataError:
            response = {
                "error": "given uuid-key is not in uuid format",
                "status": "400"
            }
            abort(400, **response)

        return instance
