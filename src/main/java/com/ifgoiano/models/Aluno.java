package com.ifgoiano.models;

/**
 * @author Flávio Diniz de Sousa
 * @author Jefferson Pereira Marques
 * @author Paulo montes Cardoso Xavier
 * <p>
 * Estrutura de Dados 1 - 27/05/2026
 * <p>
 * Está classe representa o modelo de um aluno,
 * Os atributos por esta classe definidos são:
 *  matricula: Número de matrícula do aluno;
 *  nome: Nome completo do aluno;
 *  curso: Curso em que o aluno está matriculado;
 *  endereco: Cidade de residência do aluno;
 *  telefone: Número de telefone do aluno;
 */
public class Aluno {
    private String matricula;
    private String nome;
    private String curso;
    private String endereco;
    private String telefone;

    public Aluno(String matricula, String nome, String curso, String endereco, String telefone) {
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
