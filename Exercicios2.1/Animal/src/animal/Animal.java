/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animal;

import classes.Estimacao;

/**
 *
 * @author Rangel
 */
public class Animal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Estimacao A1 = new Estimacao();
        A1.preencher();
        A1.imprimir();
        
        Estimacao A2 = new Estimacao();
        A2.copiar(A1);
        A2.imprimir();
    }
}
