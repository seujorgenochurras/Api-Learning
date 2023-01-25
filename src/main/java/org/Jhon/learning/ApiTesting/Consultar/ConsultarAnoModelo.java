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
            return getModeloObject().getID();
         }

         @Override
         public int getCodigoMarca() {
            return getMarcaObject().getID();
         }

         @Override
         public @Range(from = 1, to = 3)
         @NotNull Integer getCodigoTipoVeiculo() {
            return getMarcaObject().getVeiculoID();
         }

         @Override
         public Integer getCodigoTabelaReferencia() {
            return getMarcaObject().getTabelaReferencialID();
         }
      };
   }
   public ConsultarAnoModelo(){}
   public ConsultarAnoModelo(Modelo modelo){
     setModelo(modelo);
     setMarcaObject(modelo.getMarcaObject());
   }

}
