package br.com.healthtrack.dao;

import java.util.List;

import br.com.healthtrack.bean.Exercicio;
import br.com.healthtrack.exception.DBException;

public interface ExercicioDAO {
	void create(Exercicio exercicio) throws DBException;
	void update(Exercicio exercicio) throws DBException;
	void delete(int idExercicio) throws DBException;
	Exercicio getById(int searchId);
	List<Exercicio> getAll();
}
