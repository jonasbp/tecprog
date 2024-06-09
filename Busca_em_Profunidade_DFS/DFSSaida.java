package br.edu.insper.tecprog;

import br.edu.insper.tecprog.InsperList;

public class DFSSaida implements EncontrarSaida {
    InsperArrayList <Posicao> visitados = new InsperArrayList<>();

    @Override
    public boolean encontrarSaida(Labirinto L, int i, int j, InsperList<Posicao> caminho) {
        // AJUSTES PARA SAIDA:
        // CRIA POSIÇÃO DA FONTE,DESTINO VIRA L.EH SAIDA,RECURSÃO NO ENCONTRARSAIDA,NÃO CRIA NOVA POSICAO SÓ O VALOR,Não usa destino na recursão.
        // CRIA POSIÇÃO
        Posicao fonte = new Posicao(i,j);
        // 1 PASSO: Adiciona posição atual no caminho
        caminho.add(fonte);
        // 2 PASSO: VERIFICA SE A FONTE É DESTINO
        // DESTINO VIRA L.EHSAIDA(I,J) E TIRA O EQUALS
        if (L.ehSaida(fonte.i, fonte.j)){
            visitados = new InsperArrayList<>();
            return true;
        }
        // 3 PASSO: ADICIONA POSIÇÃO ATUAL NOS VISITADOS
        visitados.add(fonte);

        // 4 PASSO: VERIFICA BAIXO,CIMA,ESQUERDA,DIREITA
        // [BAIXO]
        if (fonte.i + 1 < L.getAltura()){
            if(L.ehLivre(fonte.i + 1, fonte.j) && !estaNaLista(visitados, new Posicao(fonte.i + 1,fonte.j))){
                if(encontrarSaida(L,fonte.i + 1,fonte.j,caminho)){
                    return true;
                }
            }
        }
        // [CIMA]
        if (fonte.i - 1 >= 0){
            if(L.ehLivre(fonte.i - 1, fonte.j) && !estaNaLista(visitados, new Posicao(fonte.i - 1,fonte.j))){
                if(encontrarSaida(L,fonte.i - 1,fonte.j,caminho)){
                    return true;
                }
            }
        }
        // [ESQUERDA]
        if (fonte.j + 1 < L.getLargura()){
            if(L.ehLivre(fonte.i, fonte.j + 1) && !estaNaLista(visitados, new Posicao(fonte.i,fonte.j + 1))){
                if(encontrarSaida(L,fonte.i,fonte.j + 1,caminho)){
                    return true;
                }
            }
        }
        // [DIREITA]
        if (fonte.j - 1 >= 0){
            if(L.ehLivre(fonte.i, fonte.j - 1) && !estaNaLista(visitados, new Posicao(fonte.i,fonte.j - 1))){
                if(encontrarSaida(L,fonte.i,fonte.j - 1,caminho)){
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
