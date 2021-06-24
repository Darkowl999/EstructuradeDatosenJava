package listaenlazada;
public class Lista {
    //puntero que indica el inicio de la lista o conocida tambien como cabeza de la lista
    private Nodo inicio;
    //variable que nos ayuda a registrar el tamaño de la lista
    private int tamanio;

    //constructor
    Lista(){
        this.inicio=null;
        tamanio=0;
    }

    //METODOS BÁSICOS

    //consulta si la lista está vacia
    //retorna true si el primer nodo (inicio), no apunta a otro nodo
    public boolean estaVacia(){
        return inicio==null;
    }
    //retorna cuantos elementos (nodos) tiene la lista
    public int tamanioLista(){
        return tamanio;
    }

    public void agregarAlfinal(int valor){
        Nodo nuevonodo= new Nodo();
        nuevonodo.setValor(valor);
        if(estaVacia()){
            inicio=nuevonodo;
        }else{
            //se crea una copia de la lista
            Nodo nodoauxiliar= inicio;
            //se recorre la lista hasta llegar al ultimo nodo
            while (nodoauxiliar.getSiguiente()!=null){
                nodoauxiliar=nodoauxiliar.getSiguiente();
            }
            //se agrega el nodo al final de la lista
            nodoauxiliar.setSiguiente(nuevonodo);

        }
        tamanio++;
    }

    public void agregarAlInicio(int valor){
        Nodo nuevonodo= new Nodo();
        nuevonodo.setValor(valor
        );
        if (estaVacia()){
            inicio=nuevonodo;
        }else{
            //uno mi nuevo nodo a la lista existente
            nuevonodo.setSiguiente(inicio);
            //renombro el nuevo nodo como el inicio de la lista
            inicio=nuevonodo;
        }
        tamanio++;
    }
    //Inserto un nuevo nodo despues de otro, ubicado por el valor que contiene
    //el parametro referencia es el valor del nodo anterior al nuevo nodo a insertar
    //el parametro valor es el valor del nodo a insertar
    public void insertarPorReferencia(int referencia, int valor){
        //definimos un nuevo nodo
        Nodo nuevonodo= new Nodo();
        nuevonodo.setValor(valor);
        //verificar si esta vacia la lista
        if (!estaVacia()){
            //consultamos si el valor existe en la lista
            if (buscar(referencia)){
                //creo una copia
                Nodo nodoauxiliar=inicio;
                //hacemos un recorrido hasta llegar al nodo de referencia
                while (nodoauxiliar.getValor()!=referencia){
                    nodoauxiliar=nodoauxiliar.getSiguiente();
                }
                //creamos un respaldo o copia de la continuacion de la lista
                Nodo nodosiguiente= nodoauxiliar.getSiguiente();
                //enlazamos el nuevo nodo despues del nodo de referencia
                nodoauxiliar.setSiguiente(nodosiguiente);
                //incrementa en el tamaño de la lista
                tamanio++;
            }
        }
    }
    //METODO PARA INSERTAR POR POSICIÓN
    //Insertar un nuevo nodo despues en una posicion determinada
    //el parametro posicion es el lugar donde se va a insertar el nuevo nodo
    //el valor es lo que ingresaremos en la lista

    public void insertarPorPosicion(int posición, int valor){
        //verificamos si la posicion se encuentra en el rango
        //tiene que ser >=0 y <= que el numero de elementos de la lista
        if (posición>=0 && posición<= tamanio){
            Nodo nuevonodo= new Nodo();
            nuevonodo.setValor(valor);
            //consultamos si el nuevo nodo a ingresar va al inicio de la lista
            if (posición==0){
                //insertamos el nodo al inicio de la lista
                nuevonodo.setSiguiente(inicio);
                inicio=nuevonodo;
            }else{// si el valor a insertar va al final de la lista
                if (posición==tamanio){
                    Nodo nodoauxiliar=inicio;
                    //recorremos la lista hasta llegar al ultimo nodo
                    while (nodoauxiliar.getSiguiente()!=null){
                        nodoauxiliar=nodoauxiliar.getSiguiente();
                    }
                    //insertamos el nuevo nodo despues del ultimo
                    nodoauxiliar.setSiguiente(nuevonodo);
                }else{ //si el nodo a insertar va en medio de la lista
                    Nodo nodoauxiliar2=inicio;
                    //recorremosl la lista hasta llegar al nodo anterior
                    for (int i=0; i<(posición-1);i++){
                        nodoauxiliar2=nodoauxiliar2.getSiguiente();
                    }
                    //guardaremos el nodo siguiente al nodo de la posicion
                    //en el cual vamos a insertar el nuevo nodo
                    Nodo nodosiguiente= nodoauxiliar2.getSiguiente();
                    //insertamos el nuevo nodo con el resto de la lista
                    nuevonodo.setSiguiente(nodosiguiente);

                }

            }
            //incrementamos el tamaño de la lista
            tamanio++;
        }
    }

    //METODO PARA BUSCAR EL NODO
    public boolean buscar(int referencia){
        //crea una copia de la lista
        Nodo nodoauxiliar= inicio;
        boolean encontrado= false;

        while (nodoauxiliar!=null && encontrado!=true){
            //consultar si el valr del nodo es igual al parametro o referencia
            if (referencia== nodoauxiliar.getValor()){
                encontrado=true;
            }else {
                nodoauxiliar=nodoauxiliar.getSiguiente();
            }
        }
        return encontrado;
    }
    //POSICION DEL NODO

