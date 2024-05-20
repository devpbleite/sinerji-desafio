package com.example.empresa.controller;

import com.example.empresa.model.Funcionario;
import com.example.empresa.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

  @Autowired
  private FuncionarioService funcionarioService;

  @GetMapping("/total-pago")
  public double getTotalPago(@RequestParam List<Funcionario> funcionarios, @RequestParam int ano,
      @RequestParam int mes) {
    return funcionarioService.calcularTotalPago(funcionarios, ano, mes);
  }

  @GetMapping("/total-salarios")
  public double getTotalSalarios(@RequestParam List<Funcionario> funcionarios, @RequestParam int ano,
      @RequestParam int mes) {
    return funcionarioService.calcularTotalSalarios(funcionarios, ano, mes);
  }

  @GetMapping("/total-beneficios")
  public double getTotalBeneficios(@RequestParam List<Funcionario> funcionarios, @RequestParam int ano,
      @RequestParam int mes) {
    return funcionarioService.calcularTotalBeneficios(funcionarios, ano, mes);
  }

  @GetMapping("/maior-pagamento")
  public Funcionario getFuncionarioComMaiorPagamento(@RequestParam List<Funcionario> funcionarios,
      @RequestParam int ano, @RequestParam int mes) {
    return funcionarioService.encontrarFuncionarioComMaiorPagamento(funcionarios, ano, mes);
  }

  @GetMapping("/maior-beneficio")
  public Funcionario getFuncionarioComMaiorBeneficio(@RequestParam List<Funcionario> funcionarios,
      @RequestParam int ano, @RequestParam int mes) {
    return funcionarioService.encontrarFuncionarioComMaiorBeneficio(funcionarios, ano, mes);
  }

  @GetMapping("/maior-venda")
  public Funcionario getVendedorComMaiorVenda(@RequestParam List<Funcionario> vendedores, @RequestParam int ano,
      @RequestParam int mes) {
    return funcionarioService.encontrarVendedorComMaiorVenda(vendedores, ano, mes);
  }
}
