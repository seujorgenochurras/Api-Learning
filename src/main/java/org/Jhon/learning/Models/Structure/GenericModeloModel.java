package org.Jhon.learning.Models.Structure;

import com.google.gson.JsonPrimitive;

public abstract class GenericModeloModel extends GenericMarcaModel{
   private int modeloID;

   public int getModeloID() {
      return modeloID;
   }

   public void setModeloID(JsonPrimitive modeloID) {
      this.modeloID = modeloID.getAsByte();
   }
   public void setModeloID(int modeloID) {
      this.modeloID = modeloID;
   }
/*
   *   setModeloID(codigoModelo);
        setMarcaID(codigoMarca);
   * */
}
