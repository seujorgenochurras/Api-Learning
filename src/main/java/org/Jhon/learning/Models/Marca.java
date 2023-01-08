package org.Jhon.learning.Models;

import org.Jhon.learning.Models.Structure.GenericAPIRequester;
import org.Jhon.learning.Models.Structure.IModel;

import java.util.Map;
import java.util.TreeMap;

public class Marca extends GenericAPIRequester<Marca> implements IModel {

   public static final Map<String, Integer> marcas = new TreeMap<>();

   @Override
   public void addToList(){
      marcas.putIfAbsent(this.getName(), this.getValue());
   }

   public static void mostrar(){
      marcas.forEach( (nome, value)->{
         System.out.println(nome + ": " + value);
      });
   }
}
