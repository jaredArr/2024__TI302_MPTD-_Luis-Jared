package tema1fundamentos;

public class crapsTest {
     public static void main(String[] args) {
         int dado1 = (int) (Math.random()* 6 + 1);
         int dado2 = (int) (Math.random()* 6 + 1);
         
         System.out.println("Dado 1"+ dado1 + "Dado2" + dado2);
         System.out.println("Suma: "+(dado1+dado2));
     }
}
