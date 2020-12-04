package br.com.healthtrack.bean;

import java.util.Calendar;

/**
 Classe que abstrai Refeições
 */
public class Refeicao {
	
		/**
		 * Código da refeição
		 * */
		private int id_refeicao;
			
		/**
		 * Indica o alimento consumido
		 * */
		private Alimento alimento;
		
		/**
		 * Usuário que ingeriu o alimento
		 * */
		private Usuario idUsuario;
		
		/**
		 * Descreve a refeição
		 * */
		private String descricao;
		
		/**
		 * Indica o momento da refeição (Manhã, tarde ou noite)
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
			return "[ID Refeição: " + id_refeicao + "| Alimento consumido: " + alimento + "| ID Usuário: " + idUsuario
					+ "| Descrição: " + descricao + "| Data: " + dataRefeicao + "]";
		}
		
		
		
				
	
}
