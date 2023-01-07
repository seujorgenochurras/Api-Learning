package org.Jhon.learning.ApiTesting.Structures;

import java.time.LocalDate;
import java.time.Year;

public interface ModeloComAnoRequest extends AnoModeloRequest {
   /*codigoTipoCombustivel:
1
anoModelo:
1992*/
   int getCodigoTipoCombustivel();

   Year getAnoModelo();

   default String getAno(){
      return getAnoModelo() + "-" + getCodigoTipoCombustivel();
   }

}
