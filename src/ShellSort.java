
import java.util.Arrays;

    public class ShellSort {

        // Shell con gap = n/2, n/=2
        public static void shellSortBasic(int[] arr) {
            int n = arr.length;
            for (int gap = n / 2; gap > 0; gap /= 2) {
                for (int i = gap; i < n; i++) {
                    int temp = arr[i];
                    int j = i;
                    while (j >= gap && arr[j - gap] > temp) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }

        // Shell usando secuencia de Ciura
        public static void shellSortCiura(int[] arr) {
            int n = arr.length;
            int[] ciura = {701, 301, 132, 57, 23, 10, 4, 1};
            for (int gap : ciura) {
                if (gap >= n) continue;
                for (int i = gap; i < n; i++) {
                    int temp = arr[i];
                    int j = i;
                    while (j >= gap && arr[j - gap] > temp) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }

        // Prueba rápida
        public static void main(String[] args) {
            int[] arr = {23, 12, 1, 8, 34, 54, 2, 3};
            System.out.println("Original: " + Arrays.toString(arr));

            int[] b1 = arr.clone();
            shellSortBasic(b1);
            System.out.println("Shell basic: " + Arrays.toString(b1));

            int[] b2 = arr.clone();
            shellSortCiura(b2);
            System.out.println("Shell Ciura: " + Arrays.toString(b2));
        }
    }

