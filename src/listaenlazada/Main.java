package listaenlazada;

public class Main {
    static Lista lista = new Lista();

    public static void main(String[] args) {
        System.out.println("Lista de ejemplo");

        //AGREGAR ELEMENTOS
        lista.agregarAlInicio(12);
        lista.agregarAlInicio(11);
        lista.agregarAlInicio(5);
        lista.agregarAlInicio(3);
        lista.agregarAlInicio(1);
        lista.agregarAlInicio(9);
        System.out.println("lista ");
        lista.listar();
        System.out.println(lista.tamanioLista());
    }
}
