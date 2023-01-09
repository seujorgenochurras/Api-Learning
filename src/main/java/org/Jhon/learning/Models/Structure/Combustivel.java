package org.Jhon.learning.Models.Structure;

public enum Combustivel {
   GASOLINA(1),
   ALCOOL(2),
   DIESEL(3),
   ETANOL(4),
   OUTROS(5);

   public final int value;
   Combustivel(int value){
      this.value = value;
   }
   public static Combustivel getByValue(int value){
      return Combustivel.values()[value -1];
   }
}
