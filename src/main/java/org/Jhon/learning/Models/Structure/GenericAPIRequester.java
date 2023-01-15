package org.Jhon.learning.Models.Structure;

import com.google.gson.JsonPrimitive;

public abstract class GenericAPIRequester<T extends IModel> {
   /**
    * name of the value
    * @see org.Jhon.learning.ApiTesting.Structures.GenericConsultarClass
    * */
     private String label;
     private int value;


     /**
      * Return the name
      * */
   public String getLabel() {
      return label;
   }

   //TODO REMOVE THIS LATER
   public String getName(){
      return getLabel();
   }
   public void setLabel(JsonPrimitive label) {
      this.label = label.getAsString();
   } public void setLabel(String label) {
      this.label = label;
   }
  /**
   * usually Returns the ID
   * */
   public int getValue() {
      return value;
   }
   public void setValue(JsonPrimitive value) {
      this.value = value.getAsInt();
   }
     public void setValue(int value) {
      this.value = value;
   }
   public Class<?> getInstace(){
      return this.getClass();
   }

   /**
    * A list of all instances
    * */
   abstract public void addToList();

}
