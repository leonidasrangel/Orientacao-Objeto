/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import classes.Game;

/**
 *
 * @author Rangel
 */
public class Jogo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Game G1 = new Game();
        G1.preencher();
        G1.imprimir();
        
        Game G2 = new Game();
        G2.copiar(G1);
        G2.imprimir();
    }
    
}
