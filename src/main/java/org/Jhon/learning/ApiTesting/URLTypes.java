package org.Jhon.learning.ApiTesting;

public enum URLTypes {
   DATA_REFERENCIA("ConsultarTabelaDeReferencia?"),
   MARCAS("ConsultarMarcas?"),
   MODELOS("ConsultarModelos?"),
   MODELO_ANO("ConsultarAnoModelo?");
   //CARRO("ConsultarValorComTodosParametros")
   final String value;
   URLTypes(String value) {
      this.value = value;
   }
}
