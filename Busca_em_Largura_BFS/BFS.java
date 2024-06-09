package br.edu.insper.tecprog;

import br.edu.insper.tecprog.InsperList;

public class BFS {

    public boolean bfs(Labirinto L, Posicao fonte, Posicao destino, InsperList<Posicao> caminho) {
        int[][] distancia = new int[L.getAltura()][L.getLargura()]; // Matriz para fazer as corezinhas :)
        Fila<Posicao> fila = new Fila<>(); // Fila para ir preenchendo a matriz
        Posicao posicao_inicial = fonte; // Pega a posição e coloca na posição inicial
        InsperList<Posicao> caminho_ajuda = new InsperArrayList<>();

        // Arruma matriz/mapa para ficar certinho :) - distancia
        for (int i = 0;i < L.getAltura();i++){
            for(int j = 0;j < L.getLargura(); j++){
                if (L.ehLivre(i, j) == false){
                    distancia[i][j] = -10; // Caso não seja livre :(
                } else {
                    distancia[i][j] = -1; // Caso seja livre :)
                }
            }
        }
        fila.addLast(fonte); // Coloquei a posição inicial na fila

        distancia[fonte.i][fonte.j] = 0; // Ponto incial

        // Enquanto a fila não estiver vazia ou seja ou ainda tem mais para espalhar ou ainda não chegou no destino.
        while(!fila.empty()){
            fonte = fila.removeFirst(); // Remove o primeiro e este é o que vamos analisar a baixo.
            if (fonte.equals(destino)){
                // Opa chegou ao destino :) / Podemos parar de procurar o destino
                break;
            }

            // Vamos pensar nos vizinhos para pintar todas as cores. (Para cada vizinho não visitado faça:)
            // Se eu puder ir para baixo e mesmo assim não acabar o labirinto
            // [FAZENDO PARA I]
            if(fonte.i + 1 < L.getAltura()){
                // Ver se ele não foi visitado :) (QUE É -1)
                if (distancia[fonte.i + 1][fonte.j] == -1){
                    // Posicão vai receber o vizinho + 1
                    distancia[fonte.i + 1][fonte.j] = distancia[fonte.i][fonte.j] + 1;
                    // Adiciona vizinho na fila
                    Posicao vizinho = new Posicao(fonte.i + 1, fonte.j);
                    fila.addLast(vizinho);
                }
            }
            if(fonte.i - 1 >= 0){
                // Ver se ele não foi visitado :) (QUE É -1)
                if (distancia[fonte.i - 1][fonte.j] == -1){
                    // Posicão vai receber o vizinho + 1
                    distancia[fonte.i - 1][fonte.j] = distancia[fonte.i][fonte.j] + 1;
                    // Adiciona vizinho na fila
                    Posicao vizinho = new Posicao(fonte.i - 1, fonte.j);
                    fila.addLast(vizinho);
                }

            }
            // [FAZENDO PARA J]
            if(fonte.j + 1 < L.getLargura()){
                // Ver se ele não foi visitado :) (QUE É -1)
                if (distancia[fonte.i][fonte.j + 1] == -1){
                    // Posicão vai receber o vizinho + 1
                    distancia[fonte.i][fonte.j + 1] = distancia[fonte.i][fonte.j] + 1;
                    // Adiciona vizinho na fila
                    Posicao vizinho = new Posicao(fonte.i, fonte.j + 1);
                    fila.addLast(vizinho);
                }
            }
            if(fonte.j - 1 >= 0){
                // Ver se ele não foi visitado :) (QUE É -1)
                if (distancia[fonte.i][fonte.j - 1] == -1){
                    // Posicão vai receber o vizinho + 1
                    distancia[fonte.i][fonte.j - 1] = distancia[fonte.i][fonte.j] + 1;
                    // Adiciona vizinho na fila
                    Posicao vizinho = new Posicao(fonte.i, fonte.j - 1);
                    fila.addLast(vizinho);
                }

            }
        }
        // Caso tenha achado o destino. (Agora vamos fazer a volta de trás para a frente para achar o caminho.)
        if (fonte.equals(destino)){
            // Adicionou a ultima posição
            caminho_ajuda.add(fonte);

            // Enquanto a posição inicial for diferente da posição atual
            while(!posicao_inicial.equals(fonte)){
                if(fonte.i + 1 < L.getAltura()){
                    // Verifica se o vizinho é 1 menor que o atual
                    if (distancia[fonte.i + 1][fonte.j] == distancia[fonte.i][fonte.j] - 1){
                        fonte = new Posicao(fonte.i + 1, fonte.j);
                        caminho_ajuda.add(fonte);
                    }
                }

                if(fonte.i - 1 >= 0){
                    // Verifica se o vizinho é 1 menor que o atual
                    if (distancia[fonte.i - 1][fonte.j] == distancia[fonte.i][fonte.j] - 1){
                        fonte = new Posicao(fonte.i - 1, fonte.j);
                        caminho_ajuda.add(fonte);
                    }
                }

                if(fonte.j + 1 < L.getLargura()){
                    // Verifica se o vizinho é 1 menor que o atual
                    if (distancia[fonte.i][fonte.j + 1] == distancia[fonte.i][fonte.j] - 1){
                        fonte = new Posicao(fonte.i, fonte.j + 1);
                        caminho_ajuda.add(fonte);
                    }
                }

                if(fonte.j - 1 >= 0){
                    // Verifica se o vizinho é 1 menor que o atual
                    if (distancia[fonte.i][fonte.j-1] == distancia[fonte.i][fonte.j] - 1){
                        fonte = new Posicao(fonte.i, fonte.j - 1);
                        caminho_ajuda.add(fonte);
                    }
                }

            }
            // Se chegar aqui é pq chegou no final e é igual ao destino. (Vamos desinverter)
            for (int i = caminho_ajuda.size() - 1; i >= 0; i--) {
                caminho.add(caminho_ajuda.get(i));
            }
            return true;
        }
        return false;

    }
    
}
