package org.Jhon.learning.RequestV2;

import org.Jhon.learning.Models.Marca;

import java.util.ArrayList;
import java.util.Collections;

public class ListUtils {
   /**
    *
    * */
   public static ArrayList<ArrayList<?>> divideList(ArrayList<?> arrayList, int partitions) {

      int numberOfElementsByPartitions = 0;
      if (arrayList.size() % partitions != 0) {
         System.out.println("WARNING!! CANNOT DIVIDE SIZE OF ARRAYLIST("+ arrayList.size()+") WITH THE NUMBER PROVIDED (" + partitions + ") YOU WILL HAVE A LOSS OF DATA");
      }
      numberOfElementsByPartitions += arrayList.size() / partitions;
      ArrayList<ArrayList<?>> finale = new ArrayList<>();

      ArrayList<Object> tmp = new ArrayList<>();
      for(int j = 0; j < partitions; j++){
      for (int i = 0; i < numberOfElementsByPartitions; i++ ){
        tmp.add(arrayList.get(0));
        arrayList.remove(0);
      }
      finale.add((ArrayList<?>) tmp.clone()); //TODO learn more about shallow and deep copies
      tmp.clear();
     }
     return finale;

   }
}
