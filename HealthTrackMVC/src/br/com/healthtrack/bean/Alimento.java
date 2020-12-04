package br.com.healthtrack.bean;

import java.io.Serializable;
import java.util.Date;
/**
 * Classe que abstrai Alimento
 * */
public class Alimento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int idAlimento;
	private String nome;
	private double kcal;
	private String info_nutricionais;
	private String descricao;
	
	public Alimento() {};

	//---------------------------------------------------
	/**Método construtor com nível de acesso publico
	 * Acrescenta as informações necessárias para informar o alimento consumido
	 * @param nome do alimento
	 * @param kcal calorias do alimento 
	 * @param descricao Descrição do alimento
	 */
	public Alimento(int idAlimento, String nome, double kcal, String info_nutricionais, String descricao) {
		super();
		this.idAlimento = idAlimento;
		this.nome = nome;
		this.kcal = kcal;
		this.info_nutricionais = info_nutricionais;
		this.descricao = descricao;
	}
	
	//---------------------------------------------------
	

	/**
	 * Realiza o cálculo aproximados de calorias ingeridas
	 * @return qtdConsumo informa a quantidade de calorias consumidas, aproximadamente
	 */
	public double calcularNrCalorias() {
			double qtdConsumo = (double) ( this.kcal);
			System.out.println("Você consumiu aproximadamente " + qtdConsumo + " calorias de " + this.nome);
			return qtdConsumo;
					
	}
	
	
	public int getIdAlimento() {
		return idAlimento;
	}

	public void setIdAlimento(int idAlimento) {
		this.idAlimento = idAlimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getKcal() {
		return kcal;
	}

	public void setKcal(double kcal) {
		this.kcal = kcal;
	}

	public String getInfo_nutricionais() {
		return info_nutricionais;
	}

	public void setInfo_nutricionais(String info_nutricionais) {
		this.info_nutricionais = info_nutricionais;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date adicionarLog() {
		/**
		 * @Date instanciado para converter a data atual e inseri-la na lista de alimentos
		 * consumidos
		 */
		Date d = new Date(System.currentTimeMillis());
		System.out.println(this.nome + " foi adicionado a lista de alimentos.");
		return d;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ID: "+ idAlimento + "| Nome: " + nome + "| Calorias: " + kcal + "|Info. Nutricionais: " + info_nutricionais + 
				"| Descrição: " + descricao;
	}
	
	
}
