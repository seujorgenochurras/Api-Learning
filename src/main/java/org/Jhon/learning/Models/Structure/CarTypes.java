package org.Jhon.learning.Models.Structure;

public enum CarTypes {
   Car(1),
   Truck(2),
   Motorcycle(3);
   final int value;
   CarTypes(int value){
      this.value = value;
   }
}
