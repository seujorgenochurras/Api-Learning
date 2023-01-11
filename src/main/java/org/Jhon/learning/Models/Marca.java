package org.Jhon.learning.Models;

import org.Jhon.learning.Models.Structure.GenericMarcaModel;
import org.Jhon.learning.Models.Structure.IModel;

import java.util.ArrayList;
import java.util.TreeMap;

public class Marca extends GenericMarcaModel implements IModel {

   public static final TreeMap<String, Integer> marcas = new TreeMap<>();

   public static final ArrayList<Marca> instances = new ArrayList<>();
   @Override
   public void addToList(){
      marcas.putIfAbsent(this.getName(), this.getValue());
      instances.add(this); //TODO fix this
    //  System.out.println("added : " + this.getName());
   }

   public static void mostrar(){
      marcas.forEach( (nome, value)->{
         System.out.println(nome + ": " + value);
      });
   }
}
