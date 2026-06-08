package com.ifgoiano;

import com.ifgoiano.models.Aluno;
import com.ifgoiano.services.ListaNotas;

import java.util.List;

public class TesteListaAluno {

    public static void main(String[] args) {

        ListaNotas lista = criarLista();

        testarRemocao(lista);
        testarBuscaPorNota(lista);
        testarBuscaPorMatricula(lista);
        testarBuscaPorCidade(lista);
        testarTamanho(lista);
    }

    private static void testarRemocao(ListaNotas lista) {
        System.out.println("\n=== REMOÇÃO POR MATRÍCULA ===");

        lista.remocaoPorMatricula("15010");

        System.out.println("Aluno Jefferson removido.\n");
    }

    private static void testarBuscaPorNota(ListaNotas lista) {
        System.out.println("=== BUSCA POR NOTA ===");

        List<Aluno> alunos = lista.buscaPorNota(4.3f);

        if (alunos != null) {
            for (Aluno aluno : alunos) {
                exibirAluno(aluno);
            }
        } else {
            System.out.println("Aluno(s) não encontrado(s).");
        }
    }

    private static void testarBuscaPorMatricula(ListaNotas lista) {
        System.out.println("\n=== BUSCA POR MATRÍCULA ===");

        Aluno aluno = lista.buscaPorMatricula("15011");

        if (aluno != null) {
            exibirAluno(aluno);
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    private static void testarBuscaPorCidade(ListaNotas lista) {
        System.out.println("\n=== BUSCA POR CIDADE ===");

        List<Aluno> alunos = lista.buscaPorCidade("Orizona");

        if (alunos != null) {
            for (Aluno aluno : alunos) {
                exibirAluno(aluno);
            }
        } else {
            System.out.println("Aluno(s) não encontrado(s).");
        }
    }

    private static void testarTamanho(ListaNotas lista) {
        System.out.println("\n=== TAMANHO DA LISTA ===");
        System.out.println("Quantidade de alunos: "
                + lista.tamanho());
    }

    private static void exibirAluno(Aluno aluno) {
        System.out.println("Matrícula: " + aluno.getMatricula());
        System.out.println("Nome: " + aluno.getNome());
        System.out.println("Curso: " + aluno.getCurso());
        System.out.println("Cidade: " + aluno.getEndereco());
        System.out.println("Telefone: " + aluno.getTelefone());
        System.out.println();
    }

    private static ListaNotas criarLista() {
        ListaNotas lista = new ListaNotas();

        lista.insercaoEmOrdem(
                new Aluno("15010", "Jefferson",
                        "Sistemas de Informação", "Orizona", "64998888"),
                6.7f);

        lista.insercaoEmOrdem(
                new Aluno("15011", "Flávio",
                        "Sistemas de Informação", "Orizona", "64998383"),
                7.4f);

        lista.insercaoEmOrdem(
                new Aluno("15012", "Paulo",
                        "Sistemas de Informação", "Orizona", "64994788"),
                4.3f);

        lista.insercaoEmOrdem(
                new Aluno("15013", "João",
                        "Sistemas de Informação", "Urutaí", "64994777"),
                4.3f);

        return lista;
    }
}