package org.Jhon.learning;

import org.Jhon.learning.ApiTesting.Consultar.ConsultarAnoModelo;
import org.Jhon.learning.ApiTesting.Consultar.ConsultarMarcas;
import org.Jhon.learning.ApiTesting.Consultar.ConsultarModelos;
import org.Jhon.learning.Models.Marca;
import org.Jhon.learning.Models.Modelo;
import org.Jhon.learning.Models.ModeloAno;
import org.Jhon.learning.Models.Structure.IModel;
import org.Jhon.learning.RequestV2.ConsultarPorThread;
import org.Jhon.learning.RequestV2.ListUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class Main {
   public static void main(String[] args) {
   try {
      //Pegando marcas
      ConsultarMarcas consultarMarcas = new ConsultarMarcas(1, 293);
      consultarMarcas.toModel(consultarMarcas.getResponse());

      ArrayList<ArrayList<?>> marcasLists = ListUtils.divideList(Marca.instances, 23);
      marcasLists.forEach(instance ->{
         //todo find why
         ConsultarPorThread<ConsultarModelos> consultarModelosPorThread = new ConsultarPorThread<>((ArrayList<Modelo>) instance);
         consultarModelosPorThread.start();
      });
      Thread.sleep(5000);

      ArrayList<ArrayList<?>> modelosList = ListUtils.divideList(Modelo.instances,  500);
      modelosList.forEach(item ->{
         ConsultarPorThread<ConsultarAnoModelo> consultarAnoModeloPorThread = new ConsultarPorThread<>((ArrayList<? extends IModel>) item);
         consultarAnoModeloPorThread.start();
      });
      Thread.sleep(15000);
      Modelo.mostrar();
      ModeloAno.mostrar();

   } catch (MalformedURLException e) {
      System.out.println(e.getMessage());
   } catch (IOException | InterruptedException e) {
      throw new RuntimeException(e);
   }
   }
}