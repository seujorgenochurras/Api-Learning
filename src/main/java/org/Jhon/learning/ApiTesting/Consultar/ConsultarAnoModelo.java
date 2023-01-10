package org.Jhon.learning.ApiTesting.Consultar;

import org.Jhon.learning.ApiTesting.Structures.GenericModeloAno;
import org.Jhon.learning.ApiTesting.Structures.Request.AnoModeloRequest;
import org.Jhon.learning.Models.Modelo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;


//Esse é referência a interface AnoModeloRequest
public class ConsultarAnoModelo extends GenericModeloAno<AnoModeloRequest> {

   @Override
   public AnoModeloRequest getStructure() {
      return new AnoModeloRequest() {
         @Override
         public int getCodigoModelo() {
            return getModeloID();
         }

         @Override
         public int getCodigoMarca() {
            return ConsultarAnoModelo.super.getMarcaID();
         }

         @Override
         public @Range(from = 1, to = 3)
         @NotNull Integer getCodigoTipoVeiculo() {
            return ConsultarAnoModelo.super.getVehicleID();
         }

         @Override
         public Integer getCodigoTabelaReferencia() {
            return ConsultarAnoModelo.super.getTabelaReferenciaID();
         }
      };
   }
   public ConsultarAnoModelo(){}
   public ConsultarAnoModelo(int codigoModelo, int codigoTipoVeiculo, int taberalReferencia, int codigoMarca){
      setModeloID(codigoModelo);
      setVehicleID(codigoTipoVeiculo);
      setTabelaReferenciaID(taberalReferencia);
      setMarcaID(codigoMarca);
   }
   public ConsultarAnoModelo(Modelo modelo){
      setModeloID(modelo.getModeloID());
      setMarcaID(modelo.getMarcaID());
      setTabelaReferenciaID(modelo.getTabelaReferencialID());
      setVehicleID(modelo.getVeiculoID());
   }

}
