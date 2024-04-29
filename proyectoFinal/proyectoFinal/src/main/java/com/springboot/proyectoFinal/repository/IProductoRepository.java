package com.springboot.proyectoFinal.repository;

// metodos de persistencia para Producto

import com.springboot.proyectoFinal.model.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto,Long>{
    
    @Query(value="SELECT * FROM productos WHERE cantidad_disponible < 5", nativeQuery=true)
    public List<Producto> stockMenorCinco();
    
}
