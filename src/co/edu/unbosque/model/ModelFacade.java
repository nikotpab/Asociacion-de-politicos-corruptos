package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.PoliticianDAO;

public class ModelFacade {

	private PoliticianDAO pdao;
	private PoliticianRepository pr;

	public ModelFacade() {
		pdao = new PoliticianDAO();
		pr = new PoliticianRepository();
	}

	public PoliticianDAO getPdao() {
		return pdao;
	}

	public void setPdao(PoliticianDAO pdao) {
		this.pdao = pdao;
	}

	public PoliticianRepository getPr() {
		return pr;
	}

	public void setPr(PoliticianRepository pr) {
		this.pr = pr;
	}

}
