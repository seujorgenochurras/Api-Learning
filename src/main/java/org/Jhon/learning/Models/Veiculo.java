package org.Jhon.learning.Models;

import org.Jhon.learning.Models.Structure.CarTypes;
import org.Jhon.learning.Models.Structure.GenericVehicleStructure;
import org.Jhon.learning.Models.Structure.IModel;
import org.Jhon.learning.MySQL.Structures.SQLInsert;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
public class Veiculo extends GenericVehicleStructure implements IModel, SQLInsert {
  public static final List<Veiculo> carro = new ArrayList<>();

  public String getVeiculoTipoNome(){
    return CarTypes.getByValue(getVeiculoID()).name();
  }

  public void addToList(){
   carro.add(this);

  }

  /**
   * @return A {@code double}, price of the vehicle
   * @see GenericVehicleStructure#getValor()
   */
  public BigDecimal getPreco() {

    //Removing the monetary symbol from the valor
    String onlyNumberPrice = getValor().replace("R$ ", "");

    //Properly parsing price to number format
    DecimalFormat format = new DecimalFormat("#,##0.00");
    format.setParseBigDecimal(true);

    try {
      return (BigDecimal) format.parse(onlyNumberPrice);
    }catch (ParseException e){
      System.err.println("Error while trying to parse a price"+ e);
    return null;
    }
  }

  public static void mostrar(){
    carro.forEach( carro->{
      System.out.println(carro.getValor());
      System.out.println(carro.getAnoModelo());
      System.out.println(carro.getAutenticacao());
      System.out.println(carro.getCombustivel());
      System.out.println(carro.getSiglaCombustivel());
      System.out.println(carro.getMarca());
      System.out.println(carro.getModelo());
      System.out.println(carro.getCodigoFipe());
      System.out.println(carro.getMesReferencia());
      System.out.println(carro.getDataConsulta());
      System.out.println(carro.getTipoVeiculo());
      System.out.println("*****FIM DO VEICULO*****\n");
    });
  }

  public static void getMostExpensiveCar(List<Veiculo> veiculosList){
    Veiculo mostExpensiveCar = null;
    long highestPrice = 0;
    for(Veiculo carro1 : veiculosList){
      if(carro1.getPreco().longValue() > highestPrice){
        highestPrice = carro1.getPreco().longValue();
        mostExpensiveCar = carro1;
      }
    }
    System.out.println(mostExpensiveCar.getValor());
    System.out.println(mostExpensiveCar.getAnoModelo());
    System.out.println(mostExpensiveCar.getAutenticacao());
    System.out.println(mostExpensiveCar.getCombustivel());
    System.out.println(mostExpensiveCar.getSiglaCombustivel());
    System.out.println(mostExpensiveCar.getMarca());
    System.out.println(mostExpensiveCar.getModelo());
    System.out.println(mostExpensiveCar.getCodigoFipe());
    System.out.println(mostExpensiveCar.getMesReferencia());
    System.out.println(mostExpensiveCar.getDataConsulta());
    System.out.println(mostExpensiveCar.getTipoVeiculo());
    System.out.println("*****FIM DO VEICULO*****\n");
  } public static void getLeastExpensiveCar(List<Veiculo> veiculosList){
    Veiculo mostExpensiveCar = veiculosList.get(0);
    long highestPrice = veiculosList.get(0).getPreco().longValue();
    for(Veiculo carro1 : veiculosList){
      if(carro1.getPreco().longValue() < highestPrice){
        highestPrice = carro1.getPreco().longValue();
        mostExpensiveCar = carro1;
      }
    }
    System.out.println(mostExpensiveCar.getValor());
    System.out.println(mostExpensiveCar.getAnoModelo());
    System.out.println(mostExpensiveCar.getAutenticacao());
      System.out.println(mostExpensiveCar.getCombustivel());
    System.out.println(mostExpensiveCar.getSiglaCombustivel());
    System.out.println(mostExpensiveCar.getMarca());
    System.out.println(mostExpensiveCar.getModelo());
    System.out.println(mostExpensiveCar.getCodigoFipe());
    System.out.println(mostExpensiveCar.getMesReferencia());
    System.out.println(mostExpensiveCar.getDataConsulta());
    System.out.println(mostExpensiveCar.getTipoVeiculo());
    System.out.println("*****FIM DO VEICULO*****\n");
  }

  @Override
  public Method[] getMethods() throws NoSuchMethodException {
    Class<? extends Veiculo> instance = this.getClass();
    Method getNome = instance.getMethod("getNome");
    Method getPreco = instance.getMethod("getPreco");
    Method getMarcaNome = instance.getMethod("getMarca");
    Method getModeloNome = instance.getMethod("getModelo");
    Method getAnoModelo = instance.getMethod("getAnoModelo");
    Method getCombustivel = instance.getMethod("getCombustivel");
    Method getSiglaCombustivel = instance.getMethod("getSiglaCombustivel");
    Method getFipe = instance.getMethod("getCodigoFipe");
    Method getMesReferencia = instance.getMethod("getMesReferencia");
    Method getAutenticacao = instance.getMethod("getAutenticacao");
    Method getDataConsulta = instance.getMethod("getDataConsulta");
    Method getTipoVeiculo = instance.getMethod("getVeiculoTipoNome");
    return new Method[]{getNome, getPreco, getMarcaNome, getModeloNome, getAnoModelo,
            getCombustivel, getSiglaCombustivel, getFipe, getMesReferencia, getAutenticacao, getDataConsulta};
  }

  @Override
  public String getTableName() {
    return "carro";
  }
}
