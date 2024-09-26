
package minicurso.jf;

public class TrianguloAsteriscos {
    public static void main(String[] args) {
        int n = 5; // Número de filas para los triángulos

        // Patrón (a): Triángulo rectángulo
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Patrón (b): Triángulo invertido
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Patrón (c): Triángulo equilátero
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}


