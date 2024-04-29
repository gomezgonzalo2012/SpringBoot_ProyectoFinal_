package com.springboot.proyectoFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.proyectoFinal.model.Cliente;
import org.springframework.stereotype.Repository;

// metodos de persistencia para Cliente

@Repository
public interface IClienteRepository extends JpaRepository <Cliente, Long>
{
    
}
