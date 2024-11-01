package unidad2.transporte;

  import java.util.Arrays;
import java.util.Scanner;

public class TransporteSfbVO extends TransporteSfb {
    
    private int[][] costs;        // Transportation cost matrix
    private int[][] allocations;  // Matrix to store allocations
    private int[] supply;         // Supply array
    private int[] demand;         // Demand array
    private int rows, cols;       // Matrix dimensions

    // Constructor to initialize the cost matrix, supply, and demand
    public TransporteSfbVO(int[][] costs, int[] supply, int[] demand) {
        this.costs = costs;
        this.supply = supply;
        this.demand = demand;
        this.rows = costs.length;
        this.cols = costs[0].length;
        this.allocations = new int[rows][cols]; // Initialize allocation matrix with zeros
        for (int[] row : allocations) {
            Arrays.fill(row, -1); // -1 indicates no allocation made in that cell yet
        }
    }

    // Method to implement Vogel's Approximation Method
    public void calculateVogel() {
        while (!isComplete()) {
            int[] rowPenalties = calculateRowPenalties();
            int[] colPenalties = calculateColPenalties();

            // Find the row or column with the maximum penalty
            boolean isRowMax = true;
            int maxPenalty = -1;
            int maxIndex = -1;

            // Check row penalties for the maximum penalty
            for (int i = 0; i < rowPenalties.length; i++) {
                if (rowPenalties[i] > maxPenalty) {
                    maxPenalty = rowPenalties[i];
                    maxIndex = i;
                    isRowMax = true;
                }
            }

            // Check column penalties for the maximum penalty
            for (int j = 0; j < colPenalties.length; j++) {
                if (colPenalties[j] > maxPenalty) {
                    maxPenalty = colPenalties[j];
                    maxIndex = j;
                    isRowMax = false;
                }
            }

            // Allocate based on the minimum cost in the selected row or column
            if (isRowMax) {
                allocateInRow(maxIndex);
            } else {
                allocateInColumn(maxIndex);
            }
        }
    }

    // Checks if all supply and demand are satisfied
    private boolean isComplete() {
        for (int i : supply) {
            if (i > 0) return false;
        }
        for (int j : demand) {
            if (j > 0) return false;
        }
        return true;
    }

    // Calculates row penalties
    private int[] calculateRowPenalties() {
        int[] penalties = new int[rows];
        for (int i = 0; i < rows; i++) {
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
            for (int j = 0; j < cols; j++) {
                if (demand[j] > 0 && costs[i][j] < min1) {
                    min2 = min1;
                    min1 = costs[i][j];
                } else if (demand[j] > 0 && costs[i][j] < min2) {
                    min2 = costs[i][j];
                }
            }
            penalties[i] = (min2 == Integer.MAX_VALUE) ? 0 : (min2 - min1);
        }
        return penalties;
    }

    // Calculates column penalties
    private int[] calculateColPenalties() {
        int[] penalties = new int[cols];
        for (int j = 0; j < cols; j++) {
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
            for (int i = 0; i < rows; i++) {
                if (supply[i] > 0 && costs[i][j] < min1) {
                    min2 = min1;
                    min1 = costs[i][j];
                } else if (supply[i] > 0 && costs[i][j] < min2) {
                    min2 = costs[i][j];
                }
            }
            penalties[j] = (min2 == Integer.MAX_VALUE) ? 0 : (min2 - min1);
        }
        return penalties;
    }

    // Allocate in the selected row
    private void allocateInRow(int row) {
        int minCost = Integer.MAX_VALUE;
        int minCol = -1;
        for (int j = 0; j < cols; j++) {
            if (demand[j] > 0 && costs[row][j] < minCost) {
                minCost = costs[row][j];
                minCol = j;
            }
        }
        allocate(row, minCol);
    }

    // Allocate in the selected column
    private void allocateInColumn(int col) {
        int minCost = Integer.MAX_VALUE;
        int minRow = -1;
        for (int i = 0; i < rows; i++) {
            if (supply[i] > 0 && costs[i][col] < minCost) {
                minCost = costs[i][col];
                minRow = i;
            }
        }
        allocate(minRow, col);
    }

    // Allocate units in the selected cell
    private void allocate(int row, int col) {
        int allocation = Math.min(supply[row], demand[col]);
        allocations[row][col] = allocation;
        supply[row] -= allocation;
        demand[col] -= allocation;
    }

    // Display the resulting tableau with allocations
    public void displayMatrix() {
        System.out.println("Allocations matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print((allocations[i][j] == -1 ? " " : allocations[i][j]) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read matrix dimensions
        System.out.print("Enter the number of rows (M) and columns (N): ");
        int M = scanner.nextInt();
        int N = scanner.nextInt();

        // Initialize the cost matrix
        int[][] costs = new int[M][N];
        System.out.println("Enter the cost matrix (M x N):");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                costs[i][j] = scanner.nextInt();
            }
        }

        // Read supply values
        int[] supply = new int[M];
        System.out.println("Enter the supply array:");
        for (int i = 0; i < M; i++) {
            supply[i] = scanner.nextInt();
        }

        // Read demand values
        int[] demand = new int[N];
        System.out.println("Enter the demand array:");
        for (int j = 0; j < N; j++) {
            demand[j] = scanner.nextInt();
        }

        // Create an instance of TransporteSfbVO and perform the calculation
        TransporteSfbVO transporte = new TransporteSfbVO(costs, supply, demand);
        transporte.calculateVogel();
        transporte.displayMatrix();

        scanner.close();
    }

    @Override
    public void sfb(float[][] costs, int[] supply, int[] demand) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
