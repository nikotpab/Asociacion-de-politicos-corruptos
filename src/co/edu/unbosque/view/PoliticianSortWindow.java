package co.edu.unbosque.view;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.util.Date;

public class PoliticianSortWindow extends JOptionPane {

	private JComboBox<String> sortAlgList;
	private int op;

	public PoliticianSortWindow() {
		String[] opp = { "Bubble Sort", "Insertion Sort", "Merge Sort", "Quick Sort", "Selection Sort" };
		sortAlgList = new JComboBox<>(opp);

		JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
		panel.add(new JLabel("Ingrese el algoritmo con el cual desea organanizar los politicos:"));
		panel.add(sortAlgList);

		op = showConfirmDialog(null, panel, "Nueva rata", OK_CANCEL_OPTION);
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

	public JComboBox<String> getSortAlgList() {
		return sortAlgList;
	}

	public void setSortAlgList(JComboBox<String> sortAlgList) {
		this.sortAlgList = sortAlgList;
	}

}
