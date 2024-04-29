
package com.springboot.proyectoFinal.service;

import com.springboot.proyectoFinal.dto.VentaMaximaDTO;
import com.springboot.proyectoFinal.dto.VentaXFechaDTO;
import com.springboot.proyectoFinal.model.Cliente;
import com.springboot.proyectoFinal.model.Producto;
import com.springboot.proyectoFinal.model.Venta;
import com.springboot.proyectoFinal.repository.IClienteRepository;
import com.springboot.proyectoFinal.repository.IProductoRepository;
import com.springboot.proyectoFinal.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService{
    @Autowired 
    IVentaRepository ventaRepository;
    @Autowired
    IProductoRepository productRepository;
    @Autowired
    IClienteRepository clienteRepository;
    // // alta
    @Override
    public void saveVenta(Venta venta) {
//        // 
//
//        List<Producto> productos = productRepository.findAllById(venta.getListaProductos().stream().map(Producto::getCodigo_producto).toList());
//        // 
//        Cliente cliente = clienteRepository.getReferenceById(venta.getUnCliente().getId_cliente());
//        
//        venta.setListaProductos(productos);
//        venta.setUnCliente(cliente);
        ventaRepository.save(venta);
    }
    // lectura individual
    @Override
    public Venta findVenta(Long id_venta) {
        return ventaRepository.getReferenceById(id_venta);
    }
    //lectura colectiva
    @Override
    public List<Venta> getVentas() {
        return ventaRepository.findAll();
    }
    // baja
    @Override
    public void deleteVenta(Long id_venta) {
        ventaRepository.deleteById(id_venta);
    }
    // edicion
    @Override
    public void editVenta(Venta venta) {
        this.saveVenta(venta);
    }
    // retornar los productos por una determinada venta
    @Override
    public List<Producto> getProductosXVentas(Long id_venta) {
        return this.findVenta(id_venta).getListaProductos();
    }
    
    // obtener la mayor venta (clase DTO)
    @Override
    public VentaMaximaDTO maximaVentaDTO(){
        // obtenemos la venta con mayor total mediante Query SQL nativa
        Venta ventaMaxima = ventaRepository.maximaVenta();
        
        // seteando datos del objeto DTO
        VentaMaximaDTO ventaDTO =  new VentaMaximaDTO();
        ventaDTO.setId_venta(ventaMaxima.getCodigo_venta());
        ventaDTO.setTotal(ventaMaxima.getTotal());
        // setea el tamaño de la lista de producto de la venta (cantidad de productos)
        ventaDTO.setCantidad_producto(ventaMaxima.getListaProductos().size());
        ventaDTO.setNombre_cliente(ventaMaxima.getUnCliente().getNombre());
        ventaDTO.setApellido_cliente(ventaMaxima.getUnCliente().getApellido());
        
        return ventaDTO;
        
                
    }
    // Obtener una venta por determinada fecha 

    @Override
    public VentaXFechaDTO getVentaXFecha(LocalDate fecha) {
        // obtenemos la lista de ventas en la fecha especificada (formato = "yyyy-MM-dd")
        List<Venta> ventas = ventaRepository.findVentaByFecha(fecha);
        // para calcular total y cantidades
        double monto_total = 0; 
        int cantidad_total = 0;
        
        for(Venta v : ventas){
            monto_total= monto_total + v.getTotal();
            cantidad_total = cantidad_total + v.getListaProductos().size();
        }
        // creamos el objeto DTO y seteamos el total y las cantidades
        VentaXFechaDTO ventaDTO = new VentaXFechaDTO();
        ventaDTO.setCantidad(cantidad_total);
        ventaDTO.setTotal(monto_total);
        
        return ventaDTO;
    }
    
}
