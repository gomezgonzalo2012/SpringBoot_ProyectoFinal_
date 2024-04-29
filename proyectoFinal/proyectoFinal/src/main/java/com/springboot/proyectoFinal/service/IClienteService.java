
package com.springboot.proyectoFinal.service;

import com.springboot.proyectoFinal.model.Cliente;
import java.util.List;

// metodos a ser implementados en el servicio ClienteService
public interface IClienteService {
    // metodos CRUD 
    
    public void saveCliente(Cliente client);
    
    public Cliente findCliente(Long id_cliente);
    
    public List<Cliente> getClientes();
    
    public void deleteCliente(Long id_cliente);
    
    public void editCliente(Cliente cliente);
    
}
