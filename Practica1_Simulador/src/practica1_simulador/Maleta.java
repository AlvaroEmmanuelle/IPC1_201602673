
package practica1_simulador;

import java.util.Random;

public class Maleta {
    public Maleta(){
        
    }
    public int cantidadmaletas(int pasajero){
        Random maletas = new Random();
        int totalmaletas=maletas.nextInt(4)+1;
        return totalmaletas;
    }
}
