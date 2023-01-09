package org.Jhon.learning.Models;

import org.Jhon.learning.Models.Structure.GenericVehicleStructure;
import org.Jhon.learning.Models.Structure.IModel;

import java.util.ArrayList;
import java.util.List;

public class Veiculo extends GenericVehicleStructure implements IModel {
  public static final List<Veiculo> carro = new ArrayList<>();


  public void addToList(){
    carro.add(this);
  }

  public static void mostrar(){
    carro.forEach( carro->{
      System.out.println(carro.getPreco());
      System.out.println(carro.getAno());
      System.out.println(carro.getAuth());
      System.out.println(carro.getCombustivel());
      System.out.println(carro.getSiglaCombustivel());
      System.out.println(carro.getMarca());
      System.out.println(carro.getModelo());
      System.out.println(carro.getCodFipe());
      System.out.println(carro.getMesReferencia());
      System.out.println(carro.getDiaConsulta());
      System.out.println(carro.getTipoVeiculo());
    });
  }
}
