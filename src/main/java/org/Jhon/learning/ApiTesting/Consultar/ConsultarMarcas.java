package org.Jhon.learning.ApiTesting.Consultar;

import com.google.gson.JsonElement;
import org.Jhon.learning.ApiTesting.Structures.GenericMarca;
import org.Jhon.learning.ApiTesting.Structures.Request.MarcasRequest;
import org.Jhon.learning.Models.Marca;
import org.Jhon.learning.Models.Structure.CarTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

import java.util.Objects;


public class ConsultarMarcas extends GenericMarca<MarcasRequest> {
   public ConsultarMarcas(int vehicleID, int tabelaReferenciaID) {
      setVehicleID(vehicleID);
      setTabelaReferenciaID(tabelaReferenciaID);
   }

   public ConsultarMarcas(CarTypes carType, int tabelaReferenciaID) {
      setVehicleID(carType.value);
      setTabelaReferenciaID(tabelaReferenciaID);
   }

   @Override
   public MarcasRequest getStructure() {
      return new MarcasRequest() {
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
