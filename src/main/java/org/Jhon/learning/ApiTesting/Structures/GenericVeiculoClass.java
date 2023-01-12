package org.Jhon.learning.ApiTesting.Structures;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.Jhon.learning.ApiTesting.Structures.Request.VeiculoRequest;
import org.Jhon.learning.Models.Veiculo;

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
      JsonArray jsonArray = new JsonArray();
      jsonArray.add(jsonElement);
      parseToModel(jsonArray, Veiculo.class);
   }

   @Override
   protected void getAdditionalMethods(Object model) {
      Veiculo veiculo = (Veiculo) model;
      veiculo.addToList();
   }
}
