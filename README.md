### RESTful api
Simple api performed by using `flask-restful` framework.

#### About
Postgres is used as database. Data stored in `key-value` format where `key` must be `uuid`,
`value` will be stored in binary format.

Only `GET` and `PUT` methods are allowed.
* `PUT` method accepts `JSON` with value which must be encoded. 
* `GET` method returns `JSON` with decoded value(s)

### Visit `/api/doc` to see how to operate with this api. 

