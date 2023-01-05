package org.Jhon.learning.Models;

import org.Jhon.learning.ApiTesting.URLTypes;
import org.Jhon.learning.Models.Structure.GenericAPIRequester;
import org.Jhon.learning.Models.Structure.IModel;

import java.util.Arrays;
import java.util.HashMap;

public class Marca extends GenericAPIRequester<Marca> implements IModel {

   public static final HashMap<String, Integer> marcas = new HashMap<>();
//
//   public Marca(String nome, int valor){
//
//   }


   @Override
   public void addToList(Marca marca){
      marcas.putIfAbsent(marca.getName(), marca.getValue());
   }

   @Override
   public void addToList(Marca... marcasList) {
      Arrays.stream(marcasList).forEach( marca->{
         marcas.putIfAbsent(marca.getName(), marca.getValue());
      });
   }


   @Override
   public String getURLStructure() {
      return URLTypes.MARCAS.name();
   }
}
