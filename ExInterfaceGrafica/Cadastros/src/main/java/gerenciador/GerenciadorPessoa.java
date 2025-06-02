package gerenciador;

import classes.Pessoa;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Rangel
 */
public class GerenciadorPessoa {
    private List<Pessoa> pessoas;

    public GerenciadorPessoa() {
        this.pessoas = new ArrayList<>();
    }
    
    public void adicionarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
        System.out.println("Pessoa adicionada com sucesso!");
    }

    public boolean removerPessoa(String cpf) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getCpf().equals(cpf)) {
                pessoas.remove(pessoa);
                System.out.println("Pessoa removida com sucesso!");
                return true;
            }
        }
        System.out.println("Pessoa não encontrada!");
        return false;
    }

    public Pessoa buscarPessoa(String cpf) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getCpf().equals(cpf)) {
                return pessoa;
            }
        }
        return null;
    }

    public void atualizarPessoa(String cpfAntigo, Pessoa pessoaNova) {
        Pessoa pessoaExistente = buscarPessoa(cpfAntigo);
        
        if (pessoaExistente != null) {
            int indice = pessoas.indexOf(pessoaExistente);
            pessoas.set(indice, pessoaNova);
            System.out.println("Pessoa atualizada com sucesso.");
        } else {
            System.out.println("Pessoa com o CPF \"" + cpfAntigo + "\" não encontrada.");
        }
    }

    @Override
    public String toString() {
        StringBuilder saida = new StringBuilder();
        for (Pessoa pessoa : pessoas) {
            saida.append(pessoa.toString()).append("\n");
        }
        return saida.toString();
    }
    
    
}
