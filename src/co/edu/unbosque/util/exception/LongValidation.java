package co.edu.unbosque.util.exception;

public class LongValidation {
    private LongValidation() {}
    public static long parse(String text, String fieldName) {
        if (text == null || text.trim().isEmpty())
            throw new IllegalArgumentException(fieldName + " no puede estar vacío.");
        try {
            return Long.parseLong(text.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(fieldName + " inválido. Ingresa un número entero (long).");
        }
    }
}
