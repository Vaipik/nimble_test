from flask import Flask
from flask_restful import Api
from flask_sqlalchemy import SQLAlchemy
from flask_migrate import Migrate
from swagger_ui import api_doc

from db_config.config import Config
from .libs.swagger import config_path as swagger_cfg

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
        api.add_resource(routes.DataByUUID, '/api/bin/<uuid>')
        db.create_all()
    api_doc(app, config_path=swagger_cfg, title="Fucking tests")
    api.init_app(app)

    return app

