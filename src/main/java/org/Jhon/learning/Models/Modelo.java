package org.Jhon.learning.Models;

import com.sun.source.tree.Tree;
import org.Jhon.learning.Models.Structure.GenericAPIRequester;
import org.Jhon.learning.Models.Structure.IModel;

import java.util.TreeMap;

//Modelo de carro kkkk
public class Modelo extends GenericAPIRequester<Modelo> implements IModel {
   /**
    * String é o nome do modelo
    * Integer é o valor, é usado em requests
    */
   public static final TreeMap<String, Integer> modelos = new TreeMap<>();

   @Override
   public void addToList() {
      modelos.putIfAbsent(this.getName(), this.getValue());
   }

   public static void mostrar() {
      modelos.forEach((nome, value) -> System.out.println(nome + ": " + value));
   }
}
