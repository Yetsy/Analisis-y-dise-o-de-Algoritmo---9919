import java.util.Scanner;

public class FactorialComparacion {

    // -------------------------
    // MÉTODO ITERATIVO
    // -------------------------
    public static long factorialIterativo(int n) {
        long resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    // -------------------------
    // MÉTODO RECURSIVO
    // -------------------------
    public static long factorialRecursivo(int n) {
        if (n == 0 || n == 1) {
            return 1; // Caso base
        }
        return n * factorialRecursivo(n - 1); // Llamada recursiva
    }

    // -------------------------
    // PROGRAMA PRINCIPAL
    // -------------------------
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número para calcular su factorial: ");
        int n = scanner.nextInt();

        long iterativo = factorialIterativo(n);
        long recursivo = factorialRecursivo(n);

        System.out.println("\n----- RESULTADOS -----");
        System.out.println("Factorial Iterativo: " + iterativo);
        System.out.println("Factorial Recursivo: " + recursivo);
    }
}
