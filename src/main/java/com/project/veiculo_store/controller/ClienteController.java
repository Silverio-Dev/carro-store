package com.project.veiculo_store.controller;

import com.project.veiculo_store.dtos.ClienteRequest;
import com.project.veiculo_store.model.Cliente;
import com.project.veiculo_store.service.ClienteService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Cliente>> listarCliente() {
        return ResponseEntity.ok(clienteService.listarClientes());
    }

    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody ClienteRequest request){
        Cliente cliente =  clienteService.cadastrarCliente(request);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClientePeloId(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.buscarClientePorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> alterarCliente(@PathVariable Long id, @RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.alterarCliente(id, cliente));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id){
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
