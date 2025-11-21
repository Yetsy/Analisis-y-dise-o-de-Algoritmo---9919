import java.util.Scanner;

public class Busquedas {

    // -------------------------
    // BÚSQUEDA LINEAL
    // -------------------------
    public static int busquedaLineal(int[] arreglo, int objetivo) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == objetivo) {
                return i;
            }
        }
        return -1;
    }

    // -------------------------
    // BÚSQUEDA BINARIA
    // -------------------------
    public static int busquedaBinaria(int[] arreglo, int objetivo) {
        int inicio = 0;
        int fin = arreglo.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;

            if (arreglo[medio] == objetivo) {
                return medio;
            }

            if (arreglo[medio] < objetivo) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        return -1;
    }

    // -------------------------
    // PROGRAMA PRINCIPAL
    // -------------------------
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear arreglo
        System.out.print("Ingrese el tamaño del arreglo: ");
        int n = scanner.nextInt();

        int[] arreglo = new int[n];

        System.out.println("Ingrese los elementos del arreglo (para busqueda binaria deben estar ordenados):");
        for (int i = 0; i < n; i++) {
            arreglo[i] = scanner.nextInt();
        }

        // Valor a buscar
        System.out.print("Ingrese el número a buscar: ");
        int objetivo = scanner.nextInt();

        // Elegir tipo de búsqueda
        System.out.println("\nSeleccione el tipo de búsqueda:");
        System.out.println("1. Búsqueda Lineal");
        System.out.println("2. Búsqueda Binaria");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();

        int resultado;

        switch (opcion) {
            case 1:
                resultado = busquedaLineal(arreglo, objetivo);
                if (resultado != -1)
                    System.out.println("Lineal: Número encontrado en la posición " + resultado);
                else
                    System.out.println("Lineal: Número NO encontrado.");
                break;

            case 2:
                resultado = busquedaBinaria(arreglo, objetivo);
                if (resultado != -1)
                    System.out.println("Binaria: Número encontrado en la posición " + resultado);
                else
                    System.out.println("Binaria: Número NO encontrado.");
                break;

            default:
                System.out.println("Opción inválida.");
        }
    }
}
