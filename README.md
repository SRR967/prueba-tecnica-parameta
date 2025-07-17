#  Proyecto Prueba Técnica Parameta

Este proyecto es una aplicación **Spring Boot** que expone un servicio **RESTful** para recibir datos de un empleado, validarlos, enviarlos a un **servicio SOAP** que los guarda en una base de datos **MySQL**, para luego calcular edad y tiempo de vinculación, y retornar el objeto **Empleado** con la informacion de los años y tiempo de vinculacion en la empresa.

---

## 🚀 Tecnologías Usadas

- Java 21
- Spring Boot 3
- Spring Web
- Spring Data JPA
- Spring WS (SOAP)
- Lombok
- MySQL
- JUnit 5
- Mockito

---

## 🧱 Estructura del Proyecto

```bash
com.parameta.pruebatecnicaparameta
├── config → Configuración del cliente SOAP
├── persistence
│ ├── entity → Entidades JPA
│ └── repository → Repositorios Spring Data
├── presentation
│ ├── controller → Controladores REST y SOAP
│ ├── dto → Clases DTO
│ └── exception → Manejo de excepciones
├── service
│ ├── client → Cliente SOAP
│ ├── implementation→ Implementaciones de servicios
│ └── interfaces → Interfaces de servicios
├── util
│ └── mapper → Conversores entre DTO y modelos
│ └── ValidadorCampos → Validaciones de negocio
```
---
## 🛠️ Instalación y Ejecución

### 1. Clonar el repositorio
```bash
git clone https://github.com/SRR967/prueba-tecnica-parameta.git
cd prueba-tecnica-parameta
```
### 2. Configurar application.properties
Renombrar el archivo src/main/resources/application.properties.example a application.properties, y cambiar por las credenciales necesarias para conectarse a la **base de datos**.

### 3. Ejecutar el proyecto
```bash
./gradlew bootRun
```
##  Endpoints

###  REST

####  Crear Empleado

**GET** `/api/empleado`
- **Request:**
```
http://localhost:8080/api/empleado?nombres=Simba&apellidos=perez&tipoDocumento=CC&numeroDocumento=121345687&fechaNacimiento=2004-02-13&fechaVinculacion=2020-05-18&cargo=desarrollador&salario=10000
```
- **Response:**

```json
{
    "error": false,
    "message": {
        "empleadoRequestDTO": {
            "nombres": "Simba",
            "apellidos": "perez",
            "tipoDocumento": "CC",
            "numeroDocumento": "121345687",
            "fechaNacimiento": "2004-02-13",
            "fechaVinculacion": "2020-05-18",
            "cargo": "desarrollador",
            "salario": 10000.0
        },
        "anios": "21 años - 5 meses - 4 días",
        "tiempoVinculacion": "5 años - 1 meses - 29 días"
    }
}

```

## Ejecutar pruebas
Si deseás correr las pruebas unitarias:
```bash
./gradlew test
```
