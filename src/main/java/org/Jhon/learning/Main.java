package org.Jhon.learning;

import org.Jhon.learning.ApiTesting.Consultar.ConsultarAnoModelo;
import org.Jhon.learning.ApiTesting.Consultar.ConsultarMarcas;
import org.Jhon.learning.ApiTesting.Consultar.ConsultarModelos;
import org.Jhon.learning.ApiTesting.Consultar.ConsultarVeiculo;
import org.Jhon.learning.Models.Marca;
import org.Jhon.learning.Models.Modelo;
import org.Jhon.learning.Models.ModeloAno;
import org.Jhon.learning.Models.Veiculo;
import org.Jhon.learning.RequestV2.ConsultarPorThread;
import org.Jhon.learning.RequestV2.ListUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.*;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
   public static void main(String[] args) throws InterruptedException, IOException {
      try {
      //Pegando marcas
      ConsultarMarcas consultarMarcas = new ConsultarMarcas(1, 293);
      consultarMarcas.toModel(consultarMarcas.getResponse());

      //Separando Lista de todas as marcas de 23 partes iguais
      List<List<Marca>> marcasLists = ListUtils.divideList(Marca.instances, 16);

      //Encontrando todos os modelos
      ExecutorService modelosExecuter = Executors.newFixedThreadPool(marcasLists.size());
      marcasLists.forEach(marcas ->{
         modelosExecuter.submit(()->{
         ConsultarPorThread<ConsultarModelos> consultarModelosPorThread = new ConsultarPorThread<>(marcas);
         consultarModelosPorThread.start();
         });
      });
      if(modelosExecuter.awaitTermination(10, TimeUnit.SECONDS)){
      modelosExecuter.shutdown();
      }

      //Separando lista com todos os modelos em 500 partes iguais
      List<List<Modelo>> modelosList = ListUtils.divideList(Modelo.instances,  139);


      //Encontrando todos os Anos dos Modelos
      ExecutorService anoModeloExecuter = Executors.newFixedThreadPool(modelosList.size());
      modelosList.forEach(item ->{
         anoModeloExecuter.submit(()->{
         ConsultarPorThread<ConsultarAnoModelo> consultarAnoModeloPorThread = new ConsultarPorThread<>(item);
         consultarAnoModeloPorThread.start();
         });
      });
      if(anoModeloExecuter.awaitTermination(30, TimeUnit.SECONDS)){
         anoModeloExecuter.shutdown();
      }
      //Separando Anos dos Modelos em 600 threads
      List<List<ModeloAno>> anoModeloList = ListUtils.divideList(ModeloAno.instances,500);

      //Encontrando todos os carros
      ExecutorService carroExectuer = Executors.newFixedThreadPool(anoModeloList.size());
      anoModeloList.forEach(anoModelo ->{
         carroExectuer.submit(()->{
            ConsultarPorThread<ConsultarVeiculo> consultarVeiculoPorThread = new ConsultarPorThread<>(anoModelo);
            consultarVeiculoPorThread.start();
         });
      });
      if(anoModeloExecuter.awaitTermination(45, TimeUnit.SECONDS)){
         anoModeloExecuter.shutdown();
      }
      } catch (MalformedURLException e) {
         System.out.println(e.getMessage());
      } catch (IOException | InterruptedException e) {
         throw new RuntimeException(e);
      }

      Connection connection;
      StringBuilder sqlInsertCarro = new StringBuilder();
      sqlInsertCarro.append("INSERT INTO carro (Nome, Valor, Marca, Modelo, AnoModelo, Combustivel, CodigoFipe, MesReferencia, Autenticacao, TipoVeiculo, SiglaCombusitvel, DataConsulta) VALUES");
      Veiculo.carro.forEach(carro ->{
         sqlInsertCarro.append("(\"" + carro.getName() + "\", " + carro.getNumberPrice()
                 + ", \"" + carro.getMarca() + "\", \"" + carro.getModelo() + "\"," + carro.getAnoModelo()
                 + ", \"" + carro.getCombustivel() + "\", \"" + carro.getCodigoFipe() + "\", \"" + carro.getMesReferencia()
                 + "\", \"" + carro.getAutenticacao() + "\", " + carro.getTipoVeiculo() + ", \"" + carro.getSiglaCombustivel()
                 + "\", \"" + carro.getDataConsulta() + "\"),");
      });
      //Removing last ")," so it won't get an error
      String sql = sqlInsertCarro.deleteCharAt(sqlInsertCarro.length()-1).toString();
      try{
         connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/apilearning", "root","Macro!");
         Statement statement = connection.createStatement();
         connection.setCatalog("APILearning");
         statement.execute(sql);
      }catch (SQLException e){
         System.out.println(e.getMessage());
      }
   }

}