package org.Jhon.learning.ApiTesting.Structures;

import com.google.gson.JsonElement;
import org.Jhon.learning.ApiTesting.Structures.Request.ModeloRequest;
import org.Jhon.learning.Models.Modelo;

import java.util.Objects;

public abstract class GenericModelo<T extends ModeloRequest> extends GenericMarca<T> {
   private int marcaID;



   public int getMarcaID() {
      return marcaID;
   }
   public void setMarcaID(int marcaID) {
      this.marcaID = marcaID;
   }
   @Override
   public void toModel(JsonElement jsonElement)throws IllegalStateException {
      if (Objects.isNull(jsonElement)) throw new IllegalStateException("JSON CANNOT BE NULL");
      parseToModel(jsonElement.getAsJsonObject().get("Modelos").getAsJsonArray(), Modelo.class);
   }
   @Override
   protected void getAdditionalMethods(Object model) {
     Modelo modelo = (Modelo) model;
      modelo.setModeloID(modelo.getValue());
      modelo.setVeiculoID(getVehicleID());
      modelo.setTabelaReferencialID(getTabelaReferenciaID());
      modelo.setMarcaID(getMarcaID());
      modelo.addToList();
   }
}
