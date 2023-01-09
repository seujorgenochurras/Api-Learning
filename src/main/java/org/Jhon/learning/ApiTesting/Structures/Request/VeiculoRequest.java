package org.Jhon.learning.ApiTesting.Structures.Request;

import org.Jhon.learning.ApiTesting.Structures.URLTypes;
import org.Jhon.learning.Models.Carro;
import org.Jhon.learning.Models.Structure.CarTypes;
import org.Jhon.learning.Models.Structure.IModel;


public interface VeiculoRequest extends AnoModeloRequest {
   default CarTypes getTipoVeiculo (){
      return CarTypes.getByValue(getCodigoTipoVeiculo());
   }
   default String getTipoDeConsulta(){
      return "tradicional";
   }
   int getCodigoTipoCombustivel();
   String getAnoModelo();

   @Override
   default StringBuilder getURL() {
      return AnoModeloRequest.super.getURL()
              .append("&tipoConsulta=")
              .append(getTipoDeConsulta())
              .append("&tipoVeiculo=")
              .append(getTipoVeiculo().name())
              .append("&anoModelo=")
              .append(getAnoModelo())
              .append("&codigoTipoCombustivel=")
              .append(getCodigoTipoCombustivel());
   }
   @Override
   default URLTypes getURLStructure(){
      return URLTypes.CARRO;
   }
   @Override
   default Class<? extends IModel> getCorrespondentModel(){
      return Carro.class;
   }
}
