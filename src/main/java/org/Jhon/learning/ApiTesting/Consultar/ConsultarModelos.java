package org.Jhon.learning.ApiTesting.Consultar;

import org.Jhon.learning.ApiTesting.Structures.GenericModelo;
import org.Jhon.learning.ApiTesting.Structures.Request.ModeloRequest;
import org.Jhon.learning.Models.Marca;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;


public class ConsultarModelos extends GenericModelo<ModeloRequest> {

   public ConsultarModelos(){}
   public ConsultarModelos(Marca marca){
     setMarcaObject(marca);
   }

   @Override
   protected ModeloRequest getStructure() {
      return new ModeloRequest() {
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



}
