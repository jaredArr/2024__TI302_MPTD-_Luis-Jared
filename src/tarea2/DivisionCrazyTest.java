package tarea2;

public class DivisionCrazyTest {
    public static void main(String ... args){
        double[] columna1 = {1, 2, 0, 1, -3};
        double[] columna2 = {1, 0, -6, 8, -4};
        
        DivisionCrazy dc= new DivisionCrazy(columna1, columna2);
        dc.resolver();
        dc.print();
                
    }
}
