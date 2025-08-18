package co.edu.unbosque.view;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.util.Date;

public class DeletePoliticianWindow extends JOptionPane {

	private JTextField txtId;
	private int op;

	public DeletePoliticianWindow() {
		txtId = new JTextField();

		JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
		panel.add(new JLabel("Número del que desea eliminar:"));
		panel.add(txtId);

		op = showConfirmDialog(null, panel, "Eliminar rata", OK_CANCEL_OPTION);
	}

	public boolean ok() {
		return op == OK_OPTION;
	}

	public int getOp() {
		return op;
	}

	public void setOp(int op) {
		this.op = op;
	}

	public JTextField getTxtId() {
		return txtId;
	}

	public void setTxtId(JTextField txtId) {
		this.txtId = txtId;
	}

}
