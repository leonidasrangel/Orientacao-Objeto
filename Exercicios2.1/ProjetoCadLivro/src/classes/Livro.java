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
public class Livro {
    private String title;
    private String author;
    private int numberPages;
    private double price;
    
    public Livro(){
    this.title = "";
    this.author = "";
    this.numberPages = 0;
    this.price = 0;    
    }
    public void preencher(){
        Scanner leitor = new Scanner(System.in);
        System.out.println("---------- Enter the Book data  -----------------");
        System.out.print("Enter the title: ");
        this.title = leitor.next();
        System.out.print("Inform the author: ");
        this.author = leitor.next();
        System.out.print("Enter the number of pages: ");
        this.numberPages = leitor.nextInt();
        System.out.print("Enter the price: ");
        this.price = leitor.nextDouble();
    }
    public void imprimir(){
        System.out.println("Title: "+ this.title);
        System.out.println("Author: "+ this.author);
        System.out.println("Page numbers: "+ this.numberPages);
        System.out.println("Price: "+ this.price);
    }
        public void copiar(Livro outro){
        this.title = outro.getTitle();
        this.author = outro.getAuthor();
        this.numberPages = outro.getNumberPages();
        this.price = outro.getPrice();
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public String getAuthor(){
        return this.author;
    }
    public void setNumberPages(int numeberPages){
        this.numberPages = numeberPages;
    }
    public int getNumberPages(){
        return this.numberPages;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public double getPrice(){
        return this.price;
    }
}
