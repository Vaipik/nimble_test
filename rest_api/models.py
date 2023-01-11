from datetime import datetime

import uuid
from sqlalchemy.dialects.postgresql import UUID

from rest_api import db


class BinaryData(db.Model):
    __tablename__ = "bin_data"

    id = db.Column(UUID(as_uuid=True), primary_key=True, default=uuid.uuid4)
    key = db.Column(db.String(64))
    value = db.Column(db.LargeBinary)
    timestamp = db.Column(db.DateTime, default=datetime.utcnow)
