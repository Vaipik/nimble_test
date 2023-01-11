from flask import Flask
from flask_restful import Api
from flask_sqlalchemy import SQLAlchemy
from flask_migrate import Migrate

from db_config.config import Config


db = SQLAlchemy()
migrate = Migrate()
api = Api()


def create_app(config: Config) -> Flask:

    app = Flask(__name__, instance_relative_config=True)
    app.config.from_object(config)

    db.init_app(app)
    migrate.init_app(app, db)
    api.init_app(app)

    with app.app_context():
        from rest_api import routes
        db.create_all()

    return app
