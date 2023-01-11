from pathlib import Path
from dotenv import dotenv_values


BASE_DIR = Path(__file__).parent.parent  #
config = dotenv_values(".env")


class Config:
    SECRET_KEY = os.environ.get("SECRET_KEY") or "123"
    SQLALCHEMY_DATABASE_URI = "mysql://root:password@127.0.0.1:3306/helper"
    SQLALCHEMY_TRACK_MODIFICATIONS = False

