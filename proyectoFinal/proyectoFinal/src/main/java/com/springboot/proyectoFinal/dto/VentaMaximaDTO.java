
package com.springboot.proyectoFinal.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class VentaMaximaDTO {
    private Long id_venta;
    private Double total;
    private int cantidad_producto;
    private String nombre_cliente;
    private String apellido_cliente;

    public VentaMaximaDTO() {
    }
  
    public VentaMaximaDTO(Long id_venta, Double total, int cantidad_producto, String nombre_cliente, String apellido_cliente) {
        this.id_venta = id_venta;
        this.total = total;
        this.cantidad_producto = cantidad_producto;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
    }
    
    
   
}
