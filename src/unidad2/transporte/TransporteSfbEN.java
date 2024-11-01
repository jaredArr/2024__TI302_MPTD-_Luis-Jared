package unidad2.transporte;

public class TransporteSfbEN extends TransporteSfb {

    @Override
    public void sfb(float[][] costs, int[] supply, int[] demand) {
        int m = supply.length;
        int n = demand.length;
        float[][] allocation = new float[m][n];
        
        int i = 0, j = 0;
        while (i < m && j < n) {
            int quantity = Math.min(supply[i], demand[j]);
            allocation[i][j] = quantity;
            supply[i] -= quantity;
            demand[j] -= quantity;
            
            if (supply[i] == 0) i++;
            if (demand[j] == 0) j++;
        }
        
        System.out.println("Allocation Matrix (Esquina Noroeste):");
        printMatrix(allocation);
    }
}
