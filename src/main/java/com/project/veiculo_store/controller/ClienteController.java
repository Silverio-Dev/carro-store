package com.project.veiculo_store.controller;

import com.project.veiculo_store.model.Cliente;
import com.project.veiculo_store.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> listarCliente() {
        return clienteService.listarClientes();
    }

    @PostMapping
    public Cliente criarCliente(@RequestBody Cliente cliente){
        return clienteService.cadastrarCliente(cliente);
    }

    @GetMapping("/{id}")
    public Cliente buscarClientePeloId(@PathVariable Long id){
        return clienteService.buscarClientePorId(id);
    }

    @PutMapping("/{id}")
    public Cliente alterarCliente(@PathVariable Long id, @RequestBody Cliente cliente){
        return clienteService.alterarCliente(id, cliente);
    }
    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable Long id){
        Cliente cliente = buscarClientePeloId(id);
        clienteService.deletarCliente(id);
    }
}
