package br.com.healthtrack.dao;

import java.util.List;

import br.com.healthtrack.bean.Contato;
import br.com.healthtrack.exception.DBException;

public interface ContatoDAO {
	void create(Contato contato) throws DBException;
	List<Contato> getAll();
}
