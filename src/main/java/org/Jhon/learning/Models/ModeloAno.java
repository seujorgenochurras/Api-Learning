package org.Jhon.learning.Models;

import org.Jhon.learning.Models.Structure.GenericAPIRequester;
import org.Jhon.learning.Models.Structure.IModel;

import java.util.TreeMap;


public class ModeloAno extends GenericAPIRequester<ModeloAno> implements IModel {
   /**
    * String é o ano <br>
    * Integer é o combustivel
    */
   public static final TreeMap<String, Integer> anoModelos = new TreeMap<>();
   public ModeloAno(){}

   @Override
   public void addToList() {

      anoModelos.putIfAbsent(this.getName(), this.getValue());
   }
   public static void mostrar() {
      anoModelos.forEach((nome, value) -> System.out.println(nome + ": " + value));
   }
}
