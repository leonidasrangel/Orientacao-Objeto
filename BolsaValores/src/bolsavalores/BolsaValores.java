/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolsavalores;

import classes.Valores;

/**
 *
 * @author Rangel
 */
public class BolsaValores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Valores Empresa1 = new Valores();
        Empresa1.preencher();
        Empresa1.imprimir();
        
        Valores Empresa2 = new Valores();
        Empresa2.copiar(Empresa1);
        Empresa2.imprimir();
    }
    
}
