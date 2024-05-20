package com.example.empresa.model;

import java.time.LocalDate;

public abstract class Funcionario {
  private String nome;
  private LocalDate dataContratacao;
  private String cargo;

  public Funcionario(String nome, LocalDate dataContratacao, String cargo) {
    this.nome = nome;
    this.dataContratacao = dataContratacao;
    this.cargo = cargo;
  }

  public String getNome() {
    return nome;
  }

  public LocalDate getDataContratacao() {
    return dataContratacao;
  }

  public String getCargo() {
    return cargo;
  }

  public abstract double calcularSalario(int ano, int mes);

  public abstract double calcularBeneficio(int ano, int mes);
}
