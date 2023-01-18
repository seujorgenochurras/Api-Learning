package org.Jhon.learning.Models;

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

   @Override
   public void addToList() {
      instances.add(this);
   }
   public static void mostrar() {
      System.out.println("mostrnado");
      instances.forEach(item -> {
         System.out.println("COMEÇANDO");
         System.out.println("Nome " + item.getModelName() + "\nID " + item.getID());
         System.out.println("VEHICLE ID " + item.getMarcaObject().getVeiculoID() + "\nMARCA ID " + item.getMarcaObject().getID());
         System.out.println(item.getModeloObject().getID());
         System.out.println(item.getCombustivel());
         System.out.println(item.getAno());
      });
   }

   @Override
   public Method[] getMethods() throws NoSuchMethodException {
      Class<? extends ModeloAno> instance = this.getClass();
      Method getModeloFK = instance.getMethod("getModeloFK");
      Method getAno = instance.getMethod("getAno");
      Method getGasID = instance.getMethod("getGasID");

      return new Method[]{getAno, getModeloFK, getGasID};
   }

   @Override
   public String getTableName() {
      return "modeloAno";
   }
}
