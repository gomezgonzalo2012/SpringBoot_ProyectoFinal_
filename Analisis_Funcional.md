# Proyecto final curso: APIs con SpringBoot

## Modelado de la Base de Datos
## Entidades
 
### producto (ED)
- codigo_producto **PK**
- nombre
- marca
- costo
- cantidad_disponible
- id_venta **FK**

### venta (ED)
- codigo_venta **PK**
- fecha_venta
- total
- id_cliente **FK**

### cliente (ED)
- id_cliente **PK**
- nombre
- apellido
- dni **UQ**

## Relaciones
- Una _venta_ tiene un _cliente_ (1-1)
- Una _venta_ tiene una lista de _producto_ (1-N)

## Diagrama Relacional de la Base de Datos

![diagrama relacional](/comercio.drawio.png)

## Reglas de negocio - Operaciones CRUD
 
 ### producto
 - _crear_ un producto.
 - _leer_ un determinado producto.
 - _leer_ todos los productos.
 - _modificar_ los datos de un producto.
 - _eliminar_ un producto.
  ### venta
 - _crear_ una venta.
 - _leer_ una determinada venta.
 - _leer_ todas las ventas.
 - _modificar_ los datos de una venta.
 - _eliminar_ una venta.
  ### cliente
 - _crear_  un cliente.
 - _leer_ un determinado cliente.
 - _leer_ todos los clientes.
 - _modificar_ los datos de un cliente.
 - _eliminar_ un cliente.

## Nomenclaturas
- PK (primiry key).
- FK (foreing key).
- ED (entidad de datos).
- UQ (unique / campo único).

