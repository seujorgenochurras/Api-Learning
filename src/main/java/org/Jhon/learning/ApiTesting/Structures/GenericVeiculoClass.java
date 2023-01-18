package org.Jhon.learning.ApiTesting.Structures;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.Jhon.learning.ApiTesting.Structures.Request.VeiculoRequest;
import org.Jhon.learning.Models.Marca;
import org.Jhon.learning.Models.Modelo;
import org.Jhon.learning.Models.ModeloAno;
import org.Jhon.learning.Models.Veiculo;

import java.util.Objects;

public abstract class GenericVeiculoClass<T extends VeiculoRequest> extends GenericModeloAno<T>  {
   private ModeloAno modeloAno;

   public ModeloAno getModeloAno() {
      return modeloAno;
   }
   @Override
   public Modelo getModeloObject(){
      return modeloAno.getModeloObject();
   }

   public void setModeloAno(ModeloAno modeloAno) {
      this.modeloAno = modeloAno;
   }
   @Override
   public Marca getMarcaObject(){
      return getModeloAno().getMarcaObject();
   }
   @Override
   public void toModel(JsonElement jsonElement) {
      if(Objects.isNull(jsonElement)) throw new IllegalStateException("CANNOT SAVE NULL JSON");
      JsonArray jsonArray = new JsonArray();
      jsonArray.add(jsonElement);
      parseToModel(jsonArray, Veiculo.class);
   }

   @Override
   protected void getAdditionalMethods(Object model) {
      Veiculo veiculo = (Veiculo) model;
      veiculo.setModeloAnoObject(getModeloAno());
      veiculo.addToList();
   }
}
