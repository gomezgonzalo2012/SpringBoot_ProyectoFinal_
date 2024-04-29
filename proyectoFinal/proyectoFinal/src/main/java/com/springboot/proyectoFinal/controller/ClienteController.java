
package com.springboot.proyectoFinal.controller;

import com.springboot.proyectoFinal.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import com.springboot.proyectoFinal.model.Cliente;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class ClienteController {

    @Autowired
    ClienteService clienteService;
// alta de cliente

    @PostMapping("/cliente/alta")
    public void saveCliente(@RequestBody Cliente cliente) {
        clienteService.saveCliente(cliente);
    }
// lectura de un cliente

    @GetMapping("/cliente/traer/{id_cliente}")
    @ResponseBody
    public Cliente findCliente(@PathVariable Long id_cliente) {
        return clienteService.findCliente(id_cliente);
    }
// lectura de todos los clientes
    
    @GetMapping("/cliente/traerTodo")
    @ResponseBody
    public List<Cliente> getClientes(){
        return clienteService.getClientes();
    }
// eliminacion de un cliente
    
    @DeleteMapping("/cliente/eliminar/{id_cliente}")
    public void deleteCliente(@PathVariable Long id_cliente){
        clienteService.deleteCliente(id_cliente);
                
    }
    
// modificacion de un cliente
    @PutMapping("/cliente/editar")
    public void editCliente(@RequestBody Cliente cliente){
        clienteService.editCliente(cliente);
    }
}
