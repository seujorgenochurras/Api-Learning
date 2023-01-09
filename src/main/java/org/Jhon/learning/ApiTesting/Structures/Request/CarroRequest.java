package org.Jhon.learning.ApiTesting.Structures.Request;

import org.Jhon.learning.ApiTesting.Structures.URLTypes;
import org.Jhon.learning.Models.Carro;
import org.Jhon.learning.Models.Structure.CarTypes;
import org.Jhon.learning.Models.Structure.IModel;


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
   @Override
   default URLTypes getURLStructure(){
      return URLTypes.CARRO;
   }
   @Override
   default Class<? extends IModel> getCorrespondentModel(){
      return Carro.class;
   }
}
