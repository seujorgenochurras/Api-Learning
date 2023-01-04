package org.Jhon.learning.Models.Structure;

import org.Jhon.learning.Models.Marca;
import org.Jhon.learning.Models.Modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class GenericCarStructure {
   private int codFipe;
   private Marca marca;
   private Modelo modelo;
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

   public Marca getMarca() {
      return marca;
   }

   public void setMarca(Marca marca) {
      this.marca = marca;
   }

   public Modelo getModelo() {
      return modelo;
   }

   public void setModelo(Modelo modelo) {
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
