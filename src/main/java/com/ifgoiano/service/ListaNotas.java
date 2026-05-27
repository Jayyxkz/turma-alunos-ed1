package com.ifgoiano.service;

import com.ifgoiano.models.Aluno;

public class ListaNotas {
    private Nodo head;
    private Nodo tail;

    public ListaNotas() {
        this.head = null;
        this.tail = this.head;
    }

    public void insercaoEmOrdem(Aluno aluno, double nota) {
        Nodo novo = new Nodo(aluno, nota);

        if (this.head == null) {
            this.head = novo;
            this.tail = this.head;
        }
        else {

        }
    }

    public void remocaoPorMatricula(Aluno aluno) {
        Nodo aux  = this.head;
        String target = aluno.getMatricula();

        if (aux == null) {
            return;
        }
        else if (aux.aluno.getMatricula().equals(target)) {
            this.head = aux.prox;
            if (this.head == null) {
                this.tail = null;
            }
            return;
        }
    }

    public Aluno buscaPorNota(double nota) {
        Nodo aux = this.head;

        while(aux.prox != null) {
            if (aux.nota == nota) {
                return aux.aluno;
            }
            aux = aux.prox;
        }
        System.out.println("Aluno não encontrado!");
        return null;
    }

    public Aluno buscaPorMatricula(Aluno aluno) {
        Nodo aux = this.head;
        String target = aluno.getMatricula();

        while (aux.prox != null) {
            if (aux.aluno.getMatricula().equals(target)) {
                return aux.aluno;
            }
            aux = aux.prox;
        }
        System.out.println("Aluno não encontrado!");
        return null;
    }

    public Aluno buscaPorCidade(Aluno aluno) {
        Nodo aux = this.head;
        String target = aluno.getEndereco();

        while (aux.prox != null) {
            if (aux.aluno.getEndereco().equals(target)) {
                return aux.aluno;
            }
            aux = aux.prox;
        }
        System.out.println("Aluno não encontrado!");
        return null;
    }
}
