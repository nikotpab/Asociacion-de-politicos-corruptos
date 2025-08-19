package co.edu.unbosque.controller;

import co.edu.unbosque.util.exception.ExceptionChecker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import co.edu.unbosque.model.Politician;
import co.edu.unbosque.model.PoliticianDTO;
import co.edu.unbosque.util.sort.BubbleSort;
import co.edu.unbosque.util.sort.InsertionSort;
import co.edu.unbosque.util.sort.MergeSort;
import co.edu.unbosque.util.sort.QuickSort;
import co.edu.unbosque.util.sort.SelectionSort;
import co.edu.unbosque.view.DeletePoliticianWindow;
import co.edu.unbosque.view.NewPoliticianWindow;
import co.edu.unbosque.view.PoliticianSortWindow;
import co.edu.unbosque.view.PopUpWindow;
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
		vf.getWin().getMap().getBtnAccept().addActionListener(this);
		vf.getWin().getMap().getBtnSort().addActionListener(this);
		vf.getWin().getMap().getBtnSortMat().addActionListener(this);
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
		} else if (e.getSource() == vf.getWin().getMmp().getBtnSort()) {
			sortPolitician();
		} else if (e.getSource() == vf.getWin().getMap().getBtnAccept()) {
			if (generateData() != null)
				PopUpWindow.generated(generateData().length);
		} else if (e.getSource() == vf.getWin().getMap().getBtnSort()) {
			sortGeneratedData();
		} else if (e.getSource() == vf.getWin().getMap().getBtnSortMat()) {
			sortGeneratedDataMat(generateMat());
		}
	}

	public void addPolitician() {
		NewPoliticianWindow popup = new NewPoliticianWindow();
		String name = popup.getTxtName().getText();
		String idTxt = popup.getTxtId().getText();
		String moneyTxt = popup.getTxtMoney().getText();
		Date birth = (popup.getDate() != null) ? popup.getDate().getDate() : null;

		if (popup.ok()) {
			try {
				ExceptionChecker.nonEmpty(name, "El nombre");
				int id = ExceptionChecker.parseInt(idTxt, "Cédula");
				long money = ExceptionChecker.parseLong(moneyTxt, "Dinero robado");
				ExceptionChecker.dateNotNull(birth, "la fecha de nacimiento");
				ExceptionChecker.dateNotFuture(birth, "La fecha de nacimiento");

				if (cs.add(name.trim(), id, money, birth)) {
					updateTable();
				} else {
					PopUpWindow.error();
				}
			} catch (IllegalArgumentException ex) {
				PopUpWindow.error();
			} catch (Throwable t) {
				PopUpWindow.error();
			}
		}
	}

	public void deletePolitician() {
		DeletePoliticianWindow popup = new DeletePoliticianWindow();
		String idTxt = popup.getTxtId().getText();
		if (popup.ok()) {
			try {
				int id = ExceptionChecker.parseInt(idTxt, "Cédula");
				if (cs.delete(null, id, 0L, null)) {
					updateTable();
				} else {
					PopUpWindow.error();
				}
			} catch (IllegalArgumentException ex) {
				PopUpWindow.error();
			} catch (Throwable t) {
				PopUpWindow.error();
			}
		}
	}

	public void sortPolitician() {
		PoliticianSortWindow popup = new PoliticianSortWindow();
		Politician[] p = {};
		if (popup.ok()) {
			orderTable();
			if ("Bubble Sort".equals(popup.getSortAlgList().getSelectedItem())) {
				BubbleSort.bubbleSort(cs.convertArrayListToMat(p));
			}
			if ("Insertion Sort".equals(popup.getSortAlgList().getSelectedItem())) {
				InsertionSort.insertionSort(cs.convertArrayListToMat(p));
			}
			if ("Merge Sort".equals(popup.getSortAlgList().getSelectedItem())) {
				MergeSort.mergeSort(cs.convertArrayListToMat(p));
			}
			if ("Quick Sort".equals(popup.getSortAlgList().getSelectedItem())) {
				QuickSort.quickSort(cs.convertArrayListToMat(p));
			}
			if ("Selection Sort".equals(popup.getSortAlgList().getSelectedItem())) {
				SelectionSort.selectionSort(cs.convertArrayListToMat(p));
			}
		}
	}

	public void updateTable() {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String[] col = { "Nombre", "Cédula", "Dinero robado", "Fecha de nacimiento" };
		Object[][] data = new Object[cs.getMf().getPdao().getAll().size()][4];
		for (int i = 0; i < cs.getMf().getPdao().getAll().size(); i++) {
			data[i][0] = cs.getMf().getPdao().getAll().get(i).getName();
			data[i][1] = String.valueOf(cs.getMf().getPdao().getAll().get(i).getId());
			data[i][2] = String.valueOf(cs.getMf().getPdao().getAll().get(i).getMoneyToRob());
			data[i][3] = df.format(cs.getMf().getPdao().getAll().get(i).getBirthDate());
		}
		DefaultTableModel model = new DefaultTableModel(data, col) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		vf.getWin().getMmp().getTable().setModel(model);
		vf.getWin().getMmp().revalidate();
		vf.getWin().getMmp().repaint();
	}

	public void orderTable() {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String[] col = { "Nombre", "Cédula", "Dinero robado", "Fecha de nacimiento" };
		List<PoliticianDTO> politicians = new ArrayList<>(cs.getMf().getPdao().getAll());
		Collections.sort(politicians);
		Object[][] data = new Object[politicians.size()][4];
		for (int i = 0; i < politicians.size(); i++) {
			PoliticianDTO p = politicians.get(i);
			data[i][0] = p.getName();
			data[i][1] = p.getId();
			data[i][2] = p.getMoneyToRob();
			data[i][3] = df.format(p.getBirthDate());
		}
		DefaultTableModel model = new DefaultTableModel(data, col) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		vf.getWin().getMmp().getTable().setModel(model);
		vf.getWin().getMmp().revalidate();
		vf.getWin().getMmp().repaint();
	}

	public Politician[] generateData() {
		try {
			String colsTxt = vf.getWin().getMap().getTxtCol().getText();
			String rowsTxt = vf.getWin().getMap().getTxtRow().getText();

			int cols = ExceptionChecker.parseInt(colsTxt, "Columnas");
			int rows = ExceptionChecker.parseInt(rowsTxt, "Filas");
			ExceptionChecker.positiveInt(cols, "Columnas");
			ExceptionChecker.positiveInt(rows, "Filas");

			int pc = cols * rows;
			vf.getWin().getMap().getPoliticianqty().setText("Cantidad de ratas en el auditorio: " + pc);

			Politician[] gen = cs.getMf().getPr().generarPoliticos(pc);
			if (gen == null) {
				PopUpWindow.error();
				return null;
			}
			return gen;

		} catch (IllegalArgumentException ex) {
			PopUpWindow.error();
			return null;
		} catch (Throwable t) {
			PopUpWindow.error();
			return null;
		}
	}

	public Politician[][] generateMat() {
		try {
			String colsTxt = vf.getWin().getMap().getTxtCol().getText();
			String rowsTxt = vf.getWin().getMap().getTxtRow().getText();

			int cols = ExceptionChecker.parseInt(colsTxt, "Columnas");
			int rows = ExceptionChecker.parseInt(rowsTxt, "Filas");
			ExceptionChecker.positiveInt(cols, "Columnas");
			ExceptionChecker.positiveInt(rows, "Filas");

			Politician[][] m = cs.getMf().getPr().generarMatrixPoliticos(cols, rows);
			ExceptionChecker.matrixWellFormed(m, "de políticos");
			return m;
		} catch (IllegalArgumentException ex) {
			PopUpWindow.error();
			return null;
		} catch (Throwable t) {
			PopUpWindow.error();
			return null;
		}
	}

	public void sortGeneratedData() {
		try {
			Object sel = vf.getWin().getMap().getOp().getSelectedItem();
			ExceptionChecker.selectionNotNull(sel, "el algoritmo");

			Politician[] datos = generateData();
			if (datos == null || datos.length == 0) {
				PopUpWindow.error();
			}
			String alg = String.valueOf(sel);
			if ("Bubble Sort".equals(alg)) {
				BubbleSort.bubbleSort(datos);
			} else if ("Insertion Sort".equals(alg)) {
				InsertionSort.insertionSort(datos);
			} else if ("Merge Sort".equals(alg)) {
				MergeSort.mergeSort(datos);
			} else if ("Quick Sort".equals(alg)) {
				QuickSort.quickSort(datos);
			} else if ("Selection Sort".equals(alg)) {
				SelectionSort.selectionSort(datos);
			} else {
				PopUpWindow.error();
			}
		} catch (IllegalArgumentException ex) {
			PopUpWindow.error();
		} catch (Throwable t) {
			PopUpWindow.error();
		}
	}

	public void sortGeneratedDataMat(Politician[][] p) {
		try {
			ExceptionChecker.matrixWellFormed(p, "de políticos");
			Object sel = vf.getWin().getMap().getOp().getSelectedItem();
			ExceptionChecker.selectionNotNull(sel, "el algoritmo");

			String alg = String.valueOf(sel);
			if ("Bubble Sort".equals(alg)) {
				BubbleSort.matrixBubbleSort(p);
			} else if ("Insertion Sort".equals(alg)) {
				InsertionSort.matrixInsertionSort(p);
			} else if ("Merge Sort".equals(alg)) {
				MergeSort.matrixMergeSort(p);
			} else if ("Quick Sort".equals(alg)) {
				QuickSort.matrixQuickSort(p);
			} else if ("Selection Sort".equals(alg)) {
				SelectionSort.matrixSelectionSort(p);
			} else {
				PopUpWindow.error();
			}
		} catch (IllegalArgumentException ex) {
			PopUpWindow.error();
		} catch (Throwable t) {
			PopUpWindow.error();
		}
	}

}
