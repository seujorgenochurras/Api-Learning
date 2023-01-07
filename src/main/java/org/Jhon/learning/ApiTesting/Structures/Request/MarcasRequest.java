package org.Jhon.learning.ApiTesting.Structures;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

public interface MarcasRequest extends Request{

   @Range(from = 1, to = 3) Byte getCodigoTipoVeiculo();

   /**
    * @return id da data da tabela
    * */

   Integer getCodigoTabelaReferencia();
}
