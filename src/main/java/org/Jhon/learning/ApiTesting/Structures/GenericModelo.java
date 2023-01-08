package org.Jhon.learning.ApiTesting.Structures;

import org.Jhon.learning.ApiTesting.Structures.GenericMarca;
import org.Jhon.learning.ApiTesting.Structures.Request.ModeloRequest;

public abstract class GenericModelo<T extends ModeloRequest> extends GenericMarca<T> {
   private int marcaID;

   public int getMarcaID() {
      return marcaID;
   }

   public void setMarcaID(int marcaID) {
      this.marcaID = marcaID;
   }

}
