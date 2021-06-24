package listaenlazada;

public class Nodo {
    //esta variable guarda el valor
    private int valor;
    //esta variable es un apuntador que enlaza al siguiente nodo
    private Nodo siguiente;

    //Constructor por defecto
    Nodo(int valor){
        this.valor=valor;
        this.siguiente=null;
    }
    Nodo(){
        this.valor=valor;
        this.siguiente=null;
    }

    //Getters y Setters


    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
