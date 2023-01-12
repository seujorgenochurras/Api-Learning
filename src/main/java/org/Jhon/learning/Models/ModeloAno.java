package org.Jhon.learning.Models;

import com.google.gson.JsonElement;
import org.Jhon.learning.Models.Structure.Combustivel;
import org.Jhon.learning.Models.Structure.GenericModeloAnoModel;
import org.Jhon.learning.Models.Structure.IModel;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


public class ModeloAno extends GenericModeloAnoModel implements IModel {
   /**
    * String é o ano <br>
    * Integer é o combustivel
    */
   public static final TreeMap<String, Integer> anoModelos = new TreeMap<>();
   public static final List<ModeloAno> instances = new ArrayList<>();
   public ModeloAno(){}
   public ModeloAno(String ano, int combustivelID){
      setLabel(ano);
      setValue(combustivelID);

   }
   public Combustivel getCombustivel(){
      return Combustivel.getByValue(getValue());
   }

   @Override
   public void addToList() {
      anoModelos.putIfAbsent(this.getLabel(), this.getValue());
      instances.add(this);
   }
   public static void mostrar() {
     instances.forEach(item -> System.out.println(item.getLabel() + " : " + item.getCombustivel().name()));
   }


}
