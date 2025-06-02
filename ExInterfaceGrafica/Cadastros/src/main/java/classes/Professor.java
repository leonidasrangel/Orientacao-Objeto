package classes;

import java.util.Objects;

/**
 *
 * @author Rangel
 */
public class Professor {
    private String nome;
    private String cpf;
    private int idade;
    private String sexo;

    public Professor() {
        this.nome = "";
        this.cpf = "";
        this.idade = 0;
        this.sexo = "";
    }

    public Professor(String nome, String CPF, int idade, String sexo) {
        this.nome = nome;
        this.cpf = CPF;
        this.idade = idade;
        this.sexo = sexo;
    }
    
    public Professor(Professor outro) {
        this.nome = outro.getNome();
        this.sexo = outro.getSexo();
        this.idade = outro.getIdade();
        this.cpf = outro.getCpf();
    }
    public void copiar(Professor outro) {
        this.setNome(outro.getNome());
        this.setSexo(outro.getSexo());
        this.setIdade(outro.getIdade());
        this.setCpf(outro.getCpf());
    }
    
    @Override
    public String toString() {
        return " ------ Dados Cadastrados ----- " 
                + "\nNome: " + nome 
                + "\nCPF: " + cpf 
                + "\nIdade: " + idade 
                + "\nSexo: " + sexo 
                + "\n--------------------------------------------------------------";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.nome);
        hash = 13 * hash + Objects.hashCode(this.cpf);
        hash = 13 * hash + this.idade;
        hash = 13 * hash + Objects.hashCode(this.sexo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Professor other = (Professor) obj;
        return Objects.equals(this.cpf, other.cpf);
    }
    
    
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
