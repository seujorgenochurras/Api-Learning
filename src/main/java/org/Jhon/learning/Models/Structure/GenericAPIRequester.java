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
      * Returns the name
      * cant change to getName, because of the way that requester works
      * @see org.Jhon.learning.ApiTesting.Structures.GenericConsultarClass
      * */
   public String getLabel() {
      return label;
   }
   public int getID(){
      return getValue();
   }
   public String getNome(){
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
   public Class<T> getModelInstace(){
      return (Class<T>) this.getClass();
   }
   /**
    * A list of all instances
    * */
   abstract public void addToList();

}
