package com.mycompany.palindromorecursivo;

/**
 * @author johnf
 */
public class PalindromoRecursivo {

    // Método privado auxiliar (Recursivo) - Oculto al usuario externo
    private static boolean esPalindromo(String palabra, int inicio, int fin) {

        // Caso base
        if (inicio >= fin) {
            return true;
        }

        // Comparar caracteres
        if (palabra.charAt(inicio) != palabra.charAt(fin)) {
            return false;
        }

        // Llamada recursiva
        return esPalindromo(palabra, inicio + 1, fin - 1);
    }

    // Método público Wrapper (Envoltorio)
    public static boolean comprobarPalindromo(String palabra) {

        if (palabra == null) {
            return false;
        }

        palabra = palabra.toLowerCase().replaceAll("\\s+", "");

        return esPalindromo(palabra, 0, palabra.length() - 1);
    }

    public static void main(String[] args) {

        // 10 pruebas
        String[] ejemplos = {
            "reconocer",
            "radar",
            "ana",
            "oso",
            "somos",
            "hola",
            "java",
            "anita lava la tina",
            "12321",
            "a"
        };

        for (String palabra : ejemplos) {
            if (comprobarPalindromo(palabra)) {
                System.out.println("\"" + palabra + "\" -> Es palindromo");
            } else {
                System.out.println("\"" + palabra + "\" -> No es palindromo");
            }
        }
        
        // Verificación de null
        System.out.println("null -> " + (comprobarPalindromo(null) ? "Es palindromo" : "No es palindromo"));
    }
}