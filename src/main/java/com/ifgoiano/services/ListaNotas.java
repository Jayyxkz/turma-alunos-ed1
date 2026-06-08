package com.ifgoiano.services;

import com.ifgoiano.models.Aluno;

import java.util.ArrayList;
import java.util.List;

public class ListaNotas {

    private static class Nodo {
        Aluno aluno;
        float nota;
        Nodo prox;

        public Nodo(Aluno aluno, float nota) {
            this.aluno = aluno;
            this.nota = nota;
        }
    }

    private Nodo head;
    private Nodo ultimo;

    public ListaNotas() {
        head = new Nodo(null, 0.0f);
        ultimo = head;
    }

    public void insercaoEmOrdem(Aluno aluno, float nota) {
        Nodo novo = new Nodo(aluno, nota);
        Nodo aux = this.head;

        while (aux.prox != null && aux.prox.nota >= nota) {
            aux = aux.prox;
        }

        novo.prox = aux.prox;
        aux.prox = novo;

        if (novo.prox == null) {
            this.ultimo = novo;
        }
    }

    public void remocaoPorMatricula(String matricula) {
        Nodo aux  = this.head;

        while (aux.prox != null && !aux.prox.aluno.getMatricula().equals(matricula)) {
            aux = aux.prox;
        }

        if (aux.prox == null) {
            return;
        }

        Nodo q = aux.prox;
        aux.prox = q.prox;

        if (aux.prox == null) {
            this.ultimo = aux;
        }
    }

    public Aluno buscaPorNota(float nota) {
        Nodo aux = this.head.prox;

        while (aux != null) {
            if (aux.nota == nota) {
                return aux.aluno;
            }
            aux = aux.prox;
        }
        return null;
    }

    public Aluno buscaPorMatricula(String matricula) {
        Nodo aux = this.head.prox;

        while (aux != null) {
            if (aux.aluno.getMatricula().equals(matricula)) {
                return aux.aluno;
            }
            aux = aux.prox;
        }
        return null;
    }

    public List<Aluno> buscaPorCidade(String cidade) {
        Nodo aux = this.head.prox;
        List<Aluno> lista = new ArrayList<>();

        while (aux != null) {
            if (aux.aluno.getEndereco().equals(cidade)) {
                lista.add(aux.aluno);
            }
            aux = aux.prox;
        }

        if (lista.isEmpty()) {
            return null;
        }
        else {
            return lista;
        }
    }

    public int tamanho() {
        Nodo aux = this.head;
        int tamanho = 0;

        while (aux.prox != null) {
            tamanho++;
            aux = aux.prox;
        }
        return tamanho;
    }
}
