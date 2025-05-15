package roteiro01;

import classes.Ponto;
import classes.Triangulo;
import classes.Quadrado;
import java.util.Scanner;

public class Roteiro01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha a forma geométrica:");
        System.out.println("1 - Triângulo");
        System.out.println("2 - Quadrado");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();

        if (opcao == 1) {
            // Entrada dos pontos do triângulo
            Ponto p1 = lerPonto(scanner, 1);
            Ponto p2 = lerPonto(scanner, 2);
            Ponto p3 = lerPonto(scanner, 3);

            Triangulo t = new Triangulo(p1, p2, p3);

            System.out.println("\nCoordenadas dos pontos:");
            t.imprimir();

            if (t.isColinear()) {
                System.out.println("\nColineares? Sim");
            } else {
                System.out.println("\nColineares? Não");
            }

            double area = t.area();
            if(area < 0)
                area = -1*area;
            System.out.println("Área do triângulo: " + area);
            System.out.println("Perímetro do triângulo: " + t.perimetro());
            System.out.println("Tipo do triângulo: " + t.tipo());

        } else if (opcao == 2) {
            // Entrada dos pontos do quadrado
            Ponto p1 = lerPonto(scanner, 1);
            Ponto p2 = lerPonto(scanner, 2);
            Ponto p3 = lerPonto(scanner, 3);
            Ponto p4 = lerPonto(scanner, 4);

            Quadrado q = new Quadrado(p1, p2, p3, p4);

            System.out.println("\nCoordenadas dos pontos:");
            q.imprimir();

            System.out.println("Área do quadrado: " + q.area());
            System.out.println("Perímetro do quadrado: " + q.perimetro());
            System.out.println("Tipo do quadrado: " + q.tipo());

        } else {
            System.out.println("Opção inválida.");
        }
    }

    // Função auxiliar para ler um ponto
    public static Ponto lerPonto(Scanner scanner, int numero) {
        Ponto p = new Ponto();
        System.out.print("Digite a coordenada X do ponto " + numero + ": ");
        p.setX(scanner.nextDouble());
        System.out.print("Digite a coordenada Y do ponto " + numero + ": ");
        p.setY(scanner.nextDouble());
        return p;
    }
}
