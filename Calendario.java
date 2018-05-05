package calendario;

import java.util.ArrayList;

public class Calendario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       generarCalendario();
        
    }    
    public static void generarCalendario(){//añadir arraylist de equipos en parametros
        /*
        Funcion basada en el algoritmo 
        round robin para la conmutacion a pares
        */
        ArrayList<String> locales = new ArrayList<String>();//CAMBIAR POR VALORES QUE VENGAN DE BBDD Y PASARLOS COMO PARAMETRO EN ARRAYLIST
        //CAMBIAR VALORES DE STRING POR EL OBJETO CORRESPONDIENTE
        ArrayList<String> visitantes = new ArrayList<String>();
        locales.add("A");
        locales.add("B");
        locales.add("C");
        locales.add("D");
        locales.add("E");
        locales.add("F");
        locales.add("G");
        locales.add("H");

       
       
        if(locales.size()%2!=0){
            locales.add("Descansa");
        }
        int jornadas=locales.size()-1;
        int mitad=(locales.size()/2)-1;
        int contador=0;
        for(int i=locales.size()-1;i>mitad;i--){
            visitantes.add(locales.get(i));
            locales.remove(i);
        }
        
            String fijo=locales.get(0);
            locales.remove(0);
        for(int k=0;k<jornadas*2;k++){
            System.out.println("----JORNADA "+(k +1) +"---------- ");
            System.out.println(fijo+"-"+visitantes.get(0));
            contador++;
            for(int x=0;x<locales.size();x++){
                System.out.println(locales.get(x)+"-"+visitantes.get(x+1));
                contador++;
            }
            locales.add(0,visitantes.get(0));
            visitantes.remove(0);
            visitantes.add(locales.get(locales.size()-1));
            locales.remove(locales.size()-1);
        }        
        System.out.println(contador);//si contador es igua a n!/(n-2)!*2 es que todo va bien
    }
}
