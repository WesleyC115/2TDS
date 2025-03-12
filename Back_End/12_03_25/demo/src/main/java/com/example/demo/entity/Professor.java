package com.example.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity

public class Professor {
    @Id
    private Integer id;
    private String nome;
    private Integer idade;
    private  double salario;

    public Professor () {

    }

    public Professor(Integer id, String nome, Integer idade, double salario) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
