package org.Jhon.learning.Models;

import org.Jhon.learning.Models.Structure.GenericVehicleStructure;
import org.Jhon.learning.Models.Structure.IModel;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Veiculo extends GenericVehicleStructure implements IModel {
  public static final List<Veiculo> carro = new ArrayList<>();


  public void addToList(){
  if(!carro.contains(this)) carro.add(this);

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
      System.out.println("*****FIM DO VEICULO*****\n");
    });
  }
  public static void getMostExpensiveCar(){
    Veiculo veiculo = null;
    int lastPriceSize = 0; //7
    for(Veiculo carro1 : carro){
      if(carro1.getPreco().length() > lastPriceSize){
        lastPriceSize = carro1.getPreco().length();
        veiculo = carro1;
      }
    }
    System.out.println(veiculo.getPreco());
    System.out.println(veiculo.getAno());
    System.out.println(veiculo.getAuth());
    System.out.println(veiculo.getCombustivel());
    System.out.println(veiculo.getSiglaCombustivel());
    System.out.println(veiculo.getMarca());
    System.out.println(veiculo.getModelo());
    System.out.println(veiculo.getCodFipe());
    System.out.println(veiculo.getMesReferencia());
    System.out.println(veiculo.getDiaConsulta());
    System.out.println(veiculo.getTipoVeiculo());
    System.out.println("*****FIM DO VEICULO*****\n");
  }
}
