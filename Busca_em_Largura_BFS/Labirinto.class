// Source code is decompiled from a .class file using FernFlower decompiler.
package br.edu.insper.tecprog;

public class Labirinto {
   private boolean[][] casas;
   private int H;
   private int W;

   public Labirinto(String var1) {
      String[] var2 = var1.split("\n");
      this.H = var2.length;
      this.W = var2[0].length();
      this.casas = new boolean[this.H][this.W];

      for(int var3 = 0; var3 < this.H; ++var3) {
         for(int var4 = 0; var4 < this.W; ++var4) {
            if (var2[var3].charAt(var4) == '.') {
               this.casas[var3][var4] = true;
            }
         }
      }

   }

   public boolean ehLivre(int var1, int var2) {
      return this.casas[var1][var2];
   }

   public boolean ehSaida(int var1, int var2) {
      return var1 != 0 && var1 != this.H - 1 && var2 != 0 && var2 != this.W - 1 ? false : this.ehLivre(var1, var2);
   }

   public int getLargura() {
      return this.W;
   }

   public int getAltura() {
      return this.H;
   }
}
