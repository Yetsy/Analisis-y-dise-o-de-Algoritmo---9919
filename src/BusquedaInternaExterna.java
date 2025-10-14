import java.util.*;

public class BusquedaInternaExterna {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] datos = {12, 23, 36, 47, 58, 69, 72, 83, 94};
        System.out.println("=== DEMO: BÚSQUEDA INTERNA Y EXTERNA CON HASH ===");
        System.out.println("Datos internos (en memoria): " + Arrays.toString(datos));

        System.out.print("\nIngrese el número que desea buscar: ");
        int valor = sc.nextInt();

        busquedaInterna(datos, valor);

        busquedaExternaConHash(datos, valor);

        sc.close();
    }

    public static void busquedaInterna(int[] datos, int valor) {
        System.out.println("\n[1] Búsqueda Interna (Lineal en memoria):");
        int comparaciones = 0;

        for (int i = 0; i < datos.length; i++) {
            comparaciones++;
            if (datos[i] == valor) {
                System.out.println("✔ Valor encontrado en la posición " + i +
                        " tras " + comparaciones + " comparaciones.");
                return;
            }
        }

        System.out.println("✘ Valor no encontrado. Comparaciones: " + comparaciones);
    }

    public static void busquedaExternaConHash(int[] datos, int valor) {
        System.out.println("\n[2] Búsqueda Externa (Hashing con Encadenamiento):");

        int tamañoTabla = 5;
        List<List<Integer>> tablaHash = new ArrayList<>();

        for (int i = 0; i < tamañoTabla; i++) {
            tablaHash.add(new LinkedList<>());
        }


        for (int dato : datos) {
            int hash = dato % tamañoTabla;
            tablaHash.get(hash).add(dato);
        }

        System.out.println("Tabla Hash generada (con colisiones):");
        for (int i = 0; i < tamañoTabla; i++) {
            System.out.println("Bucket " + i + ": " + tablaHash.get(i));
        }

        int clave = valor % tamañoTabla;
        int comparaciones = 0;
        System.out.println("\nBuscando en bucket " + clave + "...");
        for (int dato : tablaHash.get(clave)) {
            comparaciones++;
            if (dato == valor) {
                System.out.println("✔ Valor encontrado en el bucket " + clave +
                        " tras " + comparaciones + " comparaciones.");
                return;
            }
        }

        System.out.println("✘ Valor no encontrado. Comparaciones: " + comparaciones);
    }
}