package com.project.veiculo_store.dtos;

public class ClienteRequest {

    private String  name;
    private String contact;
    private int age;
    private String cpf;
    private String city;

    public ClienteRequest(String name, String contact, int age, String cpf, String city) {
        this.name = name;
        this.contact = contact;
        this.age = age;
        this.cpf = cpf;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}


