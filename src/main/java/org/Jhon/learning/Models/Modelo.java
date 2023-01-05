package org.Jhon.learning.Models;

import org.Jhon.learning.ApiTesting.Structures.RequestStructure;
import org.Jhon.learning.ApiTesting.URLTypes;
import org.Jhon.learning.Models.Structure.GenericAPIRequester;
import org.Jhon.learning.Models.Structure.IModel;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;

//Modelo de carro kkkk
public class Modelo extends GenericAPIRequester<Modelo> implements IModel {
   /**
    * String é o nome do modelo
    * Integer é o valor, é usado em requests
    * */
   public static final HashMap<String, Integer> modelos = new HashMap<>();

   public Modelo(String name, Integer valor){
      this.setName(name);
      this.setValue(valor);
      addToList(this);
   }

   @Override
   public void addToList(Modelo modelo){
      modelos.putIfAbsent(modelo.getName(), modelo.getValue());
   }
   @Override
   public void addToList(Modelo... modelosList) {
      Arrays.stream(modelosList).forEach(marca->{
         modelos.putIfAbsent(marca.getName(), marca.getValue());
      });
   }

   @Override
   public String getURLStructure() {
      return URLTypes.MODELOS.value;
   }
}
