package unidad2.transporte;

import java.util.Scanner;

public class TransporteSfbENTest {
    private int m; // Número de filas
    private int n; // Número de columnas
    private int[][] allocation; // Matriz de asignación
    private int[] supply; // Suministros
    private int[] demand; // Demandas

    // Constructor para inicializar la matriz de costos, suministro y demanda
    public TransporteSfbENTest(int m, int n, int[] supply, int[] demand) {
        this.m = m;
        this.n = n;
        this.allocation = new int[m][n];
        this.supply = supply;
        this.demand = demand;
    }

    public void applyNorthwestCornerMethod() {
        int i = 0, j = 0;
        while (i < m && j < n) {
            // Asignar la cantidad máxima posible
            int allocationAmount = Math.min(supply[i], demand[j]);
            allocation[i][j] = allocationAmount;

            // Reducir el suministro y la demanda
            supply[i] -= allocationAmount;
            demand[j] -= allocationAmount;

            // Cancelar el renglón o la columna que llega a 0
            if (supply[i] == 0) i++;
            if (demand[j] == 0) j++;
        }
    }

    public void printTableau() {
        // Imprimir la tabla de asignación
        System.out.println("Tableau de asignación:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(allocation[i][j] + "\t");
            }
            System.out.println("| " + supply[i]); // Imprimir el suministro restante al final de cada fila
        }
        
        // Imprimir línea divisoria
        for (int j = 0; j < n; j++) {
            System.out.print("----\t");
        }
        System.out.println();

        // Imprimir demanda restante al final de la tabla
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

        // Crear instancia y aplicar el método de la Esquina Noroeste
        TransporteSfbENTest transporte = new TransporteSfbENTest(m, n, supply, demand);
        transporte.applyNorthwestCornerMethod();

        // Mostrar el tableau de asignación resultante
        transporte.printTableau();
    }
}
