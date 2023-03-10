package org.Jhon.learning.ApiTesting.Structures;

public enum URLTypes {
   DATA_REFERENCIA("ConsultarTabelaDeReferencia?", URLRequests.POST),
   MARCAS("ConsultarMarcas?", URLRequests.POST),
   MODELOS("ConsultarModelos?", URLRequests.POST),
   MODELO_ANO("ConsultarAnoModelo?", URLRequests.POST),
   CARRO("ConsultarValorComTodosParametros", URLRequests.POST),
   MODELO_ATRAVES_ANO("ConsultarModelosAtravesDoAno", URLRequests.POST);
  public final String value;
  public final URLRequests requestsType;
   URLTypes(String value, URLRequests urlRequests) {
      this.value = value;
      this.requestsType = urlRequests;
   }
}
