package com.mycompany.roteiro02.classes;

/**
 *
 * @author Rangel
 */
public class Passageiro {
    private String nome;
    private String cpf;
    private SistemaFidelidade fidelidade;

    public Passageiro() {
        this.nome = "";
        this.cpf = "";
        this.fidelidade = new SistemaFidelidade();
    }

    public Passageiro(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.fidelidade = new SistemaFidelidade();
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

    public SistemaFidelidade getFidelidade() {
        return this.fidelidade;
    }

    public void setFidelidade(SistemaFidelidade fidelidade) {
        this.fidelidade = fidelidade;
    }

    @Override
    public String toString() {
        return "Passageiro{" +
               "nome='" + nome + '\'' +
               ", cpf='" + cpf + '\'' +
               ", pontosFidelidade=" + fidelidade.getSaldoPontos() +
               '}';
    }
}
