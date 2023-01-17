package org.Jhon.learning.Models.Structure;

import com.google.gson.JsonPrimitive;
import org.Jhon.learning.Models.Veiculo;

public abstract class GenericVehicleStructure extends GenericModeloAnoModel {
   private String codigoFipe;
   private String marca;
   private String modelo;
   private int anoModelo;
   private String combustivel;
   private Character siglaCombustivel;
   private String autenticacao;
   private String dataConsulta;
   private String valor;
   private String mesReferencia;
   private byte tipoVeiculo;

   @Override
   public String getNome(){
      return getMarca() + " "+ getModelo();
   }

   public Character getSiglaCombustivel() {
      return siglaCombustivel;
   }

   public void setSiglaCombustivel(JsonPrimitive siglaCombustivel) {
         this.siglaCombustivel = siglaCombustivel.getAsJsonPrimitive().getAsString().charAt(0);
  }
  public void setSiglaCombustivel(Character siglaCombustivel) {
         this.siglaCombustivel = siglaCombustivel;
  }

   public byte getTipoVeiculo() {
      return tipoVeiculo;
   }
   public String getVeiculoTipoNome(){
      return CarTypes.getByValue(getTipoVeiculo()).name();
   }

   public void setTipoVeiculo(JsonPrimitive tipoVeiculo) {
         this.tipoVeiculo = tipoVeiculo.getAsByte();
   }
   public void setTipoVeiculo(byte tipoVeiculo) {
         this.tipoVeiculo = tipoVeiculo;
   }

   public String getMesReferencia() {
      return mesReferencia;
   }

   public void setMesReferencia(JsonPrimitive mesReferencia) {
      this.mesReferencia = mesReferencia.getAsString();
   }
   public void setMesReferencia(String mesReferencia) {
      this.mesReferencia = mesReferencia;
   }

   public String getCodigoFipe() {
      return codigoFipe;
   }

   public void setCodigoFipe(JsonPrimitive codigoFipe) {
      this.codigoFipe = codigoFipe.getAsString();
   }
   public void setCodigoFipe(String codigoFipe) {
      this.codigoFipe = codigoFipe;
   }

   public String getMarca() {
      return marca;
   }

   public void setMarca(JsonPrimitive marca) {
      this.marca = marca.getAsString();
   }
   public void setMarca(String marca) {
      this.marca = marca;
   }

   public String getModelo() {
      return modelo;
   }

   public void setModelo(JsonPrimitive modelo) {
      this.modelo = modelo.getAsString();
   }
   public void setModelo(String modelo) {
      this.modelo = modelo;
   }

   public int getAnoModelo() {
      return anoModelo;
   }

   public void setAnoModelo(JsonPrimitive anoModelo) {
      this.anoModelo = anoModelo.getAsInt();
   }
   public void setAnoModelo(int anoModelo) {
      this.anoModelo = anoModelo;
   }

   public String getCombustivel() {
      return combustivel;
   }

   public void setCombustivel(JsonPrimitive combustivel) {
      this.combustivel = combustivel.getAsString();
   }
   public void setCombustivel(String combustivel) {
      this.combustivel = combustivel;
   }

   public String getAutenticacao() {
      return autenticacao;
   }

   public void setAutenticacao(JsonPrimitive autenticacao) {
      this.autenticacao = autenticacao.getAsString();
   }
   public void setAutenticacao(String autenticacao) {
      this.autenticacao = autenticacao;
   }

   public String getDataConsulta() {
      return dataConsulta;
   }

   public void setDataConsulta(JsonPrimitive dataConsulta) {
      this.dataConsulta = dataConsulta.getAsString();
   }
   public void setDataConsulta(String dataConsulta) {
      this.dataConsulta = dataConsulta;
   }

   /**
    * @return Raw price of the vehicle, containing monetary symbol
    * @see Veiculo#getPreco()
    * */
   public String getValor() {
      return valor;
   }

   public void setValor(JsonPrimitive valor) {
      this.valor = valor.getAsString();
   }
   public void setValor(String valor) {
      this.valor = valor;
   }

}
