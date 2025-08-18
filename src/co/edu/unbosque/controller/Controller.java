package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.view.DeletePoliticianWindow;
import co.edu.unbosque.view.NewPoliticianWindow;
import co.edu.unbosque.view.ViewFacade;

public class Controller implements ActionListener {

	private ViewFacade vf;
	private ControllerService cs;

	public Controller() {
		vf = new ViewFacade();
		cs = new ControllerService();
		listeners();
	}

	public void listeners() {
		vf.getWin().getWp().getBtnExit().addActionListener(this);
		vf.getWin().getWp().getBtnManageAuditorium().addActionListener(this);
		vf.getWin().getWp().getBtnManageMembers().addActionListener(this);

		vf.getWin().getMmp().getBtnBack().addActionListener(this);
		vf.getWin().getMmp().getBtnAdd().addActionListener(this);
		vf.getWin().getMmp().getBtnDelete().addActionListener(this);
		vf.getWin().getMmp().getBtnSort().addActionListener(this);

		vf.getWin().getMap().getBtnBack().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vf.getWin().getWp().getBtnExit()) {
			System.exit(0);
		} else if (e.getSource() == vf.getWin().getWp().getBtnManageMembers()) {
			vf.getWin().remove(vf.getWin().getWp());
			vf.getWin().add(vf.getWin().getMmp());
			updateTable();
			vf.getWin().revalidate();
			vf.getWin().repaint();
		} else if (e.getSource() == vf.getWin().getWp().getBtnManageAuditorium()) {
			vf.getWin().remove(vf.getWin().getWp());
			vf.getWin().add(vf.getWin().getMap());
			vf.getWin().revalidate();
			vf.getWin().repaint();
		} else if (e.getSource() == vf.getWin().getMmp().getBtnBack()) {
			vf.getWin().remove(vf.getWin().getMmp());
			vf.getWin().add(vf.getWin().getWp());
			vf.getWin().revalidate();
			vf.getWin().repaint();
		} else if (e.getSource() == vf.getWin().getMap().getBtnBack()) {
			vf.getWin().remove(vf.getWin().getMap());
			vf.getWin().add(vf.getWin().getWp());
			vf.getWin().revalidate();
			vf.getWin().repaint();
		} else if (e.getSource() == vf.getWin().getMmp().getBtnAdd()) {
			addPolitician();
		} else if (e.getSource() == vf.getWin().getMmp().getBtnDelete()) {
			deletePolitician();

		}

	}

	public void addPolitician() {
		NewPoliticianWindow popup = new NewPoliticianWindow();
		String name = popup.getTxtName().getText();
		int id = Integer.valueOf(popup.getTxtId().getText());
		long money = Long.valueOf(popup.getTxtMoney().getText());
		Date birth = popup.getDate().getDate();
		if (popup.ok()) {
			if (cs.add(name, id, money, birth)) {
				updateTable();
			}
		}

	}

	public void deletePolitician() {
		DeletePoliticianWindow popup = new DeletePoliticianWindow();
		int id = Integer.valueOf(popup.getTxtId().getText());
		if (popup.ok()) {
			if (cs.delete(null, id, 0L, null)) {
				updateTable();
			}
		}
	}

	public void updateTable() {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String[] col = { "Nombre", "ID", "Dinero robado", "Fecha de nacimiento" };
		Object[][] data = new Object[cs.getMf().getPdao().getAll().size()][4];
		for (int i = 0; i < cs.getMf().getPdao().getAll().size(); i++) {
			data[i][0] = cs.getMf().getPdao().getAll().get(i).getName();
			data[i][1] = String.valueOf(cs.getMf().getPdao().getAll().get(i).getId());
			data[i][2] = String.valueOf(cs.getMf().getPdao().getAll().get(i).getMoneyToRob());
			data[i][3] = df.format(cs.getMf().getPdao().getAll().get(i).getBirthDate());
		}
		vf.getWin().getMmp().getTable().setModel(new DefaultTableModel(data, col));
		vf.getWin().getMmp().revalidate();
		vf.getWin().getMmp().repaint();
	}
}
