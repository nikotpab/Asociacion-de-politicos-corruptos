package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.PoliticianDAO;

public class ModelFacade {

	private PoliticianDAO pdao;

	public ModelFacade() {
		pdao = new PoliticianDAO();
	}

	public PoliticianDAO getPdao() {
		return pdao;
	}

	public void setPdao(PoliticianDAO pdao) {
		this.pdao = pdao;
	}

}
