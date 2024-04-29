
package com.springboot.proyectoFinal.service;
import com.springboot.proyectoFinal.model.Producto;
import java.util.List;

// metodos a implementar en el servicio ProductoService
public interface IProductoService {
    
    // metodos CRUD 
    
    public void saveProducto(Producto produc);
    
    public Producto findProducto(Long id_producto);
    
    public List<Producto> getProductos();
    
    public void deleteProducto(Long id_producto);
    
    public void editProducto(Producto produc);
    
    public List<Producto> faltanteStock();
    
    
}
