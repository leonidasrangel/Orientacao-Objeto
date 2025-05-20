package com.mycompany.sistemabanco.classes;

import java.util.Objects;

/**
 *
 * @author Rangel
 */
public class Conta {
    private int numeroConta;
    private String titular;
    private double saldoAtual;

    public Conta() {
        this.numeroConta = 0;
        this.titular = "";
        this.saldoAtual = 0.0;
    }

    public Conta(int numero, String titular, double saldoAtual) {
        this.numeroConta = numero;
        this.titular = titular;
        this.saldoAtual = saldoAtual;
    }

    @Override
    public String toString() {
        return "Conta{" + "numero = " + numeroConta 
                + ", titular = " + titular +
                ", saldoAtual = " + saldoAtual 
                + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.numeroConta;
        hash = 79 * hash + Objects.hashCode(this.titular);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.saldoAtual) ^ (Double.doubleToLongBits(this.saldoAtual) >>> 32));
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
        final Conta other = (Conta) obj;
        return this.numeroConta == other.numeroConta;
    }
    
    //Depositar
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldoAtual += valor;
            System.out.println("Depósito de R$: " + valor + " realizado com sucesso na conta de " + this.titular + ".");
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }
    
    //Sacar
    public boolean sacar(double valor) {
        if (valor > 0 && valor <= this.saldoAtual) {
            this.saldoAtual -= valor;
            System.out.println("Saque de R$: " + valor + " realizado com sucesso da conta de " + this.titular + ".");
            return true;
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para saque.");
            return false;
        }
    }
    
    //Tansferência
    public void transferir(Conta destino, double valor) {
        if (valor > 0 && this.saldoAtual >= valor) {
            this.saldoAtual -= valor;
            destino.saldoAtual += valor;
            System.out.println("Transferência de R$: " + valor + " realizada com sucesso de " + this.titular + " para " + destino.titular + ".");
        } else {
            System.out.println("Transferência não realizada. Saldo insuficiente ou valor inválido.");
        }
    }

    
    //Atualizar Saldo
    public void atualizarSaldo(double valor) {
        this.saldoAtual = valor;
        System.out.println("Saldo atualizado para R$: " + valor);
    }
    
    public int getNumeroConta() {
        return this.numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getTitular() {
        return this.titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldoAtual() {
        return this.saldoAtual;
    }

    public void setSaldoAtual(double saldoAtual) {
        this.saldoAtual = saldoAtual;
    }
    
}
