package org.Jhon.learning.ApiTesting.Structures;


import org.Jhon.learning.ApiTesting.Structures.Request.MarcasRequest;

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

}
