package co.edu.unbosque.util.exception;

public final class MatrixWellFormedValidation {
	private MatrixWellFormedValidation() {
	}

	public static <T> void validate(T[][] m, String fieldName) {
		if (m == null || m.length == 0 || m[0] == null) {
			throw new IllegalArgumentException("La matriz " + fieldName + " está vacía o mal formada.");
		}
	}
}
