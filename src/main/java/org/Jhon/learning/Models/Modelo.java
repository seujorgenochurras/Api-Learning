package org.Jhon.learning.Models;

import java.util.HashMap;

public class Modelo {
   /**
    * String é o nome do modelo
    * Integer é o valor, é usado em requests
    * */
   public static final HashMap<String, Integer> modelos = new HashMap<>();

   private String name;
   private int valor;

   public Modelo(String name, Integer valor){
      this.setName(name);
      this.setValor(valor);
      add(this);
   }
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getValor() {
      return valor;
   }

   public void setValor(int valor) {
      this.valor = valor;
   }
   private void add(Modelo modelo){
      modelos.put(modelo.getName(), modelo.getValor());
   }




}
