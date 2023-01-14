package org.Jhon.learning.ApiTesting;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.Jhon.learning.ApiTesting.Structures.Request.Request;
import org.Jhon.learning.ApiTesting.Structures.URLTypes;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public final class Requester<T extends Request> {
   private T requestStructure;

   public T getRequestStructure() {
      return requestStructure;
   }

   public void setRequestStructure(@NotNull T requestStructure) {
      this.requestStructure = requestStructure;
   }

   public Requester(T requestStructure){
      setRequestStructure(requestStructure);
   }
   public Requester(){}


   public JsonElement doRequest() throws IOException {
      HttpURLConnection httpURLConnection;
      try {
       httpURLConnection = connection();

      }catch (IOException e){
          httpURLConnection = connection();
      }


      int connectResponse =  httpURLConnection.getResponseCode();
      //The API may respond with one of those errors, it is quite common
      if (connectResponse != 200) {
         throw new RuntimeException("HttpResponseCode: " + connectResponse);
      }
      BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
      String rawJson = in.readLine();
      in.close();
      Gson gson = new Gson();

      return gson.fromJson(rawJson, JsonElement.class);
   }

   /**
    * Tries the connection
    * */
   private HttpURLConnection connection() throws IOException {
      URLTypes requestName = requestStructure.getURLStructure();
      URL url = new URL("https://veiculos.fipe.org.br/api/veiculos//" + requestName.value);
      HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

      urlConnection.setRequestMethod(requestName.requestsType.toString());
      urlConnection.setDoOutput(true);
      urlConnection.getOutputStream().write(getParamsAsURL().getBytes());
      return urlConnection;
   }


   private String getParamsAsURL(){
      return requestStructure.getURL().toString();
   }
}
