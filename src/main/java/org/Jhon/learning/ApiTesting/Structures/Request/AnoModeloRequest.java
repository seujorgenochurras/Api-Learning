package org.Jhon.learning.ApiTesting.Structures.Request;

import org.Jhon.learning.ApiTesting.URLTypes;
import org.Jhon.learning.Models.Carro;

public interface AnoModeloRequest extends ModeloRequest {
   /**
    * @return id do modelo
    */
   int getCodigoModelo();

   @Override
   default StringBuilder getURL() {
      return ModeloRequest.super.getURL()
              .append("&codigoModelo=").append(getCodigoModelo());
   }

   @Override
   default URLTypes getURLStructure() {
      return URLTypes.MODELO_ANO;
   }
}
