from flask import jsonify
from flask_restful import Resource, reqparse

from . import db, models


class DataByUUID(Resource):

    def get(self, uuid: str):

        instance = self.__get_existing_instance(uuid)
        if instance is None:
            return jsonify(
                {
                    uuid: {
                        "status": "404"
                    }
                }
            )
        decoded_value = instance.value.decode("utf-8")
        return jsonify(
            {
                uuid: {
                    "value": decoded_value,
                    "timestamp": instance.timestamp.timestamp(),
                    "status": 200
                }
            }
        )

    def put(self, uuid: str):
        parser = reqparse.RequestParser()
        parser.add_argument("key", type=str, required=True)
        parser.add_argument("value", type=str, required=True)
        request_args = parser.parse_args()

        decoded_value = request_args.get("value")
        encoded_value = decoded_value.encode()

        instance = self.__get_existing_instance(uuid)
        if instance is None:
            instance = models.BinaryData(
                id=uuid,
                value=encoded_value
            )
            db.session.add(instance)
            print(instance.timestamp)
            db.session.commit()
            return jsonify(
                {
                    uuid: {
                        "value": decoded_value,
                        "timestamp": f"{instance.timestamp.timestamp()}",
                        "status": "201"
                    }
                }
            )
        else:
            instance.value = encoded_value
            return jsonify(
                {
                    uuid: {
                        "value": decoded_value,
                        "timestamp": f"{instance.timestamp.timestamp()}",
                        "status": "201"
                    }
                }
            )

    @staticmethod
    def __get_existing_instance(uuid: str) -> models.BinaryData | None:
        instance = models.BinaryData.query.filter_by(id=uuid).first()
        return instance

