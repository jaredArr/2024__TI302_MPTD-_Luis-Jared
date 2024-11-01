package unidad2.transporte;

import java.util.Scanner;

public class TransporteSfbCMTest {
    private int m; // Número de filas
    private int n; // Número de columnas
    private int[][] costs; // Matriz de costos
    private int[][] allocation; // Matriz de asignación
    private int[] supply; // Suministros
    private int[] demand; // Demandas

    // Constructor para inicializar la matriz de costos, suministro y demanda
    public TransporteSfbCMTest(int m, int n, int[] supply, int[] demand, int[][] costs) {
        this.m = m;
        this.n = n;
        this.supply = supply;
        this.demand = demand;
        this.costs = costs;
        this.allocation = new int[m][n];
    }

    public void applyMinimumCostMethod() {
        boolean[] rowCanceled = new boolean[m];
        boolean[] colCanceled = new boolean[n];

        while (true) {
            int minCost = Integer.MAX_VALUE;
            int minRow = -1;
            int minCol = -1;

            // Encontrar la celda de costo mínimo en una fila/columna no cancelada
            for (int i = 0; i < m; i++) {
                if (rowCanceled[i]) continue;
                for (int j = 0; j < n; j++) {
                    if (colCanceled[j]) continue;
                    if (costs[i][j] < minCost) {
                        minCost = costs[i][j];
                        minRow = i;
                        minCol = j;
                    }
                }
            }

            // Si no hay más celdas válidas, salir del bucle
            if (minRow == -1 || minCol == -1) break;

            // Asignar la cantidad máxima posible en la celda de costo mínimo
            int allocationAmount = Math.min(supply[minRow], demand[minCol]);
            allocation[minRow][minCol] = allocationAmount;

            // Reducir el suministro y la demanda
            supply[minRow] -= allocationAmount;
            demand[minCol] -= allocationAmount;

            // Cancelar el renglón o la columna que llega a 0
            if (supply[minRow] == 0) rowCanceled[minRow] = true;
            if (demand[minCol] == 0) colCanceled[minCol] = true;
        }
    }

    public void printTableau() {
        System.out.println("Matriz de asignación con suministro y demanda restantes:");

        // Imprimir encabezados de columnas de demanda
        for (int j = 0; j < n; j++) {
            System.out.print("\t" + demand[j]);
        }
        System.out.println("\tDemanda");

        // Imprimir matriz de asignación y suministro restantes
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (allocation[i][j] > 0) {
                    System.out.print(allocation[i][j] + "\t");
                } else {
                    System.out.print("-\t");
                }
            }
            System.out.println("| " + supply[i]); // Mostrar el suministro restante al final de la fila
        }

        // Imprimir línea final
        System.out.print("Suministro\t");
        for (int j = 0; j < n; j++) {
            System.out.print(demand[j] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer dimensiones de la matriz
        System.out.print("Ingrese el número de filas (M): ");
        int m = scanner.nextInt();
        System.out.print("Ingrese el número de columnas (N): ");
        int n = scanner.nextInt();

        // Leer los suministros
        System.out.println("Ingrese el suministro para cada fila:");
        int[] supply = new int[m];
        for (int i = 0; i < m; i++) {
            supply[i] = scanner.nextInt();
        }

        // Leer las demandas
        System.out.println("Ingrese la demanda para cada columna:");
        int[] demand = new int[n];
        for (int j = 0; j < n; j++) {
            demand[j] = scanner.nextInt();
        }

        // Leer la matriz de costos
        System.out.println("Ingrese la matriz de costos:");
        int[][] costs = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                costs[i][j] = scanner.nextInt();
            }
        }

        // Crear instancia y aplicar el método de costo mínimo
        TransporteSfbCMTest transporte = new TransporteSfbCMTest(m, n, supply, demand, costs);
        transporte.applyMinimumCostMethod();

        // Mostrar el tableau resultante
        transporte.printTableau();
    }
}

