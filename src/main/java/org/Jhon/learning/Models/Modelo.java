package org.Jhon.learning.Models;

import com.sun.source.tree.Tree;
import org.Jhon.learning.Models.Structure.GenericModeloModel;
import org.Jhon.learning.Models.Structure.IModel;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

//Modelo de carro kkkk
public class Modelo extends GenericModeloModel implements IModel {
   /**
    * String é o nome do modelo
    * Integer é o valor, é usado em requests
    */
   public static final List<Modelo> instances = new ArrayList<>();
   public static final TreeMap<String, Integer> modelos = new TreeMap<>();

   @Override
   public void addToList() {
      modelos.putIfAbsent(this.getName(), this.getValue());
      instances.add(this); //TODO fix this
   }

   public static void mostrar() {
      System.out.println("mostrnado");
      modelos.forEach((nome, value) -> System.out.println(nome + ": " + value));
   }
}
