//ITESS - TICS
//AGOSTO - DICIEMBRE 2024
//ESTRUCTURA Y ORGANIZACION DE DATOS
//RPOFESOR: FRANCISCO JAVIER MONTECILLO PUENTE
//PROGRAMADOR: LUIS JARED ARREDONDO CORNEJO 
//DESCRIPCION: Practica de arreglos
//03/09/2024
package minicurso.jf;

public class Arreglos {
    
   private int arr [] = new int[10];

   public void file0to9(){
       String str = "";
       for (int i = 0 ; i < arr.length; i ++)
        arr[i]= 0;


}
   public void Clean(){
       for (int i = 0 ; i < arr.length; i ++)
           arr[i] = i;
       
           
}  
    public void unosvert1(){
    for (int i=0; i <arr.length; i++)
    if (i%2==0)
    arr[i]=1;
    else
    arr[i]=0;
}   
    public void Vert1(){
        for(int i = 0; i < arr.length; i++){
            arr[i] = 1;
            i++;
        }
        for (int i = 0; i<arr.length-1; i++){
            System.out.println(arr[i]+ " ");
        }
    }
    
    @Override
    public String toString() {
        String str = "";
        for (int i =0; i < arr.length; i++){
        str+= arr[i] + " ";
        }
                
        return str ;
    }
    
    
}

