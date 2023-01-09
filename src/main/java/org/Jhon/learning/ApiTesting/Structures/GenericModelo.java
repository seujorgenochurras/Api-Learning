package org.Jhon.learning.ApiTesting.Structures;

import org.Jhon.learning.ApiTesting.Consultar.ConsultarMarcas;
import org.Jhon.learning.ApiTesting.Structures.Request.ModeloRequest;
import org.Jhon.learning.Models.Marca;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

public abstract class GenericModelo<T extends ModeloRequest> extends GenericMarca<T> {
   private int marcaID;

   public int getMarcaID() {
      return marcaID;
   }
   public void setMarcaID(int marcaID) {
      this.marcaID = marcaID;
   }
}
