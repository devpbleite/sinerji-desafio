package com.example.empresa.model;

import java.time.LocalDate;

public class Gerente extends Funcionario {
  private static final double SALARIO_BASE = 20000.00;
  private static final double BONUS_ANO = 3000.00;

  public Gerente(String nome, LocalDate dataContratacao) {
    super(nome, dataContratacao, "Gerente");
  }

  @Override
  public double calcularSalario(int ano, int mes) {
    int anosServico = ano - getDataContratacao().getYear();
    return SALARIO_BASE + (anosServico * BONUS_ANO);
  }

  @Override
  public double calcularBeneficio(int ano, int mes) {
    return 0.0;
  }
}
