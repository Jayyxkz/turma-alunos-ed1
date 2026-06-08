package com.ifgoiano.services;

import com.ifgoiano.models.Aluno;

/**
 * @author Flávio Diniz de Sousa
 * @author Jefferson Pereira Marques
 * @author Paulo montes Cardoso Xavier
 * <p>
 * Estrutura de Dados 1 - 27/05/2026
 * <p>
 * Está classe representa uma lista encadeada de alunos com suas respectivas notas,
 * Os metodos por esta classe ofertados tem capacidade de:
 *  Inserção em ordem pela nota, inserindo da maior nota para a menor;
 *  Remoção dado a matrícula do aluno, atravez de duma busca sequencial;
 *  Busca sublista de alunos com uma nota especifica, atravez de duma busca sequencial;
 *  Busca dados de aluno por matrícula, atravez de duma busca sequencial;
 *  Busca sublista de alunos de uma cidade especifica, atravez de duma busca sequencial;
 *  Tamanho da lista;
 * <p>
 * Metodos Auxiliares:
 *  print(): Auxilia na exibição da lista de alunos consuas notas;
 *  isVasia(): Auxilia na validação de uma lista vasia;
 */
public class ListaNotas {

    private static class Nodo {
        Aluno aluno;
        float nota;
        Nodo prox;

        public Nodo(Aluno aluno, float nota) {
            this.aluno = aluno;
            this.nota = nota;
        }

        private void exibirAluno() {
            System.out.println("Matrícula: " + this.aluno.getMatricula());
            System.out.println("Nome: " + this.aluno.getNome());
            System.out.println("Curso: " + this.aluno.getCurso());
            System.out.println("Cidade: " + this.aluno.getEndereco());
            System.out.println("Telefone: " + this.aluno.getTelefone());
            System.out.println("Nota: " + this.nota);
            System.out.println();
        }
    }

    private final Nodo head;
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

    public Aluno remocaoPorMatricula(String matricula) {
        if (isVazia()) { return null; }

        Nodo aux  = this.head;

        while (aux.prox != null && !aux.prox.aluno.getMatricula().equals(matricula)) {
            aux = aux.prox;
        }

        if (aux.prox == null) {
            return null;
        }

        Nodo q = aux.prox;
        aux.prox = q.prox;

        if (aux.prox == null) {
            this.ultimo = aux;
        }

        return q.aluno;
    }

    public ListaNotas buscaPorNota(float nota) {
        if (isVazia()) { return null; }

        Nodo aux = this.head.prox;
        ListaNotas lista = new ListaNotas();

        while (aux != null) {
            if (aux.nota == nota) {
                lista.insercaoEmOrdem(aux.aluno, nota);
            }
            aux = aux.prox;
        }

        if (lista.head.prox == null ) {
            return null;
        }
        else {
            return lista;
        }
    }

    public Aluno buscaPorMatricula(String matricula) {
        if (isVazia()) { return null; }

        Nodo aux = this.head.prox;

        while (aux != null) {
            if (aux.aluno.getMatricula().equals(matricula)) {
                return aux.aluno;
            }
            aux = aux.prox;
        }
        return null;
    }

    public ListaNotas buscaPorCidade(String cidade) {
        if (isVazia()) { return null; }

        Nodo aux = this.head.prox;
        ListaNotas lista = new ListaNotas();

        while (aux != null) {
            if (aux.aluno.getEndereco().equals(cidade)) {
                lista.insercaoEmOrdem(aux.aluno, aux.nota);
            }
            aux = aux.prox;
        }

        if (lista.head.prox == null ) {
            return null;
        }
        else {
            return lista;
        }
    }

    public void print() {
        if (isVazia()) { return; }

        Nodo atual = this.head.prox;
        while (atual != null) {
            atual.exibirAluno();
            atual = atual.prox;
        }
    }

    private boolean isVazia() {
        if (this.head.prox == null) {
            System.out.println("A lista está vazia.");
            return true;
        }
        return false;
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
