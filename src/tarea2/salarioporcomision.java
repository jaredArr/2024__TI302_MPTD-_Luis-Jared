//ITESS - TICS
//AGOSTO - DICIEMBRE 2024
//ESTRUCTURA Y ORGANIZACION DE DATOS
//RPOFESOR: FRANCISCO JAVIER MONTECILLO PUENTE
//PROGRAMADOR: LUIS JARED ARREDONDO CORNEJO 
//DESCRIPCION:CALCUKAR LA COMISION DE UNOS TRABAJADORES
//13/09/2024
package tarea2;

public class salarioporcomision {
    private int[] ventas;
    private int[] histograma;
    private int[] salario;
     public enum rango{
     R200_299,R300_399,R400_499,R500_599, R600_699,
     R700_799,R800_899,R900_999,R100
};
     public static final int numero_de_casillas = 9;
     public salarioporcomision(int[] ventas){
         this.ventas = ventas;
         this.salario = new int[ventas.length];
         this.histograma = new int[9];
     }
    public void CalcularelSalario(){
    for (int i=0; i< ventas.length;i++){
        salario[1] = (int) (200 + 0.09 *ventas[i]){
        
    }
    }
    
}
}
                      