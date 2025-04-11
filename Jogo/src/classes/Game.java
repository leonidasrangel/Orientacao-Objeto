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
public class Game {
    private String titulo;
    private String plataforma;
    private String classificacaoEtaria;
    private double preco;
    
    public Game(){
        this.titulo = "";
        this.plataforma = "";
        this.classificacaoEtaria = "";
        this.preco = 0;
    }
    public void preencher(){
        Scanner leitor = new Scanner(System.in);
        System.out.println("---------- Digite os dados do jogo -----------------");
        System.out.print("Infome o titulo: ");
        this.titulo = leitor.next();
        System.out.print("Informe a plataforma: ");
        this.plataforma = leitor.next();
        System.out.print("Informe a classificação etária do jogo: ");
        this.classificacaoEtaria = leitor.next();
        System.out.print("Informe o preço: ");
        this.preco = leitor.nextDouble();
    }
    public void imprimir(){
        System.out.println("Título "+ this.titulo);
        System.out.println("Plataforma: "+ this.plataforma);
        System.out.println("Classificação etária: "+ this.classificacaoEtaria);
        System.out.println("Preço: "+ this.preco);
    }
        public void copiar(Game outro){
        this.titulo = outro.getTitulo();
        this.plataforma = outro.getPlataforma();
        this.classificacaoEtaria = outro.getClassificacaoEtaria();
        this.preco = outro.getPreco();
    }
        public void setTitulo(String titulo){
            this.titulo = titulo;
        }
        public String getTitulo(){
            return this.titulo;
        }
        public void setPlataforma(String plataforma){
            this.plataforma = plataforma;
        }
        public String getPlataforma(){
            return this.plataforma;
        }
        public void setClassificaoEtaria(String duracao){
            this.classificacaoEtaria = classificacaoEtaria;
        }
        public String getClassificacaoEtaria(){
            return this.classificacaoEtaria;
        }
        public void setPreco(double preco){
            this.preco = preco;
        }
        public double getPreco(){
            return this.preco;
        }
}
