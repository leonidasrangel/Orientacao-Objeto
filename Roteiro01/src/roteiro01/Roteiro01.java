package roteiro01;

import classes.Ponto;
import classes.Triangulo;
import java.util.Scanner;

public class Roteiro01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada dos pontos do triângulo
        Ponto p1 = new Ponto();
        System.out.print("Digite a coordenada X do ponto 1: ");
        p1.setX(scanner.nextDouble());
        System.out.print("Digite a coordenada Y do ponto 1: ");
        p1.setY(scanner.nextDouble());

        Ponto p2 = new Ponto();
        System.out.print("Digite a coordenada X do ponto 2: ");
        p2.setX(scanner.nextDouble());
        System.out.print("Digite a coordenada Y do ponto 2: ");
        p2.setY(scanner.nextDouble());

        Ponto p3 = new Ponto();
        System.out.print("Digite a coordenada X do ponto 3: ");
        p3.setX(scanner.nextDouble());
        System.out.print("Digite a coordenada Y do ponto 3: ");
        p3.setY(scanner.nextDouble());

        Triangulo t = new Triangulo(p1, p2, p3);

        System.out.println("Coordenadas dos pontos:");
        t.imprimir();

        if (t.isColinear()) {
        System.out.println("\nColineares? Sim");
        } else {
        System.out.println("\nColineares? Não");
        }

        System.out.println("Área do triângulo: " + t.area()); 

        System.out.println("Perímetro do triângulo: " + t.perimetro());

        System.out.println("Tipo do triângulo: " + t.tipo());
    }
}
