package br.edu.insper.tecprog;

import java.util.ArrayList;

public class CaminhoVigiado {
    public static boolean caminhoAteMontanha(Mapa M, Posicao frodo, Posicao montanha, ArrayList<Posicao> caminho) {
        int soma=0; 
        return encontrarSaida(M, frodo, montanha, caminho,soma);
    }
    public static boolean encontrarSaida(Mapa M, Posicao frodo, Posicao montanha,ArrayList<Posicao> caminho,int soma){
        Posicao pos = new Posicao(frodo.i,frodo.j);
        caminho.add(pos);
        if(soma==3){
            caminho.remove(pos);
            return false;
        }
        if(frodo.equals(montanha)){
            return true;
        }
        // 4 PASSO: VERIFICA BAIXO,CIMA,ESQUERDA,DIREITA
        // [BAIXO]
        if (pos.i + 1 < M.getAltura()){
            if(M.ehLivre(pos.i + 1, pos.j) && !estaNaLista(caminho, new Posicao(pos.i + 1,pos.j))){
                if(M.ehVigiada(pos.i + 1, pos.j)){
                    if(encontrarSaida(M,new Posicao(pos.i + 1,pos.j),montanha,caminho,soma+1)){
                        return true;
                    } 
                }
                else{
                    if(encontrarSaida(M,new Posicao(pos.i + 1,pos.j),montanha,caminho,0)){
                        return true;
                    } 
                }
            }
        }
        // [CIMA]
        if (pos.i - 1 >= 0){
            if(M.ehLivre(pos.i - 1, pos.j) && !estaNaLista(caminho, new Posicao(pos.i - 1,pos.j))){
                if(M.ehVigiada(pos.i - 1, pos.j)){
                    if(encontrarSaida(M,new Posicao(pos.i - 1,pos.j),montanha,caminho,soma+1)){
                        return true;
                    } 
                }
                else{
                    if(encontrarSaida(M,new Posicao(pos.i - 1,pos.j),montanha,caminho,0)){
                        return true;
                    } 
                }
            }
        }
        // [ESQUERDA]
        if (pos.j + 1 < M.getLargura()){
            if(M.ehLivre(pos.i, pos.j + 1) && !estaNaLista(caminho, new Posicao(pos.i,pos.j + 1))){
                if(M.ehVigiada(pos.i, pos.j + 1)){
                    if(encontrarSaida(M,new Posicao(pos.i,pos.j + 1),montanha,caminho,soma+1)){
                        return true;
                    } 
                }
                else{
                    if(encontrarSaida(M,new Posicao(pos.i,pos.j + 1),montanha,caminho,0)){
                        return true;
                    } 
                }
            }
        }
        // [DIREITA]
        if (pos.j - 1 >= 0){
            if(M.ehLivre(pos.i, pos.j - 1) && !estaNaLista(caminho, new Posicao(pos.i,pos.j - 1))){
                if(M.ehVigiada(pos.i, pos.j - 1)){
                    if(encontrarSaida(M,new Posicao(pos.i,pos.j - 1),montanha,caminho,soma+1)){
                        return true;
                    } 
                }
                else{
                    if(encontrarSaida(M,new Posicao(pos.i,pos.j - 1),montanha,caminho,0)){
                        return true;
                    } 
                }
            }
        }
        caminho.remove(pos);
        return false;
    }
    private static boolean estaNaLista(ArrayList<Posicao> visitados,Posicao pos){
        for (int i = 0; i < visitados.size(); i++) {
            // Verifica se o elemento do indice i é igual a minha posicao
            if (visitados.get(i).equals(pos)){
                return true;
            }
        }
        return false;
    }
}
