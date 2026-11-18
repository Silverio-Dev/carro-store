package com.project.veiculo_store.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "Veiculos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String brand;
    private String sign;
    private String color;
    private int year;
    private BigDecimal value;
    private boolean disponivel;




}
