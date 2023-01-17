package org.Jhon.learning.ApiTesting.Structures;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.Jhon.learning.ApiTesting.Requester;
import org.Jhon.learning.ApiTesting.Structures.Request.Request;
import org.Jhon.learning.ApiTesting.GenericAPIModel;
import org.Jhon.learning.Models.Structure.IModel;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public abstract class GenericConsultarClass<T extends Request> {
   protected Requester<T> requester = new Requester<>();
   public JsonElement getResponse() throws IOException, InterruptedException {
      requester.setRequestStructure(getStructure());
      return requester.doRequest();
   }


   /**
    * Creates a {@code model} based on the json values.
    * <b>attention</b> json field name is very important, it should <br>
    * match with the exact name of the setters in the model class
    * Example: if you json array is [{"Label" : "Jhon Doe"}, {"Label" : "Jane Doe"}]
    * then the model should have a method named setLabel(){}.
    *
    * @param jsonArray raw json array of the response
    * @param classModel class of the model that you want to parse the json to
    * */
   protected void parseToModel(JsonArray jsonArray, Class<? extends GenericAPIModel<? extends IModel>> classModel){
      if(Objects.isNull(jsonArray)) throw new IllegalStateException("JSON CANNOT BE NULL");
      //Getting all json elements
      jsonArray.forEach(item ->{
         try {
            //Creating a model
            GenericAPIModel<?> model = classModel.getDeclaredConstructor().newInstance();
            for(Method method : model.getClass().getMethods()){
               if(method.getName().startsWith("set")){
               //Getting all the fields that correspond to the JsonArray fields
                  String fieldName = method.getName().substring(3);
                  JsonElement fieldValue = item.getAsJsonObject().get(fieldName);
                  if(fieldValue != null){
                     //this is for checking if the method is the exact type it should be
                     String fieldType = fieldValue.getClass().getTypeName();
                     String methodType = method.getParameterTypes()[0].getTypeName();
                     if(methodType.equals(fieldType)){
                        //Adding fieldValue to the method -just like a setName("Jhon");-
                        method.invoke(model, fieldValue);
                     }
                  }
               }
            }
               getAdditionalMethods(model);
         } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
         }
      });

   }
  /**
    * This should parse the responses to a model and save them,
    * by lopping throughout the jsonObject(-responses-) and saving each one on the corresponding super list
    * */
  abstract public void toModel(JsonElement jsonElement);

  /**
   * Structure of the post params
   * */
  abstract protected T getStructure();

  /**
   * This should have all the additional methods that your model has.
   * Obviously all the methods here will be kinda static among all the jsons that comes from its instance.
   * @param model {@code model} instance of the model that will be changed
   * */
   abstract protected void getAdditionalMethods(Object model);
   }

