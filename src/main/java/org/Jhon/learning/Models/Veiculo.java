package org.Jhon.learning.Models;

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

  @Override
  public int getID() {
    throw new IllegalStateException("Carro não tem id próprio, use o código fipe como id");
  }

  @Override
  public Method[] getMethods() throws NoSuchMethodException {
    Class<? extends Veiculo> instance = this.getClass();
    Method getNome = instance.getMethod("getModelName");
    Method getPreco = instance.getMethod("getPreco");
    Method getMarcaNome = instance.getMethod("getMarcaNome");
    Method getModeloNome = instance.getMethod("getModeloNome");
    Method getAnoModelo = instance.getMethod("getAno");
    Method getCombustivel = instance.getMethod("getCombustivelName");
    Method getSiglaCombustivel = instance.getMethod("getSiglaCombustivel");
    Method getFipe = instance.getMethod("getCodigoFipe");
    Method getMesReferencia = instance.getMethod("getMesReferencia");
    Method getAutenticacao = instance.getMethod("getAutenticacao");
    Method getDataConsulta = instance.getMethod("getDataConsulta");
    Method getTipoVeiculo = instance.getMethod("getVeiculoTipoNome");
    return new Method[]{getNome, getPreco, getMarcaNome, getModeloNome, getAnoModelo, getTipoVeiculo,
            getCombustivel, getSiglaCombustivel, getFipe, getMesReferencia, getAutenticacao, getDataConsulta};
  }

  @Override
  public String getTableName() {
    return "carro";
  }
}
