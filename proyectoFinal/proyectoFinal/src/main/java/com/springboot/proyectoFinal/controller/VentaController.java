
package com.springboot.proyectoFinal.controller;

import com.springboot.proyectoFinal.dto.VentaMaximaDTO;
import com.springboot.proyectoFinal.dto.VentaXFechaDTO;
import com.springboot.proyectoFinal.model.Cliente;
import com.springboot.proyectoFinal.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.proyectoFinal.service.IVentaService;
import com.springboot.proyectoFinal.model.Venta;
import com.springboot.proyectoFinal.service.IClienteService;
import com.springboot.proyectoFinal.service.IProductoService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
        
// menejo de comunicaciones HTTP
@RestController
public class VentaController {
    @Autowired  
    IVentaService ventaService;
    @Autowired
    IProductoService productoService;
    @Autowired 
    IClienteService clienteService;
    
    // alta de venta
    @PostMapping("/venta/alta")
    public void saveVenta(@RequestBody Venta venta){
        
        double total=0;
        List<Producto> productosActual = new ArrayList<>();
//        System.out.println("lista productos"+ productosActual.getFirst().getNombre());
        for (Producto p : venta.getListaProductos()){
            // buscamos el producto en base al Id 
            Producto produc = productoService.findProducto(p.getCodigo_producto());
            //y luego obtenemos el costo. eso se lo suma a total
            total= total + produc.getCosto();
            
            // seteamos el producto encontrado 
            productosActual.add(produc);
        }
        venta.setListaProductos(productosActual);
        venta.setTotal(total);
        
        // seteamos el cliente
        Cliente cliente = clienteService.findCliente(venta.getUnCliente().getId_cliente());
        venta.setUnCliente(cliente);
        // guardamos la venta
        ventaService.saveVenta(venta);
    }
    
    // lectura de una venta
    @GetMapping("/venta/traer/id_venta")
    @ResponseBody
    public Venta findVenta(@PathVariable Long id_venta){
        return ventaService.findVenta(id_venta);
    }
    
    // lectura de todas las ventas
    @GetMapping("/venta/traerTodo")
    @ResponseBody
    public List<Venta> getVentas(){
        return ventaService.getVentas();
    }
    
    // eliminación de una venta
    @DeleteMapping("/venta/eliminar/{id_venta}")
    public void deleteVenta(@PathVariable Long id_venta){
        ventaService.deleteVenta(id_venta);
    }
    
    // edición de una venta
    @PutMapping("/venta/editar")
    public void editVenta(@RequestBody Venta venta){
        ventaService.editVenta(venta);
    }
    
    // obtener los prductos de una determinada venta
    @GetMapping("/venta/producto/{id_venta}")
    @ResponseBody
    public List<Producto> getProductosXVenta(@PathVariable Long id_venta){
        return ventaService.getProductosXVentas(id_venta);
    }
    
      // Obtener una venta por determinada fecha 

    @GetMapping("/venta/{fecha_venta}")
    public VentaXFechaDTO getVentaXFecha(@PathVariable LocalDate fecha_venta){
       return  ventaService.getVentaXFecha(fecha_venta);
    }
    
    // obtener la maxima venta y datos especificos
    
    @GetMapping("/venta/mayor_venta")
    @ResponseBody
    public VentaMaximaDTO getMaximaVenta(){
        return ventaService.maximaVentaDTO();
    }
}
