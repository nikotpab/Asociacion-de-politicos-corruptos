package co.edu.unbosque.util.exception;

public class SelectionNotNullValidation {
	private SelectionNotNullValidation() {
	}

	public static void validate(Object selection, String fieldName) {
		if (selection == null) {
			throw new IllegalArgumentException("Selecciona " + fieldName + " válido.");
		}
		String s = String.valueOf(selection).trim();
		if (s.isEmpty()) {
			throw new IllegalArgumentException("Selecciona " + fieldName + " válido.");
		}
	}
}
