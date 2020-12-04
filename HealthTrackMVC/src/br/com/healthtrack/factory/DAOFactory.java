package br.com.healthtrack.factory;

import br.com.healthtrack.dao.AlimentoDAO;
import br.com.healthtrack.dao.ContatoDAO;
import br.com.healthtrack.dao.ExercicioDAO;
import br.com.healthtrack.dao.NutricionistaDAO;
import br.com.healthtrack.dao.PesoDAO;
import br.com.healthtrack.dao.PressaoDAO;
import br.com.healthtrack.dao.RefeicaoDAO;
import br.com.healthtrack.dao.TreinoDAO;
import br.com.healthtrack.dao.UsuarioDAO;
import br.com.healthtrack.dao.UsuarioLoginDAO;
import br.com.healthtrack.dao.impl.OracleAlimentoDAO;
import br.com.healthtrack.dao.impl.OracleContatoDAO;
import br.com.healthtrack.dao.impl.OracleExercicioDAO;
import br.com.healthtrack.dao.impl.OracleNutricionistaDAO;
import br.com.healthtrack.dao.impl.OraclePesoDAO;
import br.com.healthtrack.dao.impl.OraclePressaoDAO;
import br.com.healthtrack.dao.impl.OracleRefeicaoDAO;
import br.com.healthtrack.dao.impl.OracleTreinoDAO;
import br.com.healthtrack.dao.impl.OracleUsuarioDAO;
import br.com.healthtrack.dao.impl.OracleUsuarioLoginDAO;

public class DAOFactory {
	
	public static TreinoDAO getTreinoDAO() {
		return new OracleTreinoDAO();
	}
	
	public static AlimentoDAO getAlimentoDAO() {
		return (AlimentoDAO) new OracleAlimentoDAO();
	}
	
	public static RefeicaoDAO getRefeicaoDAO() {
		return (RefeicaoDAO) new OracleRefeicaoDAO();
	}
	
	public static ExercicioDAO getExercicioDAO() {
		return (ExercicioDAO) new OracleExercicioDAO();
	}
	
	public static PesoDAO getPesoDAO() {
		return (PesoDAO) new OraclePesoDAO();
	}
	
	public static PressaoDAO getPressaoDAO() {
		return (PressaoDAO) new OraclePressaoDAO();
	}
	
	public static NutricionistaDAO getNutricionista() {
		return (NutricionistaDAO) new OracleNutricionistaDAO();
	}
	
	public static UsuarioDAO getUsuarioDAO() {
		return (UsuarioDAO) new OracleUsuarioDAO();
	}
	
	public static UsuarioLoginDAO getUsuarioLoginDAO() {
		return (UsuarioLoginDAO) new OracleUsuarioLoginDAO();
	}
	
	public static ContatoDAO getContato() {
		return (ContatoDAO) new OracleContatoDAO();
	}
}
