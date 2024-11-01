package unidad2.transporte;

public abstract class TransporteSfb {
    public abstract void sfb(float[][] costs, int[] supply, int[] demand);

    protected void printMatrix(float[][] matrix) {
        for (float[] row : matrix) {
            for (float cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
    }
}
