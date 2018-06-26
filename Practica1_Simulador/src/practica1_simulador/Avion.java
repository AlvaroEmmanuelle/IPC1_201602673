
package practica1_simulador;

import java.util.Random;

public class Avion {
    public Avion(){
        
    }
   
    public int numeroAviones(){
        Random avion = new Random();
        int numero = avion.nextInt(3)+1;
        return numero;
    }
}
