package org.Jhon.learning.ApiTesting.Structures.Request;

import org.Jhon.learning.ApiTesting.Consultar.ConsultarModelos;
import org.Jhon.learning.ApiTesting.Structures.URLTypes;
import org.Jhon.learning.Models.Modelo;
import org.Jhon.learning.Models.Structure.IModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

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
