package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ManageAuditoriumPanel extends JPanel {

	private JButton btnBack, btnAccept, btnSort, btnSortMat;
	private JTextArea txtRow, txtCol;
	private JLabel politicianqty;
	private JComboBox<String> op;

	public ManageAuditoriumPanel() {
		setOpaque(true);
		setLayout(null);
		setPreferredSize(new Dimension(1200, 700));
		setBackground(new Color(253, 253, 253));

		ImageIcon imageLogo = new ImageIcon(getClass().getResource("/assets/capital.png"));
		Image imageLblLogo = imageLogo.getImage().getScaledInstance(200, 130, Image.SCALE_SMOOTH);
		JLabel logo = new JLabel(new ImageIcon(imageLblLogo));
		logo.setBounds(0, 10, 171, 105);
		logo.setVerticalAlignment(JLabel.CENTER);

		JLabel title = new JLabel("Administración de auditorio");
		title.setBounds(155, 0, 1100, 105);
		title.setFont(new Font("Consolas", Font.BOLD, 46));
		title.setVerticalAlignment(JLabel.CENTER);

		JLabel row = new JLabel("Número de filas de asientos");
		row.setBounds(50, 140, 1100, 105);
		row.setFont(new Font("Consolas", Font.BOLD, 25));
		row.setVerticalAlignment(JLabel.CENTER);

		txtRow = new JTextArea();
		txtRow.setBounds(50, 240, 380, 50);
		txtRow.setFont(new Font("Consolas", Font.BOLD, 35));
		txtRow.setBackground(new Color(240, 240, 240));

		JLabel col = new JLabel("Número de columnas de asientos");
		col.setBounds(700, 140, 1100, 105);
		col.setFont(new Font("Consolas", Font.BOLD, 25));
		col.setVerticalAlignment(JLabel.CENTER);

		txtCol = new JTextArea();
		txtCol.setBounds(700, 240, 420, 50);
		txtCol.setFont(new Font("Consolas", Font.BOLD, 35));
		txtCol.setBackground(new Color(240, 240, 240));

		btnAccept = new JButton("Generar");
		btnAccept.setBounds(490, 340, 170, 60);
		btnAccept.setFont(new Font("Consolas", Font.BOLD, 35));
		btnAccept.setBackground(new Color(225, 202, 0, 255));
		btnAccept.setToolTipText("Generar información de ladrones");
		btnAccept.setFocusPainted(false);

		politicianqty = new JLabel("Cantidad de ratas en el auditorio: " + 0);
		politicianqty.setBounds(20, 400, 1000, 105);
		politicianqty.setFont(new Font("Consolas", Font.BOLD, 20));

		String[] opp = { "Bubble Sort", "Insertion Sort", "Merge Sort", "Quick Sort", "Selection Sort" };
		op = new JComboBox<>(opp);
		op.setFont(new Font("Consolas", Font.BOLD, 16));
		op.setBounds(20, 500, 200, 50);

		btnSort = new JButton("Organizar miembros");
		btnSort.setBounds(20, 590, 200, 60);
		btnSort.setFont(new Font("Consolas", Font.BOLD, 16));
		btnSort.setBackground(new Color(225, 202, 0, 255));
		btnSort.setToolTipText("Determinar quién roba más");
		btnSort.setFocusPainted(false);

		btnSortMat = new JButton("Organizar matricialmente");
		btnSortMat.setBounds(300, 590, 250, 60);
		btnSortMat.setFont(new Font("Consolas", Font.BOLD, 16));
		btnSortMat.setBackground(new Color(225, 202, 0, 255));
		btnSortMat.setToolTipText("Determinar quién roba más");
		btnSortMat.setFocusPainted(false);

		btnBack = new JButton("Regresar");
		btnBack.setBounds(1015, 590, 150, 60);
		btnBack.setFont(new Font("Consolas", Font.BOLD, 20));
		btnBack.setBackground(new Color(225, 202, 0, 255));
		btnBack.setToolTipText("Volver a la ventana de inicio");
		btnBack.setFocusPainted(false);

		add(title);
		add(logo);
		add(btnBack);
		add(row);
		add(col);
		add(txtRow);
		add(txtCol);
		add(btnAccept);
		add(politicianqty);
		add(op);
		add(btnSort);
		add(btnSortMat);
	}

	public JButton getBtnBack() {
		return btnBack;
	}

	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}

	public JButton getBtnAccept() {
		return btnAccept;
	}

	public void setBtnAccept(JButton btnAccept) {
		this.btnAccept = btnAccept;
	}

	public JTextArea getTxtRow() {
		return txtRow;
	}

	public void setTxtRow(JTextArea txtRow) {
		this.txtRow = txtRow;
	}

	public JTextArea getTxtCol() {
		return txtCol;
	}

	public void setTxtCol(JTextArea txtCol) {
		this.txtCol = txtCol;
	}

	public JLabel getPoliticianqty() {
		return politicianqty;
	}

	public void setPoliticianqty(JLabel politicianqty) {
		this.politicianqty = politicianqty;
	}

	public JButton getBtnSort() {
		return btnSort;
	}

	public void setBtnSort(JButton btnSort) {
		this.btnSort = btnSort;
	}

	public JComboBox<String> getOp() {
		return op;
	}

	public void setOp(JComboBox<String> op) {
		this.op = op;
	}

	public JButton getBtnSortMat() {
		return btnSortMat;
	}

	public void setBtnSortMat(JButton btnSortMat) {
		this.btnSortMat = btnSortMat;
	}

}
