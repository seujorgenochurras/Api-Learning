package org.Jhon.learning.MySQL.Structures;

import org.Jhon.learning.Models.Structure.IModel;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public interface SQLInsert {
   /**
    * put the full sql insert command here, it should cointain all the methods that compose a model
    *
    * */

   Method[] getMethods() throws NoSuchMethodException;
   String getTableName();
  default String getInsertCommand() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
     StringBuilder stringBuilder = new StringBuilder();
     stringBuilder.append("INSERT INTO ").append(getTableName()).append("(");

     Method[] methods = getMethods();

     StringBuilder methodsNames = new StringBuilder();
     for (Method method : methods) {
        String methodName = method.getName().substring(3); // removing the "get" part, so I only get the name
        methodsNames.append(methodName).append(",");
     }
     methodsNames.deleteCharAt(methodsNames.length() - 1); //removing the last ","
     stringBuilder.append(methodsNames);
     stringBuilder.append(") VALUES (");
     for (Method method : methods) {
        try {
           String returnType =  method.getReturnType().getSimpleName();
           boolean methodReturnString = returnType.equals("String") || returnType.equals("char") || returnType.equals("Character");
           if (methodReturnString) {
              stringBuilder.append("\"");
           }

           stringBuilder.append(method.invoke(this));
           if (methodReturnString) {
              stringBuilder.append("\"");
           }
           stringBuilder.append(", ");
        } catch (InvocationTargetException | IllegalAccessException ex) {
           System.out.println(ex.getMessage());
        }
     }
        stringBuilder.deleteCharAt(stringBuilder.length()-2); //removing the last ","
        stringBuilder.append(");");
     return stringBuilder.toString();
  }
}
