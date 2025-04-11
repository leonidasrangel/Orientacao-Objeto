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
public class Estimacao {
    private String especie;
    private String raca;
    private int idade;
    private double peso;
    
    public Estimacao(){
        this.especie = "";
        this.raca = "";
        this.idade = 0;
        this.peso = 0;
    }
    public void preencher(){
        Scanner leitor = new Scanner(System.in);
        System.out.println("---------- Digite os dados do Animal  -----------------");
        System.out.print("Digite a especie: ");
        this.especie = leitor.next();
        System.out.print("Digite a raça: ");
        this.raca = leitor.next();
        System.out.print("Digite a idade: ");
        this.idade = leitor.nextInt();
        System.out.print("Digite o peso: ");
        this.peso = leitor.nextDouble();
    }
    public void imprimir(){
        System.out.println("Especie: "+ this.especie);
        System.out.println("Raça: "+ this.raca);
        System.out.println("Idade: "+ this.idade);
        System.out.println("Peso: "+ this.peso);
    }
        public void copiar(Estimacao outro){
        this.especie = outro.getEspecie();
        this.raca = outro.getRaca();
        this.idade = outro.getIdade();
        this.peso = outro.getPeso();
    }
        public void setEspecie(String especie){
            this.especie = especie;
        }
        public String getEspecie(){
            return this.especie;
        }
        public void setRaca(String raca){
            this.raca = raca;
        }
        public String getRaca(){
            return this.raca;
        }
        public void setIdade(int idade){
            this.idade = idade;
        }
        public int getIdade(){
            return this.idade;
        }
        public void setPeso(double peso){
            this.peso = peso;
        }
        public double getPeso(){
            return this.peso;
        }
}
