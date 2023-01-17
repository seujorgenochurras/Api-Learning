package org.Jhon.learning.Models.Structure;

public enum Combustivel {
   GASOLINA(1, 'G'),
   ALCOOL(2, 'Á'),
   DIESEL(3, 'D'),
   ETANOL(4, 'E'),
   OUTROS(5, 'U');

   public final int value;
   public final char symbol;
   Combustivel(int value, char symbol){
      this.symbol = symbol;
      this.value = value;
   }
   public static Combustivel getByValue(int value){
      return Combustivel.values()[value -1];
   }
}
