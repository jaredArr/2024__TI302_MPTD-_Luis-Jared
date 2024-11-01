package unidad2.transporte;

public class TransporteSfbCM extends TransporteSfb {

    @Override
    public void sfb(float[][] costs, int[] supply, int[] demand) {
        int m = supply.length;
        int n = demand.length;
        float[][] allocation = new float[m][n];

        while (true) {
            int minI = -1, minJ = -1;
            float minCost = Float.MAX_VALUE;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (supply[i] > 0 && demand[j] > 0 && costs[i][j] < minCost) {
                        minCost = costs[i][j];
                        minI = i;
                        minJ = j;
                    }
                }
            }

            if (minI == -1 || minJ == -1) break;

            int quantity = Math.min(supply[minI], demand[minJ]);
            allocation[minI][minJ] = quantity;
            supply[minI] -= quantity;
            demand[minJ] -= quantity;
        }

        System.out.println("Allocation Matrix (Costos Mínimos):");
        printMatrix(allocation);
    }
}
