package com.mycompany.sistemabanco.classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rangel
 */
public class Banco {
    private String nome;
    private List<Conta> contas;
    private List<Transacao> transacoes;

    public Banco() {
        this.nome = "";
        this.contas = new ArrayList<>();
        this.transacoes = new ArrayList<>();
    }
    
    public Banco(String nome) {
    this.nome = nome;
    this.contas = new ArrayList<>();
    this.transacoes = new ArrayList<>();
}

    public Banco(String nome, List<Conta> contas, List<Transacao> transacoes) {
        this.nome = nome;
        this.contas = contas;
        this.transacoes = transacoes;
    }
    
    //Adicionar e remover contas
    public void adicionarConta(Conta conta){
        contas.add(conta);
    }
    public void removerConta(Conta conta){
        contas.remove(conta);
    }
    
    //Adicionar e remover transações
    public void adicionarTransacao(Transacao transacao){
        transacoes.add(transacao);
    }
    public void removerTransacao(Transacao transacao){
        transacoes.remove(transacao);
    }
    
    //Listar contas e transações
    public void listarContas(){
        System.out.println("Contas no banco " + nome + ":");
        for(Conta conta : contas){
            System.out.println(conta);
        }
    }
    public void listarTransacoes(){
        System.out.println("Transações no banco " + nome + ":");
        for(Transacao transacao : transacoes){
            System.out.println(transacao);
        }
    }
    
    //Conta com maior saldo
    public Conta contaComMaiorSaldo(){
        if(contas.isEmpty()) return null;
        Conta maior = contas.get(0);
        for(Conta conta : contas){
            if(conta.getSaldoAtual() > maior.getSaldoAtual()){
                maior = conta;
            }
        }
        return maior;
    }
    
    //Conta com menor saldo
    public Conta contaComMenorSaldo(){
        if(contas.isEmpty()) return null;
        Conta menor = contas.get(0);
        for(Conta conta : contas){
            if(conta.getSaldoAtual() < menor.getSaldoAtual()){
                menor = conta;
            }
        }
        return menor;
    }
    
    //Total de devedores
    public void resumoDevedores(){
        int qtdDevedores = 0;
        double totalDivida = 0.0;
        
        for(Conta conta : contas){
            if(conta.getSaldoAtual() < 0){
                qtdDevedores++;
                totalDivida += conta.getSaldoAtual();
            }
        }
        System.out.println("Total de devedores: " + qtdDevedores);
        System.out.println("Somatório dos saldos negativos: " + totalDivida);
    }
    
    //Total de credores (saldo positivo)
    public void resumoCredores(){
        int qtdCredores = 0;
        double totalCredito = 0.0;
        for(Conta conta : contas){
            if(conta.getSaldoAtual() >= 0){
                qtdCredores++;
                totalCredito += conta.getSaldoAtual();
            }
        }
        System.out.println("Total de credores " + qtdCredores);
        System.out.println("Somatório dos saldos positivos: " + totalCredito);
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return this.contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public List<Transacao> getTransacoes() {
        return this.transacoes;
    }

    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }
    
    
    
}
