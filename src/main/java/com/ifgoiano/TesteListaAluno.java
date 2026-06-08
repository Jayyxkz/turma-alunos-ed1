package com.ifgoiano;

import com.ifgoiano.models.Aluno;
import com.ifgoiano.services.ListaNotas;

import java.util.List;

/**
 * @author Flávio Diniz de Sousa
 * @author Jefferson Pereira Marques
 * @author Paulo montes Cardoso Xavier
 * <p>
 * Estrutura de Dados 1 - 27/05/2026
 * <p>
 * Está classe realiza os testes dos metodos da classe ListaNotas,
 * Os metodos por esta classe ofertados tem capacidade de:
 *  Testar a inserção em ordem e exibição da lista;
 *  Testar a remoção de um aluno por matrícula;
 *  Testar a busca de alunos por nota;
 *  Testar a busca de aluno por matrícula;
 *  Testar a busca de alunos por cidade;
 *  Testar o tamanho da lista;
 * <p>
 * Metodos Auxiliares:
 *  criarLista(): Auxilia na criação e populamento da lista de alunos para os testes;
 *  exibirAluno(): Auxilia na exibição dos dados de um aluno;
 */
public class TesteListaAluno {

    public static void main(String[] args) {

        ListaNotas lista = criarLista();

        testarInsercao(lista);
        testarTamanho(lista);
        testarRemocao(lista);
        testarTamanho(lista);
        testarBuscaPorNota(lista);
        testarBuscaPorMatricula(lista);
        testarBuscaPorCidade(lista);
        testarTamanho(lista);
    }

    private static void testarInsercao(ListaNotas lista) {
        System.out.println("\n=== INSERÇÃO ===");

        lista.print();
    }

    private static void testarRemocao(ListaNotas lista) {
        System.out.println("\n=== REMOÇÃO POR MATRÍCULA ===");

        Aluno aluno = lista.remocaoPorMatricula("15010");

        System.out.println("Aluno "+ aluno.getNome() +" removido.");
    }

    private static void testarBuscaPorNota(ListaNotas lista) {
        System.out.println("\n=== BUSCA COM NOTA 4.3 ===");

        ListaNotas alunos = lista.buscaPorNota(4.3f);

        if (alunos != null) {
            alunos.print();
        } else {
            System.out.println("Aluno(s) não encontrado(s).");
        }
    }

    private static void testarBuscaPorMatricula(ListaNotas lista) {
        System.out.println("\n=== BUSCA COM MATRÍCULA 15011===");

        Aluno aluno = lista.buscaPorMatricula("15011");

        if (aluno != null) {
            exibirAluno(aluno);
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    private static void testarBuscaPorCidade(ListaNotas lista) {
        System.out.println("\n=== BUSCA DA CIDADE DE Orizona===");

        ListaNotas alunos = lista.buscaPorCidade("Orizona");

        if (alunos != null) {
            alunos.print();
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