package org.Jhon.learning.Models;

import org.Jhon.learning.Models.Structure.GenericAPIRequester;
import org.Jhon.learning.Models.Structure.IModel;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Marca extends GenericAPIRequester<Marca> implements IModel {

   public static final TreeMap<String, Integer> marcas = new TreeMap<>();

   public static final ArrayList<Marca> instances = new ArrayList<>();

   private int veiculoID;

   private int tabelaID;

   public int getTabelaID() {
      return tabelaID;
   }

   public void setTabelaID(int tabelaID) {
      this.tabelaID = tabelaID;
   }

   public int getVeiculoID() {
      return veiculoID;
   }

   public void setVeiculoID(int veiculoID) {
      this.veiculoID = veiculoID;
   }

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
