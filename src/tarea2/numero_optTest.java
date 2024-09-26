package tarea2;

public class numero_optTest {
    public static void main(String ...Args){
        int[] arr = {1, -3, -6, 9, 0, 1, -2};
        int[] arr2 = {1, 2, 3}; 
                
        numero_opt nop = new numero_opt(arr);
        System.out.println("nop: " + nop.calcular());
        
        nop.setArreglo(arr2);
        System.out.println("nop: " + nop.calcular());
    }
}
