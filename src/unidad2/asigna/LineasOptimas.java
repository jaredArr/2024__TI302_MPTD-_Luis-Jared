
package unidad2.asigna;

public class LineasOptimas {
    public int[][] resolverTransporte(int[][] costos, int[] suministro, int[] demanda) {
        int n = costos.length;
        int m = costos[0].length;
        int[][] asignacion = new int[n][m];

        // Copiar los suministros y demandas
        int[] supply = suministro.clone();
        int[] demand = demanda.clone();

        while (!todosCeros(supply) && !todosCeros(demand)) {
            // Calcular penalizaciones para filas y columnas
            int[] rowPenalty = calcularPenalizaciones(costos, true);
            int[] colPenalty = calcularPenalizaciones(costos, false);

            // Encontrar la mayor penalización
            int maxRowPenalty = maxIndice(rowPenalty);
            int maxColPenalty = maxIndice(colPenalty);

            // Determinar asignación basada en penalizaciones
            if (rowPenalty[maxRowPenalty] > colPenalty[maxColPenalty]) {
                int row = maxRowPenalty;
                int col = minIndice(costos[row], demand);
                asignar(costos, asignacion, supply, demand, row, col);
            } else {
                int col = maxColPenalty;
                int row = minIndice(columna(costos, col), supply);
                asignar(costos, asignacion, supply, demand, row, col);
            }
        }
        return asignacion;
    }

    private boolean todosCeros(int[] array) {
        for (int value : array) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

    private int[] calcularPenalizaciones(int[][] costos, boolean isRow) {
        int size = isRow ? costos.length : costos[0].length;
        int[] penalizaciones = new int[size];

        for (int i = 0; i < size; i++) {
            int[] valores = isRow ? costos[i] : columna(costos, i);
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
            for (int value : valores) {
                if (value < min1) {
                    min2 = min1;
                    min1 = value;
                } else if (value < min2) {
                    min2 = value;
                }
            }
            penalizaciones[i] = min2 - min1;
        }
        return penalizaciones;
    }

    private int[] columna(int[][] matrix, int col) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][col];
        }
        return column;
    }

    private int maxIndice(int[] array) {
        int maxIdx = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[maxIdx]) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    private int minIndice(int[] array, int[] relevantArray) {
        int minIdx = -1;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (relevantArray[i] > 0 && array[i] < minValue) {
                minValue = array[i];
                minIdx = i;
            }
        }
        return minIdx;
    }

    private void asignar(int[][] costos, int[][] asignacion, int[] supply, int[] demand, int row, int col) {
        int cantidad = Math.min(supply[row], demand[col]);
        asignacion[row][col] = cantidad;
        supply[row] -= cantidad;
        demand[col] -= cantidad;
    }
}

