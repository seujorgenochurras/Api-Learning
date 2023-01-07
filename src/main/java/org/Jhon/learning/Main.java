package org.Jhon.learning;

import org.Jhon.learning.ApiTesting.ConsultarMarcas;
import org.Jhon.learning.Models.Marca;

import java.io.IOException;
import java.net.MalformedURLException;

public class Main {
   public static void main(String[] args) {
      try {
         ConsultarMarcas consultarMarcas = new ConsultarMarcas(1, 293);
         consultarMarcas.getMarcas();
         consultarMarcas.saveMarcas();
         Marca.mostrar();
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