package co.edu.unbosque.view;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomePanel extends JPanel {

	private JButton btnManageMembers, btnManageAuditorium, btnExit;

	public WelcomePanel() {
		setOpaque(true);
		setLayout(null);
		setPreferredSize(new Dimension(1200, 700));
		setBackground(new Color(253, 253, 253));

		JLabel title = new JLabel("APOCO: Asociación de Políticos Corruptos");
		title.setBounds(155, 0, 1100, 105);
		title.setFont(new Font("Consolas", Font.BOLD, 46));
		title.setVerticalAlignment(JLabel.CENTER);

		ImageIcon imageLogo = new ImageIcon(getClass().getResource("/assets/capital.png"));
		Image imageLblLogo = imageLogo.getImage().getScaledInstance(200, 130, Image.SCALE_SMOOTH);
		JLabel logo = new JLabel(new ImageIcon(imageLblLogo));
		logo.setBounds(0, 10, 171, 105);
		logo.setVerticalAlignment(JLabel.CENTER);

		btnManageMembers = new JButton("Administrar miembros");
		btnManageMembers.setBounds(450, 180, 300, 100);
		btnManageMembers.setFont(new Font("Consolas", Font.BOLD, 20));
		btnManageMembers.setBackground(new Color(225, 202, 0, 255));
		btnManageMembers.setToolTipText("Agrega y elimina miembros de tu red criminal");
		btnManageMembers.setFocusPainted(false);

		btnManageAuditorium = new JButton("Administrar auditorio");
		btnManageAuditorium.setBounds(450, 420, 300, 100);
		btnManageAuditorium.setFont(new Font("Consolas", Font.BOLD, 20));
		btnManageAuditorium.setBackground(new Color(225, 202, 0, 255));
		btnManageAuditorium.setToolTipText("Organiza a tus hampones dentro del auditorio");
		btnManageAuditorium.setFocusPainted(false);

		btnExit = new JButton("Salir");
		btnExit.setBounds(1070, 590, 100, 60);
		btnExit.setFont(new Font("Consolas", Font.BOLD, 20));
		btnExit.setBackground(new Color(225, 202, 0, 255));
		btnExit.setToolTipText("Espero que regreses para seguir robando");
		btnExit.setFocusPainted(false);

		add(logo);
		add(title);
		add(btnManageMembers);
		add(btnManageAuditorium);
		add(btnExit);

	}

	public JButton getBtnManageMembers() {
		return btnManageMembers;
	}

	public void setBtnManageMembers(JButton btnManageMembers) {
		this.btnManageMembers = btnManageMembers;
	}

	public JButton getBtnManageAuditorium() {
		return btnManageAuditorium;
	}

	public void setBtnManageAuditorium(JButton btnManageAuditorium) {
		this.btnManageAuditorium = btnManageAuditorium;
	}

	public JButton getBtnExit() {
		return btnExit;
	}

	public void setBtnExit(JButton btnExit) {
		this.btnExit = btnExit;
	}

}
