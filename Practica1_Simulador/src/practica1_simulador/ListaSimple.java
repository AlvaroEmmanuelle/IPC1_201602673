package practica1_simulador;

public class ListaSimple {
    //punteros para saber donde esta el inicio y fin
    protected Nodo inicio,fin;
    //inicializacion de inicio y fin
    public ListaSimple(){
        inicio=fin=null;
    }
    //metodo para saber si la lista esta vacia o no
    public boolean estaVacia(){
        return inicio==null;
    }
    
    //metodo agregar al inicio
    public void agregarAlInicio(Object dato){
        //creando al Nodo
        inicio= new Nodo(dato,inicio);
        if(fin==null){
            fin=inicio;
            
        }
    }
    public void agregarAlFinal(Object dato){
            if(!estaVacia()){
                fin=fin.siguiente=new Nodo(dato);
            }else{
                inicio=fin=new Nodo(dato);
            }
        
    }
    //metodo para mostrar Lista
    public void mostrarLista(){
        Nodo recorrer = inicio;
        while(recorrer!=null){
            System.out.print("["+recorrer.dato+"]---");
            recorrer = recorrer.siguiente;
            
        }
        
    }
    //metodo para eliminar nodo del inicio
    public Object removerDelInicio(){
        Object dato= inicio.dato;
        if(inicio==fin){
            inicio=fin=null;
        }else{
            inicio=inicio.siguiente;
        }
        return dato;
    }
    public Object removerDelFinal(){
        Object dato = fin.dato;
        if(inicio==fin){
            inicio=fin=null;
        }else{
            Nodo temporal = inicio;
            while(temporal.siguiente!=fin){
                temporal=temporal.siguiente;
            }
            fin=temporal;
            fin.siguiente=null;
        }
        return dato;
    }
    
}
