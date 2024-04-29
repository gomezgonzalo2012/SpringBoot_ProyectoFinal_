
package com.springboot.proyectoFinal.service;

import com.springboot.proyectoFinal.dto.VentaMaximaDTO;
import com.springboot.proyectoFinal.dto.VentaXFechaDTO;
import com.springboot.proyectoFinal.model.Producto;
import com.springboot.proyectoFinal.model.Venta;
import java.time.LocalDate;
import java.util.List;

// metodos a implementar en el servicio VentaService
public interface IVentaService {
    
    // metodos CRUD
    public void saveVenta(Venta venta);
    
    public Venta findVenta(Long id_venta);
    
    public List<Venta> getVentas();
    
    public void deleteVenta(Long id_venta);
    
    public void editVenta(Venta venta);
    
    // obtener los productos de una venta

    public List<Producto> getProductosXVentas(Long id_venta);
    
    // obtener el monto total y la cantidad vendida en una determinada fecha
    
    public VentaXFechaDTO getVentaXFecha(LocalDate fecha);
    
    // obtener la maxima venta y datos especificos
     public VentaMaximaDTO maximaVentaDTO();
}


