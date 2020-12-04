package br.com.healthtrack.dao;

import java.util.List;

import br.com.healthtrack.bean.Nutricionista;
import br.com.healthtrack.exception.DBException;

public interface NutricionistaDAO {
	void create(Nutricionista nutricionista) throws DBException;
	void update(Nutricionista nutricionista) throws DBException;
	void delete(int idNutricionista) throws DBException;
	Nutricionista getById(int searchId);
	List<Nutricionista> getAll();
}
