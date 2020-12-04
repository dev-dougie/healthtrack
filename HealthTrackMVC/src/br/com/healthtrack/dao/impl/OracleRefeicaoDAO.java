package br.com.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.healthtrack.bean.Alimento;
import br.com.healthtrack.bean.Refeicao;
import br.com.healthtrack.dao.RefeicaoDAO;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.singleton.HealthTrackDBConnection;
public class OracleRefeicaoDAO implements RefeicaoDAO{
	
		private Connection conexao;
		
		
		public void create(Refeicao refeicao) throws DBException {
			PreparedStatement pstmt = null;
			
			try {
				conexao = HealthTrackDBConnection.getConnection();
				String sql = "INSERT INTO INGESTAO (ID_INGESTAO, ID_ALIMENTO, ID_USER, DS_INGESTAO, DT_INGESTAO) VALUES (SQ_INGESTAO.NEXTVAL, ?, ?, ?, ?)";
				pstmt = conexao.prepareStatement(sql);
				pstmt.setInt(1, refeicao.getAlimento().getIdAlimento());
				pstmt.setInt(2, refeicao.getIdUsuario().getId());
				pstmt.setString(3, refeicao.getDescricao());
				java.sql.Date data = new java.sql.Date(refeicao.getMomento_refeicao().getTimeInMillis());
				pstmt.setDate(4, data);
				
				pstmt.executeUpdate();
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
		
		public Refeicao getById(int searchId) {
			Refeicao refeicao = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				conexao = HealthTrackDBConnection.getConnection();
				String sql = "SELECT I.ID_INGESTAO,"
						+ " I.ID_ALIMENTO,"
						+ " A.NM_ALIMENTO,"
						+ " I.ID_USER,"
						+ " I.DS_INGESTAO,"
						+ " I.DT_INGESTAO FROM INGESTAO I INNER JOIN ALIMENTO A ON I.ID_ALIMENTO = A.ID_ALIMENTO WHERE ID_INGESTAO = ?";
				pstmt = conexao.prepareStatement(sql);
				pstmt.setInt(1, searchId);
				rs = pstmt.executeQuery();
				
				Alimento alimento;
				
				if(rs.next()) {
					
					
					
					refeicao = new Refeicao();
					refeicao.setId_refeicao(rs.getInt("ID_INGESTAO"));
					
					
					alimento = new Alimento();
					alimento.setIdAlimento(rs.getInt("ID_ALIMENTO"));
					alimento.setNome(rs.getString("NM_ALIMENTO"));
					
					refeicao.setAlimento(alimento);
					refeicao.setDescricao(rs.getString("DS_INGESTAO"));
					java.sql.Date data = rs.getDate("DT_INGESTAO");
					Calendar momentoRefeicao = Calendar.getInstance();
					momentoRefeicao.setTimeInMillis(data.getTime());
					refeicao.setMomento_refeicao(momentoRefeicao);
					
					
					System.out.println(refeicao.toString());
					
				}else {
					System.out.println("There is no meal with this ID");
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
			return refeicao;
		}
		
		public void update(Refeicao refeicao) throws DBException{
			PreparedStatement pstmt = null;
			
			try {
				conexao = HealthTrackDBConnection.getConnection();
				String sql = "UPDATE INGESTAO SET ID_ALIMENTO = ?, DS_INGESTAO = ?, DT_INGESTAO = ?"
						+ "WHERE ID_INGESTAO = ?";
				pstmt = conexao.prepareStatement(sql);
				pstmt.setInt(1, refeicao.getAlimento().getIdAlimento());
				pstmt.setString(2, refeicao.getDescricao());
				java.sql.Date data = new java.sql.Date(refeicao.getMomento_refeicao().getTimeInMillis());
				pstmt.setDate(3, data);
				pstmt.setInt(4, refeicao.getId_refeicao());
				
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
		
		public void delete(int idRefeicao) throws DBException{
			PreparedStatement pstmt = null;
			
			try {
				conexao = HealthTrackDBConnection.getConnection();
				String sql = "DELETE FROM INGESTAO WHERE ID_INGESTAO = ?";
				pstmt = conexao.prepareStatement(sql);
				pstmt.setInt(1, idRefeicao);
				
				pstmt.executeUpdate();
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
		
		public List<Refeicao> getAll() {
				List<Refeicao> refeicaoList = new ArrayList<Refeicao>();
				Refeicao refeicao = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				try {
					conexao = HealthTrackDBConnection.getConnection();
					 
					String sql = "SELECT I.ID_INGESTAO,"
							+ "I.ID_ALIMENTO,"
							+ "A.NM_ALIMENTO,"
							+ "I.ID_USER,"
							+ "I.DS_INGESTAO,"
							+ "I.DT_INGESTAO FROM INGESTAO I INNER JOIN ALIMENTO A ON I.ID_ALIMENTO = A.ID_ALIMENTO ORDER BY I.ID_INGESTAO";
					pstmt = conexao.prepareStatement(sql);
					
					rs = pstmt.executeQuery();
					
					Alimento alimento = new Alimento();
					refeicao = new Refeicao();
					
					while(rs.next()) {
						
						alimento.setIdAlimento(rs.getInt("ID_ALIMENTO"));
						alimento.setNome(rs.getString("NM_ALIMENTO"));
						
						refeicao.setId_refeicao(rs.getInt("ID_INGESTAO"));
						refeicao.setDescricao(rs.getString("DS_INGESTAO"));
						java.sql.Date data = rs.getDate("DT_INGESTAO");
						Calendar momentoRefeicao = Calendar.getInstance();
						momentoRefeicao.setTimeInMillis(data.getTime());
						refeicao.setMomento_refeicao(momentoRefeicao);
		
						refeicaoList.add(refeicao);
					    
					    System.out.println(refeicao.toString());
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
				
				
				return refeicaoList;
		}
		
		public List<Refeicao> getAllWithLimit(){
			List<Refeicao> refeicaoList = new ArrayList<Refeicao>();
			Refeicao refeicao = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				conexao = HealthTrackDBConnection.getConnection();
				 
				String sql = "SELECT I.ID_INGESTAO,"
						+ "I.ID_ALIMENTO,"
						+ "A.NM_ALIMENTO,"
						+ "I.ID_USER,"
						+ "I.DS_INGESTAO,"
						+ "I.DT_INGESTAO FROM INGESTAO I INNER JOIN ALIMENTO A ON I.ID_ALIMENTO = A.ID_ALIMENTO WHERE ROWNUM <= 5ORDER BY I.ID_INGESTAO DESC";
				pstmt = conexao.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				
				Alimento alimento = new Alimento();
				refeicao = new Refeicao();
				
				while(rs.next()) {
					
					alimento.setIdAlimento(rs.getInt("ID_ALIMENTO"));
					alimento.setNome(rs.getString("NM_ALIMENTO"));
					
					refeicao.setId_refeicao(rs.getInt("ID_INGESTAO"));
					refeicao.setDescricao(rs.getString("DS_INGESTAO"));
					java.sql.Date data = rs.getDate("DT_INGESTAO");
					Calendar momentoRefeicao = Calendar.getInstance();
					momentoRefeicao.setTimeInMillis(data.getTime());
					refeicao.setMomento_refeicao(momentoRefeicao);
	
					refeicaoList.add(refeicao);
				    
				    System.out.println(refeicao.toString());
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
			
			
			return refeicaoList;
		}

}
