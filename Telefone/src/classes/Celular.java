package classes;

import java.util.Scanner;

public class Celular {
    private String marca;
    private String modelo;
    private double preco;
    private double memoria; 
    
    public Celular(){
        this.marca = "";
        this.modelo = "";
        this.preco = 0;
        this.memoria = 0;
    }
    
    public void preencher(){
        Scanner leitor = new Scanner(System.in);
        System.out.println("---------------Informe os dados do celular---------------");
        System.out.print("Informe a marca do celular: ");
        this.marca = leitor.next();
        System.out.print("Informe o modelo do celular: ");
        this.modelo = leitor.next();
        System.out.print("Informe o preco do celular: ");
        this.preco = leitor.nextDouble();
        System.out.print("Informe o tamanho da memoria: ");
        this.memoria = leitor.nextDouble();
        System.out.println("---------------------------------------------------------");
    }
    public void imprimir(){
        System.out.println("Marca: "+ this.marca);
        System.out.println("Modelo: "+ this.modelo);
        System.out.println("Preco: "+ this.preco);
        System.out.println("Memoria: "+ this.memoria);
    }
    
    public void copiar(Celular outro){
        this.marca = outro.getMarca();
        this.modelo = outro.getModelo();
        this.preco = outro.getPreco();
        this.memoria = outro.getMemoria();
        
    }
    
    public void setMarca(String marca){
        this.marca = marca;
    }
    public String getMarca(){
        return this.marca;
    }
    
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    public String getModelo(){
        return this.modelo;
    }
    
    public void setPreco(double preco){
        this.preco = preco;
    }
    public double getPreco(){
        return this.preco;
    }
    
    public void setMemoria(double memoria){
        this.memoria = memoria;
    }
    public double getMemoria(){
        return this.memoria;
    }
}
