package br.com.healthtrack.bean;

import java.util.Calendar;

/**
 Classe que abstrai Refei��es
 */
public class Refeicao {
	
		/**
		 * C�digo da refei��o
		 * */
		private int id_refeicao;
			
		/**
		 * Indica o alimento consumido
		 * */
		private Alimento alimento;
		
		/**
		 * Usu�rio que ingeriu o alimento
		 * */
		private Usuario idUsuario;
		
		/**
		 * Descreve a refei��o
		 * */
		private String descricao;
		
		/**
		 * Indica o momento da refei��o (Manh�, tarde ou noite)
		 * */
		private Calendar dataRefeicao;
		
		//--------------------------
		
		public Refeicao() {}
		
		public Refeicao(int id_refeicao, Alimento alimento, Usuario idUsuario, String descricao,
				Calendar dataRefeicao) {
			super();
			this.id_refeicao = id_refeicao;
			this.alimento = alimento;
			this.idUsuario = idUsuario;
			this.descricao = descricao;
			this.dataRefeicao = dataRefeicao;
		}
		//--------------------------
		public int getId_refeicao() {
			return id_refeicao;
		}
		
		public void setId_refeicao(int id_refeicao) {
			this.id_refeicao = id_refeicao;
		}
	
		
		
		public Alimento getAlimento() {
			return alimento;
		}

		public void setAlimento(Alimento alimento) {
			this.alimento = alimento;
		}

		public Usuario getIdUsuario() {
			return idUsuario;
		}

		public void setIdUsuario(Usuario idUsuario) {
			this.idUsuario = idUsuario;
		}

		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		public Calendar getMomento_refeicao() {
			return dataRefeicao;
		}
		public void setMomento_refeicao(Calendar dataRefeicao) {
			this.dataRefeicao = dataRefeicao;
		}

		@Override
		public String toString() {
			return "[ID Refei��o: " + id_refeicao + "| Alimento consumido: " + alimento + "| ID Usu�rio: " + idUsuario
					+ "| Descri��o: " + descricao + "| Data: " + dataRefeicao + "]";
		}
		
		
		
				
	
}
