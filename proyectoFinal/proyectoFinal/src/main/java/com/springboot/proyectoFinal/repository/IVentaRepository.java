
package com.springboot.proyectoFinal.repository;

import com.springboot.proyectoFinal.model.Venta;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// metodos de persistencia para Venta
@Repository
public interface IVentaRepository extends JpaRepository<Venta,Long>{
    // obtener la venta con el mayor total
    @Query(value="SELECT v.* FROM ventas v WHERE v.total = (SELECT MAX(total) FROM ventas);",nativeQuery=true)
    public Venta maximaVenta();
    
    // obtener una venta por determinado parametro
    
    @Query(value="SELECT * FROM ventas WHERE fecha_venta = ?1", nativeQuery=  true)
    public List<Venta> findVentaByFecha(LocalDate fecha);
}
