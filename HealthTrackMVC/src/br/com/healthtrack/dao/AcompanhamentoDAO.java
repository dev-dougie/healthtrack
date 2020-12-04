package br.com.healthtrack.dao;

import java.util.List;

import br.com.healthtrack.bean.Acompanhamento;
import br.com.healthtrack.exception.DBException;

public interface AcompanhamentoDAO {
	void create(Acompanhamento acompanhamento) throws DBException;
	void update(Acompanhamento acompanhamento) throws DBException;
	void delete(int idAcompanhamento) throws DBException;
	Acompanhamento getById(int searchId);
	List<Acompanhamento> getAll();
}
