package org.Jhon.learning.Models.Structure;

import com.google.gson.JsonPrimitive;
import org.Jhon.learning.ApiTesting.GenericAPIModel;
import org.Jhon.learning.Models.Marca;

public abstract class GenericMarcaModel extends GenericAPIModel<Marca> {
   private int veiculoID;

   private int tabelaReferencialID;

   public int getTabelaReferencialID() {
      return tabelaReferencialID;
   }

   public void setTabelaReferencialID(JsonPrimitive tabelaReferencialID) {
      this.tabelaReferencialID = tabelaReferencialID.getAsByte();
   }
   public void setTabelaReferencialID(int tabelaReferencialID) {
      this.tabelaReferencialID = tabelaReferencialID;
   }
   public void setVeiculoID(int veiculoID) {
      this.veiculoID = veiculoID;
   }
   public int getVeiculoID() {
      return veiculoID;
   }
   public void setVeiculoID(JsonPrimitive veiculoID) {
      this.veiculoID = veiculoID.getAsByte();
   }
   public void setVeiculoID(byte veiculoID) {
      this.veiculoID = veiculoID;
   }

}