    public int damePosicion(int referencia){
        //esta variable almacena la posicion del nodo
        int contador=0;
        //consultar si el valor que busco existe en la lista
        if (buscar(referencia)){
            Nodo nodoauxiliar=inicio;

            //recorrer la lista
            while (referencia!=nodoauxiliar.getValor()){
                //incrementar contador
                contador++;
                nodoauxiliar=nodoauxiliar.getSiguiente();
            }
        }
        return contador;
    }


    public int dameValor(int posicion){
        if (posicion>=0 && posicion<tamanio){
            return inicio.getValor();
        }else{
            //creo una copia
            Nodo nodoauxiliar=inicio;
            for (int i=0; i<posicion;i++){
                nodoauxiliar=nodoauxiliar.getSiguiente();
            }
            //retorno el valor
            return nodoauxiliar.getValor();
        }
    }
    //EDITAR POR REFERENCIA
    //actualiza el valor de un nodo que se encuentre en la lista ubicado por un valor de referencia
    //el parametro referencia es el valor del nodo el cual se desea actualizar
    // valor es el parametro que actualizaremos

    public void editarPorReferencia(int referencia,int valor){
        //consultamos si el valor existe en la lista
        if (buscar(referencia)){
            //creamos una copia de la lista
            Nodo nodoauxiliar=inicio;
            //recorremos la lista hasta llegar al nodo referencia
            while (nodoauxiliar.getValor()!=referencia){
                nodoauxiliar=nodoauxiliar.getSiguiente();
            }
            //actualizamos el valor del nodo
            nodoauxiliar.setValor(valor);
        }

    }
    //EDITAR POR POSICION
    //actualiza el valor de un nodo que se encuentre en la lista ubicado por su posicion
    //posicion es el parametro en la cual se encuentra el nodo a actualizar
    //valor sera el nuevo valor del nodo

    public void editarPorPosicion(int posicion, int valor ){
        //verificamos si la posicion ingresada se encuentra en el rango
        //>=0 y < que el numero de elementos de la lista
        if (posicion>=0 && posicion<tamanio){
            //consultamos si el nodo a eliminar (editar es el primero)
            if (posicion==0){
                //actualizamos el valor del primer nodo
                inicio.setValor(valor);
            }else {//en caso de que el nodo a eliminar esté por el medio
                //o sea el ultimo
                Nodo nodoauxiliar=inicio;
                //recorremos la lista hasta llegar al nodo anterior a eliminar
                for (int i=0;i<posicion;i++){
                    nodoauxiliar=nodoauxiliar.getSiguiente();
                }
                //actualizamos el valor del nodo
                nodoauxiliar.setValor(valor);
            }
        }

    }
    //REMOVER POR REFERENCIA
    //elimina un nodo que se encuentre en la lista ubicado por el valor de referencia
    //el parametro referencia es el nodo que se desea eliminar
    public void removerPorReferencia(int referencia){
        if (buscar(referencia)){
            //consulto si el nodo a eliminar es el primero de la lista
            if (inicio.getValor()==referencia){
                //el primer nodo apunta al siguiente
                inicio=inicio.getSiguiente();
            }else {
                //creo un nodo copia de la lista
                Nodo nodoauxiliar=inicio;
                //recorrer la lista hasta llegar al nodo anterior al de la referencia
                while (nodoauxiliar.getSiguiente().getValor()!=referencia){
                    nodoauxiliar=nodoauxiliar.getSiguiente();
                }
                //guardo el nodo siguiente del nodo a eliminar
                Nodo nodosiguiente= nodoauxiliar.getSiguiente().getSiguiente();
                //enlazo el nodo anterior al de eliminar con el siguiente despues de el
                nodoauxiliar.setSiguiente(nodosiguiente);
            }
        }
    }
    //REMOVER POR POSICION
    //elimina un nodo que se encuentre en la lista ubicado por su posicion
    //posicion es el parametro en el cual se encuentra el nodo a eliminar

    public void removerPorPosicion(int posicion){
        //verficamos si la posicion se encuentra en el rango
        if (posicion>=0 && posicion<tamanio){
            //consultamos si el nodo a eliminar es el primero
            if (posicion==0){
                //elimina el primer nodo apuntando al siguiente
                inicio=inicio.getSiguiente();
            } else { //en caso que el nodo a eliminar esta por el medio o sea el ultimo
                //creamos una copia de la lista
                Nodo nodoauxiliar=inicio;
                //recorremos la lista hasta llegar al nodo anterior al eliminar
                for (int i=0;i<posicion-1;i++){
                    nodoauxiliar=nodoauxiliar.getSiguiente();
                }
                //guardamos el nodo siguiente a eliminar
                Nodo nodosiguiente= nodoauxiliar.getSiguiente();
                //eliminamos la referencia del nodo apuntando al nodo siguiente
                nodoauxiliar.setSiguiente(nodosiguiente.getSiguiente());
            }
            //disminuimos el contador de tamaño de la lista
            tamanio--;
        }
    }




    public void eliminar(){
        //eliminar el valor y la referencia de los demas nodos
        inicio=null;
        tamanio=0;
    }
    //MUESTRA POR PANTALLA LOS ELEMENTOS DE LA LISTA
    public void listar(){
        //verificamos sila lista contiene elementos
        if (!estaVacia()){
            Nodo nodoauxiliar=inicio;
            //variable para la posicion de los elementos de una lista
            int i=0;
            //recorrer
            while (nodoauxiliar!=null){
                System.out.print(i+"["+nodoauxiliar.getValor()+"]"+"->");
                nodoauxiliar=nodoauxiliar.getSiguiente();
                i++;
            }
        }
    }



}
