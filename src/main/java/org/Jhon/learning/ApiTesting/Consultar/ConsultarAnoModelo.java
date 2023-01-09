package org.Jhon.learning.ApiTesting.Consultar;

import com.google.gson.JsonArray;
import org.Jhon.learning.ApiTesting.Structures.GenericModeloAno;
import org.Jhon.learning.ApiTesting.Structures.Request.AnoModeloRequest;
import org.Jhon.learning.Models.Modelo;
import org.Jhon.learning.Models.ModeloAno;
import org.Jhon.learning.Models.Structure.Combustivel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

import java.time.LocalDate;
import java.time.Year;
import java.util.Objects;

//Esse é referência a interface AnoModeloRequest
public class ConsultarAnoModelo extends GenericModeloAno<AnoModeloRequest> {

   @Override
   public void toModel() {
      if(Objects.isNull(response)) throw new IllegalStateException("CANNOT SAVE NULL JSON");
      JsonArray jsonArray = response.getAsJsonArray();
      jsonArray.forEach(item ->{
         String[] rawValues = item.getAsJsonObject().get("Value").getAsString().split("-");
         //"Value":"1992-1"
         String ano = rawValues[0];
         int combustivel = Integer.parseInt(rawValues[1]);
         ModeloAno modeloAno = new ModeloAno();
         modeloAno.setName(ano);
         modeloAno.setValue(combustivel);
         modeloAno.addToList();
      });
   }

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
}
