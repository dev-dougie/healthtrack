package br.com.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.bean.Acompanhamento;
import br.com.healthtrack.bean.Nutricionista;
import br.com.healthtrack.bean.Usuario;
import br.com.healthtrack.dao.AcompanhamentoDAO;
import br.com.healthtrack.singleton.HealthTrackDBConnection;

public class OracleAcompanhamentoDAO implements AcompanhamentoDAO{
		
	private Connection conexao;
	
	public void create(Acompanhamento acompanhamento) {
		PreparedStatement pstmt = null;
		
		try {
			conexao = HealthTrackDBConnection.getConnection();
			String sql = "INSERT INTO ACOMPANHAMENTO (ID_ACOMPANHAMENTO, ID_USER, ID_NUTRI, TIPO_ACOMPANHAMENTO, DS_ACOMPANHAMENTO, ST_ACOMPANHAMENTO)"
					+ "  VALUES (SQ_ACOMPANHAMENTO.NEXTVAL, ?, ?, ?, ?, ?)";
			pstmt = conexao.prepareStatement(sql);
			pstmt.setInt(1, acompanhamento.getIdUsuario().getId());
			pstmt.setInt(2, acompanhamento.getIdNutricionista().getId());
			pstmt.setString(3, acompanhamento.getTipoAcompanhamento());
			pstmt.setString(4, acompanhamento.getDescricao());
			pstmt.setString(5, acompanhamento.getStatus());
		
			
			pstmt.executeUpdate();
			
			System.out.println("Valores inseridos com sucesso!");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conexao.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
}
		
	public Acompanhamento getById(int searchId) {
		Acompanhamento acompanhamento = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conexao = HealthTrackDBConnection.getConnection();
			String sql = "SELECT "
					   + "A.ID_ACOMPANHAMENTO,"
					   + "N.ID_NUTRI,"
					   + "N.NM_NUTRI,"
					   + "U.ID_USER,"
					   + "U.NM_USER,"
					   + "A.TIPO_ACOMPANHAMENTO,"
					   + "A.DS_ACOMPANHAMENTO,"
					   + "A.ST_ACOMPANHAMENTO"
					   + " FROM ACOMPANHAMENTO A INNER JOIN NUTRICIONISTA N ON A.ID_NUTRI = N.ID_NUTRI INNER JOIN USUARIO U ON A.ID_USER = U.ID_USER WHERE ID_ACOMPANHAMENTO = ?";
			pstmt = conexao.prepareStatement(sql);
			pstmt.setInt(1, searchId);
			
			rs = pstmt.executeQuery();
			acompanhamento = new Acompanhamento();
			Usuario usuario = new Usuario();
			Nutricionista nutricionista = new Nutricionista();
					
			if(rs.next()) {
				
				acompanhamento.setId(rs.getInt("ID_ACOMPANHAMENTO"));
				
				usuario = new Usuario();
				usuario.setId(rs.getInt("ID_USER"));
				usuario.setNome(rs.getString("NM_USER"));
				acompanhamento.setIdUsuario(usuario);
				
				nutricionista = new Nutricionista();
				
				nutricionista.setId(rs.getInt("ID_NUTRI"));
				nutricionista.setNome(rs.getString("NM_NUTRI"));
				acompanhamento.setIdNutricionista(nutricionista);
				
				
				acompanhamento.setTipoAcompanhamento(rs.getString("TIPO_ACOMPANHAMENTO"));
				acompanhamento.setDescricao(rs.getString("DS_ACOMPANHAMENTO"));
				acompanhamento.setStatus(rs.getString("ST_ACOMPANHAMENTO"));
				
				
				System.out.println(acompanhamento.toString());
				
				
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conexao.close();
				rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return acompanhamento;
	}
	
	public void update(Acompanhamento acompanhamento) {
		PreparedStatement pstmt = null;
		
		
		try {
			conexao = HealthTrackDBConnection.getConnection();
			String sql = "UPDATE ACOMPANHAMENTO SET ID_USER = ?, ID_NUTRI = ?, TIPO_ACOMPANHAMENTO = ?, DS_ACOMPANHAMENTO = ? "
					+ "ST_ACOMPANHAMENTO = ? WHERE ID_ACOMPANHAMENTO = ?";
			pstmt = conexao.prepareStatement(sql);
			pstmt.setInt(1, acompanhamento.getIdUsuario().getId());
			pstmt.setInt(2, acompanhamento.getIdNutricionista().getId());
			pstmt.setString(3, acompanhamento.getTipoAcompanhamento());
			pstmt.setString(4, acompanhamento.getDescricao());
			pstmt.setString(5,acompanhamento.getStatus());
			pstmt.setInt(6, acompanhamento.getId());
			
			pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conexao.close();
				pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void delete(int idAcompanhamento) {
		PreparedStatement pstmt = null;
		
		try {
			conexao = HealthTrackDBConnection.getConnection();
			String sql = "DELETE FROM ACOMPANHAMENTO WHERE ID_ACOMPANHAMENTO = ?";
		    pstmt = conexao.prepareStatement(sql);
		    pstmt.setInt(1, idAcompanhamento);
		    pstmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conexao.close();
				pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public List<Acompanhamento> getAll() {
		List<Acompanhamento> acompanhamentoList = new ArrayList<Acompanhamento>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Acompanhamento acompanhamento;
			
			conexao = HealthTrackDBConnection.getConnection();
			String sql = "SELECT "
					   + "A.ID_ACOMPANHAMENTO,"
					   + "N.ID_NUTRI,"
					   + "N.NM_NUTRI,"
					   + "U.ID_USER,"
					   + "U.NM_USER,"
					   + "A.TIPO_ACOMPANHAMENTO,"
					   + "A.DS_ACOMPANHAMENTO,"
					   + "A.ST_ACOMPANHAMENTO"
					   + " FROM ACOMPANHAMENTO A INNER JOIN NUTRICIONISTA N ON A.ID_NUTRI = N.ID_NUTRI INNER JOIN USUARIO U ON A.ID_USER = U.ID_USER ORDER BY ID_ACOMPANHAMENTO ";
			pstmt = conexao.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			acompanhamento = new Acompanhamento();
			Usuario usuario;
			Nutricionista nutricionista;
			
			while(rs.next()) {
				acompanhamento.setId(rs.getInt("ID_ACOMPANHAMENTO"));
				
				usuario = new Usuario();
				usuario.setId(rs.getInt("ID_USER"));
				usuario.setNome(rs.getString("NM_USER"));
				acompanhamento.setIdUsuario(usuario);
				
				nutricionista = new Nutricionista();
				
				nutricionista.setId(rs.getInt("ID_NUTRI"));
				nutricionista.setNome(rs.getString("NM_NUTRI"));
				acompanhamento.setIdNutricionista(nutricionista);
				
				
				acompanhamento.setTipoAcompanhamento(rs.getString("TIPO_ACOMPANHAMENTO"));
				acompanhamento.setDescricao(rs.getString("DS_ACOMPANHAMENTO"));
				acompanhamento.setStatus(rs.getString("ST_ACOMPANHAMENTO"));
				
				
				acompanhamentoList.add(acompanhamento);
				
				System.out.println(acompanhamento.toString());
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				conexao.close();
				pstmt.close();
				rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return acompanhamentoList;
	}
	


}
