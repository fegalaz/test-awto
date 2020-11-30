# Test-Awto
Test fot Awto

<a href="https://google.cl/"><img src="https://www.awto.cl/static/53fc5fd369ccc836745d0dd412055cf1/143f4/logo-awto-color.png" width="180px" align="right" /></a>

Proyecto cuya finalidad es consumir 3 APIRest

## Tecnologías ocupadas en el desarrollo:

* Spring Framework 
* Spring JPA
* Swagger
* Spring WEB
* Lombok
* Gradle
* Java 8


## APIs expuestas por el microservicios 

| Type Method   | Method        | URL  |
| ------------- | ------------- | ---- |
| POST          | createLog()   | localhost:8080//api/v1/logs|
| GET           | findById()    | localhost:8080/api/v1/logs/hashtag/{hashtagId} |
| PUT           | updateHashTag()  | localhost:8080//api/v1/hashtags


## Compilacion y despliegue del microservicio

* Para compilar el proyecto de debe escribir el siguiente comando gradle `grandlew clean build` , el compilado se genera en la ruta `{base_proyect}/build/libs/testAwto-0.0.1-SNAPSHOT`

* Para correr el proyecto ya **compilado** escribir el siguiente comando `gradle bootRun`

* Para construir una imagen docker escribir el siguiente comando `docker build -t test-docker .`

* Para levantar o correr el contenedor con la imagen creada `docker run --name test-docker -p 8080:8080 test-docker:latest`


## Swagger

* Para poder ver la documentacion de las Apis Rest ver el siguiente enlace `http://localhost:8080/swagger-ui.html`


**Autor**
***Felipe Galaz***




