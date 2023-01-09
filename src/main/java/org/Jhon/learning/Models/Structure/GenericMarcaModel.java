package org.Jhon.learning.Models.Structure;

import org.Jhon.learning.Models.Marca;

public abstract class GenericMarcaModel extends GenericAPIRequester<Marca> {
   private int veiculoID;

   private int marcaID;

   private int tabelaReferencialID;

   public int getTabelaReferencialID() {
      return tabelaReferencialID;
   }

   public void setTabelaReferencialID(int tabelaReferencialID) {
      this.tabelaReferencialID = tabelaReferencialID;
   }

   public int getVeiculoID() {
      return veiculoID;
   }

   public void setVeiculoID(int veiculoID) {
      this.veiculoID = veiculoID;
   }

   public int getMarcaID() {
      return marcaID;
   }

   public void setMarcaID(int marcaID) {
      this.marcaID = marcaID;
   }
}
