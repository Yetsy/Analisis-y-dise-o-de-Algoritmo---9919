class HashTable{
    // Clase interna para representar cada nodo de la lista
    private class Nodo{
        int clave;
        String valor;
        Nodo sig;
        Nodo(int c,String v){
            clave=c;
            valor=v;
            sig=null;
        }
    }

    private Nodo[] tabla;
    private int capacidad;

    public HashTable(int cap){
        capacidad=cap;
        tabla=new Nodo[capacidad];
    }

    private int hash(int clave){
        return clave%capacidad;
    }

    public void insertar(int clave,String valor){
        int indice=hash(clave);
        Nodo actual=tabla[indice];
        while(actual!=null){
            if(actual.clave==clave){
                actual.valor=valor; // si la clave existe, actualiza
                return;
            }
            actual=actual.sig;
        }
        Nodo nuevo=new Nodo(clave,valor);
        nuevo.sig=tabla[indice];
        tabla[indice]=nuevo;
    }

    public String obtener(int clave){
        int indice=hash(clave);
        Nodo actual=tabla[indice];
        while(actual!=null){
            if(actual.clave==clave)return actual.valor;
            actual=actual.sig;
        }
        return null;
    }

    public void eliminar(int clave){
        int indice=hash(clave);
        Nodo actual=tabla[indice],previo=null;
        while(actual!=null){
            if(actual.clave==clave){
                if(previo==null)tabla[indice]=actual.sig;
                else previo.sig=actual.sig;
                return;
            }
            previo=actual;
            actual=actual.sig;
        }
    }

    public void mostrar(){
        for(int i=0;i<capacidad;i++){
            System.out.print(i+": ");
            Nodo actual=tabla[i];
            while(actual!=null){
                System.out.print("("+actual.clave+","+actual.valor+") ");
                actual=actual.sig;
            }
            System.out.println();
        }
    }
}

public class Main{
    public static void main(String[] args){
        HashTable h=new HashTable(5);
        h.insertar(1,"Yetsy");
        h.insertar(2,"Andrea");
        h.insertar(3,"Choque");
        h.insertar(8,"Tunque"); // colisión con clave 3
        h.mostrar();
        System.out.println("Clave 2 -> "+h.obtener(2));
        h.eliminar(3);
        h.mostrar();
    }
}