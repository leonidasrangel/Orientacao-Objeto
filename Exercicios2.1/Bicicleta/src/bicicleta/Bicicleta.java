/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicicleta;

import classes.Bike;

/**
 *
 * @author Rangel
 */
public class Bicicleta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bike B1 = new Bike();
        B1.preencher();
        B1.imprimir();
        
        Bike B2 = new Bike();
        B2.copiar(B1);
        B2.imprimir();
    }
    
}
