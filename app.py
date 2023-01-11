from rest_api import create_app, db
from db_config.config import Config


app = create_app(Config)


@app.shell_context_processor
def make_shell_context():
    return {
        "db": db,
    }


if __name__ == "__main__":
    app.run(debug=True)
