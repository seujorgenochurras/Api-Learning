package org.Jhon.learning.ApiTesting.Structures;


import com.google.gson.JsonElement;
import org.Jhon.learning.ApiTesting.Structures.Request.MarcasRequest;
import org.Jhon.learning.Models.Marca;

import java.util.Objects;

public abstract class GenericMarca<T extends MarcasRequest> extends GenericConsultarClass<T>{
   private Integer vehicleID;
   private Integer tabelaReferenciaID;

   public int getVehicleID() {
      return vehicleID;
   }

   public void setVehicleID(int vehicleID) {
      this.vehicleID = vehicleID;
   }
   public int getTabelaReferenciaID() {
      return tabelaReferenciaID;
   }

   public void setTabelaReferenciaID(int tabelaReferenciaID) {
      this.tabelaReferenciaID = tabelaReferenciaID;
   }

   @Override
   public void toModel(JsonElement jsonElement)throws IllegalStateException {
      if (Objects.isNull(jsonElement)) throw new IllegalStateException("JSON CANNOT BE NULL");
      try {

      parseToModel(jsonElement.getAsJsonArray(), Marca.class);
      }catch (IllegalStateException e){
         System.out.println("damn it, something went completely wrong .-.");
         System.out.println(e.getMessage());
      }
   }
   @Override
   protected void getAdditionalMethods(Object model) {
      Marca marca = (Marca) model;
      marca.setVeiculoID(getVehicleID());
      marca.setTabelaReferencialID(getTabelaReferenciaID());

      marca.addToList();
   }
}
