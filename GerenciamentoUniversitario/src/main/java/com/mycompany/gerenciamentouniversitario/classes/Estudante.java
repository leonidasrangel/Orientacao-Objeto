package com.mycompany.gerenciamentouniversitario.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Rangel
 */

public class Estudante {
    private String nome;
    private int matricula;
    private List<Curso> cursosMatriculados;

    public Estudante() {
        this.nome = "";
        this.matricula = 0;
        this.cursosMatriculados = new ArrayList<>();
    }

    public Estudante(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
        this.cursosMatriculados = new ArrayList<>();
    }

    public void matricularCurso(Curso curso) {
        if (!cursosMatriculados.contains(curso)) {
            cursosMatriculados.add(curso);
            curso.adicionarEstudante(this);
        }
    }

    public void desmatricularCurso(Curso curso) {
        if (cursosMatriculados.contains(curso)) {
            cursosMatriculados.remove(curso);
            curso.removerEstudante(this);
        }
    }
    
        @Override
    public String toString() {
        StringBuilder cursos = new StringBuilder();
        for (Curso c : cursosMatriculados) {
            cursos.append(c.getNome()).append(", ");
        }
        if (cursos.length() > 0) cursos.setLength(cursos.length() - 2);
        return "Estudante{" +
               "nome='" + nome + '\'' +
               ", matricula=" + matricula +
               ", cursosMatriculados=[" + cursos + "]" +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estudante estudante = (Estudante) o;
        return matricula == estudante.matricula;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public List<Curso> getCursosMatriculados() {
        return cursosMatriculados;
    }

    public void setCursosMatriculados(List<Curso> cursosMatriculados) {
        this.cursosMatriculados = cursosMatriculados;
    }


}