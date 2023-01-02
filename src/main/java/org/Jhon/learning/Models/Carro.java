package org.Jhon.learning.Models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Carro {

  public static final LocalDate mesReferencia = LocalDate.of(2023,1,1);

  private int codFipe;
  private String marca;
  private String modelo;
  private LocalDate ano;
  private Combustivel combustivel;
  private String auth;
  private LocalDate diaConsulta;
  private BigDecimal preco;

  public int getCodFipe() {
    return codFipe;
  }

  public void setCodFipe(int codFipe) {
    this.codFipe = codFipe;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public LocalDate getAno() {
    return ano;
  }

  public void setAno(LocalDate ano) {
    this.ano = ano;
  }

  public Combustivel getCombustivel() {
    return combustivel;
  }

  public void setCombustivel(Combustivel combustivel) {
    this.combustivel = combustivel;
  }

  public String getAuth() {
    return auth;
  }

  public void setAuth(String auth) {
    this.auth = auth;
  }

  public LocalDate getDiaConsulta() {
    return diaConsulta;
  }

  public void setDiaConsulta(LocalDate diaConsulta) {
    this.diaConsulta = diaConsulta;
  }

  public BigDecimal getPreco() {
    return preco;
  }

  public void setPreco(BigDecimal preco) {
    this.preco = preco;
  }
}
