package org.Jhon.learning;

import org.Jhon.learning.ApiTesting.Consultar.ConsultarAnoModelo;
import org.Jhon.learning.ApiTesting.Consultar.ConsultarMarcas;
import org.Jhon.learning.ApiTesting.Consultar.ConsultarModelos;
import org.Jhon.learning.ApiTesting.Consultar.ConsultarVeiculo;
import org.Jhon.learning.Models.Marca;
import org.Jhon.learning.Models.Modelo;
import org.Jhon.learning.Models.ModeloAno;
import org.Jhon.learning.Models.Veiculo;
import org.Jhon.learning.MySQL.SQLConnector;
import org.Jhon.learning.RequestV2.ConsultarPorThread;
import org.Jhon.learning.RequestV2.ListUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {


   public static void main(String[] args) throws InterruptedException, IOException {

   for(int i = 1; i < 4; i++){
      Marca.instances.clear();
      Modelo.instances.clear();
      ModeloAno.instances.clear();
      Veiculo.carro.clear();

      try {
      //Pegando marcas
         ConsultarMarcas consultarMarcas = new ConsultarMarcas(i, 293);
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
      if(modelosExecuter.awaitTermination(60, TimeUnit.SECONDS)){
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
      if(anoModeloExecuter.awaitTermination(150, TimeUnit.SECONDS)){
         anoModeloExecuter.shutdown();
      }
      //Separando Anos dos Modelos em 600 threads
      List<List<ModeloAno>> anoModeloList = ListUtils.divideList(ModeloAno.instances,700);

      //Encontrando todos os carros
      ExecutorService carroExectuer = Executors.newFixedThreadPool(anoModeloList.size());
      anoModeloList.forEach(anoModelo ->{
         carroExectuer.submit(()->{
            ConsultarPorThread<ConsultarVeiculo> consultarVeiculoPorThread = new ConsultarPorThread<>(anoModelo);
            consultarVeiculoPorThread.start();
         });
      });
      if(anoModeloExecuter.awaitTermination(150, TimeUnit.SECONDS)){
         anoModeloExecuter.shutdown();
      }
      } catch (InterruptedException e) {
         throw new RuntimeException(e);
      }

      SQLConnector sqlConnector = new SQLConnector();
      sqlConnector.createSQLConnection();

      System.out.println("Injecting sql code");
         Marca.instances.forEach(instace ->{
            try {
               sqlConnector.sqlInject(instace.getInsertCommand());
            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                     IllegalAccessException e) {
               throw new RuntimeException(e);
            }
         });
      Modelo.instances.forEach(instace ->{
         try {
            sqlConnector.sqlInject(instace.getInsertCommand());
         } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                  IllegalAccessException e) {
            throw new RuntimeException(e);
         }
      });
         ModeloAno.instances.forEach(instace ->{
            try {
               sqlConnector.sqlInject(instace.getInsertCommand());
            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                     IllegalAccessException e) {
               throw new RuntimeException(e);
            }
         });
         Veiculo.carro.forEach(instace ->{
            try {
               sqlConnector.sqlInject(instace.getInsertCommand());
            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                     IllegalAccessException e) {
               throw new RuntimeException(e);
            }
         });
      System.out.println("Injection finished");
      }
      Thread.sleep(300000);
      System.out.println("acabou");
   }
}
