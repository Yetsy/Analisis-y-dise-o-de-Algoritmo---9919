public class BacktrackingEjemplo {

    static void generar(String prefijo, int n) {
        // Caso base
        if (n == 0) {
            System.out.println(prefijo);
            return;
        }

        // Conjunto de opciones
        char[] letras = {'A', 'B', 'C'};

        // Recorrer todas las opciones
        for (char letra : letras) {
            generar(prefijo + letra, n - 1); // Avanza
        }
    }

    public static void main(String[] args) {
        generar("", 3); // Generar combinaciones de longitud 3
    }
}
