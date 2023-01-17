package org.Jhon.learning.Models.Structure;

import org.Jhon.learning.ApiTesting.GenericAPIModel;
import org.Jhon.learning.Models.Marca;
import org.Jhon.learning.Models.Modelo;
import org.Jhon.learning.Models.ModeloAno;

public abstract class GenericModeloAnoModel extends GenericAPIModel<ModeloAno> {

   private Modelo modeloObject;

   private Marca marcaObject;

   public Marca getMarcaObject() {
      return marcaObject;
   }

   public void setMarcaObject(Marca marcaObject) {
      this.marcaObject = marcaObject;
   }

   public Modelo getModeloObject() {
      return modeloObject;
   }

   public void setModeloObject(Modelo modeloObject) {
      this.modeloObject = modeloObject;
   }

   /**
    * Returns the raw {@code ENUM} of the {@code combustivel} type
    * */
   public Combustivel getCombustivel(){
      return Combustivel.getByValue(getValue());
   }
   public int getModeloFK(){
      return getModeloObject().getID();
   }
   public int getAno(){
      return Integer.parseInt(getLabel());
   }
   public int getGasID(){
      return getValue();
   }

}
