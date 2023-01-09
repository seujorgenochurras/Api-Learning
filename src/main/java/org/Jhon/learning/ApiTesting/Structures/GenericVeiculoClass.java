package org.Jhon.learning.ApiTesting.Structures;

import org.Jhon.learning.ApiTesting.Structures.Request.VeiculoRequest;

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
}
