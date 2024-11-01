package tarea2;
import java.util.Random;

public class SlotsGame{
        public static void main(String[] args) {
        Random random = new Random();
        
        // Generar dos números aleatorios entre 1 y 6 (simulando un dado)
        int numero1 = random.nextInt(2) + 1;
        int numero2 = random.nextInt(2) + 1;
        
        // Mostrar los números generados
        System.out.println("Numero 1: " + numero1);
        System.out.println("Numero 2: " + numero2);
        
        // Verificar si ambos números son 2
        if (numero1 == 2 && numero2 == 2) {
            System.out.println("¡Ganaste! La combinacion es 2 y 2.");
        } else {
            System.out.println("No ganaste. Intenta de nuevo.");
        }
    }
}
