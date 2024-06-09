package br.edu.insper.tecprog;
import java.util.Arrays;
import java.util.Comparator;

public class MaisLeve implements MochilaBinaria {
	public Solucao resolveMochila(int[] Valor, int[] Peso, int Capacidade) {
		Solucao S = new Solucao(Valor.length);
        // Criando um array de índices para os objetos
        Integer[] indices = new Integer[Valor.length];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }

        // Ordenando os índices com base no peso em ordem crescente
        Arrays.sort(indices, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return Integer.compare(Peso[a], Peso[b]);
            }
        });

		int PesoTotal = 0;
		int ValorTotal = 0;

		for(int i =0;i<Valor.length;i++ ){
			int index = indices[i];
			if(Peso[index] + PesoTotal <= Capacidade){
				S.objetos[index] = true;
				PesoTotal = PesoTotal + Peso[index];
				ValorTotal = ValorTotal + Valor[index];
			}
		}
		S.valor = ValorTotal;
		S.peso = PesoTotal;
		
		return S;
	}
}
