package org.Jhon.learning.ApiTesting.Structures.Request;

import org.Jhon.learning.Models.Structure.CarTypes;


public interface CarroRequest extends ModeloComAnoRequest {
   default CarTypes getTipoVeiculo (){
      return CarTypes.getByNumber(getCodigoTipoVeiculo());
   }
   default String getTipoDeConsulta(){
      return "tradicional";
   }

   @Override
   default StringBuilder getURL() {
      return ModeloComAnoRequest.super.getURL()
              .append("&tipoConsulta")
              .append(getTipoDeConsulta())
              .append("&tipoVeiculo=")
              .append(getTipoVeiculo());
   }
}
