package com.project.veiculo_store.dtos;

import java.math.BigDecimal;

public class CarroResponse {

    private Long id;
    private String model;
    private String brand;
    private String sign;
    private String color;
    private int year;
    private BigDecimal value;
    private boolean disponivel;

    public CarroResponse(Long id, String model, String brand, String sign, String color,
                         int year, BigDecimal value, boolean disponivel) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.sign = sign;
        this.color = color;
        this.year = year;
        this.value = value;
        this.disponivel = disponivel;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

}
