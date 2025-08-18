package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ManageAuditoriumPanel extends JPanel {

	private JButton btnBack;

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

		btnBack = new JButton("Regresar");
		btnBack.setBounds(1020, 590, 150, 60);
		btnBack.setFont(new Font("Consolas", Font.BOLD, 20));
		btnBack.setBackground(new Color(225, 202, 0, 255));
		btnBack.setToolTipText("Volver a la ventana de inicio");
		btnBack.setFocusPainted(false);

		add(title);
		add(logo);
		add(btnBack);
	}

	public JButton getBtnBack() {
		return btnBack;
	}

	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}

}
