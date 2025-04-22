package classes;

import java.util.Scanner;

public class Televisao {
    private String marca;
    private double tamanho;
    private String resolucao;
    private double preco;

public Televisao(){
    this.marca = "";
    this.tamanho = 0;
    this.resolucao = "";
    this.preco = 0;
    }
public void preencher(){
        Scanner leitor = new Scanner(System.in);
        System.out.println("--------------- Informe os dados da TV -------------------");
        System.out.print("Informe a marca da TV: ");
        this.marca = leitor.next();
        System.out.print("Informe o tamanho da TV: ");
        this.tamanho = leitor.nextDouble();
        System.out.print("Informe a resolucao da TV: ");
        this.resolucao = leitor.next();
        System.out.print("Informe o preco da TV: ");
        this.preco = leitor.nextDouble();
        System.out.println("----------------------------------------------------------");
    }
public void imprimir(){
        System.out.println("Marca: "+ this.marca);
        System.out.println("Modelo: "+ this.tamanho);
        System.out.println("Preco: "+ this.resolucao);
        System.out.println("Memoria: "+ this.preco);
    }
    
    public void copiar(Televisao outro){
        this.marca = outro.getMarca();
        this.tamanho = outro.getTamanho();
        this.resolucao = outro.getResolucao();
        this.preco = outro.getPreco();
        
    }
    public void setMarca(String marca){
        this.marca = marca;
    }
    public String getMarca(){
        return this.marca;
    }
    
    public void setTamanho(double tamanho){
        this.tamanho = tamanho;
    }
    public double getTamanho(){
        return this.tamanho;
    }
    
    public void setResolucao(String resolucao){
        this.resolucao = resolucao;
    }
    public String getResolucao(){
        return this.resolucao;
    }
    public void setPreco(double preco){
        this.preco = preco;
    }
    public double getPreco(){
        return this.preco;
    }
}