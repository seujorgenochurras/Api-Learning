package org.Jhon.learning.Models;

import java.time.LocalDate;


public class ModeloAno {

   private LocalDate ano;
   private Combustivel combustivel;

   public LocalDate getAno() {
      return ano;
   }

   public void setAno(LocalDate ano) {
      this.ano = ano;
   }

   public Combustivel getCombustivel() {
      return combustivel;
   }

   public void setCombustivel(Combustivel combustivel) {
      this.combustivel = combustivel;
   }
   public ModeloAno(LocalDate ano, Combustivel combustivel){
      this.setAno(ano);
      this.setCombustivel(combustivel);

   }
}
