package br.com.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.bean.Exercicio;
import br.com.healthtrack.dao.ExercicioDAO;
import br.com.healthtrack.singleton.HealthTrackDBConnection;

public class OracleExercicioDAO implements ExercicioDAO{
	
		private Connection conexao;
		
		
		public void create(Exercicio exercicio) {
			PreparedStatement pstmt = null;
			
			try {
				conexao = HealthTrackDBConnection.getConnection();
				String sql = "INSERT INTO EXERCICIO (CD_EXER, NM_EXER, TP_EXER, DS_EXER) VALUES (SQ_EXERCICIO.NEXTVAL, ?, ?, ?)";
				pstmt = conexao.prepareStatement(sql);
				pstmt.setString(1, exercicio.getNome());
				pstmt.setString(2, exercicio.getTipo());
				pstmt.setString(3, exercicio.getDescricao());
				
				
				
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
		
		public Exercicio getById(int searchId) {
			Exercicio exercicio = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				conexao = HealthTrackDBConnection.getConnection();
				String sql = "SELECT * FROM EXERCICIO WHERE CD_EXER = ?";
				pstmt = conexao.prepareStatement(sql);
				pstmt.setInt(1, searchId);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					int numeroId = rs.getInt("CD_EXER");
					String nome = rs.getString("NM_EXER");
					String tipo = rs.getString("TP_EXER");
					String descricao = rs.getString("DS_EXER");
					
					exercicio = new Exercicio(numeroId, nome, tipo, descricao);
					
					System.out.println(exercicio.toString());
					
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
			return exercicio;
		}
		
		public void update(Exercicio exercicio) {
			PreparedStatement pstmt = null;
			
			try {
				conexao = HealthTrackDBConnection.getConnection();
				String sql = "UPDATE EXERCICIO SET NM_EXER = ?, TP_EXER = ?, DS_EXER = ?"
						+ "WHERE CD_EXER = ?";
				pstmt = conexao.prepareStatement(sql);
				pstmt.setString(1, exercicio.getNome());
				pstmt.setString(2, exercicio.getTipo());
				pstmt.setString(3, exercicio.getDescricao());
				pstmt.setInt(4, exercicio.getId());
				
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
		
		public void delete(int idExercicio) {
			PreparedStatement pstmt = null;
			
			try {
				conexao = HealthTrackDBConnection.getConnection();
				String sql = "DELETE FROM EXERCICIO WHERE CD_EXER = ?";
				pstmt = conexao.prepareStatement(sql);
				pstmt.setInt(1, idExercicio);
				
				pstmt.executeUpdate();
				System.out.println("Exercício exclúido com sucesso");
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
		
		public List<Exercicio> getAll() {
				List<Exercicio> exercicioList = new ArrayList<Exercicio>();
				Exercicio exercicio = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				try {
					conexao = HealthTrackDBConnection.getConnection();
					String sql = "SELECT * FROM EXERCICIO ORDER BY CD_EXER";
					pstmt = conexao.prepareStatement(sql);
					
					rs = pstmt.executeQuery();
					
					while(rs.next()) {
						int numeroId = rs.getInt("CD_EXER");
						String nome = rs.getString("NM_EXER");
						String tipo = rs.getString("TP_EXER");
						String descricao = rs.getString("DS_EXER");
						
						exercicio = new Exercicio(numeroId, nome, tipo, descricao);
						exercicioList.add(exercicio);
						
						System.out.println(exercicio.toString());
						
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
				
				
				return exercicioList;
		}

}

