package org.Jhon.learning.Models.Structure;

public abstract class GenericModeloAnoModel extends GenericModeloModel{
   public int modeloFK(){
      return super.getModeloID();
   }
   public int getAno(){
      return getValue();
   }


}
