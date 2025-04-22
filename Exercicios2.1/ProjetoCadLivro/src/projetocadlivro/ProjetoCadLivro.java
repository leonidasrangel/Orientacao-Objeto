/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocadlivro;

import classes.Livro;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Rangel
 */
public class ProjetoCadLivro {

    public static int printMenu() {
        
        Scanner reader = new Scanner(System.in);
        
        System.out.println("-----------------------------------");
        System.out.println("1 - Insert book");
        System.out.println("2 - Remove book");
        System.out.println("3 - Search Book (Title)");
        System.out.println("4 - Search Book (Author)");
        System.out.println("0 - Quit");
        System.out.println("-----------------------------------");
        System.out.println("Choose an option: ");
        
        return reader.nextInt();
        
    }
    public static void main(String[] args) {
        
        List<Livro> listBook;
        listBook = new ArrayList<Livro>();
        Scanner reader = new Scanner(System.in);
        int option = 0;
        
        do{
        option = printMenu();
        if(option == 1){
            Livro L1 = new Livro();
            L1.preencher();
            listBook.add(L1);
            //insert
        }else if(option == 2){
            System.out.println("Enter the title:");
            String title = reader.nextLine();
            
            for(int i=0; i<= listBook.size()-1; i++){
                Livro Li = listBook.get(i);
                if(title.equals(Li.getTitle())){
                    System.out.println("Book found");
                    listBook.remove(Li);
                    
                }
            }
        }
            //remove
        else if(option == 3){
            System.out.println("Enter the title:");
            String title = reader.nextLine();
            
            for(int i=0; i<= listBook.size()-1; i++){
                Livro Li = listBook.get(i);
                if(title.equals(Li.getTitle())){
                    System.out.println("Book found");
                    Li.imprimir();
                    
                }
            }
            //search title
        }else if(option == 4){
            System.out.println("Enter the author:");
            String author = reader.nextLine();
            
            for(int i=0; i<= listBook.size()-1; i++){
                Livro Li = listBook.get(i);
                if(author.equals(Li.getAuthor())){
                    System.out.println("Author found");
                    Li.imprimir();
            //search author
        }
    }
    
}
        }while(option != 0);
}
        }
