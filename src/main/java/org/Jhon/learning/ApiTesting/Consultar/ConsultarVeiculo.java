package org.Jhon.learning.ApiTesting.Consultar;

import com.google.gson.JsonObject;
import org.Jhon.learning.ApiTesting.Structures.GenericVeiculoClass;
import org.Jhon.learning.ApiTesting.Structures.Request.VeiculoRequest;
import org.Jhon.learning.Models.Veiculo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

import java.time.Year;
import java.util.Objects;

public class ConsultarVeiculo extends GenericVeiculoClass<VeiculoRequest> {
   @Override
   public void toModel() {
      if(Objects.isNull(response)) throw new IllegalStateException("CANNOT SAVE NULL JSON");
      JsonObject json = response.getAsJsonObject();
         String preco = json.get("Valor").getAsString();
         String marca = json.get("Marca").getAsString(); //TODO this comes from a model
         String modelo = json.get("Modelo").getAsString(); //TODO this comes from a model
         String anoModelo = json.get("AnoModelo").getAsString();
         String combustivel = json.get("Combustivel").getAsString(); //TODO this comes from a model
         String codigoFipe = json.get("CodigoFipe").getAsString();
         String mesReferencia = json.get("MesReferencia").getAsString();
         String auth = json.get("Autenticacao").getAsString();
         int codigoVeiculo = json.get("TipoVeiculo").getAsInt();
         String siglaCombustivel = json.get("SiglaCombustivel").getAsString();
         String dataConsulta = json.get("DataConsulta").getAsString();

         Veiculo veiculo = new Veiculo();
         veiculo.setPreco(preco);
         veiculo.setAno(Year.parse(anoModelo));
         veiculo.setAuth(auth);
         veiculo.setCombustivel(combustivel);
         veiculo.setSiglaCombustivel(siglaCombustivel);
         veiculo.setMarca(marca);
         veiculo.setModelo(modelo);
         veiculo.setCodFipe(codigoFipe);
         veiculo.setMesReferencia(mesReferencia);
         veiculo.setDiaConsulta(dataConsulta);
         veiculo.setTipoVeiculo(codigoVeiculo);

         veiculo.addToList();
      }

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
}
