package org.Jhon.learning.ApiTesting.Structures;

import org.Jhon.learning.Models.Structure.CarTypes;


public interface CarroRequest extends AnoModeloRequest{
   default CarTypes getTipoVeiculo (){
      return CarTypes.getByNumber(getCodigoTipoVeiculo());
   }
   default String getTipoDeConsulta(){
      return "tradicional";
   }
}
