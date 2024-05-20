package com.example.empresa.model;

import java.time.LocalDate;

public class Secretario extends Funcionario {
  private static final double SALARIO_BASE = 7000.00;
  private static final double BONUS_ANO = 1000.00;
  private static final double BENEFICIO_PERCENTUAL = 0.20;

  public Secretario(String nome, LocalDate dataContratacao) {
    super(nome, dataContratacao, "Secretário");
  }

  @Override
  public double calcularSalario(int ano, int mes) {
    int anosServico = ano - getDataContratacao().getYear();
    return SALARIO_BASE + (anosServico * BONUS_ANO);
  }

  @Override
  public double calcularBeneficio(int ano, int mes) {
    return calcularSalario(ano, mes) * BENEFICIO_PERCENTUAL;
  }
}
