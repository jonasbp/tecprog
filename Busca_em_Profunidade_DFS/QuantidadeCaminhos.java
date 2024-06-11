package br.edu.insper.tecprog;

import java.util.ArrayList;

public class Caminhos {
    private static int conta=0;
    public static int numCaminhos(String labirinto, Posicao inicial) {
        Labirinto lab= new Labirinto(labirinto);
        ArrayList<Posicao> caminho = new ArrayList<Posicao>();
        conta=0;
        encontrarSaida(lab, inicial, caminho);
        return conta;
    }

    private static boolean encontrarSaida(Labirinto labirinto, Posicao posAtual, ArrayList<Posicao> caminho) {
        Posicao pos = new Posicao(posAtual.i, posAtual.j);
        caminho.add(pos);
        // Poderia ter uma restrição aqui

        // Caso termine
        if(labirinto.ehSaida(pos.i, pos.j)){
            caminho.remove(pos);
            conta = conta+1;
            return false;
        }
        // Vizinhos
        
        if(labirinto.ehLivre(pos.i+1,pos.j) && !foiVisitado(new Posicao(pos.i+1,pos.j), caminho)){
            if(encontrarSaida(labirinto,new Posicao(pos.i+1,pos.j), caminho)){
                return true; 
            }
            
        }
        if(labirinto.ehLivre(pos.i-1,pos.j) && !foiVisitado(new Posicao(pos.i-1,pos.j), caminho)){
            if(encontrarSaida(labirinto,new Posicao(pos.i-1,pos.j), caminho)){
                return true; 
            }
           
        }
        if(labirinto.ehLivre(pos.i,pos.j-1) && !foiVisitado(new Posicao(pos.i,pos.j-1), caminho)){

            if(encontrarSaida(labirinto,new Posicao(pos.i,pos.j-1), caminho)){
                return true; 
            }

        }
        if(labirinto.ehLivre(pos.i,pos.j+1) && !foiVisitado(new Posicao(pos.i,pos.j+1), caminho)){
            if(encontrarSaida(labirinto,new Posicao(pos.i,pos.j+1), caminho)){
                return true; 
            }
            
        }
        caminho.remove(pos);
        return false;
    }
    private static boolean foiVisitado(Posicao pos,ArrayList<Posicao> vistitado ){
        for (int i =0 ; i< vistitado.size(); i++){
            if (pos.equals(vistitado.get(i))){
                return true;
            }
        }
        return false;
    }
    

   
}