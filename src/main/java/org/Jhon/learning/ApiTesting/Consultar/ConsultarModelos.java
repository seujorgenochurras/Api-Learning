package org.Jhon.learning.ApiTesting.Consultar;

import org.Jhon.learning.ApiTesting.Structures.GenericModelo;
import org.Jhon.learning.ApiTesting.Structures.Request.ModeloRequest;
import org.Jhon.learning.Models.Marca;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;


public class ConsultarModelos extends GenericModelo<ModeloRequest> {
   public ConsultarModelos(int marcaID, int vehicleID, int tabelaReferenciaID){
      setMarcaID(marcaID);
      setVehicleID(vehicleID);
      setTabelaReferenciaID(tabelaReferenciaID);
   }
   public ConsultarModelos(){}
   public ConsultarModelos(Marca marca){
      setVehicleID(marca.getVeiculoID());
      setTabelaReferenciaID(marca.getTabelaReferencialID());
      setMarcaID(marca.getValue());
   }

   @Override
   protected ModeloRequest getStructure() {
      return new ModeloRequest() {
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



}
