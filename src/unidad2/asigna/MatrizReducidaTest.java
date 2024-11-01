package unidad2.asigna;

import java.util.Arrays;
import java.util.Scanner;

public class MatrizReducidaTest {
    public static void main(String[] args) {
        // Crear la matriz de costos con números genéricos m y n
        int[][] costos = {
            {14, 5, 8, 7},   // m
            {2, 12, 6, 5},   // n
            {7, 8, 3, 9},
            {2, 4, 6, 10}
        };
        
        int[] suministro = {15, 25, 20, 15};  // m
        int[] demanda = {10, 20, 25, 20};     // n
        
        MatrizReducidaTest metodo = new MatrizReducidaTest();
        int[][] asignacion = metodo.resolverTransporte(costos, suministro, demanda);
        
        // Imprimir resultado
        System.out.println("Matriz de asignación:");
        for (int i = 0; i < asignacion.length; i++) {
            for (int j = 0; j < asignacion[0].length; j++) {
                System.out.print(asignacion[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class MetodoPenalizacionTransporte {
    public int[][] resolverTransporte(int[][] costos, int[] suministro, int[] demanda) {
        // Implementación del método de penalización de transporte
        int[][] asignacion = new int[costos.length][costos[0].length];
        // Aquí va la lógica del método de penalización
        return asignacion;
    }
}

 
