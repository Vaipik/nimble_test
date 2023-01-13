from flask import Flask, Blueprint
from flask_restful import Api
from flask_sqlalchemy import SQLAlchemy
from flask_migrate import Migrate
from swagger_ui import api_doc

from db_config.config import Config
from .libs.swagger import config_path as swagger_cfg


db = SQLAlchemy()
migrate = Migrate()


def create_app(config: Config) -> Flask:

    app = Flask(__name__)
    app.config.from_object(config)

    db.init_app(app)
    migrate.init_app(app, db)

    api = Api(app)

    with app.app_context():
        db.create_all()
        from .resources import bin
        api.add_resource(bin.DataByUUID, "/api/bin", "/api/bin/<uuid>")
        api_doc(app, config_path=swagger_cfg, title="Nimble test task")


    return app

