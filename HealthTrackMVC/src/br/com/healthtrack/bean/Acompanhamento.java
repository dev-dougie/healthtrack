package br.com.healthtrack.bean;

/**
 * Classe que abstrai Acompanhamento
 * */
public class Acompanhamento {
	
	/**
	 * Identificação do acompanhamento
	 */
	private int id;
	
	/**
	 * Nome do usuário/ paciente 
	 */
	private Usuario idUsuario;
	
	
	/**
	 * Nome do nutricionista responsável 
	 */
	private Nutricionista idNutricionista;
	
	
	/**
	 * Indica o tipo de acompanhamento
	 */
	private String tipoAcompanhamento;
	
	/**
	 * Observações
	 * */
	private String descricao;
	
	/**
	 * Indica o status do acompanhamento 1 = true e 0 = false;
	 * */
	private String status;
	
	//__________________
	
	public Acompanhamento() {};


	public Acompanhamento(int id, Usuario idUsuario, Nutricionista idNutricionista, String tipoAcompanhamento, String descricao,
			String status) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.idNutricionista = idNutricionista;
		this.tipoAcompanhamento = tipoAcompanhamento;
		this.descricao = descricao;
		this.status = status;
	}


	//____________________
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Nutricionista getIdNutricionista() {
		return idNutricionista;
	}
	
	public void setIdNutricionista(Nutricionista idNutricionista) {
		this.idNutricionista = idNutricionista;
	}

	public String getTipoAcompanhamento() {
		return tipoAcompanhamento;
	}

	public void setTipoAcompanhamento(String tipoAcompanhamento) {
		this.tipoAcompanhamento = tipoAcompanhamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "[ID: " + id + "| Usuário: " + idUsuario.getNome() + "| Nutricionista: " + idNutricionista.getNome()
				+ "| Tipo de Acompanhamento: " + tipoAcompanhamento + "| Descrição: " + descricao + "| Status: " + status;
	}
	
	
	
	
}
