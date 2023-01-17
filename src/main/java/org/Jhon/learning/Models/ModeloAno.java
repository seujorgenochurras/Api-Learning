package org.Jhon.learning.Models;

import org.Jhon.learning.Models.Structure.Combustivel;
import org.Jhon.learning.Models.Structure.GenericModeloAnoModel;
import org.Jhon.learning.Models.Structure.IModel;
import org.Jhon.learning.MySQL.Structures.SQLInsert;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


public class ModeloAno extends GenericModeloAnoModel implements IModel, SQLInsert {
   /**
    * String é o ano <br>
    * Integer é o combustivel
    */
   public static final TreeMap<String, Integer> anoModelos = new TreeMap<>();
   public static final List<ModeloAno> instances = new ArrayList<>();
   public ModeloAno(){}
   public Combustivel getCombustivel(){
      return Combustivel.getByValue(getValue());
   }

   @Override
   public void addToList() {
      anoModelos.putIfAbsent(this.getLabel(), this.getValue());
      instances.add(this);
   }
   public static void mostrar() {
     instances.forEach(item -> System.out.println(item.getLabel() + " : " + item.getCombustivel().name()));
   }

   @Override
   public Method[] getMethods() throws NoSuchMethodException {
      Class<? extends ModeloAno> instance = this.getClass();
      Method getModeloFK = instance.getMethod("getModeloID");
      Method getAno = instance.getMethod("getAno");
      Method getGasID = instance.getMethod("getGasID");

      return new Method[]{getAno, getModeloFK, getGasID  };
   }

   @Override
   public String getTableName() {
      return "modeloAno";
   }
}
