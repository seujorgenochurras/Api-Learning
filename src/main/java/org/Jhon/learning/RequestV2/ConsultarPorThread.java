package org.Jhon.learning.RequestV2;

import org.Jhon.learning.ApiTesting.Consultar.ConsultarAnoModelo;
import org.Jhon.learning.ApiTesting.Consultar.ConsultarModelos;
import org.Jhon.learning.ApiTesting.Consultar.ConsultarVeiculo;
import org.Jhon.learning.ApiTesting.Structures.GenericConsultarClass;
import org.Jhon.learning.Models.Structure.IModel;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ConsultarPorThread<T extends GenericConsultarClass<?>> extends Thread {

   /**
    * list that it will iterate and get its models
    * */
   private List<? extends IModel> modelsList = new ArrayList<>();
   private ClassModel classLevel;
   public List<? extends IModel> getIterationList() {
      return modelsList;
   }

   public  <H extends IModel> void setIterationList(List<H> iterationList) {
      this.modelsList = iterationList;
   }

   public <H extends IModel>ConsultarPorThread(List<H> listaDePesquisa){
      //When you have like 30 elements on a list and try to divide it into 300 threads
      try {
         listaDePesquisa.get(0);
      }catch (IndexOutOfBoundsException e){
         System.out.println(e);
         System.out.println("Have more threads than needed");
      }
      switch (listaDePesquisa.get(0).getClass().getSimpleName()) {
         //todo fix this monkey code
         case "Marca" -> this.classLevel = ClassModel.MARCA;
         case "Modelo" -> this.classLevel = ClassModel.MODELO;
         case "ModeloAno" -> this.classLevel = ClassModel.MODELO_ANO;
         case "Veiculo" -> this.classLevel = ClassModel.VEICULO;
      }
      setIterationList(listaDePesquisa);
   }

   @Override
   public void run(){
      System.out.println("*******Carregando " + modelsList.get(0).getClass().getSimpleName() + "*******");
      AtomicInteger tmp = new AtomicInteger();
      
         Class<?> model = classLevel.classe;
         Class<?>[] paramType = {modelsList.get(0).getClass()};
      modelsList.forEach(item ->{
         try {
            //todo find what this warning means
           T instance = (T) model.getDeclaredConstructor(paramType).newInstance(item);
            instance.toModel(instance.getResponse());
            System.out.println(tmp.getAndIncrement() + 1 + " de " + modelsList.size());
         } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            System.out.println("ERRO AO CARREGAR O " + classLevel.name() + " numero " + tmp.getAndIncrement());
            throw new RuntimeException(e);
         } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
         }
      });
   }



   /**
    * Return the class model that a request should return;
    * for example, a "modelo" comes from a "marca" class.
    * */
   private enum ClassModel {
      MARCA(ConsultarModelos.class),
      MODELO(ConsultarAnoModelo.class),
      MODELO_ANO(ConsultarVeiculo.class),
      VEICULO(null);

      public final Class<? extends GenericConsultarClass<?>> classe;

      ClassModel(Class<? extends GenericConsultarClass<?>> classe) {
         this.classe = classe;
      }

      public static ClassModel getClass(Class<?> value) {
         for (ClassModel level : ClassModel.values()) {
            if (level.classe.equals(value)) return level;
         }
      return null;
      }
   }

}

