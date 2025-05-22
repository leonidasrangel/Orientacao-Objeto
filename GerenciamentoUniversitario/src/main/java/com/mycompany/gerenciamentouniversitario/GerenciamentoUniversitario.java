package com.mycompany.gerenciamentouniversitario;

import com.mycompany.gerenciamentouniversitario.classes.Curso;
import com.mycompany.gerenciamentouniversitario.classes.Estudante;
import com.mycompany.gerenciamentouniversitario.classes.Universidade;

/**
 *
 * @author Rangel
 */
public class GerenciamentoUniversitario {

    public static void main(String[] args) {
        // Criando cursos
        Curso matematica = new Curso("Matemática", 101);
        Curso fisica = new Curso("Física", 102);
        Curso quimica = new Curso("Química", 103);
        Curso biologia = new Curso("Biologia", 104);
        Curso computacao = new Curso("Computação", 105);
        Curso historia = new Curso("História", 106);

        // Criando estudantes
        Estudante ana = new Estudante("Ana", 1);
        Estudante bruno = new Estudante("Bruno", 2);
        Estudante carla = new Estudante("Carla", 3);
        Estudante daniel = new Estudante("Daniel", 4);
        Estudante eduarda = new Estudante("Eduarda", 5);

        // Matriculando estudantes nos cursos
        ana.matricularCurso(matematica);
        ana.matricularCurso(computacao);

        bruno.matricularCurso(matematica);
        bruno.matricularCurso(fisica);

        carla.matricularCurso(quimica);
        carla.matricularCurso(historia);

        daniel.matricularCurso(biologia);
        daniel.matricularCurso(computacao);

        eduarda.matricularCurso(computacao);

        // Criando a universidade
        Universidade universidade = new Universidade("Universidade Federal");

        // Adicionando cursos à universidade
        universidade.adicionarCurso(matematica);
        universidade.adicionarCurso(fisica);
        universidade.adicionarCurso(quimica);
        universidade.adicionarCurso(biologia);
        universidade.adicionarCurso(computacao);
        universidade.adicionarCurso(historia);

        // Adicionando estudantes à universidade
        universidade.adicionarEstudante(ana);
        universidade.adicionarEstudante(bruno);
        universidade.adicionarEstudante(carla);
        universidade.adicionarEstudante(daniel);
        universidade.adicionarEstudante(eduarda);

        // Usando os métodos estatísticos
        System.out.println("Número total de alunos matriculados na " + universidade.getNome() + ": " + universidade.NumeroTotalDeAlunos());

        Curso cursoMaisPopular = universidade.CursoComMaisAlunos();
        if (cursoMaisPopular != null) {
            System.out.println("Curso com mais alunos: " + cursoMaisPopular.getNome());
        } else {
            System.out.println("Curso com mais alunos: Nenhum");
        }

        System.out.println("Top 5 cursos com mais alunos:");
        for (Curso curso : universidade.Top5CursosComMaisAlunos()) {
            System.out.println("- " + curso.getNome() + " (" + curso.getEstudantesMatriculados().size() + " alunos)");
        }
    }
}