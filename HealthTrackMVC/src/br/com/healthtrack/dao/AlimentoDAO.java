package br.com.healthtrack.dao;

import java.util.List;

import br.com.healthtrack.bean.Alimento;
import br.com.healthtrack.exception.DBException;

public interface AlimentoDAO {
	void create(Alimento alimento) throws DBException;
	void update(Alimento alimento) throws DBException;
	void delete(int idAlimento) throws DBException;
	Alimento getById(int searchId);
	List<Alimento> getAll();
}
