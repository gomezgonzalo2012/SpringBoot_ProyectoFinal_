
package com.springboot.proyectoFinal.controller;

import com.springboot.proyectoFinal.model.Producto;
import com.springboot.proyectoFinal.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {
    @Autowired  
    IProductoService productoService;
    
    // alta de producto
    @PostMapping("/producto/alta")
    public void saveProducto(@RequestBody Producto produ){
        productoService.saveProducto(produ);
    }
    
    // lectura de un producto
    @GetMapping("/producto/traer/{id_producto}")
    @ResponseBody
    public Producto findProducto(@PathVariable Long id_producto){
        return productoService.findProducto(id_producto);
    }
    
    // lectura de todos los productos
    @GetMapping("/producto/traerTodo")
    @ResponseBody
    public List<Producto> getProductos(){
        return productoService.getProductos();
    }
    
    // eliminación de un producto
    @DeleteMapping("/producto/eliminar/{id_producto}")
    public void deleteProducto( @PathVariable Long id_producto){
        productoService.deleteProducto(id_producto);
    }
    
    // edición de un producto
    @PutMapping("/producto/editar")
    public void editProducto(@RequestBody Producto producto){
        productoService.editProducto(producto);
    }
    
    // Obtener todos los productos cuya cantidad_disponible sea menor a 
    
    @GetMapping("producto/falta_stock")
    public List<Producto> faltanteStock(){
        return productoService.faltanteStock();
    }
}
