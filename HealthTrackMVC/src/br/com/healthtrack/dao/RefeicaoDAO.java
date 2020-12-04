package br.com.healthtrack.dao;

import java.util.List;

import br.com.healthtrack.bean.Refeicao;
import br.com.healthtrack.exception.DBException;

public interface RefeicaoDAO {
	void create(Refeicao refeicao) throws DBException;
	void update(Refeicao refeicao) throws DBException;
	void delete(int idRefeicao) throws DBException;
	Refeicao getById(int searchId);
	List<Refeicao> getAll();
	List<Refeicao> getAllWithLimit();
}
