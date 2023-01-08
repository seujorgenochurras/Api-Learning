package org.Jhon.learning.ApiTesting.Structures.Request;

import org.Jhon.learning.ApiTesting.URLTypes;
import org.Jhon.learning.Models.Modelo;
import org.Jhon.learning.Models.Structure.IModel;

public interface ModeloRequest extends MarcasRequest{
   /**
    * @return id da marca
    * */
   int getCodigoMarca();

   @Override
   default StringBuilder getURL() {
      return MarcasRequest.super.getURL().append("&codigoMarca=")
              .append(getCodigoMarca());
   }

   default URLTypes getURLStructure() {
      return URLTypes.MODELOS;
   }

   @Override
   default Class<? extends IModel> getCorrespondentModel(){
      return Modelo.class;
   }
}
