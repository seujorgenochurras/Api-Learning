package org.Jhon.learning.ApiTesting.Structures.Request;

public interface AnoModeloRequest extends ModeloRequest {
   /**
    * @return id do modelo
    * */
   int getCodigoModelo();

   @Override
   default StringBuilder getURL() {
      return ModeloRequest.super.getURL()
              .append("&codigoModelo=").append(getCodigoModelo());
   }
   /*
      urlBuilder.append("&codigoModelo=").append(structure.getCodigoModelo());
      urlBuilder.append("&codigoMarca=").append(structure.getCodigoMarca());
      urlBuilder.append("&ano=").append(structure.getAno());
      urlBuilder.append("&codigoTipoCombustivel=").append(structure.getCodigoTipoCombustivel());
      urlBuilder.append("&anoModelo=").append(structure.getAnoModelo());
      urlBuilder.append("&modeloCodigoExterno=").append(structure.getModeloCodigoExterno());*/
}