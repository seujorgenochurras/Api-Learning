package org.Jhon.learning.ApiTesting.Structures;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.Jhon.learning.ApiTesting.Structures.Request.VeiculoRequest;
import org.Jhon.learning.Models.Veiculo;

import java.time.Year;
import java.util.Objects;

public abstract class GenericVeiculoClass<T extends VeiculoRequest> extends GenericModeloAno<T>  {
   private int combustivelID;
   private String anoModeloID;

   public int getCombustivelID() {
      return combustivelID;
   }

   public void setCombustivelID(int combustivelID) {
      this.combustivelID = combustivelID;
   }

   public String getAnoModeloID() {
      return anoModeloID;
   }

   public void setAnoModeloID(String anoModeloID) {
      this.anoModeloID = anoModeloID;
   }
   @Override
   public void toModel(JsonElement jsonElement) {
      if(Objects.isNull(jsonElement)) throw new IllegalStateException("CANNOT SAVE NULL JSON");
      JsonObject json = jsonElement.getAsJsonObject();
      String preco = json.get("Valor").getAsString();
      String marca = json.get("Marca").getAsString(); //TODO this comes from a model
      String modelo = json.get("Modelo").getAsString(); //TODO this comes from a model
      String anoModelo = json.get("AnoModelo").getAsString();
      String combustivel = json.get("Combustivel").getAsString(); //TODO this comes from a model
      String codigoFipe = json.get("CodigoFipe").getAsString();
      String mesReferencia = json.get("MesReferencia").getAsString();
      String auth = json.get("Autenticacao").getAsString();
      int codigoVeiculo = json.get("TipoVeiculo").getAsInt();
      String siglaCombustivel = json.get("SiglaCombustivel").getAsString();
      String dataConsulta = json.get("DataConsulta").getAsString();

      Veiculo veiculo = new Veiculo();
      veiculo.setPreco(preco);
      veiculo.setAno(Year.parse(anoModelo));
      veiculo.setAuth(auth);
      veiculo.setCombustivel(combustivel);
      veiculo.setSiglaCombustivel(siglaCombustivel);
      veiculo.setMarca(marca);
      veiculo.setModelo(modelo);
      veiculo.setCodFipe(codigoFipe);
      veiculo.setMesReferencia(mesReferencia);
      veiculo.setDiaConsulta(dataConsulta);
      veiculo.setTipoVeiculo(codigoVeiculo);

      veiculo.addToList();
   }

}
