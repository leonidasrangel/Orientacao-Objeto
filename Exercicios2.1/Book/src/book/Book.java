/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book;

import classes.Bookstore;

/**
 *
 * @author Rangel
 */
public class Book {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bookstore bookOne = new Bookstore();
        bookOne.preencher();
        bookOne.imprimir();
        
        Bookstore bookTwo = new Bookstore();
        bookTwo.copiar(bookOne);
        bookTwo.imprimir();
    }
    
}
