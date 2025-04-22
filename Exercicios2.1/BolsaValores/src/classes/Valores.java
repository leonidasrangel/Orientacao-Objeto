/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Scanner;

/**
 *
 * @author Rangel
 */
public class Valores {
    private String nomeEmpresa;
    private double precoAcao;
    private double volumeNegociacoes;
    private double variacaoDiaria;
    
    public Valores(){
        this.nomeEmpresa = "";
        this.precoAcao = 0;
        this.volumeNegociacoes = 0;
        this.variacaoDiaria = 0;
    }
    public void preencher(){
        Scanner leitor = new Scanner(System.in);
        System.out.println("---------- Digite os dados da empresa -----------------");
        System.out.print("Infome o nome: ");
        this.nomeEmpresa = leitor.next();
        System.out.print("Informe o preço da ação: ");
        this.precoAcao = leitor.nextDouble();
        System.out.print("Informe o volume das negociações: ");
        this.volumeNegociacoes = leitor.nextDouble();
        System.out.print("Informe a variação diária: ");
        this.variacaoDiaria = leitor.nextDouble();
    }
    public void imprimir(){
        System.out.println("Empresa: "+ this.nomeEmpresa);
        System.out.println("Preço ação: "+ this.precoAcao);
        System.out.println("Volume das negociações: "+ this.volumeNegociacoes);
        System.out.println("Variação diária: "+ this.variacaoDiaria);
    }
        public void copiar(Valores outro){
        this.nomeEmpresa = outro.getNomeEmpresa();
        this.precoAcao = outro.getPrecoAcao();
        this.volumeNegociacoes = outro.getVolumeNegociacoes();
        this.variacaoDiaria = outro.getVariacaoDiaria();
    }
        public void setNomeEmpresa(String nomeEmpresa){
            this.nomeEmpresa = nomeEmpresa;
        }
        public String getNomeEmpresa(){
            return this.nomeEmpresa;
        }
        public void setPrecoAcao(double precoAcao){
            this.precoAcao = precoAcao;
        }
        public double getPrecoAcao(){
            return this.precoAcao;
        }
        public void setVolumeNegociacoes(double volumeNegociacoes){
            this.volumeNegociacoes = volumeNegociacoes;
        }
        public double getVolumeNegociacoes(){
            return this.volumeNegociacoes;
        }
        public void setVariacaoDiaria(double variacaoDiaria){
            this.variacaoDiaria = variacaoDiaria;
        }
        public double getVariacaoDiaria(){
            return this.variacaoDiaria;
        }
}
