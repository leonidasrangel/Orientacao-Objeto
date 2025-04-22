package classes;

import java.util.Scanner;

public class Casas {
    private String endereco;
    private double area;
    private int quartos;
    private double preco;

public Casas(){
    this.endereco = "";
    this.area = 0;
    this.quartos = 0;
    this.preco = 0;
    }
public void preencher(){
        Scanner leitor = new Scanner(System.in);
        System.out.println("--------------- Informe os dados da casa -------------------");
        System.out.print("Informe a endereco da casa: ");
        this.endereco = leitor.next();
        System.out.print("Informe a area da casa: ");
        this.area = leitor.nextDouble();
        System.out.print("Informe quantos quartos possui a casa: ");
        this.quartos = leitor.nextInt();
        System.out.print("Informe o preco da casa: ");
        this.preco = leitor.nextDouble();
        System.out.println("----------------------------------------------------------");
    }
public void imprimir(){
        System.out.println("Endereco: "+ this.endereco);
        System.out.println("Area: "+ this.area);
        System.out.println("Quartos: "+ this.quartos);
        System.out.println("Preco: "+ this.preco);
    }
    
    public void copiar(Casas outro){
        this.endereco = outro.getEndereco();
        this.area = outro.getArea();
        this.quartos = outro.getQuartos();
        this.preco = outro.getPreco();
        
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public String getEndereco(){
        return this.endereco;
    }
    
    public void setArea(double area){
        this.area = area;
    }
    public double getArea(){
        return this.area;
    }
    
    public void setQuartos(int quartos){
        this.quartos = quartos;
    }
    public int getQuartos(){
        return this.quartos;
    }
    public void setPreco(double preco){
        this.preco = preco;
    }
    public double getPreco(){
        return this.preco;
    }
}