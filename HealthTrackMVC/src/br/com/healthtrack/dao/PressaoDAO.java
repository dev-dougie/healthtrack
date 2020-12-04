package br.com.healthtrack.dao;

import java.util.List;

import br.com.healthtrack.bean.Pressao;
import br.com.healthtrack.exception.DBException;

public interface PressaoDAO {
	void create(Pressao pressao) throws DBException;
	void update(Pressao pressao) throws DBException;
	void delete(int idPeso) throws DBException;
	Pressao getById(int searchId);
	List<Pressao> getAll();
	List<Pressao> getAllWithLimit();
}
