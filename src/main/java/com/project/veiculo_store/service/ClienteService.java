package com.project.veiculo_store.service;

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


    public Cliente cadastrarCliente(Cliente cliente){
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
