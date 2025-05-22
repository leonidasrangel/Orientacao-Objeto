package com.mycompany.gerenciamentouniversitario.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Rangel
 */
public class Curso {
    private String nome;
    private int codigo;
    private List<Estudante> estudantesMatriculados;

    public Curso() {
        this.nome = "";
        this.codigo = 0;
        this.estudantesMatriculados = new ArrayList<>();
    }

    public Curso(String nome, int codigo) {
        this.nome = nome;
        this.codigo = codigo;
        this.estudantesMatriculados = new ArrayList<>();
    }

    public void adicionarEstudante(Estudante estudante) {
        if (!estudantesMatriculados.contains(estudante)) {
            estudantesMatriculados.add(estudante);
        }
    }

    public void removerEstudante(Estudante estudante) {
        estudantesMatriculados.remove(estudante);
    }
    
        @Override
    public String toString() {
        StringBuilder estudantes = new StringBuilder();
        for (Estudante e : estudantesMatriculados) {
            estudantes.append(e.getNome()).append(", ");
        }
        if (estudantes.length() > 0) estudantes.setLength(estudantes.length() - 2);
        return "Curso{" +
               "nome='" + nome + '\'' +
               ", codigo=" + codigo +
               ", estudantesMatriculados=[" + estudantes + "]" +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return codigo == curso.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public List<Estudante> getEstudantesMatriculados() {
        return estudantesMatriculados;
    }

    public void setEstudantesMatriculados(List<Estudante> estudantesMatriculados) {
        this.estudantesMatriculados = estudantesMatriculados;
    }


}
