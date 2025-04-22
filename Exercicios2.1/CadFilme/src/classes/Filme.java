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
public class Filme {
    private String titulo;
    private String diretor;
    private int duracao;
    private double preco;
    
    public Filme(){
        this.titulo = "";
        this.diretor = "";
        this.duracao = 0;
        this.preco = 0;
    }
    public void preencher(){
        Scanner leitor = new Scanner(System.in);
        System.out.println("---------- Digite os dados do filme  -----------------");
        System.out.print("Infome o titulo: ");
        this.titulo = leitor.next();
        System.out.print("Informe o diretor: ");
        this.diretor = leitor.next();
        System.out.print("Informe a duração do filme: ");
        this.duracao = leitor.nextInt();
        System.out.print("Informe o preço: ");
        this.preco = leitor.nextDouble();
    }
    public void imprimir(){
        System.out.println("Título "+ this.titulo);
        System.out.println("Diretor: "+ this.diretor);
        System.out.println("Duração: "+ this.duracao);
        System.out.println("Preço: "+ this.preco);
    }
        public void copiar(Filme outro){
        this.titulo = outro.getTitulo();
        this.diretor = outro.getDiretor();
        this.duracao = outro.getDuracao();
        this.preco = outro.getPreco();
    }
        public void setTitulo(String titulo){
            this.titulo = titulo;
        }
        public String getTitulo(){
            return this.titulo;
        }
        public void setDiretor(String diretor){
            this.diretor = diretor;
        }
        public String getDiretor(){
            return this.diretor;
        }
        public void setDuracao(int duracao){
            this.duracao = duracao;
        }
        public int getDuracao(){
            return this.duracao;
        }
        public void setPreco(double preco){
            this.preco = preco;
        }
        public double getPreco(){
            return this.preco;
        }
 
}
