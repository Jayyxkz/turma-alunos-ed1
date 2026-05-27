package com.ifgoiano;

import com.ifgoiano.models.Aluno;
import com.ifgoiano.services.ListaNotas;

import java.util.List;

public class TesteListaAluno {
    public static void main(String[] args) {

        ListaNotas lista = getListaNotas();

        Aluno menorDesempenho = lista.buscaPorNota(4.3f);
        System.out.println("Alunos com menor desempenho:\n" + menorDesempenho.getNome());

        lista.remocaoPorMatricula("15010");
        System.out.println("\nAluno Jefferson removido!");

        List<Aluno> alunosOrizona = lista.buscaPorCidade("Orizona");
        System.out.println("\nAlunos de Orizona:");
        for (Aluno aluno : alunosOrizona) {
            System.out.println(aluno.getNome());
        }

        System.out.println("\nTamanho da lista: " + lista.tamanho());
    }

    // Insere alunos na lista
    private static ListaNotas getListaNotas() {
        Aluno aluno1 = new Aluno("15010", "Jefferson", "Sistemas de Informação", "Orizona",
                "64998888");
        Aluno aluno2 = new Aluno("15011", "Flávio", "Sistemas de Informação", "Orizona",
                "64998383");
        Aluno aluno3 = new Aluno("15012", "Paulo", "Sistemas de Informação", "Orizona",
                "64994788");
        Aluno aluno4 = new Aluno("15013", "João", "Sistemas de Informação", "Urutaí",
                "64994777");

        ListaNotas lista = new ListaNotas();

        lista.insercaoEmOrdem(aluno1, 6.7f);
        lista.insercaoEmOrdem(aluno2, 7.4f);
        lista.insercaoEmOrdem(aluno3, 7.5f);
        lista.insercaoEmOrdem(aluno4, 4.3f);
        return lista;
    }
}