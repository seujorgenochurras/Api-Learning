package org.Jhon.learning.ApiTesting.Structures.Request;

import org.Jhon.learning.Models.Structure.IModel;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

import java.time.LocalDate;
import java.util.Objects;

public interface FullRequestStructure extends IModel, Request {


   @Nullable
   @Range(from = 1, to = 3) Byte getCodigoTipoVeiculo();

   /**
    * @return id da data da tabela
    * */
   @Nullable
   Integer getCodigoTabelaReferencia();

   /**
    * @return id do modelo
    * */
   @Nullable
   Integer getCodigoModelo();

   /**
    * @return id da marca
    * */
   @Nullable
   Integer getCodigoMarca();

   /**
    * @return {ano} - {id_gasolina}; uma string com o ano seguido do tipo de gasolina
    * */
   @Nullable
   default String getAno() throws NullPointerException{
      if(Objects.isNull(getAnoModelo()) || Objects.isNull(getCodigoTipoCombustivel())){
         return null;
      }
      return getAnoModelo().getYear() + "-" + getCodigoTipoCombustivel();
   }

   /**
    * @return id do combustivel
    * */
   @Nullable
   Integer getCodigoTipoCombustivel();

  /**
    * @return o ano do modelo
    * */
   @Nullable
   LocalDate getAnoModelo();

   /**
    * Não sei onde isso pode ser usado, não achei nada ainda. Por algum motivo é sempre passado na API
    * */
   @Nullable
   default Object getModeloCodigoExterno(){return null;}



   /*
    *  codigoTabelaReferencia -> value da data de referencia (1, atual 293,)
    * codigoTipoVeiculo (1, 3) -> 1 = carro, 2 = truck, 3 = moto
    *codigoModelo: int (1, unknown)
    *codigoMarca: int (1, unknown)
    *ano: date (ex:2007-3)
    *codigoTipoCombustivel: int (1, unknown)
    *anoModelo: date (ex:2007)
    *modeloCodigoExterno: não sei de nada desse
    * */
}
