package co.edu.unbosque.controller;

import java.util.Date;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.PoliticianDTO;
import co.edu.unbosque.view.PopUpWindow;

public class ControllerService {

	private ModelFacade mf;
	private PopUpWindow puw;

	public ControllerService() {
		mf = new ModelFacade();
		puw = new PopUpWindow();
	}

	public boolean add(String name, int id, long money, Date date) {
		if (mf.getPdao().add(new PoliticianDTO(id, money, date, name))) {
			puw.successAdd();
			return true;
		}
		puw.failedAdd();
		return false;
	}

	public boolean delete(String name, int id, long money, Date date) {
		if (mf.getPdao().delete(new PoliticianDTO(id, 0L, null, null))) {
			puw.successDelete();
			return true;
		}
		puw.faileDelete();
		return false;
	}

	public void print() {
		System.out.println(mf.getPdao().showAll());
	}

	public ModelFacade getMf() {
		return mf;
	}

	public void setMf(ModelFacade mf) {
		this.mf = mf;
	}

}
