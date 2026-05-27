package com.ifgoiano.service;

import com.ifgoiano.models.Aluno;

public class Nodo {
    Aluno aluno;
    double nota;
    Nodo prox;

    public Nodo(Aluno aluno, double nota) {
        this.aluno = aluno;
        this.nota = nota;
    }
}
