package unidad2.asigna;

import java.util.Scanner;

public class PivoteoAsignacion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Leer tamaño de la matriz
        int m = scanner.nextInt();
        int[][] costos = new int[m][m];
        
        // Leer matriz de costos
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                costos[i][j] = scanner.nextInt();
            }
        }
        
        // Leer índices de renglones y columnas marcadas
        int rCount = scanner.nextInt();
        int[] renglonesMarcados = new int[rCount];
        for (int i = 0; i < rCount; i++) {
            renglonesMarcados[i] = scanner.nextInt();
        }

        int cCount = scanner.nextInt();
        int[] columnasMarcadas = new int[cCount];
        for (int i = 0; i < cCount; i++) {
            columnasMarcadas[i] = scanner.nextInt();
        }
        
        // Llamar al método para realizar el pivoteo
        realizarPivoteo(costos, renglonesMarcados, columnasMarcadas);
        
        // Imprimir matriz ajustada
        System.out.println("Matriz ajustada:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(costos[i][j] + " ");
            }
            System.out.println();
        }
        
        scanner.close();
    }

    public static void realizarPivoteo(int[][] costos, int[] renglonesMarcados, int[] columnasMarcadas) {
        int m = costos.length;
        boolean[] renglonCubierto = new boolean[m];
        boolean[] columnaCubierta = new boolean[m];
        
        for (int r : renglonesMarcados) {
            renglonCubierto[r] = true;
        }
        
        for (int c : columnasMarcadas) {
            columnaCubierta[c] = true;
        }
        
        // Encontrar el elemento no cubierto más pequeño
        int k = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (!renglonCubierto[i] && !columnaCubierta[j] && costos[i][j] < k) {
                    k = costos[i][j];
                }
            }
        }
        
        // Ajustar la matriz de costos
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (!renglonCubierto[i] && !columnaCubierta[j]) {
                    costos[i][j] -= k;
                } else if (renglonCubierto[i] && columnaCubierta[j]) {
                    costos[i][j] += k;
                }
            }
        }
    }
}

