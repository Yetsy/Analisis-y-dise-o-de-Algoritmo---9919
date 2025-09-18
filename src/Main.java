class HashTable{
    private static class Nodo{
        int clave;String valor;Nodo sig;
        Nodo(int c,String v){clave=c;valor=v;}
    }
    private final Nodo[] tabla;
    private final int capacidad;
    public HashTable(int cap){capacidad=cap;tabla=new Nodo[cap];}
    private int hash(int clave){return clave%capacidad;}
    public void insertar(int clave,String valor){
        int i=hash(clave);Nodo a=tabla[i];
        while(a!=null){if(a.clave==clave){a.valor=valor;return;}a=a.sig;}
        Nodo n=new Nodo(clave,valor);n.sig=tabla[i];tabla[i]=n;
    }
    public String obtener(int clave){
        int i=hash(clave);Nodo a=tabla[i];
        while(a!=null){if(a.clave==clave)return a.valor;a=a.sig;}
        return null;
    }
    public void eliminar(int clave){
        int i=hash(clave);Nodo a=tabla[i],p=null;
        while(a!=null){
            if(a.clave==clave){if(p==null)tabla[i]=a.sig;else p.sig=a.sig;return;}
            p=a;a=a.sig;
        }
    }
    public void mostrar(){
        for(int i=0;i<capacidad;i++){
            System.out.print(i+": ");
            Nodo a=tabla[i];
            while(a!=null){System.out.print("("+a.clave+","+a.valor+") ");a=a.sig;}
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
        h.insertar(8,"Tunque");
        h.mostrar();
        System.out.println("Clave 2 -> "+h.obtener(2));
        h.eliminar(3);
        h.mostrar();
    }
}