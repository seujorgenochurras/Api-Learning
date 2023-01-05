package org.Jhon.learning;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.github.cdimascio.dotenv.Dotenv;

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

         URL url = new URL("https://veiculos.fipe.org.br/api/veiculos//ConsultarModelos");
         HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

         urlConnection.setRequestMethod("POST");
         urlConnection.setDoOutput(true);
         urlConnection.getOutputStream().write("codigoTipoVeiculo=1&codigoTabelaReferencia=293&codigoMarca=2".getBytes());
         int connectResponse = urlConnection.getResponseCode();
         if (connectResponse != 200) {
            throw new RuntimeException("HttpResponseCode: " + connectResponse);
         }


         BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
         String response = in.readLine();
         in.close();
         Gson gson = new Gson();
         HashMap<String, Integer> modelos = new HashMap<>();
         JsonObject jsonObject = gson.fromJson(response, JsonObject.class);
         JsonArray jsonArray = jsonObject.getAsJsonArray("Modelos");

         jsonArray.forEach((item) ->{
            String nome = item.getAsJsonObject().get("Label").getAsString();
            int value = item.getAsJsonObject().get("Value").getAsInt();
            modelos.put(nome, value);
         });
        modelos.forEach((nome, value) -> System.out.println(nome + ": " + value));

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