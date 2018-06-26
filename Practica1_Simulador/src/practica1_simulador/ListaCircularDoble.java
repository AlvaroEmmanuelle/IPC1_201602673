package practica1_simulador;

public class ListaCircularDoble {
    NodoCircular primero;
    NodoCircular ultimo;
    public ListaCircularDoble(){
        primero=ultimo=null;
    }
    public boolean estaVacia(){
        return primero == null;
    }
    public void agregarAlFinal(Object dato){
        if(!estaVacia()){
            NodoCircular nuevo = new NodoCircular(dato);
            ultimo.setSiguiente(nuevo);
            nuevo.setSiguiente(primero);
            nuevo.setAnterior(ultimo);
            ultimo = nuevo;
            primero.setAnterior(ultimo); 
        }else{
            primero=ultimo= new NodoCircular(dato);
        }
    }
    public void agregarAlInicio(Object dato){
        if(!estaVacia()){
            NodoCircular nuevo = new NodoCircular(dato);
            primero.setAnterior(nuevo);
            nuevo.setSiguiente(primero);
            nuevo.setAnterior(ultimo);
            primero = nuevo;
            ultimo.setSiguiente(primero);
            
        }else{ 
            primero=ultimo=new NodoCircular(dato);
        }
        
    }
    public void removerDelFrente(Object dato){
        NodoCircular actual = new NodoCircular();
        NodoCircular anterior = new NodoCircular();
        
        actual = primero;
        anterior = ultimo;
        do{
            if(actual.dato == dato){
                if(actual == primero){
                       primero = primero.siguiente;
                       ultimo.siguiente=primero;
                       primero.anterior=ultimo;
                }else if(actual == ultimo){
                    ultimo = anterior;
                    primero.anterior=ultimo;
                    ultimo.siguiente=primero;
                }else{
                    anterior.siguiente=actual.siguiente;
                    actual.siguiente.anterior=anterior;
                    
                }
            }
            anterior=actual;
            actual = actual.siguiente;
        }while(actual != primero);
    }
    public void imprimirListaCircular(){
        NodoCircular auxiliar=ultimo.siguiente;
        do{
            System.out.print(auxiliar.getDato()+"<----->");
            auxiliar = auxiliar.getSiguiente();
            
        }while(auxiliar != ultimo.siguiente);
    }
    
}   
