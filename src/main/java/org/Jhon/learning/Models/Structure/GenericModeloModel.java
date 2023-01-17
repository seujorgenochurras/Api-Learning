package org.Jhon.learning.Models.Structure;

import com.google.gson.JsonPrimitive;
import org.Jhon.learning.ApiTesting.GenericAPIModel;
import org.Jhon.learning.Models.Marca;
import org.Jhon.learning.Models.Modelo;

public abstract class GenericModeloModel extends GenericAPIModel<Modelo> {
   private int modeloID;

   private Marca marcaObject;

   public Marca getMarcaObject() {
      return this.marcaObject;
   }

   public void setMarcaObject(Marca marcaObject) {
      this.marcaObject = marcaObject;
   }

   public int getModeloID() {
      return modeloID;
   }

   public void setModeloID(JsonPrimitive modeloID) {
      this.modeloID = modeloID.getAsByte();
   }
   public void setModeloID(int modeloID) {
      this.modeloID = modeloID;
   }

   public int getMarcaFK(){
      return getMarcaObject().getID();
   }
/*
   *   setModeloID(codigoModelo);
        setMarcaID(codigoMarca);
   * */
}
