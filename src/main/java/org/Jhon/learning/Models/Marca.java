package org.Jhon.learning.Models;

import org.Jhon.learning.Models.Structure.GenericMarcaModel;
import org.Jhon.learning.Models.Structure.IModel;
import org.Jhon.learning.MySQL.Structures.SQLInsert;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Marca extends GenericMarcaModel implements IModel, SQLInsert {


   public static final ArrayList<Marca> instances = new ArrayList<>();
   @Override
   public void addToList(){
      instances.add(this); //TODO fix this
    //  System.out.println("added : " + this.getName());
   }

   @Override
   public Method[] getMethods() throws NoSuchMethodException {
      Class<? extends Marca> instance = this.getClass();
      Method getID = instance.getMethod("getID");
      Method getNome = instance.getMethod("getNome");
      Method getVeiculoID = instance.getMethod("getVeiculoID");
      Method getMesReferencia = instance.getMethod("getTabelaReferencialID");

      return new Method[]{getID, getNome, getVeiculoID, getMesReferencia};
   }

   @Override
   public String getTableName() {
      return "Marca";
   }
}
