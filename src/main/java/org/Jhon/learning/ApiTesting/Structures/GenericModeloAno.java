package org.Jhon.learning.ApiTesting.Structures;

import com.google.gson.*;
import org.Jhon.learning.ApiTesting.Structures.Request.AnoModeloRequest;
import org.Jhon.learning.Models.Modelo;
import org.Jhon.learning.Models.ModeloAno;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

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
      //Getting only the years
      JsonArray jsonYears = jsonElement.getAsJsonArray();

      //Creating an emulated response Json
      JsonArray emulatedJson = new JsonArray();
      JsonObject emulatedFields = new JsonObject();
      AtomicBoolean s = new AtomicBoolean(false);
      jsonYears.forEach(field ->{
          //Transforming JsonField "Value" into the two needed values
          String[] valueFields = field.getAsJsonObject().get("Value").getAsString().split("-");
          String ano = valueFields[0];
          String combustivelID = valueFields[1];

      emulatedFields.add("Label", JsonParser.parseString(ano));
      emulatedFields.add("Value",  JsonParser.parseString(combustivelID));
      emulatedJson.add(emulatedFields.deepCopy());
      });
     parseToModel(emulatedJson, ModeloAno.class);
   }

   @Override
   protected void getAdditionalMethods(Object model) {
     ModeloAno modeloAno = (ModeloAno) model;
      modeloAno.setModeloID(getModeloID());
      modeloAno.setMarcaID(getMarcaID());
      modeloAno.setVeiculoID(getVehicleID());
      modeloAno.setTabelaReferencialID(getTabelaReferenciaID());
      modeloAno.addToList();
   }
}
