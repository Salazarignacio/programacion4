# Guía de Carga de Objetos en Postman
**Proyecto:** Gestor de Pedidos (API REST - Spring Boot)  
**Base de Datos:** H2 en memoria (`jdbc:h2:mem:testdb`)

---

## 📌 Instrucciones de Uso en Postman
1. Para solicitudes `POST` y `PUT`, seleccionar en Postman:  
   `Body` ➔ `raw` ➔ formato `JSON`.
2. Seguir el orden de los pasos (Categorías y Usuarios primero, luego Productos, luego Pedidos y Detalles) para asegurar la consistencia de los IDs autogenerados.

---

## PASO 1: Crear Categorías (3)
**Método:** `POST`  
**URL:** `http://localhost:8080/categoria`

### Categoría 1
```json
{
  "nombre": "Electrónica",
  "descripcion": "Dispositivos electrónicos y tecnología"
}
```

### Categoría 2
```json
{
  "nombre": "Indumentaria",
  "descripcion": "Ropa, calzado y accesorios"
}
```

### Categoría 3
```json
{
  "nombre": "Hogar",
  "descripcion": "Artículos para el hogar y muebles"
}
```

---

## PASO 2: Crear Usuarios (2)
**Método:** `POST`  
**URL:** `http://localhost:8080/usuario`

### Usuario 1 (ADMIN)
```json
{
  "nombre": "Ignacio",
  "apellido": "Salazar",
  "mail": "ignacio@gmail.com",
  "celular": "3416050505",
  "contrasenia": "123abc",
  "rol": "ADMIN"
}
```

### Usuario 2 (USUARIO)
```json
{
  "nombre": "Florencia",
  "apellido": "Campora",
  "mail": "flor@gmail.com",
  "celular": "3416050506",
  "contrasenia": "zxy789",
  "rol": "USUARIO"
}
```

---

## PASO 3: Crear Productos (10)
**Método:** `POST`  
**URL:** `http://localhost:8080/producto`

### Productos Categoría 1 (Electrónica - ID 1)

#### Producto 1
```json
{
  "nombre": "Auriculares Bluetooth",
  "precio": 15000.00,
  "descripcion": "Auriculares inalámbricos con cancelación de ruido",
  "stock": 15,
  "imagen": "auriculares.jpg",
  "disponible": true,
  "IdCategoria": 1
}
```

#### Producto 2
```json
{
  "nombre": "Smartwatch Pro",
  "precio": 35000.00,
  "descripcion": "Reloj inteligente con monitor de ritmo cardíaco",
  "stock": 10,
  "imagen": "smartwatch.jpg",
  "disponible": true,
  "IdCategoria": 1
}
```

#### Producto 3
```json
{
  "nombre": "Teclado Mecánico RGB",
  "precio": 25000.00,
  "descripcion": "Teclado gamer switches azúl",
  "stock": 8,
  "imagen": "teclado.jpg",
  "disponible": true,
  "IdCategoria": 1
}
```

#### Producto 4
```json
{
  "nombre": "Monitor 24 pulgadas",
  "precio": 85000.00,
  "descripcion": "Monitor Full HD IPS 75Hz",
  "stock": 5,
  "imagen": "monitor.jpg",
  "disponible": true,
  "IdCategoria": 1
}
```

### Productos Categoría 2 (Indumentaria - ID 2)

#### Producto 5
```json
{
  "nombre": "Remera 100% Algodón",
  "precio": 12000.00,
  "descripcion": "Remera talle M manga corta",
  "stock": 20,
  "imagen": "remera.jpg",
  "disponible": true,
  "IdCategoria": 2
}
```

#### Producto 6
```json
{
  "nombre": "Pantalón Jean Slim",
  "precio": 28000.00,
  "descripcion": "Jean denim elastizado",
  "stock": 12,
  "imagen": "jean.jpg",
  "disponible": true,
  "IdCategoria": 2
}
```

#### Producto 7
```json
{
  "nombre": "Campera Térmica",
  "precio": 55000.00,
  "descripcion": "Campera de abrigo impermeable",
  "stock": 6,
  "imagen": "campera.jpg",
  "disponible": true,
  "IdCategoria": 2
}
```

### Productos Categoría 3 (Hogar - ID 3)

#### Producto 8
```json
{
  "nombre": "Lámpara LED Escritorio",
  "precio": 8500.00,
  "descripcion": "Lámpara táctil con regulación de brillo",
  "stock": 25,
  "imagen": "lampara.jpg",
  "disponible": true,
  "IdCategoria": 3
}
```

#### Producto 9
```json
{
  "nombre": "Silla Ergonómica Oficina",
  "precio": 65000.00,
  "descripcion": "Silla ejecutiva con soporte lumbar",
  "stock": 4,
  "imagen": "silla.jpg",
  "disponible": true,
  "IdCategoria": 3
}
```

#### Producto 10
```json
{
  "nombre": "Cafetera Express",
  "precio": 45000.00,
  "descripcion": "Cafetera automática presión 15 bares",
  "stock": 7,
  "imagen": "cafetera.jpg",
  "disponible": true,
  "IdCategoria": 3
}
```

---

## PASO 4: Crear Pedidos (3)
**Método:** `POST`  
**Nota:** El endpoint requiere el `idUsuario` como parámetro de consulta (`RequestParam`).

### Pedido 1 (Usuario 1 - EFECTIVO)
**URL:** `http://localhost:8080/pedido?idUsuario=1`  
**Body (raw):**
```json
"EFECTIVO"
```

### Pedido 2 (Usuario 2 - TARJETA)
**URL:** `http://localhost:8080/pedido?idUsuario=2`  
**Body (raw):**
```json
"TARJETA"
```

### Pedido 3 (Usuario 2 - TRANSFERENCIA)
**URL:** `http://localhost:8080/pedido?idUsuario=2`  
**Body (raw):**
```json
"TRANSFERENCIA"
```

---

## PASO 5: Crear Detalles de Pedido
**Método:** `POST`  
**URL:** `http://localhost:8080/detallepedido`

### Detalle 1 (2 unidades de Producto ID 1)
```json
{
  "cantidad": 2,
  "producto": {
    "id": 1
  }
}
```

### Detalle 2 (1 unidad de Producto ID 5)
```json
{
  "cantidad": 1,
  "producto": {
    "id": 5
  }
}
```

### Detalle 3 (3 unidades de Producto ID 8)
```json
{
  "cantidad": 3,
  "producto": {
    "id": 8
  }
}
```

---

## 🔍 Endpoints de Consulta y Verificación

- **Buscar Usuario por Mail:** `GET http://localhost:8080/usuario/mail/ignacio@gmail.com`
- **Buscar Usuario por ID:** `GET http://localhost:8080/usuario/1`
- **Actualizar Categoría 1:** `PUT http://localhost:8080/categoria/1`
- **Interfaz Swagger UI:** `GET http://localhost:8080/swagger-ui/index.html`
