ms-publicaciones

Microservicio encargado de la gestión de publicaciones de la plataforma SocialCloud.

Tecnologías utilizadas
Java 17
Spring Boot 3.4.6
Spring Security
JWT
Spring Data JPA
MySQL
Maven
Configuración Base de Datos

Crear la base de datos:

CREATE DATABASE socialcloud_publicaciones;

Configurar en:

src/main/resources/application.properties
spring.application.name=ms-publicaciones

server.port=8083

spring.datasource.url=jdbc:mysql://localhost:3306/socialcloud_publicaciones
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
Compilar proyecto
mvn clean install
Ejecutar proyecto
mvn spring-boot:run

O ejecutar la clase:

MsPublicacionesApplication.java
Generar artefacto JAR
mvn clean package

Archivo generado:

target/ms-publicaciones-0.0.1-SNAPSHOT.jar
Seguridad JWT

Las rutas están protegidas mediante JWT.

Header requerido:

Authorization: Bearer TOKEN
Endpoints
Crear publicación
POST /api/publicaciones

Body:

{
  "usuarioId": 1,
  "contenido": "Mi primera publicación"
}
Obtener todas las publicaciones
GET /api/publicaciones
Obtener publicación por ID
GET /api/publicaciones/{id}
Obtener publicaciones por usuario
GET /api/publicaciones/usuario/{usuarioId}
Actualizar publicación
PUT /api/publicaciones/{id}
Eliminar publicación
DELETE /api/publicaciones/{id}
Estructura del Proyecto
src/main/java/com/socialcloud/ms_publicaciones
│
├── Config
├── Controller
├── Dto
├── Entity
├── Exception
├── Repository
├── Security
├── Service
└── MsPublicacionesApplication
Autor

Diego Alejandro González

Asignatura

JVY0101 - Java: Diseño y Construcción de Soluciones Nativas en Nube

Proyecto

SocialCloud

Microservicio de publicaciones desarrollado con arquitectura de microservicios utilizando Spring Boot, JWT, MySQL y Maven.
