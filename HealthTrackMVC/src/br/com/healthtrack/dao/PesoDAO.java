package br.com.healthtrack.dao;

import java.util.List;
import br.com.healthtrack.bean.Peso;
import br.com.healthtrack.exception.DBException;

public interface PesoDAO {
	void create(Peso peso) throws DBException;
	void update(Peso peso) throws DBException;
	void delete(int idPeso) throws DBException;
	Peso getById(int searchId);
	List<Peso> getAll();
	List<Peso> getAllWithLimit();
}
