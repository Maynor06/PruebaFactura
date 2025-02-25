# 📌 Proyecto de Facturación (Backend y Frontend)

Este proyecto es una aplicación de facturación que incluye un **backend** desarrollado en **Java con Spring Boot** y un **frontend** en **React**. La base de datos utilizada es **MySQL**, administrada con **MySQL Workbench**.

---

## 🛠️ Tecnologías Utilizadas

### **Backend** (API REST con Spring Boot)
- Java 17+
- Spring Boot
- Spring Data JPA
- Spring Security (si aplica)
- MySQL con MySQL Workbench
- Lombok
- Maven

### **Frontend** (Interfaz en React)
- React.js
- React Router DOM
- Axios

---

## 🗄️ **Estructura de la Base de Datos**

Se diseñaron las siguientes tablas en **MySQL**:

```sql
CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(100) UNIQUE,
    numero_telefono VARCHAR(15),
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE facturas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    fecha_emision DATETIME,
    valor_total DECIMAL(10,2) NOT NULL,
    estado ENUM('pagada', 'pendiente') DEFAULT 'pendiente',
    FOREIGN KEY (id_cliente) REFERENCES clientes(id) ON DELETE CASCADE
);

```

---

## 🚀 **Instalación y Configuración**

### **1. Clonar el repositorio**
```sh
git clone https://github.com/tu-usuario/tu-repo.git
cd tu-repo
```

### **2. Configurar la base de datos en `application.properties`**
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/facturacion
spring.datasource.username=root
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
```


## 🌍 **Endpoints del Backend**

### 📌 **Facturas**
| Método | Endpoint | Descripción |
|--------|---------|-------------|
| `GET` | `/facturas` | Obtener todas las facturas |
| `POST` | `/facturas` | Crear una nueva factura |
| `GET` | `/facturas/{id}` | Obtener una factura por ID |
| `DELETE` | `/facturas/{id}` | Eliminar una factura |
| `GET` | `/facturas/reporte?fechaInicio=YYYY-MM-DD&fechaFin=YYYY-MM-DD` | Reporte de facturas por rango de fechas |

## 🎨 **Interfaz del Frontend**
- **Formulario de Factura**: Permite crear nuevas facturas.
- **Búsqueda de Facturas**: Buscar una factura específica por su ID.
- **Reporte de Facturas**: Permite filtrar facturas por un rango de fechas.

