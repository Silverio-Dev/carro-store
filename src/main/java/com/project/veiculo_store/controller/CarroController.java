package com.project.veiculo_store.controller;

import com.project.veiculo_store.dtos.CarroRequest;
import com.project.veiculo_store.dtos.DescontoRequest;
import com.project.veiculo_store.model.Carro;
import com.project.veiculo_store.service.CarroService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/Carro-store")
public class CarroController {

    private CarroService carroService;

    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping
    public ResponseEntity<List<Carro>> listarCarro() {
        return ResponseEntity.ok(carroService.listarCarros());

    }

    @GetMapping("/cor")
    public ResponseEntity<List<Carro>> buscarCarroPorColor(@RequestParam String color) {
        return ResponseEntity.ok(carroService.listarCarroPorColor(color));
    }

    @GetMapping("/marca")
    public ResponseEntity<List<Carro>> buscarCarroPorMarca(@RequestParam String brand) {
        return ResponseEntity.ok(carroService.buscarCarroPorBrand(brand));
    }

    @GetMapping("/model")
    public ResponseEntity<List<Carro>> buscarCarroPorModelo(@RequestParam String model) {
        return ResponseEntity.ok(carroService.buscarCarroPorModel(model));
    }

    @GetMapping("/disponiveis")
    public ResponseEntity<List<Carro>> buscarCarrosDisponiveis(boolean disponivel) {
        return ResponseEntity.ok(carroService.listarDisponiveis(true));
    }

    @PostMapping
    public ResponseEntity<Carro> cadastrarCarro(@RequestBody CarroRequest request) {
        Carro carro =  carroService.cadastrarCarro(request);
        return ResponseEntity.ok(carro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> buscarCarroPorId(@PathVariable Long id) {
        return ResponseEntity.ok(carroService.buscarCarroPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCarro(@PathVariable Long id){
        carroService.deletarCarro(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/desconto")
    public ResponseEntity<Carro> aplicarDesconto(@PathVariable Long id, @RequestBody DescontoRequest request){
        return ResponseEntity.ok(carroService.aplicarDesconto(id, request.getPercentual()));
    }
}
