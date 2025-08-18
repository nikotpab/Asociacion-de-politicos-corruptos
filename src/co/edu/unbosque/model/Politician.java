package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Date;

public class Politician implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private long moneyToRob;
	private Date birthDate;
	private String name;

	public Politician() {

	}

	public Politician(int id, long moneyToRob, Date birthDate, String name) {
		super();
		this.id = id;
		this.moneyToRob = moneyToRob;
		this.birthDate = birthDate;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getMoneyToRob() {
		return moneyToRob;
	}

	public void setMoneyToRob(long moneyToRob) {
		this.moneyToRob = moneyToRob;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "\nID: " + id + "\nDinero dispuesto a robar: " + moneyToRob + "\nFecha de nacimiento: " + birthDate
				+ "\nNombre:" + name;
	}

}
