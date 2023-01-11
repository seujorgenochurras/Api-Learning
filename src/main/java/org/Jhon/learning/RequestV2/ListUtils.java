package org.Jhon.learning.RequestV2;


import java.util.ArrayList;
import java.util.List;

public class ListUtils {
   /**
    *
    * */
   public static List<List<?>> divideList(List<?> list, int partitions) {
      if (list.size() % partitions != 0) {
         System.out.println("WARNING!! LIST SIZE (" + list.size() + ") CANNOT BE EVENLY DIVIDED BY (" + partitions + ") YOU WILL HAVE A LOSS OF DATA");
      }

      List<List<?>> result = new ArrayList<>();
      int elementsPerPartition = list.size() / partitions;

      for(int i = 0; i < partitions; i++){
         int startIndex = i * elementsPerPartition;
         int endIndex = startIndex + elementsPerPartition;
         result.add(new ArrayList<>(list.subList(startIndex, endIndex)));
      }
      return result;
   }
}
