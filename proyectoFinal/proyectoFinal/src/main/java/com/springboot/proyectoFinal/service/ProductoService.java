
package com.springboot.proyectoFinal.service;

import com.springboot.proyectoFinal.model.Producto;
import com.springboot.proyectoFinal.repository.IProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService{
    @Autowired
    IProductoRepository productoRepository;
    
    // alta
    @Override
    public void saveProducto(Producto produc) {
        productoRepository.save(produc);
    }
    // lectura individual
    @Override
    public Producto findProducto(Long id_produc) {
        return productoRepository.getReferenceById(id_produc);
    }
    // lectura colectiva
    @Override
    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }
    
    // baja
    @Override
    public void deleteProducto(Long id_producto) {
        productoRepository.deleteById(id_producto);
    }
    
    // edición
    @Override
    public void editProducto(Producto produc) {
        this.saveProducto(produc);
    }
    // Obtener todos los productos cuya cantidad_disponible sea menor a 5
    @Override
    public List<Producto> faltanteStock() {
        return productoRepository.stockMenorCinco();
    }
    
    
}
