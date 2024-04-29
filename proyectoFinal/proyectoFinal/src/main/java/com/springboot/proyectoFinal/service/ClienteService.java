
package com.springboot.proyectoFinal.service;

import com.springboot.proyectoFinal.model.Cliente;
import com.springboot.proyectoFinal.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService{
    @Autowired
    IClienteRepository clienteRepository;
    
    // alta
    @Override
    public void saveCliente(Cliente client) {
        clienteRepository.save(client);
    }
    // lectura individual
    @Override
    public Cliente findCliente(Long id_cliente) {
        return clienteRepository.getReferenceById(id_cliente);
    }
    // lectura colectiva
    @Override
    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }
    
    // baja
    @Override
    public void deleteCliente(Long id_cliente) {
        clienteRepository.deleteById(id_cliente);
    }
    

    @Override
    public void editCliente(Cliente cliente) {
        this.saveCliente(cliente);
    }
    
}
