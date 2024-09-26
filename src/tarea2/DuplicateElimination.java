package tarea2;

    import java.util.Scanner;

public class DuplicateElimination {
    public static void main(String[] args) {
        int[] uniqueNumbers = new int[5];
        int count = 0;
        Scanner scanner = new Scanner(System.in);

        while (count < uniqueNumbers.length) {
            System.out.print("Ingresa un número entre 10 y 100: ");
            int number = scanner.nextInt();

            if (number >= 10 && number <= 100) {
                boolean isDuplicate = false;
                for (int i = 0; i < count; i++) {
                    if (uniqueNumbers[i] == number) {
                        isDuplicate = true;
                        break;
                    }
                }

                if (!isDuplicate) {
                    uniqueNumbers[count] = number;
                    count++;
                    System.out.print("Valores únicos hasta ahora: ");
                    for (int i = 0; i < count; i++) {
                        System.out.print(uniqueNumbers[i] + " ");
                    }
                    System.out.println();
                } else {
                    System.out.println("Número duplicado, inténtalo de nuevo.");
                }
            } else {
                System.out.println("Número fuera de rango. Debe estar entre 10 y 100.");
            }
        }
    }
}


