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
      setTabelaReferencialID(tabelaID);
      setVeiculoID(vehicleID);
      setMarcaID(marcaID);
   }
   public Modelo(){}
   public static void mostrar() {
      System.out.println("mostrnado");
      modelos.forEach((nome, value) -> System.out.println(nome + ": " + value));
   }

   @Override
   public Method[] getMethods() throws NoSuchMethodException {
      Class<? extends Modelo> instance = this.getClass();
      Method getID = instance.getMethod("getID");
      Method getMarcaFK = instance.getMethod("getMarcaID");
      Method getNome = instance.getMethod("getNome");
      return new Method[]{getID, getMarcaFK, getNome};
   }

   @Override
   public String getTableName() {
      return "Modelo";
   }
}
