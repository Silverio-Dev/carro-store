package com.project.veiculo_store.repository;

import com.project.veiculo_store.model.Carro;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarroRepository extends JpaRepository<Carro,Id> {

    List<Carro> findByBrand(String brand);
    List<Carro> findByModel(String model);
    List<Carro> findByColor(String color);
    List<Carro> findByDisponivelTrue(boolean disponivel);

    Optional<Object> findById(Long id);

    List<Carro> id(Long id);

    List<Carro> model(String model);
}
