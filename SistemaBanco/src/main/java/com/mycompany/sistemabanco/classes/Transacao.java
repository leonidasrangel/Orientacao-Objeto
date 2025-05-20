package com.mycompany.sistemabanco.classes;

/**
 *
 * @author Rangel
 */
public class Transacao {
    private int idTransacao;
    private String tipoTransacao; //Depósito, saque ou transferência
    private double valor;
    private String data;
    private Conta contaAssociada;

    public Transacao() {
        this.idTransacao = 0;
        this.tipoTransacao = "";
        this.valor = 0.0;
        this.data = "";
        this.contaAssociada = null;
    }

    public Transacao(int idTransacao, String tipoTransacao, double valor, String data, Conta contaAssociada) {
        this.idTransacao = idTransacao;
        this.tipoTransacao = tipoTransacao;
        this.valor = valor;
        this.data = data;
        this.contaAssociada = contaAssociada;
    }

    @Override
    public String toString() {
        return "Transacao{" + "idTransacao = " + idTransacao 
                + ", tipoTransacao = " + tipoTransacao 
                + ", valor = " + valor 
                + ", data = " + data 
                + ", contaAssociada=" + contaAssociada 
                + '}';
    }

    public int getIdTransacao() {
        return this.idTransacao;
    }

    public void setIdTransacao(int idTransacao) {
        this.idTransacao = idTransacao;
    }

    public String getTipoTransacao() {
        return this.tipoTransacao;
    }

    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Conta getContaAssociada() {
        return this.contaAssociada;
    }

    public void setContaAssociada(Conta contaAssociada) {
        this.contaAssociada = contaAssociada;
    }
    
        
}
