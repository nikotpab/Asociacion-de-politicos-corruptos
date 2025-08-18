package co.edu.unbosque.view;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.util.Date;

public class NewPoliticianWindow extends JOptionPane {

	private JTextField txtName, txtId, txtMoney;
	private JDateChooser date;
	private int op;

	public NewPoliticianWindow() {
		txtName = new JTextField();
		txtId = new JTextField();
		date = new JDateChooser();
		txtMoney = new JTextField();

		JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
		panel.add(new JLabel("Nombre:"));
		panel.add(txtName);
		panel.add(new JLabel("Número de cédula:"));
		panel.add(txtId);
		panel.add(new JLabel("date de nacimiento:"));
		panel.add(date);
		panel.add(new JLabel("Dinero robado:"));
		panel.add(txtMoney);

		op = showConfirmDialog(null, panel, "Nueva rata", OK_CANCEL_OPTION);
	}
	
	public boolean ok() {
	    return op == OK_OPTION;
	}


	public JTextField getTxtName() {
		return txtName;
	}

	public void setTxtName(JTextField txtName) {
		this.txtName = txtName;
	}

	public JTextField getTxtId() {
		return txtId;
	}

	public void setTxtId(JTextField txtId) {
		this.txtId = txtId;
	}

	public JTextField getTxtMoney() {
		return txtMoney;
	}

	public void setTxtMoney(JTextField txtMoney) {
		this.txtMoney = txtMoney;
	}

	public JDateChooser getDate() {
		return date;
	}

	public void setDate(JDateChooser date) {
		this.date = date;
	}

	public int getOp() {
		return op;
	}

	public void setOp(int op) {
		this.op = op;
	}

}
