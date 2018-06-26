package practica1_simulador;

public class Nodo {
    public Object dato;
    public Nodo siguiente;
    //constructor insertar al final
    public Nodo(Object dato){
        this.dato=dato;
        this.siguiente=null;
    }
    //constructor insertar al inicio
    public Nodo(Object dato, Nodo siguiente){
        this.dato=dato;
        this.siguiente=siguiente;
    }
    
    public Nodo(){
        
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
          
    
}
