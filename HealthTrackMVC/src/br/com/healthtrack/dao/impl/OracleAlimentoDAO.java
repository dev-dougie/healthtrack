package br.com.healthtrack.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.bean.Alimento;
import br.com.healthtrack.dao.AlimentoDAO;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.singleton.HealthTrackDBConnection;

public class OracleAlimentoDAO implements AlimentoDAO{
	private Connection conexao;
	
	
	public void create(Alimento alimento) throws DBException {
		
		PreparedStatement pstmt = null;
		
		try {
			conexao = HealthTrackDBConnection.getConnection();
			String sql = "INSERT INTO ALIMENTO (ID_ALIMENTO, NM_ALIMENTO, NR_CALORIAS, DS_ALIMENTO, INF_NUTRICIONAIS) VALUES (SQ_ALIMENTO.NEXTVAL, ?, ?, ?, ?)";
			pstmt = conexao.prepareStatement(sql);
			pstmt.setString(1, alimento.getNome());
			pstmt.setDouble(2, alimento.getKcal());
			pstmt.setString(3, alimento.getDescricao());
			pstmt.setString(4, alimento.getInfo_nutricionais());
			
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
	
	public List<Alimento> getAll() {
		List<Alimento> list = new ArrayList<Alimento>();
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		
		try {
			conexao = HealthTrackDBConnection.getConnection();
			String sql = "SELECT * FROM ALIMENTO ORDER BY ID_ALIMENTO";
			pstmt = conexao.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			//Percorre registros encontrados
			while(rs.next()) {
				int id = rs.getInt("ID_ALIMENTO");
				String nome = rs.getString("NM_ALIMENTO");
				double kcal = rs.getDouble("NR_CALORIAS");
				String info_nutricionais = rs.getString("INF_NUTRICIONAIS");
				String descricao = rs.getString("DS_ALIMENTO");
				
				Alimento alimento = new Alimento(id, nome, kcal, info_nutricionais, descricao);
				
				list.add(alimento);
				
				System.out.println(alimento.toString());
			}
		}
			catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					pstmt.close();
					rs.close();
					conexao.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
		return list;
	};
	
	public void delete(int id) throws DBException {
		PreparedStatement pstmt = null;
		
		
		try {
			conexao = HealthTrackDBConnection.getConnection();
			String sql = "DELETE FROM ALIMENTO WHERE ID_ALIMENTO = ?";
			pstmt = conexao.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conexao.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	};
	
	public Alimento getById(int searchId) {
		
		Alimento alimento = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			conexao = HealthTrackDBConnection.getConnection();
			String sql = "SELECT * FROM ALIMENTO WHERE ID_ALIMENTO = ?";
			pstmt = conexao.prepareStatement(sql);
			pstmt.setInt(1, searchId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt("ID_ALIMENTO");
				String nome = rs.getString("NM_ALIMENTO");
				double kcal = rs.getDouble("NR_CALORIAS");
				String info_nutricionais = rs.getString("INF_NUTRICIONAIS");
				String descricao = rs.getString("DS_ALIMENTO");
				
				alimento = new Alimento(id, nome, kcal, info_nutricionais, descricao);
				
				
				System.out.println(alimento.toString());
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
				rs.close();
				conexao.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return alimento;
	}
	
	public void update(Alimento alimento) throws DBException {
		PreparedStatement pstmt = null;
		
		
		try {
			conexao = HealthTrackDBConnection.getConnection();
			String sql = "UPDATE ALIMENTO SET NM_ALIMENTO = ?, NR_CALORIAS = ?, DS_ALIMENTO = ?, INF_NUTRICIONAIS = ?"
					+ "WHERE ID_ALIMENTO = ?";
			pstmt = conexao.prepareStatement(sql);
			pstmt.setString(1, alimento.getNome());
			pstmt.setDouble(2, alimento.getKcal());
			pstmt.setString(3, alimento.getDescricao());
			pstmt.setString(4, alimento.getInfo_nutricionais());
			pstmt.setInt(5, alimento.getIdAlimento());
			
			pstmt.executeQuery();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
				conexao.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
