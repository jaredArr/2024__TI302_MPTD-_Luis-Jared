package tarea2;


public class GaussR {
    private double[][] a;
    private int r;
    private int c;

    public GaussR(double[][] a, int r, int c) {
        this.a = a;
        this.r = r;
        this.c = c;
    }

    public void seta(double[][] a) {
        this.a = a;
    }

    public void setr(int r) {
        this.r = r;
    }

    public void setc(int c) {
        this.c = c;
    }
    
    public void pivoting(){
        double pivote = a[r][c];
        for(int j = 1; j < a[0].length; j++ )
            a[r][j] = a[r][j]/pivote; 
        
        for( int i = 0; i < a.length; i++)
            
            if(i != r){
            double factor = -a[i][c];
                for(int j = 0; j < a[i].length; j++){
                    a[i][j] = a[r][j] * factor + a[i][j];
                }
    }
    }
    
    public void print(){
        System.out.println("A-------------------------");
        for(int i = 0; i <a.length; i++) {
            for(int j = 0; j < a[0].length; j++) {
                System.out.printf("%+6.3f ", a[i][j]);
            }
            System.out.println("");
        }
    } 
}