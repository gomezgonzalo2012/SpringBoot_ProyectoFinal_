
package com.springboot.proyectoFinal.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VentaXFechaDTO {
    private double total;
    private int cantidad;

    public VentaXFechaDTO() {
    }

    public VentaXFechaDTO(double total, int cantidad) {
        this.total = total;
        this.cantidad = cantidad;
    }
    
    
}
