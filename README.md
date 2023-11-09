# Triveous E-commerce-RestAPI

A sample Rest-API application developed using Java, SpringBoot for an ecommerce project. Entity relationships are not properly designed since the project is rapidly developed to showcase a demo. 


## Application.Properties

configure following entries in application.properties before running the project

`server.port= YOUR_PORT_NUMBER`

`spring.datasource.url=YOUR_DATABASE_URL`

`spring.datasource.username= YOUR_DB_USERNAME`

`spring.datasource.password= YOUR_DB_PASSWORD`


## Deployment

Follow following instruction to run the project
- Navigate to the project folder and run the following command in the the terminal

```bash
  mvn spring-boot:run
```
- Ensure application console for any exception to be not thrown.
- Application will be running on `hhtp://localhost:YOUR_PORT_NUMBER/`

## API Documentation

Swagger java library is used to automatically generate the API documentation. Access the Swagger UI in the following URL.
`http://localhost:YOUR_PORT_NUMBER/swagger-ui/index.html`

Enter following path in the url box to get the api endpoints
`/apidoc`

