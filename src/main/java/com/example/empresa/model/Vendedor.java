package com.example.empresa.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Vendedor extends Funcionario {
  private static final double SALARIO_BASE = 12000.00;
  private static final double BONUS_ANO = 1800.00;
  private Map<String, Double> vendas;

  public Vendedor(String nome, LocalDate dataContratacao) {
    super(nome, dataContratacao, "Vendedor");
    this.vendas = new HashMap<>();
  }

  public void adicionarVenda(String mesAno, double valor) {
    vendas.put(mesAno, valor);
  }

  public double getVendasMes(int ano, int mes) {
    String chave = String.format("%02d/%d", mes, ano);
    return vendas.getOrDefault(chave, 0.0);
  }

  @Override
  public double calcularSalario(int ano, int mes) {
    int anosServico = ano - getDataContratacao().getYear();
    return SALARIO_BASE + (anosServico * BONUS_ANO);
  }

  @Override
  public double calcularBeneficio(int ano, int mes) {
    return getVendasMes(ano, mes) * 0.30;
  }
}
