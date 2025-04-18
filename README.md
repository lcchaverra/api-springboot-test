# BaseAPI - CRUD de Usuarios con Spring Boot

Este es un proyecto base en Java utilizando **Spring Boot**. La idea principal es construir una API REST limpia, escalable y con buenas prácticas desde el inicio. Actualmente implementa un CRUD de usuarios conectado a una base de datos **MySQL**, utilizando **Spring Data JPA** como ORM.

## 🚀 Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL
- Maven

## 📌 Funcionalidades

✅ Crear, obtener, actualizar y eliminar usuarios.  
✅ Validación básica de datos.  
✅ Manejo de errores personalizado.  
✅ Organización por capas (Controller, Service, Repository).  
✅ Configuración por variables de entorno.  

## 📚 Endpoints actuales

```
GET     /users/         # Obtener todos los usuarios  
GET     /users/{id}     # Obtener usuario por ID  
POST    /users/         # Crear nuevo usuario  
PUT     /users/{id}     # Actualizar un usuario existente  
DELETE  /users/{id}     # Eliminar un usuario  
```

## 🧠 Lo que se viene

🔒 Sistema de autenticación con JWT  
📦 Dockerización del proyecto  
📑 Documentación con Swagger  
🧰 Implementación de DTOs  
📂 Servicios comunes reutilizables  
🧱 Uso de patrones de diseño  

## 🛠 Cómo correr el proyecto

1. Clona el repositorio:
   ```bash
   git clone https://github.com/lcchaverra/api-springboot-test.git
   cd api-springboot-test
   ```

2. Configura tu base de datos en `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://TU_HOST:PUERTO/NOMBRE_DB
   spring.datasource.username=TU_USUARIO
   spring.datasource.password=TU_PASSWORD
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Ejecuta la aplicación desde tu IDE o con:
   ```bash
   ./mvnw spring-boot:run
   ```
