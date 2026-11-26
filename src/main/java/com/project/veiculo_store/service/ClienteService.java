package com.project.veiculo_store.service;

import com.project.veiculo_store.dtos.ClienteRequest;
import com.project.veiculo_store.model.Cliente;
import com.project.veiculo_store.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;
    
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    public Cliente cadastrarCliente(ClienteRequest request){
        Cliente cliente = new Cliente();
        cliente.setName(request.getName());
        cliente.setCity(request.getCity());
        cliente.setContact(request.getContact());
        cliente.setCpf(request.getCpf());
        cliente.setAge(request.getAge());
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    public Cliente buscarClientePorId(Long id){
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
    }

    public Cliente alterarCliente(Long id, Cliente cliente){
       Cliente clienteAtualizado  =  buscarClientePorId(id);

       clienteAtualizado.setName(cliente.getName());
       clienteAtualizado.setCpf(cliente.getCpf());
       clienteAtualizado.setContact(cliente.getContact());
       clienteAtualizado.setAge(cliente.getAge());
       clienteAtualizado.setCity(cliente.getCity());

       return clienteRepository.save(clienteAtualizado);
    }

    public void deletarCliente(Long id){
        Cliente cliente = buscarClientePorId(id);
        clienteRepository.delete(cliente);
    }

}
