package co.edu.unbosque.view;

import java.util.Properties;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.persistence.FileHandler;

public class PopUpWindow {

	private JOptionPane message;

	public PopUpWindow() {

	}

	public void successAdd() {
		message.showMessageDialog(null, "Corrupto agregado exitosamente");
	}

	public void failedAdd() {
		message.showMessageDialog(null, "No se pudo agregar corrupto");
	}

	public void successDelete() {
		message.showMessageDialog(null, "Corrupto eliminado exitosamente");
	}

	public void faileDelete() {
		message.showMessageDialog(null, "No se pudo eliminar corrupto");
	}

}
