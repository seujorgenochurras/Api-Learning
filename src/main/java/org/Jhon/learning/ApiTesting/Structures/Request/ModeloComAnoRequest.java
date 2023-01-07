package org.Jhon.learning.ApiTesting.Structures.Request;

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
   /*
      urlBuilder.append("&codigoModelo=").append(structure.getCodigoModelo());
      urlBuilder.append("&codigoMarca=").append(structure.getCodigoMarca());
      urlBuilder.append("&ano=").append(structure.getAno());
      urlBuilder.append("&codigoTipoCombustivel=").append(structure.getCodigoTipoCombustivel());
      urlBuilder.append("&anoModelo=").append(structure.getAnoModelo());
      urlBuilder.append("&modeloCodigoExterno=").append(structure.getModeloCodigoExterno());*/
}
