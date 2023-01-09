package org.Jhon.learning.ApiTesting.Structures;

import org.Jhon.learning.ApiTesting.Structures.Request.AnoModeloRequest;

//Esse é referência a interface AnoModeloRequest
public abstract class GenericModeloAno<T extends AnoModeloRequest> extends GenericModelo<T> {
   private int modeloID;
   public int getModeloID() {
      return modeloID;
   }

   public void setModeloID(int modeloID) {
      this.modeloID = modeloID;
   }



}
