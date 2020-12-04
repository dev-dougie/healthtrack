package br.com.healthtrack.bean;

/**
 * Classe que abstrai Nutricionista
 * */

public class Nutricionista extends Pessoa{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * crn do nutricionista
	 */
	private String crn;
	
	/**
	 * Indica o endere�o do consult�rio do nutricionista
	 * */
	private String end_consultorio;
	
	//---------------------------------------------
	public Nutricionista() {}
	
	public Nutricionista(int id, String crn, String nome, String sexo, String email, String telefone, String end_consultorio) {
		super();
		this.crn = crn;
		this.end_consultorio = end_consultorio;
	}
	
	//----------------------------------------------
	
	public String getCrn() {
		return crn;
	}
	
	public void setCrn(String crn) {
		this.crn = crn;
	}
	
	public String getEnd_consultorio() {
		return end_consultorio;
	}
	public void setEnd_consultorio(String end_consultorio) {
		this.end_consultorio = end_consultorio;
	}

	@Override
	public String toString() {
		return "[CRN: " + crn + "| Endere�o de consult�rio: " + end_consultorio + "]";
	}
	
	
	
	
}
