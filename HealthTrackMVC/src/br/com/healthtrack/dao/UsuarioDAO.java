package br.com.healthtrack.dao;

import br.com.healthtrack.bean.Usuario;
import br.com.healthtrack.exception.DBException;

public interface UsuarioDAO {
	Usuario getById(int searchID);
	void create(Usuario usuario) throws DBException;
}
