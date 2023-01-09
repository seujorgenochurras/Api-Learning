package org.Jhon.learning.Models.Structure;

import java.time.Year;

public abstract class GenericVehicleStructure extends GenericModeloAnoModel {
   private String codFipe;
   private String marca;
   private String modelo;
   private Year ano;
   private String combustivel;
   private String siglaCombustivel;
   private String auth;
   private String diaConsulta;
   private String preco;

   private String mesReferencia;

   private int tipoVeiculo;

   public String getSiglaCombustivel() {
      return siglaCombustivel;
   }

   public void setSiglaCombustivel(String siglaCombustivel) {
      this.siglaCombustivel = siglaCombustivel;
   }

   public int getTipoVeiculo() {
      return tipoVeiculo;
   }

   public void setTipoVeiculo(int tipoVeiculo) {
      this.tipoVeiculo = tipoVeiculo;
   }

   public String getMesReferencia() {
      return mesReferencia;
   }

   public void setMesReferencia(String mesReferencia) {
      this.mesReferencia = mesReferencia;
   }

   public String getCodFipe() {
      return codFipe;
   }

   public void setCodFipe(String codFipe) {
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

   public Year getAno() {
      return ano;
   }

   public void setAno(Year ano) {
      this.ano = ano;
   }

   public String getCombustivel() {
      return combustivel;
   }

   public void setCombustivel(String combustivel) {
      this.combustivel = combustivel;
   }

   public String getAuth() {
      return auth;
   }

   public void setAuth(String auth) {
      this.auth = auth;
   }

   public String getDiaConsulta() {
      return diaConsulta;
   }

   public void setDiaConsulta(String diaConsulta) {
      this.diaConsulta = diaConsulta;
   }

   public String getPreco() {
      return preco;
   }

   public void setPreco(String preco) {
      this.preco = preco;
   }
}
