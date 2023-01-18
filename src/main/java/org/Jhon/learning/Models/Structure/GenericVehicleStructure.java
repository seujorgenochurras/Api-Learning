package org.Jhon.learning.Models.Structure;

import com.google.gson.JsonPrimitive;
import org.Jhon.learning.ApiTesting.GenericAPIModel;
import org.Jhon.learning.Models.Marca;
import org.Jhon.learning.Models.Modelo;
import org.Jhon.learning.Models.ModeloAno;
import org.Jhon.learning.Models.Veiculo;

public abstract class GenericVehicleStructure extends GenericAPIModel<Veiculo> {
   private String codigoFipe;
   private String autenticacao;
   private String dataConsulta;
   private String valor;
   private String mesReferencia;
   private ModeloAno modeloAnoObject;

   ModeloAno getModeloAnoObject() {
      return modeloAnoObject;
   }

   public void setModeloAnoObject(ModeloAno modeloAnoObject) {
      this.modeloAnoObject = modeloAnoObject;
   }
   public String getVeiculoTipoNome(){
      return CarTypes.getByValue(getMarcaObject().getVeiculoID()).name();
   }

   public Marca getMarcaObject(){
      return getModeloObject().getMarcaObject();
   }
   public Modelo getModeloObject(){
      return getModeloAnoObject().getModeloObject();
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

   public String getCombustivelName() {
      return getModeloAnoObject().getCombustivel().name();
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

   public char getSiglaCombustivel(){
      return getModeloAnoObject().getCombustivel().symbol;
   }

   public String getModeloNome(){
      return getModeloObject().getModelName();
   }
   public String getMarcaNome(){
      return getMarcaObject().getModelName();
   }

   public int getAno(){
      return getModeloAnoObject().getAno();
   }

@Override
   public String getModelName(){
      return getMarcaObject().getModelName() + " "+ getModeloAnoObject().getModeloObject().getModelName();
}

}
