package org.Jhon.learning.ApiTesting;

import com.google.gson.JsonArray;
import org.Jhon.learning.ApiTesting.Structures.GenericConsultarClass;
import org.Jhon.learning.ApiTesting.Structures.Request.MarcasRequest;
import org.Jhon.learning.Models.Marca;
import org.Jhon.learning.Models.Structure.CarTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

import java.io.IOException;

public class ConsultarMarcas extends GenericConsultarClass<MarcasRequest> {
   private int vehicleID;
   private int tabelaReferenciaID;

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


   public ConsultarMarcas( int vehicleID, int tabelaReferenciaID){
         setVehicleID(vehicleID);
         setTabelaReferenciaID(tabelaReferenciaID);
      }
   public ConsultarMarcas(CarTypes carType, int tabelaReferenciaID){
         setVehicleID(carType.value);
         setTabelaReferenciaID(tabelaReferenciaID);
      }

   @Override
   public JsonArray getResponse() throws IOException {
      requester.setRequestStructure(new MarcasRequest() {
         @Override
         public @Range(from = 1, to = 3) @NotNull Integer getCodigoTipoVeiculo() {
            return getVehicleID();
         }

         @Override
         public Integer getCodigoTabelaReferencia() {
            return getTabelaReferenciaID();
         }

         @Override
         public URLTypes getURLStructure() {
            return URLTypes.MARCAS;
         }
      });
      response = requester.doRequest().getAsJsonArray();
      return response;
   }

   /* public void getMarcas() throws IOException {

      */
   @Override
   public void saveResponse() {
      response.forEach(item -> {
         Marca marca = new Marca();
         marca.setName(item.getAsJsonObject().get("Label").getAsString());
         marca.setValue(item.getAsJsonObject().get("Value").getAsInt());
         marca.addToList();
      });
   }
}
