package com.project.veiculo_store.service;

import com.project.veiculo_store.model.Carro;
import com.project.veiculo_store.repository.CarroRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    private CarroRepository carroRepository;

    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }


    public Carro cadastrarCarro(Carro carro){
        return carroRepository.save(carro);
    }

    public List<Carro> listarCarros(){
        return carroRepository.findAll();
    }

    public Carro buscarCarroPorId(Long id){
        return (Carro) carroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carro não encontrado"));

    }

    public List<Carro> buscarCarroPorModel(String model){
        return carroRepository.findByModel(model);
    }

    public List<Carro> buscarCarroPorBrand(String brand){
        return carroRepository.findByBrand(brand);
    }

    public List<Carro> listarDisponiveis(boolean disponivel){
        return carroRepository.findByDisponivelTrue(disponivel);
    }

    public List<Carro> listarCarroPorColor(String color){
        return carroRepository.findByColor(color);
    }

    public Carro atualizarCarro(Long id, Carro carro){
        Carro carroatualizado = buscarCarroPorId(id);

        carroatualizado.setModel(carro.getModel());
        carroatualizado.setBrand(carro.getBrand());
        carroatualizado.setColor(carro.getColor());
        carroatualizado.setSign(carro.getSign());
        carroatualizado.setDisponivel(carro.isDisponivel());
        carroatualizado.setValue(carro.getValue());
        return carroRepository.save(carroatualizado);
    }

    public void deletarCarro(Long id){
        Carro carro = buscarCarroPorId(id);
        carroRepository.delete(carro);
    }



}
