package br.com.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.bean.Contato;
import br.com.healthtrack.dao.ContatoDAO;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.singleton.HealthTrackDBConnection;

public class OracleContatoDAO implements ContatoDAO{
private Connection conexao;
	
	
	public void create(Contato contato) throws DBException {
		
		PreparedStatement pstmt = null;
		
		try {
			conexao = HealthTrackDBConnection.getConnection();
			String sql = "INSERT INTO CONTATO (ID_CONTATO, NOME, EMAIL, MENSAGEM) VALUES (SQ_ALIMENTO.NEXTVAL, ?, ?, ?)";
			pstmt = conexao.prepareStatement(sql);
			pstmt.setString(1, contato.getNome());
			pstmt.setString(2, contato.getEmail());
			pstmt.setString(3, contato.getMensagem());
			
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
	
	public List<Contato> getAll() {
		List<Contato> contatoList = new ArrayList<Contato>();
		Contato contato = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conexao = HealthTrackDBConnection.getConnection();
			String sql = "SELECT * FROM CONTATO ORDER BY ID_CONTATO DESC";
			pstmt = conexao.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int numeroId = rs.getInt("ID_CONTATO");
				String nome = rs.getString("NOME");
				String email = rs.getString("EMAIL");
				String mensagem = rs.getString("MENSAGEM");
				
				contato = new Contato(numeroId, nome, email, mensagem);
				contatoList.add(contato);
				
				System.out.println(contato.toString());
				
			}
		}
			catch(SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					conexao.close();
					pstmt.close();
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		
		
		return contatoList;
}

}
