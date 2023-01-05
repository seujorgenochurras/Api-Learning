package org.Jhon.learning.ApiTesting;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.Jhon.learning.ApiTesting.Structures.RequestStructure;
import org.Jhon.learning.Models.Structure.IModel;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;

public final class Requester {
//   public static HashSet<? extends IModel> postRequest(int value){
//   return null;
//   }
   private URL url;
   private RequestStructure requestStructure;

   public RequestStructure getRequestStructure() {
      return requestStructure;
   }

   public void setRequestStructure(RequestStructure requestStructure) {
      this.requestStructure = requestStructure;
   }

   private void doRequest(URLTypes requestName) throws IOException {
      url = new URL("https://veiculos.fipe.org.br/api/veiculos//" + requestName.value);
      HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

      urlConnection.setRequestMethod(requestName.requestsType.toString());
      urlConnection.setDoOutput(true);
      urlConnection.getOutputStream().write(getParamsAsURL(getRequestStructure()).getBytes());

      int connectResponse = urlConnection.getResponseCode();
      if (connectResponse != 200) {
         throw new RuntimeException("HttpResponseCode: " + connectResponse);
      }
   }
   private String getParamsAsURL(@NotNull RequestStructure structure){
      StringBuilder urlBuilder = new StringBuilder();
      urlBuilder.append("codigoTipoVeiculo=").append(structure.getCodigoTipoVeiculo());
      urlBuilder.append("&codigoTabelaReferencia=").append(structure.getCodigoTabelaReferencia());
      urlBuilder.append("&codigoModelo=").append(structure.getCodigoModelo());
      urlBuilder.append("&codigoMarca=").append(structure.getCodigoMarca());
      urlBuilder.append("&ano=").append(structure.getAno());
      urlBuilder.append("&codigoTipoCombustivel=").append(structure.getCodigoTipoCombustivel());
      urlBuilder.append("&anoModelo=").append(structure.getAnoModelo());
      urlBuilder.append("&modeloCodigoExterno=").append(structure.getModeloCodigoExterno());
      while(urlBuilder.indexOf("null") != -1){
         int indexOfNull = urlBuilder.indexOf("null");
         urlBuilder.replace(indexOfNull, indexOfNull + 4, "");
      }
      return urlBuilder.toString();
   }
   public static void doSmth(){
      try {

         URL url = new URL("https://veiculos.fipe.org.br/api/veiculos//ConsultarModelos");
         HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

         urlConnection.setRequestMethod("POST");
         urlConnection.setDoOutput(true);
         urlConnection.getOutputStream().write("codigoTipoVeiculo=1&codigoTabelaReferencia=293&codigoMarca=2".getBytes());

         BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
         String response = in.readLine();
         in.close();
         Gson gson = new Gson();
         HashMap<String, Integer> modelos = new HashMap<>();
         JsonObject jsonObject = gson.fromJson(response, JsonObject.class);
         JsonArray jsonArray = jsonObject.getAsJsonArray("Modelos");

         jsonArray.forEach((item) ->{
            String nome = item.getAsJsonObject().get("Label").getAsString();
            int value = item.getAsJsonObject().get("Value").getAsInt();
            modelos.put(nome, value);
         });
         modelos.forEach((nome, value) -> {
            System.out.println(nome + ":" + value);
         });

      } catch (MalformedURLException e) {
         System.out.println(e.getMessage());
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }
}
