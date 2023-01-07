package org.Jhon.learning.Models.Structure;

import org.jetbrains.annotations.Range;

public enum CarTypes {
   Car(1),
   Truck(2),
   Motorcycle(3);
   public final int value;
   CarTypes(int value){
      this.value = value;
   }

   /**
    * @param value value of car
    */
   public static CarTypes getByNumber(@Range(from = 1, to = 3) int value){
      return values()[value-1];
   }

}
