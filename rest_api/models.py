from datetime import datetime

from sqlalchemy.dialects.postgresql import UUID, TIMESTAMP
import uuid

from rest_api import db


class BinaryData(db.Model):
    __tablename__ = "bin_data"

    id = db.Column(UUID(as_uuid=True), primary_key=True, default=uuid.uuid4)
    value = db.Column(db.LargeBinary)
    timestamp = db.Column(TIMESTAMP, default=datetime.utcnow)
