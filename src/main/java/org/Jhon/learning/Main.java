package org.Jhon.learning;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

public class Main {
   public static void main(String[] args) {
      Connection connection;
      try{
       String dbPass = Dotenv.configure().load().get("DB_PASS");
       connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/apitest", "root",dbPass);
       Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery("select * from cars");
         while(resultSet.next()){
            System.out.println(resultSet.getString("firstName"));
         }
      }catch (SQLException e){
         System.out.println(e);
         System.out.println(e.getMessage());

      }
   }
}