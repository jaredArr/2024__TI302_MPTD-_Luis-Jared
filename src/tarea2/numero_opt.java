package tarea2;

public class numero_opt {
 private int[] arreglo;
    public numero_opt(int[] arreglo) {
        this.arreglo = arreglo;
    }
 public int calcular(){
     int min = arreglo[0];
     int index = 0;
     
     for  (int i = 0; i< arreglo.length; i++){
         if ( arreglo[i] <min){
             index = i;
             min = arreglo[i];
         }
     }
     return min >= 0 ? -1: index;
 }
    public void setArreglo(int[] arreglo) {
        this.arreglo = arreglo;
    }
}