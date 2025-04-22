/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filme;

import classes.Movie;

/**
 *
 * @author Rangel
 */
public class Filme {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Movie F1 = new Movie();
        F1.preencher();
        F1.imprimir();
        
        Movie F2 = new Movie();
        F2.copiar(F1);
        F2.imprimir();
    }
    
}
