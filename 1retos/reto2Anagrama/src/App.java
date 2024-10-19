import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        String palabra1, palabra2;
        do {
            System.out.println("Introduce la primera palabra");
            palabra1 = sc.nextLine();
            System.out.println("Introduce la segunda palabra");
            palabra2 = sc.nextLine();
        } while (palabra1.isEmpty() || palabra2.isEmpty());

        sc.close();
        esAnagrama(palabra1, palabra2);

    }

    static void esAnagrama(String p1, String p2) {
        // Un anagrama es una palabra que resulta del cambio del orden de los caracteres
        // de otra.
        // Ejemplos de anagramas son la palabra amor, ramo o mora.
        // Implementa un método llamado esAnagrama. Dicho método recibe dos palabras y
        // devuelve si son anagramas la una de la otra.
        String p1anagrama = "";
        char[] p1revers = p1.toCharArray();
        for (int i = p1revers.length - 1; i >= 0; i--) {
            p1anagrama = p1anagrama + p1revers[i];
        }

        if (p2.equalsIgnoreCase(p1anagrama)) {
            System.out.println(p1 + " y " + p2 + " son anagramas");
        } else {
            System.out.println(p1 + " y " + p2 + " no son anagramas");
        }
    }
}
