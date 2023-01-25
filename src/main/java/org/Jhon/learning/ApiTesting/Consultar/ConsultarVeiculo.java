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
            return getModeloAno().getValue(); //todo fix this
         }

         @Override
         public int getAnoModelo() {
            return getModeloAno().getAno();
         }

         @Override
         public int getCodigoModelo() {
            return getModeloObject().getID();
         }

         @Override
         public int getCodigoMarca() {
            return getMarcaObject().getID();
         }

         @Override
         public @Range(from = 1, to = 3) @NotNull Integer getCodigoTipoVeiculo() {
            return getMarcaObject().getVeiculoID();
         }

         @Override
         public Integer getCodigoTabelaReferencia() {
            return getMarcaObject().getTabelaReferencialID();
         }
      };
   }
   public ConsultarVeiculo(){};
   public ConsultarVeiculo(ModeloAno modeloAno){
          setModeloAno(modeloAno);
   }
}
