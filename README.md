# grails3-rest-example

To run this application, you will need an instance of MongoDB running on localhost:27017. Feel free to change application.yml configurations to fit your needs.

The easier way to test this application is:

- Run the application the commando below. Grails required version is 3.1.9:
    - $ grails run-app
- Download Postman Chrome addon.
- Configure a request with the following information:
    - url: http://localhost:8080/api/login
    - method: POST
    - body:
        - encode: x-www-form-encoded
        - username: admin
        - password: 1234
- Send the request
- This should return a JSON containing the attribute "access_token". Copy its value.
- Configure another request with the following information:
    - url: http://localhost:8080/api/books/
    - method: GET
    - headers:
        - Authorization: Bearer <access_token copied in the last step>
- Send the request
- You should get a list of books


