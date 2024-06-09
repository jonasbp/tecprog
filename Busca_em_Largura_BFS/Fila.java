package br.edu.insper.tecprog;

import br.edu.insper.tecprog.InsperArrayList;

public class Fila<T extends Comparable<T>> {
    private InsperArrayList<T> data;

    Fila() {
        data = new InsperArrayList<>();
    }

    public void addLast(T V) {
        data.add(V);
    }

    public T removeFirst() {
        T primeiro_elemento = data.get(0);
        data.remove(0);
        return primeiro_elemento;
    
    }

    public boolean empty() {
        if (data.size() == 0){
            return true;
        }
        else {
            return false;
        }
    }
}
