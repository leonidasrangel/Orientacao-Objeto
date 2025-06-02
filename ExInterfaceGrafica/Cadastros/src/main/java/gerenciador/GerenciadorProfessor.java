package gerenciador;

import classes.Professor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rangel
 */
public class GerenciadorProfessor {
    private List<Professor> professores;

    public GerenciadorProfessor() {
        this.professores = new ArrayList<>();
    }
    
    public void adicionarProfessor(Professor professor) {
        professores.add(professor);
        System.out.println("Professor(a) adicionado(a) com sucesso!");
    }

    public boolean removerProfessor(String cpf) {
        for (Professor professor : professores) {
            if (professor.getCpf().equals(cpf)) {
                professores.remove(professor);
                System.out.println("Professor(a) removido(a) com sucesso!");
                return true;
            }
        }
        System.out.println("Professor(a) não encontrado(a)!");
        return false;
    }

    public Professor buscarProfessor(String cpf) {
        for (Professor professor : professores) {
            if (professor.getCpf().equals(cpf)) {
                return professor;
            }
        }
        return null;
    }

    public void atualizarProfessor(String cpfAntigo, Professor professorNova) {
        Professor professorExistente = buscarProfessor(cpfAntigo);
        
        if (professorExistente != null) {
            int indice = professores.indexOf(professorExistente);
            professores.set(indice, professorNova);
            System.out.println("Professor(a) atualizado(a) com sucesso.");
        } else {
            System.out.println("Professor(a) com o CPF \"" + cpfAntigo + "\" não encontrada.");
        }
    }

    @Override
    public String toString() {
        StringBuilder saida = new StringBuilder();
        for (Professor professor : professores) {
            saida.append(professor.toString()).append("\n");
        }
        return saida.toString();
    }
}
