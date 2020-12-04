package br.com.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.healthtrack.bean.Exercicio;
import br.com.healthtrack.bean.Treino;
import br.com.healthtrack.dao.TreinoDAO;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.singleton.HealthTrackDBConnection;


public class OracleTreinoDAO implements TreinoDAO{
	private Connection conexao;
	
	public List<Treino> getAll(){
		List<Treino> trainningList =  new ArrayList<Treino>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Treino treino = new Treino();
		
		
		try {
			conexao = HealthTrackDBConnection.getConnection();
			String sql = "SELECT "
					+ "T.ID_ATIV, "
					+ "E.CD_EXER, "
					+ "E.NM_EXER, "
					+ "T.ID_USER, "
					+ "T.KCAL_QUEIMADAS, "
					+ "T.DURACAO_ATIV, "
					+ "T.DS_ATIVIDADE, "
					+ "T.OBS_ATIV_FIS, "
					+ "T.FREQ_CARDIACA, "
					+ "T.DT_ATIVIDADE FROM ATIV_FISICA T INNER JOIN EXERCICIO E ON T.CD_EXER = E.CD_EXER ORDER BY T.ID_ATIV";
			pstmt = conexao.prepareStatement(sql);
			rs = pstmt.executeQuery();
					
			Exercicio ex = new Exercicio();
			
			//Percorre registros encontrados
			while(rs.next()) {

				ex.setId(rs.getInt("CD_EXER"));
				ex.setNome(rs.getString("NM_EXER"));
				
				
				treino.setIdTreino(rs.getInt("ID_ATIV"));
				treino.setExercicioRealizado(ex);
				treino.setIdUsuario(rs.getInt("ID_USER"));
				treino.setKcalQueimadas(rs.getDouble("KCAL_QUEIMADAS"));
				treino.setDuracaoMin(rs.getDouble("DURACAO_ATIV"));
				treino.setDescricao(rs.getString("DS_ATIVIDADE"));
				treino.setObs(rs.getString("OBS_ATIV_FIS"));
				treino.setFreqCardiaca(rs.getInt("FREQ_CARDIACA"));
				java.sql.Date data = rs.getDate("DT_ATIVIDADE");
				Calendar dataTreino = Calendar.getInstance();
				dataTreino.setTimeInMillis(data.getTime());
				treino.setDataTreino(dataTreino);
				
				
				trainningList.add(treino);
				
				System.out.println(treino.toString());
				
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
        
		return trainningList;
	}
	
	public List<Treino> getAllWithLimit(){
		List<Treino> trainningList =  new ArrayList<Treino>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Treino treino = new Treino();
		
		
		try {
			conexao = HealthTrackDBConnection.getConnection();
			String sql = "SELECT "
					+ "T.ID_ATIV, "
					+ "E.CD_EXER, "
					+ "E.NM_EXER, "
					+ "T.ID_USER, "
					+ "T.KCAL_QUEIMADAS, "
					+ "T.DURACAO_ATIV, "
					+ "T.DS_ATIVIDADE, "
					+ "T.OBS_ATIV_FIS, "
					+ "T.FREQ_CARDIACA, "
					+ "T.DT_ATIVIDADE FROM ATIV_FISICA T INNER JOIN EXERCICIO E ON T.CD_EXER = E.CD_EXER WHERE ROWNUM <= 5 ORDER BY T.ID_ATIV DESC";
			pstmt = conexao.prepareStatement(sql);
			rs = pstmt.executeQuery();
					
			Exercicio ex = new Exercicio();
			
			//Percorre registros encontrados
			while(rs.next()) {

				ex.setId(rs.getInt("CD_EXER"));
				ex.setNome(rs.getString("NM_EXER"));
				
				
				treino.setIdTreino(rs.getInt("ID_ATIV"));
				treino.setExercicioRealizado(ex);
				treino.setIdUsuario(rs.getInt("ID_USER"));
				treino.setKcalQueimadas(rs.getDouble("KCAL_QUEIMADAS"));
				treino.setDuracaoMin(rs.getDouble("DURACAO_ATIV"));
				treino.setDescricao(rs.getString("DS_ATIVIDADE"));
				treino.setObs(rs.getString("OBS_ATIV_FIS"));
				treino.setFreqCardiaca(rs.getInt("FREQ_CARDIACA"));
				java.sql.Date data = rs.getDate("DT_ATIVIDADE");
				Calendar dataTreino = Calendar.getInstance();
				dataTreino.setTimeInMillis(data.getTime());
				treino.setDataTreino(dataTreino);
				
				
				trainningList.add(treino);
				
				System.out.println(treino.toString());
				
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
        
		return trainningList;
		
	}
	
//	//CREATE
	public void create(Treino treino) throws DBException{
		PreparedStatement pstmt = null;
		
		try {
			conexao = HealthTrackDBConnection.getConnection();
			String sql = "INSERT INTO ATIV_FISICA (ID_ATIV, CD_EXER, ID_USER, DURACAO_ATIV, OBS_ATIV_FIS, DS_ATIVIDADE, FREQ_CARDIACA, KCAL_QUEIMADAS, DT_ATIVIDADE)"
					+ " VALUES (SQ_ATIV_FIS.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conexao.prepareStatement(sql);
			
			pstmt.setInt(1, treino.getExercicioRealizado().getId());
			pstmt.setInt(2, treino.getIdUsuario());
			pstmt.setDouble(3, treino.getDuracaoMin());
			pstmt.setString(4, treino.getObs());
			pstmt.setString(5, treino.getDescricao());
			pstmt.setInt(6, treino.getFreqCardiaca());
			pstmt.setDouble(7, treino.getKcalQueimadas());
			java.sql.Date data = new java.sql.Date(treino.getDataTreino().getTimeInMillis());
			pstmt.setDate(8, data);
			
			
			pstmt.executeUpdate();
			System.out.println("Treino cadastrado com sucesso!");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conexao.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

//	//READ
	public Treino getById(int searchId) {
		Treino treino = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conexao = HealthTrackDBConnection.getConnection();
			String sql = "SELECT T.ID_ATIV,"
					+ " E.CD_EXER, "
					+ "E.NM_EXER, "
					+ "T.ID_USER, "
					+ "T.KCAL_QUEIMADAS, "
					+ "T.DURACAO_ATIV, "
					+ "T.DS_ATIVIDADE, "
					+ "T.OBS_ATIV_FIS, "
					+ "T.FREQ_CARDIACA, "
					+ "T.DT_ATIVIDADE FROM ATIV_FISICA T INNER JOIN EXERCICIO E ON T.CD_EXER = E.CD_EXER WHERE ID_ATIV = ?";
			pstmt = conexao.prepareStatement(sql);
			pstmt.setInt(1, searchId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				
				
				treino = new Treino();
				treino.setIdTreino(rs.getInt("ID_ATIV"));
				treino.setIdUsuario(rs.getInt("ID_USER"));
				
				Exercicio ex =  new Exercicio();
				ex.setId(rs.getInt("CD_EXER"));
				ex.setNome(rs.getString("NM_EXER"));
				
				treino.setExercicioRealizado(ex);				
				treino.setKcalQueimadas(rs.getDouble("KCAL_QUEIMADAS"));
				treino.setDuracaoMin(rs.getDouble("DURACAO_ATIV"));
				treino.setDescricao(rs.getString("DS_ATIVIDADE"));
				treino.setObs(rs.getString("OBS_ATIV_FIS"));
				treino.setFreqCardiaca(rs.getInt("FREQ_CARDIACA"));
				java.sql.Date data = rs.getDate("DT_ATIVIDADE");
				Calendar dataTreino = Calendar.getInstance();
				dataTreino.setTimeInMillis(data.getTime());
				treino.setDataTreino(dataTreino);
				
				
			
				System.out.println(treino.toString());
				
			}
			
		}catch(SQLException e) {
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
		
		return treino;
	}
	
//	//UPDATE
	public void update(Treino treino) throws DBException{
		PreparedStatement  pstmt = null;
		
		try {
			conexao = HealthTrackDBConnection.getConnection();
			String sql = "UPDATE ATIV_FISICA SET CD_EXER = ?, DURACAO_ATIV = ?, OBS_ATIV_FIS = ?, DS_ATIVIDADE = ?, FREQ_CARDIACA = ?, KCAL_QUEIMADAS = ?, DT_ATIVIDADE = ?"
					+ "WHERE ID_ATIV = ?";
			pstmt = conexao.prepareStatement(sql);
			pstmt.setInt(1, treino.getExercicioRealizado().getId());
			pstmt.setDouble(2, treino.getDuracaoMin());
			pstmt.setString(3, treino.getObs());
			pstmt.setString(4, treino.getDescricao());
			pstmt.setInt(5, treino.getFreqCardiaca());
			pstmt.setDouble(6, treino.getKcalQueimadas());
			java.sql.Date data = new java.sql.Date(treino.getDataTreino().getTimeInMillis());	
			pstmt.setDate(7, data);
			pstmt.setInt(8, treino.getIdTreino());
			
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
//	
//	//DELETE
	public void delete(int idTreino) throws DBException{
		PreparedStatement pstmt = null;
		
		
		try {
			conexao = HealthTrackDBConnection.getConnection();
			String sql = "DELETE FROM ATIV_FISICA WHERE ID_ATIV = ?";
			pstmt = conexao.prepareStatement(sql);
			
			pstmt.setInt(1, idTreino);
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
	

}
