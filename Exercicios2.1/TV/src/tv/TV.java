package tv;

import classes.Televisao;

public class TV {

    public static void main(String[] args) {
        Televisao TV1 = new Televisao();
        TV1.preencher();
        TV1.imprimir();
        
        Televisao TV2 = new Televisao();
        TV2.copiar(TV1);
        TV2.imprimir();
    }
    
}
