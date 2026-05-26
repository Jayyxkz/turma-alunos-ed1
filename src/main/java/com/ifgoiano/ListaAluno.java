package com.ifgoiano;

public class ListaAluno {
    private Nodo head;
    private Nodo tail;

    public ListaAluno() {
        this.head = null;
        this.tail = this.head;
    }

    public void insercaoEmOrdem(Aluno aluno, double nota) {
        Nodo novo = new Nodo(aluno.getMatricula(), nota);

        if (this.head == null) {
            this.head = novo;
            this.tail = this.head;
        }
        else {

        }
    }

    public void remocaoPorMatricula(Aluno aluno) {
        Nodo aux  = this.head;

        if (aux == null) {
            return;
        }
        else if (aux.matricula.equals(aluno.getMatricula())) {
            this.head = aux.prox;
            if (this.head == null) {
                this.tail = null;
            }
            return;
        }

        while (aux.prox != null ) {
            if (aux.prox.matricula.equals(aluno.getMatricula())) {
                
                return;
            }
            aux = aux.prox;
        }
    }
}
