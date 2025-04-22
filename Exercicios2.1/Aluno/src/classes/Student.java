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
public class Student {
    private String nome;
    private int idade;
    private String matricula;
    private int anoIngresso;
    
    public Student(){
        this.nome = "";
        this.idade = 0;
        this.matricula = "";
        this.anoIngresso = 0;
    }
    public void preencher(){
        Scanner leitor = new Scanner(System.in);
        System.out.println("---------- Informe os dados do estudante -----------------");
        System.out.println("Informe o nome: ");
        this.nome = leitor.next();
        System.out.println("Informe a idade: ");
        this.idade = leitor.nextInt();
        System.out.println("Informe o numero de matricula: ");
        this.matricula = leitor.next();
        System.out.println("Informe o ano de ingresso");
        this.anoIngresso = leitor.nextInt();
    }
    public void imprimir(){
        System.out.println("Nome: "+ this.nome);
        System.out.println("Idade: "+ this.idade);
        System.out.println("Matricula: "+ this.matricula);
        System.out.println("Ano de ingresso: "+ this.anoIngresso);
    }
        public void copiar(Student outro){
        this.nome = outro.getNome();
        this.idade = outro.getIdade();
        this.matricula = outro.getMatricula();
        this.anoIngresso = outro.getAnoIngresso();
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    
    public void setIdade(int idade){
        this.idade = idade;
    }
    public int getIdade(){
        return this.idade;
    }
    
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
    public String getMatricula(){
        return this.matricula;
    }
    public void setAnoIngresso(int anoIngresso){
        this.anoIngresso = anoIngresso;
    }
    public int getAnoIngresso(){
        return this.anoIngresso;
    }
}
