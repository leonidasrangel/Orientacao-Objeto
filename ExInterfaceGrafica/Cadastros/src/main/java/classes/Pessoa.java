package classes;

import java.util.Objects;

/**
 *
 * @author Rangel
 */
public class Pessoa {
    private String nome;
    private String cpf;
    private int idade;
    private String sexo;

    public Pessoa() {
        this.nome = "";
        this.cpf = "";
        this.idade = 0;
        this.sexo = "";
    }

    public Pessoa(String nome, String CPF, int idade, String sexo) {
        this.nome = nome;
        this.cpf = CPF;
        this.idade = idade;
        this.sexo = sexo;
    }
    
        public Pessoa(Pessoa outro) {
        this.nome = outro.getNome();
        this.sexo = outro.getSexo();
        this.idade = outro.getIdade();
        this.cpf = outro.getCpf();
    }
    
    public void copiar(Pessoa outro) {
        this.setNome(outro.getNome());
        this.setSexo(outro.getSexo());
        this.setIdade(outro.getIdade());
        this.setCpf(outro.getCpf());
    }
  

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.nome);
        hash = 79 * hash + Objects.hashCode(this.cpf);
        hash = 79 * hash + this.idade;
        hash = 79 * hash + Objects.hashCode(this.sexo);
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
        final Pessoa other = (Pessoa) obj;
        return Objects.equals(this.cpf, other.cpf);
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
