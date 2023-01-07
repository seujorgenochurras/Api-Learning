package org.Jhon.learning.ApiTesting.Structures.Request;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

public interface MarcasRequest extends Request{

   @Range(from = 1, to = 3) @NotNull Integer getCodigoTipoVeiculo();


   /**
    * @return id da data da tabela
    * */
   Integer getCodigoTabelaReferencia();

   @Override
   default StringBuilder getURL(){
       return
               new StringBuilder("codigoTipoVeiculo=").append(getCodigoTipoVeiculo())
                       .append("&codigoTabelaReferencia=").append(getCodigoTabelaReferencia());
   }

}
