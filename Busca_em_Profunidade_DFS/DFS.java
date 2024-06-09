package br.edu.insper.tecprog;

import br.edu.insper.tecprog.InsperList;

public class DFS {
    // 0 PASSO: Criar uma lista com os visitados.
    InsperArrayList <Posicao> visitados = new InsperArrayList<>();
    public boolean dfs(Labirinto L, Posicao fonte, Posicao destino, InsperList<Posicao> caminho) {
        // 1 PASSO: Adiciona posição atual no caminho
        caminho.add(fonte);
        // 2 PASSO: VERIFICA SE A FONTE É DESTINO
        if (fonte.equals(destino)){
            visitados = new InsperArrayList<>();
            return true;
        }
        // 3 PASSO: ADICIONA POSIÇÃO ATUAL NOS VISITADOS
        visitados.add(fonte);

        // 4 PASSO: VERIFICA BAIXO,CIMA,ESQUERDA,DIREITA
        // [BAIXO]
        if (fonte.i + 1 < L.getAltura()){
            if(L.ehLivre(fonte.i + 1, fonte.j) && !estaNaLista(visitados, new Posicao(fonte.i + 1,fonte.j))){
                if(dfs(L,new Posicao(fonte.i + 1,fonte.j),destino,caminho)){
                    return true;
                }
            }
        }
        // [CIMA]
        if (fonte.i - 1 >= 0){
            if(L.ehLivre(fonte.i - 1, fonte.j) && !estaNaLista(visitados, new Posicao(fonte.i - 1,fonte.j))){
                if(dfs(L,new Posicao(fonte.i - 1,fonte.j),destino,caminho)){
                    return true;
                }
            }
        }
        // [ESQUERDA]
        if (fonte.j + 1 < L.getLargura()){
            if(L.ehLivre(fonte.i, fonte.j + 1) && !estaNaLista(visitados, new Posicao(fonte.i,fonte.j + 1))){
                if(dfs(L,new Posicao(fonte.i,fonte.j + 1),destino,caminho)){
                    return true;
                }
            }
        }
        // [DIREITA]
        if (fonte.j - 1 >= 0){
            if(L.ehLivre(fonte.i, fonte.j - 1) && !estaNaLista(visitados, new Posicao(fonte.i,fonte.j - 1))){
                if(dfs(L,new Posicao(fonte.i,fonte.j - 1),destino,caminho)){
                    return true;
                }
            }
        }

        caminho.remove(fonte);
        return false;
    }
    private boolean estaNaLista(InsperList<Posicao> lista,Posicao pos){
        for (int i = 0; i < lista.size(); i++) {
            // Verifica se o elemento do indice i é igual a minha posicao
            if (lista.get(i).equals(pos)){
                return true;
            }
        }
        return false;
    }
}
