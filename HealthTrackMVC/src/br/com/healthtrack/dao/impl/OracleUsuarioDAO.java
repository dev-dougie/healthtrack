package br.com.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import br.com.healthtrack.bean.Usuario;
import br.com.healthtrack.dao.UsuarioDAO;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.singleton.HealthTrackDBConnection;

public class OracleUsuarioDAO implements UsuarioDAO{
	
	private Connection conexao;
	private Usuario usuario;

	public Usuario getById(int searchId) {
		usuario = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conexao = HealthTrackDBConnection.getConnection();
			String sql = "SELECT * FROM USUARIO WHERE ID_USER = ?";
			pstmt = conexao.prepareStatement(sql);
			pstmt.setInt(1, searchId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt("ID_USER");
				String nome = rs.getString("NM_USER");
				String cpf = rs.getString("CPF_USER");
				String email = rs.getString("EMAIL_USER");
				java.sql.Date data = rs.getDate("DT_NASC");
				Calendar dataNascimento = Calendar.getInstance();
				dataNascimento.setTimeInMillis(data.getTime());
				String sexo = rs.getString("DS_SEXO");
			    sexo.toCharArray();
			    double altura = rs.getDouble("ALT_USER");
			    double peso = rs.getDouble("PESO_USER");
			    String nickname = rs.getString("NICK_USER");
			    String endereco = rs.getString("DS_ENDERECO");
			    String numeroTel = rs.getString("NR_TELEFONE");
			    String senha = rs.getString("DS_SENHA");
   
			    usuario = new Usuario(id, nome, cpf, email, dataNascimento,sexo, altura, peso, nickname, endereco,  numeroTel,  (peso/(altura*altura)), senha);
			   
			    
			    System.out.println(usuario.toString());
			 }
		}
			catch(SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					pstmt.close();
					conexao.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		
		return usuario;
	}
	
	
	public void create(Usuario usuario) throws DBException {
		
		PreparedStatement pstmt = null;
		
		try {
			conexao = HealthTrackDBConnection.getConnection();
			String sql = "INSERT INTO USUARIO (ID_USER, NM_USER, CPF_USER, EMAIL_USER, DT_NASC, DS_SEXO, ALT_USER, PESO_USER, NICK_USER, DS_ENDERECO, NR_TELEFONE, DS_SENHA) VALUES (SQ_USUARIO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conexao.prepareStatement(sql);
			pstmt.setString(1, usuario.getNome());
			pstmt.setString(2, usuario.getCpf());
			pstmt.setString(3, usuario.getEmail());
			java.sql.Date data = new java.sql.Date(usuario.getDataNascimento().getTimeInMillis());
			pstmt.setDate(4, data);
			pstmt.setString(5, usuario.getSexo());
			pstmt.setDouble(6, usuario.getAltura());
			pstmt.setDouble(7, usuario.getPeso());
			pstmt.setString(8, usuario.getNickname());
			pstmt.setString(9, usuario.getEndereco());
			pstmt.setString(10, usuario.getNrTelefone());
			pstmt.setString(11, usuario.getSenha());
	
			
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
	
		
}
