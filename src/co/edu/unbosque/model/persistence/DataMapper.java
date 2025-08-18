package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Politician;
import co.edu.unbosque.model.PoliticianDTO;

public class DataMapper {

	public static Politician politicianDTOToPolitician(PoliticianDTO dto) {
		Politician entity;
		entity = new Politician(dto.getId(), dto.getMoneyToRob(), dto.getBirthDate(), dto.getName());
		return entity;
	}

	public static PoliticianDTO politicianToPoliticianDTO(Politician entity) {
		PoliticianDTO dto;
		dto = new PoliticianDTO(entity.getId(), entity.getMoneyToRob(), entity.getBirthDate(), entity.getName());
		return dto;
	}

	public static ArrayList<PoliticianDTO> listPoliticianToListPoliticianDTO(ArrayList<Politician> entityList) {
		ArrayList<PoliticianDTO> dtoList = new ArrayList<>();
		for (Politician m : entityList) {

			dtoList.add(new PoliticianDTO(m.getId(), m.getMoneyToRob(), m.getBirthDate(), m.getName()));

		}
		return dtoList;
	}

	public static ArrayList<Politician> listPoliticianDTOToListPolitician(ArrayList<PoliticianDTO> dtoList) {
		ArrayList<Politician> entityList = new ArrayList<>();
		for (Politician mDTO : entityList) {
			entityList.add(new Politician(mDTO.getId(), mDTO.getMoneyToRob(), mDTO.getBirthDate(), mDTO.getName()));
		}
		return entityList;
	}

}