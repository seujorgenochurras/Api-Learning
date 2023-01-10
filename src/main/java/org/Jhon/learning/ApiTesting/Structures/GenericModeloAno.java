package org.Jhon.learning.ApiTesting.Structures;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.Jhon.learning.ApiTesting.Structures.Request.AnoModeloRequest;
import org.Jhon.learning.Models.ModeloAno;

import java.util.Objects;

//Esse é referência a interface AnoModeloRequest
public abstract class GenericModeloAno<T extends AnoModeloRequest> extends GenericModelo<T> {
   private int modeloID;
   public int getModeloID() {
      return modeloID;
   }

   public void setModeloID(int modeloID) {
      this.modeloID = modeloID;
   }


   @Override
   public void toModel(JsonElement jsonElement) {
      if(Objects.isNull(jsonElement)) throw new IllegalStateException("CANNOT SAVE NULL JSON");
      JsonArray jsonArray = jsonElement.getAsJsonArray();
      jsonArray.forEach(item ->{
         String[] rawValues = item.getAsJsonObject().get("Value").getAsString().split("-");
         //"Value":"1992-1"
         String ano = rawValues[0];
         int combustivel = Integer.parseInt(rawValues[1]);
         ModeloAno modeloAno = new ModeloAno();
         modeloAno.setName(ano);
         modeloAno.setValue(combustivel);
         modeloAno.setModeloID(getModeloID());
         modeloAno.setMarcaID(getMarcaID());
         modeloAno.setVeiculoID(getVehicleID());
         modeloAno.setTabelaReferencialID(getTabelaReferenciaID());
         modeloAno.addToList();
      });
   }
}
