package com.mycompany.gerenciamentouniversitario.classes;

import java.util.*;

/**
 *
 * @author Rangel
 */

public class Universidade {
    private String nome;
    private List<Curso> cursosOferecidos;
    private List<Estudante> estudantesMatriculados;

    public Universidade() {
        this.nome = "";
        this.cursosOferecidos = new ArrayList<>();
        this.estudantesMatriculados = new ArrayList<>();
    }

    public Universidade(String nome) {
        this.nome = nome;
        this.cursosOferecidos = new ArrayList<>();
        this.estudantesMatriculados = new ArrayList<>();
    }

    public void adicionarCurso(Curso curso) {
        if (!cursosOferecidos.contains(curso)) {
            cursosOferecidos.add(curso);
        }
    }

    public void removerCurso(Curso curso) {
        cursosOferecidos.remove(curso);
    }

    public void adicionarEstudante(Estudante estudante) {
        if (!estudantesMatriculados.contains(estudante)) {
            estudantesMatriculados.add(estudante);
        }
    }

    public void removerEstudante(Estudante estudante) {
        estudantesMatriculados.remove(estudante);
    }

    public void listarCursos() {
        System.out.println("Cursos oferecidos na universidade " + nome + ":");
        for (Curso curso : cursosOferecidos) {
            System.out.println(curso);
        }
    }

    public void listarEstudantes() {
        System.out.println("Estudantes matriculados na universidade " + nome + ":");
        for (Estudante estudante : estudantesMatriculados) {
            System.out.println(estudante);
        }
    }

    public int NumeroTotalDeAlunos() {
        return estudantesMatriculados.size();
    }

    //O método stream() converte a coleção em um stream, permitindo operações funcionais (como filtragem, ordenação ou agregação) sobre os elementos.
    public Curso CursoComMaisAlunos() {
        return cursosOferecidos.stream() //Percorre todos os cursos oferecidos
                .max(Comparator.comparingInt(c -> c.getEstudantesMatriculados().size())) //max() encontra o elemento com o maior valor com base em um critério de comparação.
                //Comparator.comparingInt cria um comparador que avalia cada curso (c) com base no tamanho da lista de estudantes matriculados
                .orElse(null); //Se a lista tiver vazia retorna null
    }

    public List<Curso> Top5CursosComMaisAlunos() {
        return cursosOferecidos.stream()
                .sorted((c1, c2) -> Integer.compare(c2.getEstudantesMatriculados().size(), c1.getEstudantesMatriculados().size())) //Integer.compare(c2..., c1...) ordena em ordem decrescente (note que c2 vem antes de c1), pois o curso com mais alunos deve aparecer primeiro.
                //O método sorted() ordena os elementos do stream com base em um comparador.
                //O comparador é uma expressão lambda que compara dois cursos (c1 e c2) com base no tamanho de suas listas de estudantes (getEstudantesMatriculados().size()).
                .limit(5) //Limita o stream aos primeiros 5 elementos após a ordenação.
                .toList(); //Converte o stream em uma List<Curso> imutável, contendo os cursos ordenados (até 5, no máximo).
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Curso> getCursosOferecidos() {
        return this.cursosOferecidos;
    }

    public List<Estudante> getEstudantesMatriculados() {
        return this.estudantesMatriculados;
    }

    @Override
    public String toString() {
        return "Universidade{" +
                "nome='" + nome + '\'' +
                ", cursosOferecidos=" + cursosOferecidos.size() +
                ", estudantesMatriculados=" + estudantesMatriculados.size() +
                '}';
    }
} 

