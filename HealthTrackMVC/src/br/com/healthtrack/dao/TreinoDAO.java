package br.com.healthtrack.dao;

import java.util.List;

import br.com.healthtrack.bean.Treino;
import br.com.healthtrack.exception.DBException;

public interface TreinoDAO {
	void create(Treino treino) throws DBException;
	void update(Treino treino) throws DBException;
	void delete(int idTreino) throws DBException;
	Treino getById(int searchId);
	List<Treino> getAll();
	List<Treino> getAllWithLimit();
}
