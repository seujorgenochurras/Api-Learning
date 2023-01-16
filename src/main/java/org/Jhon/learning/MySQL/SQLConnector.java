package org.Jhon.learning.MySQL;

import io.github.cdimascio.dotenv.Dotenv;
import org.Jhon.learning.Models.Structure.IModel;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

public class SQLConnector {
   /**
    * This needs the {@code Dotenv} Database information
    *
    * */
   public static Connection getSQLConnection(){
   Connection connection;
   Dotenv dotenv = Dotenv.load();

      String dbURL = dotenv.get("DATABASE_URL");
      String dbUser = dotenv.get("DATABASE_USER");
      String dbPass = dotenv.get("DATABASE_PASS");
      String dbCatalog = dotenv.get("DATABASE_CATALOG");
   try{
      connection = DriverManager.getConnection(dbURL, dbUser, dbPass);
      if(!Objects.isNull(dbCatalog)){
         connection.setCatalog(dbCatalog);
      }
      return connection;
   }catch (SQLException e){
      System.out.println(e.getMessage());
      return null;
      }
   }
   /**
    * Not the hack stuff lol
    * Injects whatever sql code  there is in the {@code sql} string.
    * @param sql sql code
    *
    * */
   public static void sqlInject(String sql){
      try {
      Statement statement = getSQLConnection().createStatement();
      statement.execute(sql);
      }catch (SQLException e){
         System.out.println(e.getMessage());
      }
      System.out.println("Successfully injected sql code");
   }

      /**
       * Creates an {@code insert sql code} based on the instaces of the model list
       * However, most of the time this won't work,
       * */
      public static <T extends IModel> String insertModel(List<T> modelList, String tableName){
         StringBuilder stringBuilder = new StringBuilder();

         stringBuilder.append("INSERT INTO ").append(tableName).append(" VALUES");

         Class<? extends IModel> modelClass = modelList.get(0).getClass();
         Method[] modelClassMethods = modelClass.getMethods();

         modelList.forEach(model ->{
            for (Method method : modelClassMethods) {
               if(method.getName().startsWith("get")){
                  try {
                     boolean methodReturnString = method.getReturnType().getSimpleName().equals("String");
                     if(methodReturnString){
                        stringBuilder.append("\"");
                     }
                     stringBuilder.append(method.invoke(model, (Object) null));
                     if(methodReturnString){
                        stringBuilder.append("\"");
                     }
                     stringBuilder.append(",");
                  } catch (InvocationTargetException | IllegalAccessException ex) {
                     System.out.println(ex.getMessage());
                  }
               }
            }
            stringBuilder.append("),");
         });
         //Removing last "," so it won't get an error
         return stringBuilder.deleteCharAt(stringBuilder.length()-1).toString();
      }

}
