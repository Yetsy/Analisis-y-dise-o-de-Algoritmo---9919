import java.util.*;

public class algoritmo {

    public static boolean buscarElemento(int[] arr, int x) {
        for (int n : arr) if (n == x) return true;
        return false;
    }

    public static void seleccion(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[min]) min = j;
            int t = arr[min]; arr[min] = arr[i]; arr[i] = t;
        }
    }

    public static void fusionNatural(int[] arr) {
        int[] aux = arr.clone(); boolean ordenado;
        do {
            int i = 0; ordenado = true;
            while (i < arr.length - 1) {
                int m = i; while (m < arr.length - 1 && arr[m] <= arr[m+1]) m++;
                if (m == arr.length - 1) break;
                int f = m+1; while (f < arr.length - 1 && arr[f] <= arr[f+1]) f++;
                fusionar(arr, aux, i, m, f);
                i = f+1; ordenado = false;
            }
        } while (!ordenado);
    }
    private static void fusionar(int[] arr, int[] aux, int ini, int med, int fin) {
        System.arraycopy(arr, ini, aux, ini, fin - ini + 1);
        int i = ini, j = med+1, k = ini;
        while (i <= med && j <= fin) arr[k++] = (aux[i] <= aux[j]) ? aux[i++] : aux[j++];
        while (i <= med) arr[k++] = aux[i++];
        while (j <= fin) arr[k++] = aux[j++];
    }


    public static void mezclaEquilibrada(int[][] listas) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[] idx = new int[listas.length];
        for (int i = 0; i < listas.length; i++)
            if (listas[i].length > 0) pq.add(new int[]{listas[i][0], i});

        while (!pq.isEmpty()) {
            int[] min = pq.poll();
            System.out.print(min[0] + " ");
            if (++idx[min[1]] < listas[min[1]].length)
                pq.add(new int[]{listas[min[1]][idx[min[1]]], min[1]});
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] datos = {64, 25, 12, 22, 11};
        System.out.println("Buscar 22: " + buscarElemento(datos, 22));

        seleccion(datos);
        System.out.println("Selección: " + Arrays.toString(datos));

        int[] datos2 = {5, 2, 8, 3, 9, 1};
        fusionNatural(datos2);
        System.out.println("Fusión natural: " + Arrays.toString(datos2));

        int[][] listas = {{1, 4, 7}, {2, 5, 8}, {0, 6, 9}};
        System.out.print("Mezcla equilibrada: ");
        mezclaEquilibrada(listas);
    }
}
