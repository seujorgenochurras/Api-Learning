package org.Jhon.learning;

import org.Jhon.learning.ApiTesting.Consultar.ConsultarMarcas;
import org.Jhon.learning.ApiTesting.Consultar.ConsultarModelos;
import org.Jhon.learning.Models.Marca;
import org.Jhon.learning.Models.Modelo;
import org.Jhon.learning.RequestV2.ConsultarPorThread;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
   public static void main(String[] args) {
   try {
      ConsultarMarcas consultarMarcas = new ConsultarMarcas(1, 293);
      consultarMarcas.toModel(consultarMarcas.getResponse());
      AtomicInteger tmp = new AtomicInteger();
      ArrayList<Marca> marcas1 = new ArrayList<>();
      for (int i = 0; i < Marca.instances.size(); i++){
         Marca marca = Marca.instances.get(0);
         tmp.getAndIncrement();
         marcas1.add(marca);
         Marca.instances.remove(0);
         if(tmp.get() == 50) break;
      }

      ConsultarPorThread<ConsultarModelos> consultarPorThread = new ConsultarPorThread<>(Marca.instances);
      ConsultarPorThread<ConsultarModelos> consultarPorThread1= new ConsultarPorThread<>(marcas1);
      consultarPorThread.start();
     consultarPorThread1.start();
      Thread.sleep(10000);
      consultarPorThread.interrupt();
      consultarPorThread1.interrupt();
      Modelo.mostrar();
//         ConsultarMarcas consultarMarcas = new ConsultarMarcas(1, 293);
//         consultarMarcas.toModel(consultarMarcas.getResponse());
//        System.out.println("Carregando modelos...");
//        AtomicInteger atomicInteger = new AtomicInteger();
//        int marcasQuantidade = Marca.instances.size();
//         Marca.instances.forEach((instance)->{
//            System.out.println(atomicInteger.getAndIncrement() + " de " + marcasQuantidade);
//            ConsultarModelos consultarModelos = new ConsultarModelos(instance);
//            try {
//               consultarModelos.toModel(consultarModelos.getResponse());
//            } catch (IOException e) {
//               throw new RuntimeException(e);
//            }
//         });
//            System.out.println("*******MODELOS CARREGADOS...*******");
//              System.out.println("Carregando anos...");
//
//        AtomicInteger tmp = new AtomicInteger();
//        int instacesTotal = Modelo.instances.size() +1;
//            Modelo.instances.forEach((instace) ->{
//               System.out.println(tmp.getAndIncrement() + " de " + instacesTotal);
//               ConsultarAnoModelo consultarAnoModelo = new ConsultarAnoModelo(instace);
//               try {
//                  consultarAnoModelo.toModel(consultarAnoModelo.getResponse());
//
//               } catch (IOException e) {
//                  throw new RuntimeException(e);
//               }
//
//            });
//        System.out.println("*******ANOS CARREGADOS...*******");
//
//      Modelo.instances.forEach((instace) -> System.out.println(instace.getName() + " : " + instace.getValue()));
//      ModeloAno.instances.forEach((instace) -> System.out.println(instace.getName() + " : " + instace.getValue()));
   } catch (MalformedURLException e) {
      System.out.println(e.getMessage());
   } catch (IOException | InterruptedException e) {
      throw new RuntimeException(e);
   }
   }
}