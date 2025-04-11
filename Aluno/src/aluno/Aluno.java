/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aluno;

import classes.Student;

/**
 *
 * @author Rangel
 */
public class Aluno {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Student aluno1 = new Student();
        aluno1.preencher();
        aluno1.imprimir();
        
        Student aluno2 = new Student();
        aluno2.copiar(aluno1);
        aluno2.imprimir();
    }
    
}
