package org.Jhon.learning.ApiTesting.Structures;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.Jhon.learning.ApiTesting.Consultar.ConsultarMarcas;
import org.Jhon.learning.ApiTesting.Structures.Request.ModeloRequest;
import org.Jhon.learning.Models.Marca;
import org.Jhon.learning.Models.Modelo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

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
   public void toModel(JsonElement jsonElement) {
      if(Objects.isNull(jsonElement)) throw new IllegalStateException("CANNOT SAVE NULL JSON");
      JsonArray json = (JsonArray) jsonElement.getAsJsonObject().get("Modelos");
      json.getAsJsonArray().forEach(item ->{
         int value = item.getAsJsonObject().get("Value").getAsInt();
         String name = item.getAsJsonObject().get("Label").getAsString();
         Modelo modelo = new Modelo();
         modelo.setValue(value);
         modelo.setName(name);
         modelo.setModeloID(value);
         modelo.setVeiculoID(getVehicleID());
         modelo.setTabelaReferencialID(getTabelaReferenciaID());
         modelo.setMarcaID(getMarcaID());
         modelo.addToList();
      });
   }
}
