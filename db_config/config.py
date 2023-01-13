from pathlib import Path
from dotenv import dotenv_values


BASE_DIR = Path(__file__).parent
config = dotenv_values(BASE_DIR / ".env")


class Config:
    SECRET_KEY = config["SECRET_KEY"] or "123"
    SQLALCHEMY_DATABASE_URI = f"postgresql://" \
                              f"{config['DB_USER']}:{config['DB_PASSWORD']}@" \
                              f"{config['DB_HOST']}:{config['DB_PORT']}/{config['DB_NAME']}"
    SQLALCHEMY_TRACK_MODIFICATIONS = False
