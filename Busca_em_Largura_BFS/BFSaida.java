package br.edu.insper.tecprog;

import br.edu.insper.tecprog.InsperList;

public class BFSSaida implements EncontrarSaida {
    
    @Override
    public boolean encontrarSaida(Labirinto L, int i, int j, InsperList<Posicao> caminho) {
        int[][] distancia = new int[L.getAltura()][L.getLargura()]; // Matriz para fazer as corezinhas :)
        InsperArrayList<Posicao> fila = new InsperArrayList<>();; // Fila para ir preenchendo a matriz
        Posicao posicao_inicial = new Posicao(i, j); // Pega a posição e coloca na posição inicial
        Posicao pos = new Posicao(i, j);
        InsperList<Posicao> caminho_ajuda = new InsperArrayList<>();

        // Arruma matriz/mapa para ficar certinho :) - distancia
        for (int k = 0;k < L.getAltura();k++){
            for(int l = 0;l < L.getLargura(); l++){
                if (L.ehLivre(k, l) == false){
                    distancia[k][l] = -10; // Caso não seja livre :(
                } else {
                    distancia[k][l] = -1; // Caso seja livre :)
                }
            }
        }
        fila.addLast(posicao_inicial); // Coloquei a posição inicial na fila

        distancia[posicao_inicial.i][posicao_inicial.j] = 0; // Ponto incial

        // Enquanto a fila não estiver vazia ou seja ou ainda tem mais para espalhar ou ainda não chegou no destino.
        while(!fila.empty()){
            pos = fila.removeFirst(); // Remove o primeiro e este é o que vamos analisar a baixo.
            if (L.ehSaida(pos.i,pos.j)){
                // Opa chegou ao destino :) / Podemos parar de procurar o destino
                break;
            }

            // Vamos pensar nos vizinhos para pintar todas as cores. (Para cada vizinho não visitado faça:)
            // Se eu puder ir para baixo e mesmo assim não acabar o labirinto
            // [FAZENDO PARA I]
            if(pos.i + 1 < L.getAltura()){
                // Ver se ele não foi visitado :) (QUE É -1)
                if (distancia[pos.i + 1][pos.j] == -1){
                    // Posicão vai receber o vizinho + 1
                    distancia[pos.i + 1][pos.j] = distancia[pos.i][pos.j] + 1;
                    // Adiciona vizinho na fila
                    Posicao vizinho = new Posicao(pos.i + 1, pos.j);
                    fila.addLast(vizinho);
                }
            }
            if(pos.i - 1 >= 0){
                // Ver se ele não foi visitado :) (QUE É -1)
                if (distancia[pos.i - 1][pos.j] == -1){
                    // Posicão vai receber o vizinho + 1
                    distancia[pos.i - 1][pos.j] = distancia[pos.i][pos.j] + 1;
                    // Adiciona vizinho na fila
                    Posicao vizinho = new Posicao(pos.i - 1, pos.j);
                    fila.addLast(vizinho);
                }

            }
            // [FAZENDO PARA J]
            if(pos.j + 1 < L.getLargura()){
                // Ver se ele não foi visitado :) (QUE É -1)
                if (distancia[pos.i][pos.j + 1] == -1){
                    // Posicão vai receber o vizinho + 1
                    distancia[pos.i][pos.j + 1] = distancia[pos.i][pos.j] + 1;
                    // Adiciona vizinho na fila
                    Posicao vizinho = new Posicao(pos.i, pos.j + 1);
                    fila.addLast(vizinho);
                }
            }
            if(pos.j - 1 >= 0){
                // Ver se ele não foi visitado :) (QUE É -1)
                if (distancia[pos.i][pos.j - 1] == -1){
                    // Posicão vai receber o vizinho + 1
                    distancia[pos.i][pos.j - 1] = distancia[pos.i][pos.j] + 1;
                    // Adiciona vizinho na fila
                    Posicao vizinho = new Posicao(pos.i, pos.j - 1);
                    fila.addLast(vizinho);
                }

            }
        }
        // Caso tenha achado o destino. (Agora vamos fazer a volta de trás para a frente para achar o caminho.)
        if (L.ehSaida(pos.i, pos.j)){
            // Adicionou a ultima posição
            caminho_ajuda.add(pos);

            // Enquanto a posição inicial for diferente da posição atual
            while(!posicao_inicial.equals(pos)){
                boolean adicionou = false;

                if(pos.i + 1 < L.getAltura()){
                    // Verifica se o vizinho é 1 menor que o atual
                    if (distancia[pos.i + 1][pos.j] == distancia[pos.i][pos.j] - 1 && adicionou == false){
                        pos = new Posicao(pos.i + 1, pos.j);
                        caminho_ajuda.add(pos);
                        adicionou = true;
                    }
                }

                if(pos.i - 1 >= 0){
                    // Verifica se o vizinho é 1 menor que o atual
                    if (distancia[pos.i - 1][pos.j] == distancia[pos.i][pos.j] - 1 && adicionou == false){
                        pos = new Posicao(pos.i - 1, pos.j);
                        caminho_ajuda.add(pos);
                        adicionou = true;
                    }
                }

                if(pos.j + 1 < L.getLargura()){
                    // Verifica se o vizinho é 1 menor que o atual
                    if (distancia[pos.i][pos.j + 1] == distancia[pos.i][pos.j] - 1 && adicionou == false){
                        pos = new Posicao(pos.i, pos.j + 1);
                        caminho_ajuda.add(pos);
                        adicionou = true;
                    }
                }

                if(pos.j - 1 >= 0){
                    // Verifica se o vizinho é 1 menor que o atual
                    if (distancia[pos.i][pos.j-1] == distancia[pos.i][pos.j] - 1 && adicionou == false){
                        pos = new Posicao(pos.i, pos.j - 1);
                        caminho_ajuda.add(pos);
                        adicionou = true;
                    }
                }

            }
            // Se chegar aqui é pq chegou no final e é igual ao destino. (Vamos desinverter)
            for (int k = caminho_ajuda.size() - 1; k >= 0; k--) {
                caminho.add(caminho_ajuda.get(k));
            }
            return true;
        }
        return false;
    }
    
}
