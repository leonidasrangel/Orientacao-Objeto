/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musica;

import classes.Music;

/**
 *
 * @author Rangel
 */
public class Musica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Music M1 = new Music();
        M1.preencher();
        M1.imprimir();
        M1.tocarMusica();
        M1.desligarMusica();
        
        Music M2 = new Music();
        M2.copiar(M1);
        M2.imprimir();
    }
    
}
