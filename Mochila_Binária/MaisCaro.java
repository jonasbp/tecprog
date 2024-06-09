package br.edu.insper.tecprog;

import java.util.Arrays;

public class MaisCaro implements MochilaBinaria {
	public Solucao resolveMochila(int[] Valor, int[] Peso, int Capacidade) {
		Solucao S = new Solucao(Valor.length);
		// Criando um array para armazenar os índices dos objetos
        Integer[] IDS = new Integer[Valor.length];
        for (int i = 0; i < IDS.length; i++) {
            IDS[i] = i;
        }
		 // Ordenando os índices dos objetos com base no valor, em ordem decrescente
        Arrays.sort(IDS, (a, b) -> Integer.compare(Valor[b], Valor[a]));
		int PesoTotal = 0;
		int ValorTotal = 0;

		for(int i =0;i<Valor.length;i++ ){
			if(Peso[IDS[i]] + PesoTotal <= Capacidade){
				S.objetos[IDS[i]] = true;
				PesoTotal = PesoTotal + Peso[IDS[i]];
				ValorTotal = ValorTotal + Valor[IDS[i]];
			}
		}
		S.valor = ValorTotal;
		S.peso = PesoTotal;
		
		return S;
	}
}
