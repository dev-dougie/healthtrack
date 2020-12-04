package br.com.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.healthtrack.bean.Peso;
import br.com.healthtrack.dao.PesoDAO;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.singleton.HealthTrackDBConnection;

public class OraclePesoDAO implements PesoDAO{
	
		private Connection conexao;
		
		
		public void create(Peso peso) throws DBException {
			PreparedStatement pstmt = null;
			
			try {
				conexao = HealthTrackDBConnection.getConnection();
				String sql = "INSERT INTO PESO_USUARIO (ID_PESO, ID_USER, VL_PESAGEM, DT_PESAGEM) VALUES (SQ_PESO.NEXTVAL,"
						+ "?, ?, ?)";
				pstmt = conexao.prepareStatement(sql);
				pstmt.setInt(1, peso.getIdUser());
				pstmt.setDouble(2, peso.getValPesagem());
				java.sql.Date data = new java.sql.Date(peso.getDataPesagem().getTimeInMillis());
				pstmt.setDate(3, data);
				
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
		
		public Peso getById(int searchId) {
			Peso peso = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				conexao = HealthTrackDBConnection.getConnection();
				String sql = "SELECT * FROM PESO_USUARIO WHERE ID_PESO = ?";
				pstmt = conexao.prepareStatement(sql);
				pstmt.setInt(1, searchId);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					int numeroId = rs.getInt("ID_PESO");
					int idUser = rs.getInt("ID_USER");
					double valor = rs.getDouble("VL_PESAGEM");
					java.sql.Date data = rs.getDate("DT_PESAGEM");
					Calendar dataPesagem = Calendar.getInstance();
					dataPesagem.setTimeInMillis(data.getTime());
					
					peso = new Peso(numeroId, idUser, valor, dataPesagem);
					
					System.out.println(peso.toString());
					
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
			return peso;
		}
		
		public void update(Peso peso) throws DBException {
			PreparedStatement pstmt = null;
			
			try {
				conexao = HealthTrackDBConnection.getConnection();
				String sql = "UPDATE PESO_USUARIO SET VL_PESAGEM = ?, DT_PESAGEM = ?"
						+ "WHERE ID_PESO = ?";
				pstmt = conexao.prepareStatement(sql);
				pstmt.setDouble(1, peso.getValPesagem());
				java.sql.Date data = new java.sql.Date(peso.getDataPesagem().getTimeInMillis());
				pstmt.setDate(2, data);
				pstmt.setInt(3, peso.getIdPeso());
			
				
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
		
		public void delete(int idPeso) throws DBException {
			PreparedStatement pstmt = null;
			
			try {
		
				conexao = HealthTrackDBConnection.getConnection();
				String sql = "DELETE FROM PESO_USUARIO WHERE ID_PESO = ?";
				pstmt = conexao.prepareStatement(sql);
				pstmt.setInt(1, idPeso);
				
				pstmt.executeUpdate();
				System.out.println("PESO EXCLUIDO!");
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
		
		public List<Peso> getAll() {
				List<Peso> pesoList = new ArrayList<Peso>();
				Peso peso = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				try {
					conexao = HealthTrackDBConnection.getConnection();
					String sql = "SELECT * FROM PESO_USUARIO ORDER BY ID_PESO";
					pstmt = conexao.prepareStatement(sql);
					
					rs = pstmt.executeQuery();
					
					while(rs.next()) {
						int numeroId = rs.getInt("ID_PESO");
						int idUser = rs.getInt("ID_USER");
						double valor = rs.getDouble("VL_PESAGEM");
						java.sql.Date data = rs.getDate("DT_PESAGEM");
						Calendar dataPesagem = Calendar.getInstance();
						dataPesagem.setTimeInMillis(data.getTime());
						
						peso = new Peso(numeroId, idUser, valor, dataPesagem);
						
						pesoList.add(peso);
						
						System.out.println(peso.toString());
						
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
				
				
				return pesoList;
		}
		
		public List<Peso> getAllWithLimit(){
			List<Peso> pesoList = new ArrayList<Peso>();
			Peso peso = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				conexao = HealthTrackDBConnection.getConnection();
				String sql = "SELECT * FROM PESO_USUARIO WHERE ROWNUM <=5 ORDER BY ID_PESO";
				pstmt = conexao.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					int numeroId = rs.getInt("ID_PESO");
					int idUser = rs.getInt("ID_USER");
					double valor = rs.getDouble("VL_PESAGEM");
					java.sql.Date data = rs.getDate("DT_PESAGEM");
					Calendar dataPesagem = Calendar.getInstance();
					dataPesagem.setTimeInMillis(data.getTime());
					
					peso = new Peso(numeroId, idUser, valor, dataPesagem);
					
					pesoList.add(peso);
					
					System.out.println(peso.toString());
					
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
			
			
			return pesoList;
		}

			
}
