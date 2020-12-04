package br.com.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.healthtrack.bean.Pressao;
import br.com.healthtrack.dao.PressaoDAO;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.singleton.HealthTrackDBConnection;

public class OraclePressaoDAO implements PressaoDAO {
	
	
	private Connection conexao;
	
	
	public void create(Pressao pressao) throws DBException {
		PreparedStatement pstmt = null;
		
		try {
			conexao = HealthTrackDBConnection.getConnection();
			String sql = "INSERT INTO PRESSAO (ID_PRESSAO, ID_USUARIO, SISTOLICA, DIASTOLICA, DT_AFERICAO) VALUES (SQ_PRESSAO.NEXTVAL,"
					+ "?, ?, ?, ?)";
			pstmt = conexao.prepareStatement(sql);
			pstmt.setInt(1, pressao.getIdUsuario());
			pstmt.setInt(2, pressao.getSistolica());
			pstmt.setInt(3, pressao.getDiastolica());
			java.sql.Date data = new java.sql.Date(pressao.getDataAfericao().getTimeInMillis());
			pstmt.setDate(4, data);
			
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
	
	public Pressao getById(int searchId) {
		Pressao pressao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conexao = HealthTrackDBConnection.getConnection();
			String sql = "SELECT * FROM PRESSAO WHERE ID_PRESSAO = ?";
			pstmt = conexao.prepareStatement(sql);
			pstmt.setInt(1, searchId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int numeroId = rs.getInt("ID_PRESSAO");
				int idUser = rs.getInt("ID_USUARIO");
				int sistolica = rs.getInt("SISTOLICA");
				int diastolica = rs.getInt("DIASTOLICA");
				java.sql.Date data = rs.getDate("DT_AFERICAO");
				Calendar dataAfericao = Calendar.getInstance();
				dataAfericao.setTimeInMillis(data.getTime());
				
				pressao = new Pressao(numeroId, idUser, sistolica, diastolica, dataAfericao);
				
				System.out.println(pressao.toString());
				
			}
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
		return pressao;
	}
	
	public void update(Pressao pressao) throws DBException {
		PreparedStatement pstmt = null;
		
		try {
			conexao = HealthTrackDBConnection.getConnection();
			String sql = "UPDATE PESO_USUARIO SET SISTOLICA = ?, DIASTOLICA = ?, DT_AFERICAO = ?"
					+ "WHERE ID_PESO = ?";
			pstmt = conexao.prepareStatement(sql);
			pstmt.setInt(1, pressao.getSistolica());
			pstmt.setInt(2, pressao.getDiastolica());
			java.sql.Date data = new java.sql.Date(pressao.getDataAfericao().getTimeInMillis());
			pstmt.setDate(3, data);
			pstmt.setInt(4, pressao.getIdPressao());
		
			
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
	
	public void delete(int idPressao) throws DBException {
		PreparedStatement pstmt = null;
		
		try {
	
			conexao = HealthTrackDBConnection.getConnection();
			String sql = "DELETE FROM PRESSAO WHERE ID_PESO = ?";
			pstmt = conexao.prepareStatement(sql);
			pstmt.setInt(1, idPressao);
			
			pstmt.executeUpdate();
			System.out.println("PRESSAO EXCLUIDA!");
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
	}
	
	public List<Pressao> getAll() {
			List<Pressao> pressaoList = new ArrayList<Pressao>();
			Pressao pressao = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				conexao = HealthTrackDBConnection.getConnection();
				String sql = "SELECT * FROM PRESSAO ORDER BY ID_PRESSAO";
				pstmt = conexao.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					int numeroId = rs.getInt("ID_PRESSAO");
					int idUser = rs.getInt("ID_USUARIO");
					int sistolica = rs.getInt("SISTOLICA");
					int diastolica = rs.getInt("DIASTOLICA");
					java.sql.Date data = rs.getDate("DT_AFERICAO");
					Calendar dataAfericao = Calendar.getInstance();
					dataAfericao.setTimeInMillis(data.getTime());
					
					pressao = new Pressao(numeroId, idUser, sistolica, diastolica, dataAfericao);
					
					pressaoList.add(pressao);

					
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
			
			
			return pressaoList;
	}
	
	public List<Pressao> getAllWithLimit() {
		List<Pressao> pressaoList = new ArrayList<Pressao>();
		Pressao pressao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conexao = HealthTrackDBConnection.getConnection();
			String sql = "SELECT * FROM PRESSAO WHERE ROWNUM <=5 ORDER BY ID_PRESSAO";
			pstmt = conexao.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int numeroId = rs.getInt("ID_PRESSAO");
				int idUser = rs.getInt("ID_USUARIO");
				int sistolica = rs.getInt("SISTOLICA");
				int diastolica = rs.getInt("DIASTOLICA");
				java.sql.Date data = rs.getDate("DT_AFERICAO");
				Calendar dataAfericao = Calendar.getInstance();
				dataAfericao.setTimeInMillis(data.getTime());
				
				pressao = new Pressao(numeroId, idUser, sistolica, diastolica, dataAfericao);
				
				pressaoList.add(pressao);

				
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
		
		
		return pressaoList;
}


}
