package org.Jhon.learning.ApiTesting;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.Jhon.learning.ApiTesting.Structures.MarcasRequest;
import org.Jhon.learning.ApiTesting.Structures.RequestStructure;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

import java.io.IOException;
import java.time.LocalDate;

public class ConsultarMarcas {
   static Requester<RequestStructure> requester = new Requester<>();
   private static JsonArray jsonArray;
   public static void getMarcas() throws IOException {
      requester.setRequestStructure(new RequestStructure() {
         @Override
         public String getURLStructure() {
            return URLTypes.MARCAS.name();
         }

         @Override
         public @Range(from = 1, to = 3) @NotNull Byte getCodigoTipoVeiculo() {
            return 1;
         }

         @Override
         public Integer getCodigoTabelaReferencia() {
            return 293;
         }

         @Override
         public @Nullable Integer getCodigoModelo() {
            return null;
         }

         @Override
         public @Nullable Integer getCodigoMarca() {
            return null;
         }

         @Override
         public @Nullable Integer getCodigoTipoCombustivel() {
            return null;
         }

         @Override
         public @Nullable LocalDate getAnoModelo() {
            return null;
         }
      });
      jsonArray = requester.doRequest(URLTypes.MARCAS);

   }
   public static void mostrar(){
      jsonArray.forEach(System.out::println);
   }

}
