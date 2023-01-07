package org.Jhon.learning.ApiTesting;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.Jhon.learning.ApiTesting.Structures.Request.Request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public final class Requester<T extends Request> {
//   public static HashSet<? extends IModel> postRequest(int value){
//   return null;
//   }
   private URL url;
   private T requestStructure;

   public T getRequestStructure() {
      return requestStructure;
   }

   public void setRequestStructure(T requestStructure) {
      this.requestStructure = requestStructure;
   }

   public Requester(T requestStructure){
      setRequestStructure(requestStructure);
   }
   public Requester(){}
   public JsonArray doRequest() throws IOException {
      //URLTypes requestName = requestStructure;
      URLTypes requestName = requestStructure.getURLStructure();
      url = new URL("https://veiculos.fipe.org.br/api/veiculos//" + requestName.value);
      HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

      urlConnection.setRequestMethod(requestName.requestsType.toString());
      urlConnection.setDoOutput(true);
      urlConnection.getOutputStream().write(getParamsAsURL().getBytes()); //TODO ERROR HERE

      int connectResponse = urlConnection.getResponseCode();
      if (connectResponse != 200) {
         throw new RuntimeException("HttpResponseCode: " + connectResponse);
      }
      BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
      String rawJson = in.readLine();
      in.close();
      Gson gson = new Gson();

      return gson.fromJson(rawJson, JsonArray.class);
   }

   private String getParamsAsURL(){
      return requestStructure.getURL().toString();
   }
}
