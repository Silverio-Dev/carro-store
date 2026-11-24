package com.project.veiculo_store.controller;

import com.project.veiculo_store.dtos.CarroRequest;
import com.project.veiculo_store.model.Carro;
import com.project.veiculo_store.service.CarroService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Carro-store")
public class CarroController {

    private CarroService carroService;

    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping
    public List<Carro> listarCarro() {
        return carroService.listarCarros();
    }

    @GetMapping("/cor")
    public List<Carro> buscarCarroPorColor(@RequestParam String color) {
        return carroService.listarCarroPorColor(color);
    }

    @GetMapping("/marca")
    public List<Carro> buscarCarroPorMarca(@RequestParam String brand) {
        return carroService.buscarCarroPorBrand(brand);
    }

    @GetMapping("/model")
    public List<Carro> buscarCarroPorModelo(@RequestParam String model) {
        return carroService.buscarCarroPorModel(model);
    }

    @GetMapping("/disponiveis")
    public List<Carro> buscarCarrosDisponiveis(boolean disponivel) {
        return carroService.listarDisponiveis(true);
    }

    @PostMapping
    public ResponseEntity<Carro> cadastrarCarro(@RequestBody CarroRequest request) {
        Carro carro =  carroService.cadastrarCarro(request);
        return ResponseEntity.ok(carro);
    }

    @GetMapping("/{id}")
    public Carro buscarCarroPorId(@PathVariable Long id) {
        return carroService.buscarCarroPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarCarro(@PathVariable Long id){
        carroService.deletarCarro(id);

    }
}
