package org.Jhon.learning.ApiTesting.Structures;

import com.google.gson.JsonElement;
import org.Jhon.learning.ApiTesting.Requester;
import org.Jhon.learning.ApiTesting.Structures.Request.Request;

import java.io.IOException;

public abstract class GenericConsultarClass<T extends Request> {
   protected Requester<T> requester = new Requester<>();
   protected JsonElement response;


   public JsonElement getResponse() throws IOException {
      requester.setRequestStructure(getStructure());
      response = requester.doRequest();
      return requester.doRequest();
   }

  /**
    * This should parse the responses to a model and save them,
    * by lopping throughout the jsonObject(-responses-) and saving each one on the corresponding super list
    * */
  abstract public void toModel();
  abstract public T getStructure();
   }

