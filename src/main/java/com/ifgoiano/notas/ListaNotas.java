package com.ifgoiano.notas;

import com.ifgoiano.models.Aluno;

public class ListaNotas {
    private NodoNotas head;
    private NodoNotas tail;

    public ListaNotas() {
        this.head = null;
        this.tail = this.head;
    }

    public void insercaoEmOrdem(String matricula, double nota) {
        NodoNotas novo = new NodoNotas(matricula, nota);

        if (this.head == null) {
            this.head = novo;
            this.tail = this.head;
        }
        else {

        }
    }

    public void remocaoPorMatricula(String matricula) {
        NodoNotas aux  = this.head;

        if (aux == null) {
            return;
        }
        else if (aux.matricula.equals(matricula)) {
            this.head = aux.prox;
            if (this.head == null) {
                this.tail = null;
            }
            return;
        }
    }

    public void buscaPorMatricula(String matricula, ListaNotas alunos) {
        NodoNotas aux  = this.head;

        while (aux.prox != null ) {
            if (aux.matricula.equals(matricula)) {

            }
            aux = aux.prox;
        }
    }
}
