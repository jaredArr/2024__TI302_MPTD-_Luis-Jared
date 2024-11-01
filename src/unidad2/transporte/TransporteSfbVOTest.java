package unidad2.transporte;

import java.util.Scanner;

public class TransporteSfbVOTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows (M) and columns (N): ");
        int M = scanner.nextInt();
        int N = scanner.nextInt();

        int[][] costs = new int[M][N];

        System.out.println("Enter the cost matrix (M x N):");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                costs[i][j] = scanner.nextInt();
            }
        }

        int[] supply = new int[M];
        System.out.println("Enter the supply array:");
        for (int i = 0; i < M; i++) {
            supply[i] = scanner.nextInt();
        }

        int[] demand = new int[N];
        System.out.println("Enter the demand array:");
        for (int j = 0; j < N; j++) {
            demand[j] = scanner.nextInt();
        }

        TransporteSfbVO transporte = new TransporteSfbVO(costs, supply, demand);

        transporte.calculateVogel();

        transporte.displayMatrix();

        scanner.close();
    }
}
