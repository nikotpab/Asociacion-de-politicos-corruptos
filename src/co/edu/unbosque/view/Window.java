package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class Window extends JFrame {

	private WelcomePanel wp;
	private ManageMemberPanel mmp;
	private ManageAuditoriumPanel map;

	public Window() {
		wp = new WelcomePanel();
		mmp = new ManageMemberPanel();
		map = new ManageAuditoriumPanel();

		setTitle("APOCO");
		setSize(1200, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1300, 700);
		layeredPane.setLayout(null);
		add(layeredPane);
		setVisible(true);
		add(wp);
	}

	public WelcomePanel getWp() {
		return wp;
	}

	public void setWp(WelcomePanel wp) {
		this.wp = wp;
	}

	public ManageMemberPanel getMmp() {
		return mmp;
	}

	public void setMmp(ManageMemberPanel mmp) {
		this.mmp = mmp;
	}

	public ManageAuditoriumPanel getMap() {
		return map;
	}

	public void setMap(ManageAuditoriumPanel map) {
		this.map = map;
	}

}
