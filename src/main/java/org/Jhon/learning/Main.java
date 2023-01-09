package org.Jhon.learning;

import org.Jhon.learning.ApiTesting.Consultar.ConsultarAnoModelo;
import org.Jhon.learning.ApiTesting.Consultar.ConsultarMarcas;
import org.Jhon.learning.ApiTesting.Consultar.ConsultarModelos;
import org.Jhon.learning.ApiTesting.Consultar.ConsultarVeiculo;
import org.Jhon.learning.Models.Carro;
import org.Jhon.learning.Models.Marca;
import org.Jhon.learning.Models.Modelo;
import org.Jhon.learning.Models.ModeloAno;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class Main {
   public static void main(String[] args) {
     try {
         ConsultarMarcas consultarMarcas = new ConsultarMarcas(1, 293);
         consultarMarcas.getResponse();
         consultarMarcas.toModel();
         Marca.instances.forEach((instance)->{
            ConsultarModelos consultarModelos = new ConsultarModelos(instance);
            try {
               consultarModelos.getResponse();
               consultarModelos.toModel();
            } catch (IOException e) {
               throw new RuntimeException(e);
            }
         });
      Modelo.instances.forEach((instace) ->{
         System.out.println(instace.getName() + " : " + instace.getValue());
      });

       // Marca.mostrar();

//         ConsultarModelos consultarModelos = new ConsultarModelos(Marca.instances.get(1));
//         consultarModelos.getResponse();
//         consultarModelos.toModel();
//         Modelo.mostrar();

//         ConsultarModelos consultarModelos = new ConsultarModelos();
//         consultarModelos.setMarcaID(1);
//         consultarModelos.setVehicleID(1);
//         consultarModelos.setTabelaReferenciaID(293);
//         consultarModelos.getResponse();
//         consultarModelos.toModel();
//         Modelo.mostrar();
//
//         ConsultarMarcas consultarMarcas = new ConsultarMarcas(1, 293);
//         consultarMarcas.getResponse();
//         consultarMarcas.toModel();
//         Marca.mostrar();

//         ConsultarAnoModelo consultarAnoModelo = new ConsultarAnoModelo();
//         consultarAnoModelo.setMarcaID(2);
//         consultarAnoModelo.setModeloID(4564);
//         consultarAnoModelo.setVehicleID(1);
//         consultarAnoModelo.setTabelaReferenciaID(293);
//         consultarAnoModelo.getResponse();
//         consultarAnoModelo.toModel();
//         ModeloAno.mostrar();

//         ConsultarVeiculo consultarVeiculo = new ConsultarVeiculo();
//         consultarVeiculo.setMarcaID(1);
//         consultarVeiculo.setModeloID(1);
//         consultarVeiculo.setVehicleID(1);
//         consultarVeiculo.setAnoModeloID("1992");
//         consultarVeiculo.setCombustivelID(1);
//         consultarVeiculo.setTabelaReferenciaID(293);
//         consultarVeiculo.getResponse();
//         consultarVeiculo.toModel();
//         Carro.mostrar();


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