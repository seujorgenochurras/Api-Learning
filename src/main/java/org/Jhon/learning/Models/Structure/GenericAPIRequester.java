package org.Jhon.learning.Models.Structure;

public abstract class GenericAPIRequester<T extends IModel> {
     private String name;
     private int value;

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

   public Class<?> getInstace(){
      return this.getClass();
   }

   abstract public void addToList(T t);

   abstract public void addToList(T ...t);
}
