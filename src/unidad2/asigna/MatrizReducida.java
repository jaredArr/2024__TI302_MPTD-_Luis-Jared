package unidad2.asigna;

import java.util.Scanner;
import java.util.Arrays;

public class MatrizReducida {
    public int[][] resolverTransporte(int[][] costos, int[] suministro, int[] demanda) {
        int M = costos.length;
        int N = costos[0].length;
        int[][] asignacion = new int[M][N];
        for (int[] row : asignacion) Arrays.fill(row, 0);

        while (Arrays.stream(suministro).anyMatch(s -> s > 0) && Arrays.stream(demanda).anyMatch(d -> d > 0)) {
            // Calcular penalizaciones para filas y columnas
            int[] penalizacionesFilas = calcularPenalizacionesFilas(costos, suministro, demanda);
            int[] penalizacionesColumnas = calcularPenalizacionesColumnas(costos, suministro, demanda);

            // Determinar la penalización máxima
            int maxPenalizacionFila = Arrays.stream(penalizacionesFilas).max().orElse(-1);
            int maxPenalizacionColumna = Arrays.stream(penalizacionesColumnas).max().orElse(-1);

            int filaIndex, columnaIndex;

            if (maxPenalizacionFila >= maxPenalizacionColumna) {
                filaIndex = obtenerIndiceMaximo(penalizacionesFilas, maxPenalizacionFila);
                columnaIndex = obtenerIndiceMinimoCosto(costos[filaIndex], demanda);
            } else {
                columnaIndex = obtenerIndiceMaximo(penalizacionesColumnas, maxPenalizacionColumna);
                filaIndex = obtenerIndiceMinimoCostoColumna(costos, columnaIndex, suministro);
            }

            // Asignar el valor máximo posible a la celda seleccionada
            int asignacionValor = Math.min(suministro[filaIndex], demanda[columnaIndex]);
            asignacion[filaIndex][columnaIndex] = asignacionValor;
            suministro[filaIndex] -= asignacionValor;
            demanda[columnaIndex] -= asignacionValor;
        }

        return asignacion;
    }

    private int[] calcularPenalizacionesFilas(int[][] costos, int[] suministro, int[] demanda) {
        int M = costos.length;
        int[] penalizaciones = new int[M];

        for (int i = 0; i < M; i++) {
            if (suministro[i] > 0) {
                int[] fila = Arrays.stream(costos[i])
                    .filter(c -> demanda[Arrays.asList(costos[i]).indexOf(c)] > 0)
                    .sorted()
                    .toArray();

                if (fila.length > 1) {
                    penalizaciones[i] = fila[1] - fila[0];
                } else {
                    penalizaciones[i] = Integer.MAX_VALUE;
                }
            } else {
                penalizaciones[i] = -1;
            }
        }
        return penalizaciones;
    }

    private int[] calcularPenalizacionesColumnas(int[][] costos, int[] suministro, int[] demanda) {
        int N = costos[0].length;
        int M = costos.length;
        int[] penalizaciones = new int[N];

        for (int j = 0; j < N; j++) {
            if (demanda[j] > 0) {
                int[] columna = new int[M];
                int k = 0;
                for (int i = 0; i < M; i++) {
                    if (suministro[i] > 0) {
                        columna[k++] = costos[i][j];
                    }
                }
                columna = Arrays.stream(columna).filter(c -> c > 0).sorted().toArray();

                if (columna.length > 1) {
                    penalizaciones[j] = columna[1] - columna[0];
                } else {
                    penalizaciones[j] = Integer.MAX_VALUE;
                }
            } else {
                penalizaciones[j] = -1;
            }
        }
        return penalizaciones;
    }

    private int obtenerIndiceMaximo(int[] penalizaciones, int maxValor) {
        for (int i = 0; i < penalizaciones.length; i++) {
            if (penalizaciones[i] == maxValor) {
                return i;
            }
        }
        return -1;
    }

    private int obtenerIndiceMinimoCosto(int[] fila, int[] demanda) {
        int minCosto = Integer.MAX_VALUE;
        int indice = -1;

        for (int j = 0; j < fila.length; j++) {
            if (demanda[j] > 0 && fila[j] < minCosto) {
                minCosto = fila[j];
                indice = j;
            }
        }
        return indice;
    }

    private int obtenerIndiceMinimoCostoColumna(int[][] costos, int columnaIndex, int[] suministro) {
        int minCosto = Integer.MAX_VALUE;
        int indice = -1;

        for (int i = 0; i < costos.length; i++) {
            if (suministro[i] > 0 && costos[i][columnaIndex] < minCosto) {
                minCosto = costos[i][columnaIndex];
                indice = i;
            }
        }
        return indice;
    }
}
