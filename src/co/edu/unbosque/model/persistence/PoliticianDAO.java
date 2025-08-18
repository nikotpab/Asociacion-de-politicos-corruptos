package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Politician;
import co.edu.unbosque.model.PoliticianDTO;

public class PoliticianDAO implements CRUDOperation<PoliticianDTO, Politician> {

	private ArrayList<Politician> listCriminals;
	private final String SERIAL_NAME = "criminals.dat";

	public PoliticianDAO() {
		FileHandler.checkFolder();
		readSerialized();
	}

	@Override
	public String showAll() {
		String rta = "";
		if (listCriminals.isEmpty()) {
			return "No hay datos en la lista";
		} else {
			for (Politician Politician : listCriminals) {
				rta += Politician.toString() + "\n";
			}
			return rta;
		}
	}

	@Override
	public ArrayList<PoliticianDTO> getAll() {
		return DataMapper.listPoliticianToListPoliticianDTO(listCriminals);
	}

	@Override
	public boolean add(PoliticianDTO newData) {
		if (find(DataMapper.politicianDTOToPolitician(newData)) == null) {
			listCriminals.add(DataMapper.politicianDTOToPolitician(newData));
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean delete(PoliticianDTO toDelete) {
		Politician found = find(DataMapper.politicianDTOToPolitician(toDelete));
		if (found != null) {
			listCriminals.remove(found);
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Politician find(Politician toFind) {
		Politician found = null;
		if (!listCriminals.isEmpty()) {
			for (Politician p : listCriminals) {
				if (p.getId() == toFind.getId()) {
					found = p;
					return found;
				} else {
					continue;
				}
			}
		} else {
			return null;
		}
		return null;
	}

	public void writeSerialized() {
		FileHandler.writeSerialized(SERIAL_NAME, listCriminals);
	}

	public void readSerialized() {
		Object content = FileHandler.readSerialized(SERIAL_NAME);
		if (content == null) {
			listCriminals = new ArrayList<>();
		} else {
			listCriminals = (ArrayList<Politician>) content;
		}
	}

}