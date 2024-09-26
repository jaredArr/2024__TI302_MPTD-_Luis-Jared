//ITESS - TICS
//AGOSTO - DICIEMBRE 2024
//ESTRUCTURA Y ORGANIZACION DE DATOS
//RPOFESOR: FRANCISCO JAVIER MONTECILLO PUENTE
//PROGRAMADOR: LUIS JARED ARREDONDO CORNEJO 
//DESCRIPCION: escaleras de asteriscos
//11/09/2024
package tema1fundamentos;


public class EDAlgoTP01 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        System.out.println(); 

        
        for (int i = 10; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println(); 
                                                                                                                                                                                                                                                                                                                                                  
        
        for (int i = 1; i <= 10; i++) {
            
            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }
            
            for (int j = i; j <= 10; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println(); 

        
        for (int i = 1; i <= 10; i++) {
            
            for (int j = 10; j > i; j--) {
                System.out.print(" ");
            }
            
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}


