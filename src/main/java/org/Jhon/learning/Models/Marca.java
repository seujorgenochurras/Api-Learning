package org.Jhon.learning.Models;

import java.util.HashMap;

public class Marca {
   private String name;
   private int value;
   private Modelo modelos;

   public static final HashMap<String, Integer> marcas = new HashMap<>();
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getValue() {
      return value;
   }

   public void setValue(int value) {
      this.value = value;
   }



}
