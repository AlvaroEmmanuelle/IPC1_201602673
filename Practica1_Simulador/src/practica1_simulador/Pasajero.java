
package practica1_simulador;

import java.util.Random;

public class Pasajero {
    public static ColaSimple colaPasajeros = new ColaSimple();
    Random rpasajeros = new Random();
    
    public Pasajero(){
        
    }
    public int numeroPasajeros(int tipoAvion){
        int passenger=0;
        switch(tipoAvion){
            case 1:
                passenger = rpasajeros.nextInt(5)+5;
                
                break;
            case 2:
                passenger = rpasajeros.nextInt(10)+15;
                
                break;
            case 3:
                passenger = rpasajeros.nextInt(10)+30;
                
                break;
        }
        return passenger;
    }
    
    public int documentos(int pasajero){
        Random doc = new Random();
        int docu = doc.nextInt(10)+1;
        return docu;
    }
}
