package org.Jhon.learning.Models;

import org.Jhon.learning.Models.Structure.GenericModeloModel;
import org.Jhon.learning.Models.Structure.IModel;
import org.Jhon.learning.MySQL.Structures.SQLInsert;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.TreeMap;

//Modelo de carro kkkk
public class Modelo extends GenericModeloModel implements IModel, SQLInsert {
   /**
    * String é o nome do modelo
    * Integer é o valor, é usado em requests
    */
   public static final ArrayList<Modelo> instances = new ArrayList<>();
   public static final TreeMap<String, Integer> modelos = new TreeMap<>();

   @Override
   public void addToList() {
      modelos.putIfAbsent(this.getLabel(), this.getValue());
      instances.add(this); //TODO fix this
   }

   public Modelo(int modeloID, int vehicleID, int tabelaID, int marcaID){
      setModeloID(modeloID);
      getMarcaObject().setTabelaReferencialID(tabelaID);
       getMarcaObject().setVeiculoID(vehicleID);
       getMarcaObject().setValue(marcaID);
   }
   public Modelo(){}
   public static void mostrar() {
      System.out.println("mostrnado");
      instances.forEach(item -> {
         System.out.println("COMEÇANDO");
        System.out.println("Nome " + item.getModelName() + "\nID " + item.getID());
          System.out.println("VEHICLE ID " + item.getMarcaObject().getVeiculoID() + "\nMARCA ID " + item.getMarcaObject().getID());
         System.out.println(item.getTableName());
         System.out.println(item);

      });
   }

   @Override
   public Method[] getMethods() throws NoSuchMethodException {
      Class<? extends Modelo> instance = this.getClass();
      Method getID = instance.getMethod("getID");
      Method getMarcaFK = instance.getMethod("getMarcaFK");
      Method getNome = instance.getMethod("getModelName");
      return new Method[]{getID, getMarcaFK, getNome};
   }

   @Override
   public String getTableName() {
      return "Modelo";
   }
}
