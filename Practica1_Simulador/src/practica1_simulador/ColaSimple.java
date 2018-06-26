package practica1_simulador;

public class ColaSimple {
    ListaSimple listasimple;
    public ColaSimple(){
        listasimple = new ListaSimple();
    }
    public void encolar(Object dato){
        listasimple.agregarAlFinal(dato);
        
    }
    public Object descolar() throws EmptyListException{
        return listasimple.removerDelInicio();
    }
    public void imprimirCola(){
        listasimple.mostrarLista();
    }
}

class EmptyListException extends RuntimeException{
    public EmptyListException(){
            
    }
}