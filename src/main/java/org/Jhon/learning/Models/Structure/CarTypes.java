package org.Jhon.learning.Models.Structure;

import org.jetbrains.annotations.Range;

public enum CarTypes {
   CARRO(1),
   MOTO(2),
   CAMINHAO(3);
   public final int value;
   CarTypes(int value){
      this.value = value;
   }

   /**
    * @param value value of car
    */
   public static CarTypes getByValue(@Range(from = 1, to = 3) int value){
      return values()[value-1];
   }

}
