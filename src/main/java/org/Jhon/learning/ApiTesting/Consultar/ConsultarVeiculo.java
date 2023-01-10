package org.Jhon.learning.ApiTesting.Consultar;

import org.Jhon.learning.ApiTesting.Structures.GenericVeiculoClass;
import org.Jhon.learning.ApiTesting.Structures.Request.VeiculoRequest;
import org.Jhon.learning.Models.ModeloAno;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;


public class ConsultarVeiculo extends GenericVeiculoClass<VeiculoRequest> {
   @Override
   public VeiculoRequest getStructure() {
      return new VeiculoRequest() {
         @Override
         public int getCodigoTipoCombustivel() {
            return getCombustivelID();
         }

         @Override
         public String getAnoModelo() {
            return getAnoModeloID();
         }

         @Override
         public int getCodigoModelo() {
            return getModeloID();
         }

         @Override
         public int getCodigoMarca() {
            return getMarcaID();
         }

         @Override
         public @Range(from = 1, to = 3) @NotNull Integer getCodigoTipoVeiculo() {
            return getVehicleID();
         }

         @Override
         public Integer getCodigoTabelaReferencia() {
            return getTabelaReferenciaID();
         }
      };
   }
   public ConsultarVeiculo(){};
   public ConsultarVeiculo(ModeloAno modeloAno){
      setAnoModeloID(modeloAno.getName());
      setCombustivelID(modeloAno.getValue());
      setTabelaReferenciaID(modeloAno.getTabelaReferencialID());
      setModeloID(modeloAno.getModeloID());
      setMarcaID(modeloAno.getMarcaID());
      setVehicleID(modeloAno.getVeiculoID());
   }
}
