package telefone;

import classes.Celular;

public class Telefone {

    public static void main(String[] args) {
        Celular c = new Celular();
        c.preencher();
        c.imprimir();
        
        Celular c2 = new Celular();
        c2.copiar(c);
        c2.imprimir();
    }
    
}
