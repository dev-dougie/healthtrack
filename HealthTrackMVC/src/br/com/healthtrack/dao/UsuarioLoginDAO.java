package br.com.healthtrack.dao;

import br.com.healthtrack.bean.UsuarioLogin;
import br.com.healthtrack.exception.DBException;

public interface UsuarioLoginDAO {
		
	boolean validarUsuario(UsuarioLogin usuarioLogin);
	
	void create(UsuarioLogin usuarioLogin) throws DBException;
}
