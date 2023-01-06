package org.Jhon.learning;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.github.cdimascio.dotenv.Dotenv;
import org.Jhon.learning.ApiTesting.ConsultarMarcas;
import org.Jhon.learning.ApiTesting.Structures.MarcasRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpRequest;
import java.sql.*;
import java.util.*;

public class Main {
   public static void main(String[] args) {
      try {
         ConsultarMarcas.getMarcas();
         ConsultarMarcas.mostrar();
      } catch (MalformedURLException e) {
         System.out.println(e.getMessage());
      } catch (IOException e) {
         throw new RuntimeException(e);
      }

//      //Connecting to a mysql Database
//      Connection connection;
//      try{
//       String dbPass = Dotenv.configure().load().get("DB_PASS");
//       connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/apitest", "root",dbPass);
//       Statement statement = connection.createStatement();
//         ResultSet resultSet = statement.executeQuery("select * from cars");
//         while(resultSet.next()){
//            System.out.println(resultSet.getString("firstName"));
//         }
//      }catch (SQLException e){
//         System.out.println(e);
//         System.out.println(e.getMessage());
//      }
   }
}