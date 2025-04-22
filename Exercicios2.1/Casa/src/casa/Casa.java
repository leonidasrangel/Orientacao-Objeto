package casa;

import classes.Casas;

public class Casa {


    public static void main(String[] args) {
        Casas c3 = new Casas();
        c3.preencher();
        c3.imprimir();
        
        Casas c2 = new Casas();
        c2.copiar(c3);
        c2.imprimir();
    }
    
}
