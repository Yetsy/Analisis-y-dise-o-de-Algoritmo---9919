public class HashTable {
    private class Nodo{
        int clave;String valor;Nodo sig;
        Nodo(int c,String v){clave=c;valor=v;}
    }
    private Nodo[] tabla;int cap;
    public HashTable(int c){cap=c;tabla=new Nodo[c];}
    private int hash(int k){return k%cap;}
    public void put(int k,String v){
        int i=hash(k);Nodo n=tabla[i];
        while(n!=null){if(n.clave==k){n.valor=v;return;}n=n.sig;}
        Nodo nuevo=new Nodo(k,v);nuevo.sig=tabla[i];tabla[i]=nuevo;
    }
    public String get(int k){
        int i=hash(k);Nodo n=tabla[i];
        while(n!=null){if(n.clave==k)return n.valor;n=n.sig;}
        return null;
    }
    public void remove(int k){
        int i=hash(k);Nodo n=tabla[i],p=null;
        while(n!=null){
            if(n.clave==k){if(p==null)tabla[i]=n.sig;else p.sig=n.sig;return;}
            p=n;n=n.sig;
        }
    }
    public void mostrar(){
        for(int i=0;i<cap;i++){
            System.out.print(i+":");
            Nodo n=tabla[i];
            while(n!=null){System.out.print("("+n.clave+","+n.valor+")");n=n.sig;}
            System.out.println();
        }
    }
}
public class Main{
    public static void main(String[] args){
        HashTable h=new HashTable(5);
        h.put(1,"Yetsy");
        h.put(2,"Andrea");
        h.put(3,"Choque");
        h.put(8,"Tunque"); // colisión con 3
        h.mostrar();
        System.out.println("Clave 2:"+h.get(2));
        h.remove(3);
        h.mostrar();
    }
}