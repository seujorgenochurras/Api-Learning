package org.Jhon.learning.ApiTesting.Structures.Request;

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

}
