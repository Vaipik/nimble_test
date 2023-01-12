from rest_api import create_app, db
from db_config.config import Config


app_api = create_app(Config)


@app_api.shell_context_processor
def make_shell_context():
    return {
        "db": db,
    }


if __name__ == "__main__":
    app_api.run(debug=True)
