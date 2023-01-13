package org.Jhon.learning;

import org.Jhon.learning.ApiTesting.Consultar.ConsultarAnoModelo;
import org.Jhon.learning.ApiTesting.Consultar.ConsultarMarcas;
import org.Jhon.learning.ApiTesting.Consultar.ConsultarModelos;
import org.Jhon.learning.ApiTesting.Consultar.ConsultarVeiculo;
import org.Jhon.learning.Models.Marca;
import org.Jhon.learning.Models.Modelo;
import org.Jhon.learning.Models.ModeloAno;
import org.Jhon.learning.Models.Structure.IModel;
import org.Jhon.learning.Models.Veiculo;
import org.Jhon.learning.RequestV2.ConsultarPorThread;
import org.Jhon.learning.RequestV2.ListUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

   public static void main(String[] args) {
      try {
      //Pegando marcas
      ConsultarMarcas consultarMarcas = new ConsultarMarcas(1, 293);
      consultarMarcas.toModel(consultarMarcas.getResponse());

      //Separando Lista de todas as marcas de 23 partes iguais
      List<List<?>> marcasLists = ListUtils.divideList(Marca.instances, 16);

      //Encontrando todos os modelos
      ExecutorService modelosExecuter = Executors.newFixedThreadPool(marcasLists.size());
      marcasLists.forEach(marcas ->{
         modelosExecuter.submit(()->{
         ConsultarPorThread<ConsultarModelos> consultarModelosPorThread = new ConsultarPorThread<>((ArrayList<Modelo>) marcas);
         consultarModelosPorThread.start();
         });
      });
      if(modelosExecuter.awaitTermination(20, TimeUnit.SECONDS)){
      modelosExecuter.shutdown();
      }

      //Separando lista com todos os modelos em 500 partes iguais
      List<List<?>> modelosList = ListUtils.divideList(Modelo.instances,  139);


      //Encontrando todos os Anos dos Modelos
      ExecutorService anoModeloExecuter = Executors.newFixedThreadPool(modelosList.size());
      modelosList.forEach(item ->{
         anoModeloExecuter.submit(()->{
         ConsultarPorThread<ConsultarAnoModelo> consultarAnoModeloPorThread = new ConsultarPorThread<>((ArrayList<ModeloAno>) item);
         consultarAnoModeloPorThread.start();
         });
      });
      if(anoModeloExecuter.awaitTermination(30, TimeUnit.SECONDS)){
         anoModeloExecuter.shutdown();
      }

      //Separando Anos dos Modelos em 600 threads
      List<List<?>> anoModeloList = ListUtils.divideList(ModeloAno.instances,650);

      //Encontrando todos os carros
      ExecutorService carroExectuer = Executors.newFixedThreadPool(anoModeloList.size());
      anoModeloList.forEach(anoModelo ->{
         carroExectuer.submit(()->{
            ConsultarPorThread<ConsultarVeiculo> consultarVeiculoPorThread = new ConsultarPorThread<>((ArrayList<? extends IModel>) anoModelo);
            consultarVeiculoPorThread.start();
         });
      });
      if(anoModeloExecuter.awaitTermination(90, TimeUnit.SECONDS)){
         anoModeloExecuter.shutdown();
      }
      Veiculo.getMostExpensiveCar(Veiculo.carro);
      Veiculo.getLeastExpensiveCar(Veiculo.carro);
      Veiculo.getMostExpensiveCar(Veiculo.get2023Cars());
      Veiculo.getLeastExpensiveCar(Veiculo.get2023Cars());

      } catch (MalformedURLException e) {
         System.out.println(e.getMessage());
      } catch (IOException | InterruptedException e) {
         throw new RuntimeException(e);
      }
   }
}