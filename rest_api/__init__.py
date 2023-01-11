from flask import Flask
from flask_restful import Api
from flask_sqlalchemy import SQLAlchemy
from flask_migrate import Migrate

from db_config.config import Config

api = Api()
db = SQLAlchemy()
migrate = Migrate()


def create_app(config: Config) -> Flask:

    app = Flask(__name__)
    app.config.from_object(config)

    db.init_app(app)
    migrate.init_app(app, db)

    with app.app_context():
        from rest_api import routes
        api.add_resource(routes.DataByUUID, '/api/<uuid>')
        api.add_resource(routes.MultiplyResponse, '/api')
        db.create_all()

    api.init_app(app)

    return app

