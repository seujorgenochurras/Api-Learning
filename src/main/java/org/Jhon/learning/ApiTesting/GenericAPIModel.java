package org.Jhon.learning.ApiTesting;

import com.google.gson.JsonPrimitive;
import org.Jhon.learning.Models.Structure.IModel;

public abstract class GenericAPIModel<T extends IModel> {
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

   /**
    * @param value The id of the model
    * */
     public void setValue(int value) {
      this.value = value;
   }
   public Class<T> getModelInstace(){
      return (Class<T>) this.getClass();
   }


   /**
    * Literally the same as getValue()
    * */;
   public int getID(){
      return getValue();
   }
   /**
    * Literally the same as getLabel()
    * */;
   public String getModelName(){
      return getLabel();
   }


   /**
    * A list of all instances
    * */
   abstract public void addToList();



}
