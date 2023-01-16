package org.Jhon.learning.Models;

import org.Jhon.learning.Models.Structure.GenericMarcaModel;
import org.Jhon.learning.Models.Structure.IModel;
import org.Jhon.learning.MySQL.Structures.SQLInsert;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.TreeMap;

public class Marca extends GenericMarcaModel implements IModel, SQLInsert {

   public static final TreeMap<String, Integer> marcas = new TreeMap<>();

   public static final ArrayList<Marca> instances = new ArrayList<>();
   @Override
   public void addToList(){
      marcas.putIfAbsent(this.getLabel(), this.getValue());
      instances.add(this); //TODO fix this
    //  System.out.println("added : " + this.getName());
   }

   public static void mostrar(){
      marcas.forEach( (nome, value)->{
         System.out.println(nome + ": " + value);
      });
   }

   @Override
   public Method[] getMethods() throws NoSuchMethodException {
      Class<? extends Marca> instance = this.getClass();
      Method getID = instance.getMethod("getID");
      Method getNome = instance.getMethod("getNome");
      Method getVeiculoID = instance.getMethod("getVeiculoID");
      Method getMesReferencia = instance.getMethod("getTabelaReferencialID");

      return new Method[]{getID, getNome, getVeiculoID, getMesReferencia};
   }

   @Override
   public String getTableName() {
      return "Marca";
   }
}
