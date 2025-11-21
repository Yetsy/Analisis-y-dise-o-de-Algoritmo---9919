public class RecursividadIndirecta {

    static void funcionA(int n) {
        if (n <= 0) {
            System.out.println("Fin de A");
            return;
        }
        System.out.println("A: " + n);
        funcionB(n - 1);  // A llama a B
    }

    static void funcionB(int n) {
        if (n <= 0) {
            System.out.println("Fin de B");
            return;
        }
        System.out.println("B: " + n);
        funcionA(n - 2);  // B llama a A
    }

    public static void main(String[] args) {
        funcionA(5); // Se inicia llamando a A
    }
}
