package org.Jhon.learning.ApiTesting.Structures.Request;

import org.Jhon.learning.ApiTesting.URLTypes;

import java.time.Year;

public interface ModeloComAnoRequest extends AnoModeloRequest {

   int getCodigoTipoCombustivel();

   Year getAnoModelo();

   default String getAno(){
      return getAnoModelo() + "-" + getCodigoTipoCombustivel();
   }

   @Override
   default StringBuilder getURL() {
      return AnoModeloRequest.super.getURL()
              .append("&ano=")
              .append(getAno())
              .append("&codigoTipoCombustivel=")
              .append(getCodigoTipoCombustivel());
   }
   @Override
   default URLTypes getURLStructure(){
      return URLTypes.MODELO_ATRAVES_ANO;
   }
}
