package org.Jhon.learning.RequestV2;


import java.util.ArrayList;
import java.util.List;

public class ListUtils {
   /**
    *
    * Divides a {@code List<>} by the partitions size
    *
    * @param list list to be divided
    * @param partitions number of partitions that you want the list to have
    * */
   public static <T> List<List<T>> divideList(List<T> list, int partitions) {
      if(partitions > list.size()) throw new IllegalArgumentException("Cannot divide the list size : " + list.size() + " with partitions: " + partitions );
      //Dividing partitions
      int elementsPerPartition = list.size() / partitions;

      //if cant be equally divided, some lists may have 1 more element
      //this is the rest of the elements that couldn't fit
      int elementsPerPartitionBuffer = list.size() % partitions;


      List<List<T>> result = new ArrayList<>(list.size());

      int startIndex = 0;
      int endIndex = elementsPerPartition;
      for(int i = 0; i < partitions; i++){
         if(elementsPerPartitionBuffer > 0){
            endIndex++;
            elementsPerPartitionBuffer--;
         }
         result.add(new ArrayList<>(list.subList(startIndex, endIndex)));
         startIndex = endIndex;
         endIndex += elementsPerPartition;
      }
      return result;
   }
}
