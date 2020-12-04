package br.com.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.healthtrack.bean.UsuarioLogin;
import br.com.healthtrack.dao.UsuarioLoginDAO;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.singleton.HealthTrackDBConnection;

public class OracleUsuarioLoginDAO implements UsuarioLoginDAO {
		
		private Connection conexao;
		
		public void create(UsuarioLogin usuarioLogin) throws DBException {
			
			PreparedStatement pstmt = null;
			
			try {
				conexao = HealthTrackDBConnection.getConnection();
				String sql = "INSERT INTO USER_ACCESS (DS_EMAIL, DS_SENHA) VALUES (?, ?)";
				pstmt = conexao.prepareStatement(sql);
				pstmt.setString(1, usuarioLogin.getEmail());
				pstmt.setString(2,  usuarioLogin.getSenha());
				
				pstmt.executeUpdate();
				System.out.println("Dados inseridos com sucesso!");
			}
			catch(SQLException e){
					e.printStackTrace();	
			}
			finally 
			{
				try {
					pstmt.close();
					conexao.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
		};
		
		
		public boolean validarUsuario(UsuarioLogin usuarioLogin) {
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			try {
				conexao = HealthTrackDBConnection.getConnection();
				String sql = "SELECT * FROM USER_ACCESS WHERE DS_EMAIL = ? AND DS_SENHA = ?";
				pstmt = conexao.prepareStatement(sql);
				pstmt.setString(1, usuarioLogin.getEmail());
				pstmt.setString(2, usuarioLogin.getSenha());
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					return true;
				}	
			}
			catch(SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					pstmt.close();
					rs.close();
					conexao.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			return false;
		}
		
	
}
