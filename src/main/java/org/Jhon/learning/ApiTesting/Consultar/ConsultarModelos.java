package org.Jhon.learning.ApiTesting.Consultar;

import com.google.gson.JsonArray;
import org.Jhon.learning.ApiTesting.Structures.GenericModelo;
import org.Jhon.learning.ApiTesting.Structures.Request.ModeloRequest;
import org.Jhon.learning.Models.Marca;
import org.Jhon.learning.Models.Modelo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

import java.util.Objects;

public class ConsultarModelos extends GenericModelo<ModeloRequest> {
   @Override
   public void toModel() throws IllegalStateException{
    if(Objects.isNull(response)) throw new IllegalStateException("CANNOT SAVE NULL JSON");
    JsonArray json = (JsonArray) response.getAsJsonObject().get("Modelos");
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

   public ConsultarModelos(int marcaID, int vehicleID, int tabelaReferenciaID){
      setMarcaID(marcaID);
      setVehicleID(vehicleID);
      setTabelaReferenciaID(tabelaReferenciaID);
   }
   public ConsultarModelos(){}
   public ConsultarModelos(Marca marca){
      setVehicleID(marca.getVeiculoID());
      setTabelaReferenciaID(marca.getTabelaReferencialID());
      setMarcaID(marca.getValue());
   }

   @Override
   protected ModeloRequest getStructure() {
      return new ModeloRequest() {
         @Override
         public int getCodigoMarca() {
            return getMarcaID();
         }

         @Override
         public @Range(from = 1, to = 3) @NotNull Integer getCodigoTipoVeiculo() {
            return getVehicleID();
         }

         @Override
         public Integer getCodigoTabelaReferencia() {
            return getTabelaReferenciaID();
         }
      };
   }



}
