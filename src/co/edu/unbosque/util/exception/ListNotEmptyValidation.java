package co.edu.unbosque.util.exception;

import java.util.List;

public class ListNotEmptyValidation {
	private ListNotEmptyValidation() {
	}

	public static <T> void validate(List<T> list, String fieldName) {
		if (list == null || list.isEmpty()) {
			throw new IllegalArgumentException("No hay datos en " + fieldName + ".");
		}
	}
}
