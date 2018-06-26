package practica1_simulador;

public class NodoDoble {
    Object dato;
    NodoDoble siguiente;
    NodoDoble anterior;
    //constructor cuando hayan Nodos
    public NodoDoble(Object dato, NodoDoble siguiente, NodoDoble anterior){
        this.dato=dato;
        this.siguiente=siguiente;
        this.anterior=anterior;
        
    }
    //constructor cuando no hayan Dobles
    public NodoDoble(Object dato){
        this(dato,null,null);
        
    }
    public NodoDoble(){
        
    }
    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }
    
}
