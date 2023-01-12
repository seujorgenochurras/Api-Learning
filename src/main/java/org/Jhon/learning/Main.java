package org.Jhon.learning;

import org.Jhon.learning.ApiTesting.Consultar.ConsultarAnoModelo;
import org.Jhon.learning.ApiTesting.Consultar.ConsultarMarcas;
import org.Jhon.learning.ApiTesting.Consultar.ConsultarModelos;
import org.Jhon.learning.ApiTesting.Consultar.ConsultarVeiculo;
import org.Jhon.learning.Models.Marca;
import org.Jhon.learning.Models.Modelo;
import org.Jhon.learning.Models.ModeloAno;
import org.Jhon.learning.Models.Veiculo;

import java.io.IOException;
import java.net.MalformedURLException;

public class Main {
   public static void main(String[] args) {
   try {
      ConsultarMarcas consultarMarcas = new ConsultarMarcas(1, 293);
      consultarMarcas.toModel(consultarMarcas.getResponse());

      Marca marca = Marca.instances.get(0);
      ConsultarModelos consultarModelos = new ConsultarModelos(marca);
      consultarModelos.toModel(consultarModelos.getResponse());

      Modelo modelo = Modelo.instances.get(0);
      ConsultarAnoModelo consultarAnoModelo = new ConsultarAnoModelo(modelo);
      consultarAnoModelo.toModel(consultarAnoModelo.getResponse());

      ModeloAno modeloAno = ModeloAno.instances.get(0);
      ConsultarVeiculo consultarVeiculo = new ConsultarVeiculo(modeloAno);
      consultarVeiculo.toModel(consultarVeiculo.getResponse());

      Marca.mostrar();
      Modelo.mostrar();
      ModeloAno.mostrar();
      Veiculo.mostrar();

//      //Pegando marcas
//      ConsultarMarcas consultarMarcas = new ConsultarMarcas(1, 293);
//      consultarMarcas.toModel(consultarMarcas.getResponse());
//
//      //Separando Lista de todas as marcas de 23 partes iguais
//      List<List<?>> marcasLists = ListUtils.divideList(Marca.instances, 4);
//
//      //Encontrando todos os modelos
//      ExecutorService modelosExecuter = Executors.newFixedThreadPool(marcasLists.size());
//      marcasLists.forEach(marcas ->{
//         modelosExecuter.submit(()->{
//         ConsultarPorThread<ConsultarModelos> consultarModelosPorThread = new ConsultarPorThread<>((ArrayList<Modelo>) marcas);
//         consultarModelosPorThread.start();
//         });
//      });
//      if(modelosExecuter.awaitTermination(10, TimeUnit.SECONDS)){
//      modelosExecuter.shutdown();
//      }
//
//      //Separando lista com todos os modelos em 500 partes iguais
//      List<List<?>> modelosList = ListUtils.divideList(Modelo.instances,  139);
//
//
//      //Encontrando todos os Anos dos Modelos
//      ExecutorService anoModeloExecuter = Executors.newFixedThreadPool(modelosList.size());
//      modelosList.forEach(item ->{
//         anoModeloExecuter.submit(()->{
//         ConsultarPorThread<ConsultarAnoModelo> consultarAnoModeloPorThread = new ConsultarPorThread<>((ArrayList<ModeloAno>) item);
//         consultarAnoModeloPorThread.start();
//         });
//      });
//      if(anoModeloExecuter.awaitTermination(30, TimeUnit.SECONDS)){
//         anoModeloExecuter.shutdown();
//      }
//
//      //Separando Anos dos Modelos em 600 threads
//      List<List<?>> anoModeloList = ListUtils.divideList(ModeloAno.instances,600  );
//
//      //Encontrando todos os carros
//      ExecutorService carroExectuer = Executors.newFixedThreadPool(anoModeloList.size());
//      anoModeloList.forEach(anoModelo ->{
//         carroExectuer.submit(()->{
//            ConsultarPorThread<ConsultarVeiculo> consultarVeiculoPorThread = new ConsultarPorThread<>((ArrayList<? extends IModel>) anoModelo);
//            consultarVeiculoPorThread.start();
//         });
//      });
//      if(anoModeloExecuter.awaitTermination(50, TimeUnit.SECONDS)){
//         anoModeloExecuter.shutdown();
//      }
//      Veiculo.getMostExpensiveCar(Veiculo.carro);
//      Veiculo.getLeastExpensiveCar(Veiculo.carro);
//      Veiculo.getMostExpensiveCar(Veiculo.get2023Cars());
//      Veiculo.getLeastExpensiveCar(Veiculo.get2023Cars());

   } catch (MalformedURLException e) {
      System.out.println(e.getMessage());
   } catch (IOException e) {
      throw new RuntimeException(e);
   }
   }
}