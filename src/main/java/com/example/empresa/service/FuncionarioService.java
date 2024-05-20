package com.example.empresa.service;

import com.example.empresa.model.Funcionario;
import com.example.empresa.model.Vendedor;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FuncionarioService {

  public double calcularTotalPago(List<Funcionario> funcionarios, int ano, int mes) {
    return funcionarios.stream()
        .mapToDouble(f -> f.calcularSalario(ano, mes) + f.calcularBeneficio(ano, mes))
        .sum();
  }

  public double calcularTotalSalarios(List<Funcionario> funcionarios, int ano, int mes) {
    return funcionarios.stream()
        .mapToDouble(f -> f.calcularSalario(ano, mes))
        .sum();
  }

  public double calcularTotalBeneficios(List<Funcionario> funcionarios, int ano, int mes) {
    return funcionarios.stream()
        .filter(f -> f.calcularBeneficio(ano, mes) > 0)
        .mapToDouble(f -> f.calcularBeneficio(ano, mes))
        .sum();
  }

  public Funcionario encontrarFuncionarioComMaiorPagamento(List<Funcionario> funcionarios, int ano, int mes) {
    return funcionarios.stream()
        .max((f1, f2) -> Double.compare(
            f1.calcularSalario(ano, mes) + f1.calcularBeneficio(ano, mes),
            f2.calcularSalario(ano, mes) + f2.calcularBeneficio(ano, mes)))
        .orElse(null);
  }

  public Funcionario encontrarFuncionarioComMaiorBeneficio(List<Funcionario> funcionarios, int ano, int mes) {
    return funcionarios.stream()
        .filter(f -> f.calcularBeneficio(ano, mes) > 0)
        .max((f1, f2) -> Double.compare(f1.calcularBeneficio(ano, mes), f2.calcularBeneficio(ano, mes)))
        .orElse(null);
  }

  public Funcionario encontrarVendedorComMaiorVenda(List<Funcionario> vendedores, int ano, int mes) {
    return vendedores.stream()
        .filter(f -> f instanceof Vendedor)
        .max((f1, f2) -> Double.compare(((Vendedor) f1).getVendasMes(ano, mes), ((Vendedor) f2).getVendasMes(ano, mes)))
        .orElse(null);
  }
}
