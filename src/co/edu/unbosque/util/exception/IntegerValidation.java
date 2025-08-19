package co.edu.unbosque.util.exception;

public class IntegerValidation {
    private IntegerValidation() {}
    public static int parse(String text, String fieldName) {
        if (text == null || text.trim().isEmpty())
            throw new IllegalArgumentException(fieldName + " no puede estar vacío.");
        try {
            return Integer.parseInt(text.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(fieldName + " inválido. Ingresa un entero (sin letras).");
        }
    }
}