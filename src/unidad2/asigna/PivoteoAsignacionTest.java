package unidad2.asigna;

import java.util.Scanner;

public class PivoteoAsignacionTest {
    public void realizarPivoteo(int[][] costos, int[] renglonesMarcados, int[] columnasMarcadas) {
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
    

