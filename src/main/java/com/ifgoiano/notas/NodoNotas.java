package com.ifgoiano.notas;

public class NodoNotas {
    String matricula;
    double nota;
    NodoNotas prox;

    public NodoNotas(String matricula, double nota) {
        this.matricula = matricula;
        this.nota = nota;
    }
}
