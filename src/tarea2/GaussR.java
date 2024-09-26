package tarea2;


public class GaussR {
    
    private int r ; 
    private int e ;
    private double pl ;


    public double getPl() {
        return pl;
    }
    public int getE() {
        return e;
    }
    public void setE(int e) {
        this.e = e;
    }
    public int getR() {
        return r;
    }
    public void setR(int r) {
        this.r = r;
    }

public void pivoting(){
        double piv = pl[r][e];
        
        for (int j = 1 ; j <pl[0].length; j++)
            pl[r][j] =´pl[r][j]/ piv;
            
            for(int i = 0;i <pl.length; i++)
             if ( i != r){
                double fact = -pl[i][c]
                for (int j = 0; j < pl[0].length; j++)
                 pl[i][0]= pl[r][j] * fact + pl[i][j];
                
    
}
    public void print(){
System.out.println("pl: --------------------------------");
        for (int i = 0; i <pl.length; i++){
            for (int j = 0 ; j <pl[0].length; j++){
            System.out.printf("%+6.3f", pl[i][j])};
        }
        System.out.prinln("");
    }            
}