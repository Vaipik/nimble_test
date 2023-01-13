from uuid import uuid4


uuids = [uuid4() for _ in range(4)]
url = '/api/bin'


def test_api_bin_put_201(client):

    for uuid in uuids:
        new_record_json = {"value": uuid}
        response = client.put(f"{url}/{uuid}", json=new_record_json)
        assert response.status_code == 201


def test_api_bin_put_200(client):

    for uuid in uuids:
        new_record_json = {"value": f"{uuid}|100"}
        response = client.put(f"{url}/{uuid}", json=new_record_json)
        assert response.status_code == 200


def test_api_bin_put_400_no_value(client):

    for uuid in uuids:
        new_record_json = {"val": uuid}
        response = client.put(f"{url}/{uuid}", json=new_record_json)
        assert response.status_code == 400


def test_api_bin_put_400_wrong_uuid(client):

    for uuid in uuids:
        new_record_json = {"value": uuid}
        response = client.put(f"{url}/{uuid}a", json=new_record_json)
        assert response.status_code == 400


def test_api_bin_get_200(client):

    for uuid in uuids:
        new_record_json = {"value": uuid}
        response = client.get(f"{url}/{uuid}", json=new_record_json)
        assert response.status_code == 200


def test_api_bin_get_400(client):
    not_existing_uuids = [uuid4() for _ in range(4)]

    for uuid in not_existing_uuids:
        new_record_json = {"value": uuid}
        response = client.get(f"{url}/{uuid}a", json=new_record_json)
        assert response.status_code == 400


def test_api_bin_get_404(client):

    not_existing_uuids = [uuid4() for _ in range(4)]

    for uuid in not_existing_uuids:
        new_record_json = {"value": uuid}
        response = client.get(f"{url}/{uuid}", json=new_record_json)
        assert response.status_code == 404
