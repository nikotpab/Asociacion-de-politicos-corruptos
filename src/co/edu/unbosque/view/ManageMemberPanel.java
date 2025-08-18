package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ManageMemberPanel extends JPanel {

	private JButton btnBack, btnAdd, btnDelete, btnSort;
	private JTable table;

	public ManageMemberPanel() {
		setOpaque(true);
		setLayout(null);
		setPreferredSize(new Dimension(1200, 700));
		setBackground(new Color(253, 253, 253));

		ImageIcon imageLogo = new ImageIcon(getClass().getResource("/assets/capital.png"));
		Image imageLblLogo = imageLogo.getImage().getScaledInstance(200, 130, Image.SCALE_SMOOTH);
		JLabel logo = new JLabel(new ImageIcon(imageLblLogo));
		logo.setBounds(0, 10, 171, 105);
		logo.setVerticalAlignment(JLabel.CENTER);

		JLabel title = new JLabel("Administración de miembros");
		title.setBounds(155, 0, 1100, 105);
		title.setFont(new Font("Consolas", Font.BOLD, 46));
		title.setVerticalAlignment(JLabel.CENTER);

		String[] col = { "Nombre", "Cédula", "Dinero robado", "Fecha de nacimiento" };
		Object[][] data = {};
		DefaultTableModel model = new DefaultTableModel(data, col) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		table = new JTable(model);
		table.setFont(new Font("Consolas", Font.PLAIN, 14));
		table.setRowHeight(28);
		table.getTableHeader().setFont(new Font("Consolas", Font.BOLD, 15));
		table.getTableHeader().setBackground(new Color(225, 202, 0, 255));
		table.setSelectionBackground(new Color(250, 250, 250));
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);

		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(180, 130, 800, 300);

		btnAdd = new JButton("Agregar miembro");
		btnAdd.setBounds(20, 450, 200, 60);
		btnAdd.setFont(new Font("Consolas", Font.BOLD, 16));
		btnAdd.setBackground(new Color(225, 202, 0, 255));
		btnAdd.setToolTipText("Ingresa nuevos ladrones a tu partido");
		btnAdd.setFocusPainted(false);

		btnDelete = new JButton("Eliminar miembro");
		btnDelete.setBounds(20, 520, 200, 60);
		btnDelete.setFont(new Font("Consolas", Font.BOLD, 16));
		btnDelete.setBackground(new Color(225, 202, 0, 255));
		btnDelete.setToolTipText("Si no roba al pueblo, puedes sacarlo");
		btnDelete.setFocusPainted(false);

		btnSort = new JButton("Organizar miembros");
		btnSort.setBounds(20, 590, 200, 60);
		btnSort.setFont(new Font("Consolas", Font.BOLD, 16));
		btnSort.setBackground(new Color(225, 202, 0, 255));
		btnSort.setToolTipText("Determinar quién roba más");
		btnSort.setFocusPainted(false);

		btnBack = new JButton("Regresar");
		btnBack.setBounds(1020, 590, 150, 60);
		btnBack.setFont(new Font("Consolas", Font.BOLD, 20));
		btnBack.setBackground(new Color(225, 202, 0, 255));
		btnBack.setToolTipText("Volver a la ventana de inicio");
		btnBack.setFocusPainted(false);

		add(scroll);
		add(btnBack);
		add(btnAdd);
		add(btnDelete);
		add(btnSort);
		add(logo);
		add(title);

	}

	public JButton getBtnBack() {
		return btnBack;
	}

	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public JButton getBtnSort() {
		return btnSort;
	}

	public void setBtnSort(JButton btnSort) {
		this.btnSort = btnSort;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

}
