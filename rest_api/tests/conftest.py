import pytest

from rest_api import create_app
from db_config.config import Config, config


class TestConfig(Config):
    SQLALCHEMY_DATABASE_URI = f"{config['TEST_DB']}://" \
                              f"{config['TEST_DB_USER']}:{config['TEST_DB_PASSWORD']}@" \
                              f"{config['TEST_DB_HOST']}:{config['TEST_DB_PORT']}/{config['TEST_DB_NAME']}"


@pytest.fixture
def client():

    app = create_app(TestConfig)
    app.config["TESTING"] = True

    with app.test_client() as client:
        yield client
