package br.com.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.bean.Nutricionista;
import br.com.healthtrack.singleton.HealthTrackDBConnection;

public class OracleNutricionistaDAO {
	
	private Connection conexao; 
	
	
	public void create(Nutricionista nutricionista) {
			PreparedStatement pstmt = null;
		
		try {
			conexao = HealthTrackDBConnection.getConnection();
			String sql = "INSERT INTO NUTRICIONISTA (ID_NUTRI, NR_CRN, NM_NUTRI, NR_TELEFONE, END_EMAIL, END_CONSULTORIO, DS_SEXO) VALUES (SQ_NUTRICIONISTA.NEXTVAL, ?, ?, ?, ?, ?, ?)";
			pstmt = conexao.prepareStatement(sql);
			pstmt.setString(1, nutricionista.getCrn());
			pstmt.setString(2, nutricionista.getNome());
			pstmt.setString(3, nutricionista.getTelefone());
			pstmt.setString(4, nutricionista.getEmail());
			pstmt.setString(5, nutricionista.getEnd_consultorio());
			pstmt.setString(6, nutricionista.getSexo());
			
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
	
	public Nutricionista getById(int searchId) {
		
		  Nutricionista nutricionista = null;
		  PreparedStatement stmt = null;
		  ResultSet rs = null;
		  try {
		    conexao = HealthTrackDBConnection.getConnection();
		    stmt = conexao.prepareStatement("SELECT * FROM NUTRICIONISTA WHERE ID_NUTRI = ?");
		    stmt.setInt(1, searchId);
		    rs = stmt.executeQuery();
		  
		    if (rs.next()){
		      int id = rs.getInt("ID_NUTRI");
		      String crn = rs.getString("NR_CRN");
		      String nome = rs.getString("NM_NUTRI");
		      String email = rs.getString("END_EMAIL");
		      String telefone = rs.getString("NR_TELEFONE");
		      String endConsultorio = rs.getString("END_CONSULTORIO");
		      String sexo = rs.getString("DS_SEXO");
		      sexo.toCharArray();
		      
		      nutricionista = new Nutricionista(id, crn, nome, sexo, email, telefone, endConsultorio);
		    
		      System.out.println(nutricionista.toString());
		    
		    }
		    
		  } catch (SQLException e) {
		    e.printStackTrace();
		  }finally {
		    try {
		      stmt.close();
		      rs.close();
		      conexao.close();
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		  }
		  return nutricionista;
}

	public void update(Nutricionista nutricionista) {
		PreparedStatement  pstmt = null;
		
		try {
			conexao = HealthTrackDBConnection.getConnection();
			String sql = "UPDATE NUTRICIONISTA SET NM_NUTRI = ?, NR_CRN = ?, NR_TELEFONE = ?, END_EMAIL = ?, END_CONSULTORIO = ?"
					+ "WHERE ID_NUTRI = ?";
			pstmt = conexao.prepareStatement(sql);
			pstmt.setString(1, nutricionista.getNome());
			pstmt.setString(2, nutricionista.getCrn());
			pstmt.setString(3, nutricionista.getTelefone());
			pstmt.setString(4, nutricionista.getEmail());
			pstmt.setString(5, nutricionista.getEnd_consultorio());
			pstmt.setInt(6, nutricionista.getId());
			
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				conexao.close();
			}
			catch(SQLException e) {
			e.printStackTrace();
			}
		}
	}

	public List<Nutricionista> getAll() {
		List<Nutricionista> nutricionistaList = new ArrayList<Nutricionista>();
		Nutricionista nutricionista = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conexao = HealthTrackDBConnection.getConnection();
			String sql = "SELECT * FROM NUTRICIONISTA ORDER BY ID_NUTRI";
			pstmt = conexao.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				 int id = rs.getInt("ID_NUTRI");
				 String crn = rs.getString("NR_CRN");
			     String nome = rs.getString("NM_NUTRI");
			     String email = rs.getString("END_EMAIL");
			     String telefone = rs.getString("NR_TELEFONE");
			     String endConsultorio = rs.getString("END_CONSULTORIO");
			     String sexo = rs.getString("DS_SEXO");
			     sexo.toCharArray();
			      
			     nutricionista = new Nutricionista(id, crn, nome, sexo, email, telefone, endConsultorio);
			     nutricionistaList.add(nutricionista);
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
		
		return nutricionistaList;
	}
	
	public void delete(int codigo){
	    PreparedStatement stmt = null;
	  
	    try {
	      conexao = HealthTrackDBConnection.getConnection();
	      String sql = "DELETE FROM NUTRICIONISTA WHERE ID_NUTRI = ?";
	      stmt = conexao.prepareStatement(sql);
	      stmt.setInt(1, codigo);
	      stmt.executeUpdate();
	      
	      
	    } catch (SQLException e) {
	      e.printStackTrace();
	    } finally {
	      try {
	        stmt.close();
	        conexao.close();
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	    }
	  }
}
