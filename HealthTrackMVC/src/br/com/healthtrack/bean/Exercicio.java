package br.com.healthtrack.bean;

import java.io.Serializable;

/**
 * Super-classe para cria��o de exerc�cios
 * */

public class Exercicio implements Serializable {
		
	private static final long serialVersionUID = 1L;
		
		/**
		 * Identifica��o do exerc�cio
		 */
		private int id;
	
		/**
		 * Nome do exerc�cio realizado
		 */
		private String nome;
		
		/**
		 * Indica o tipo de exerc�cio
		 * */
		private String tipo;
		
		/**
		  Descricao do exerc�cio realizado
		 */
		private String descricao;
		
	
		//-----------------------------------
		
		public Exercicio() {};
		
	
		public Exercicio(int id, String nome, String tipo, String descricao) {
			super();
			this.id = id;
			this.nome = nome;
			this.tipo = tipo;
			this.descricao = descricao;
		}



		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}


		@Override
		public String toString() {
			return "[ID: " + id + "| Nome: " + nome + "| Tipo: " + tipo + "| Descri��o: " + descricao + "]";
		}	
		
		
		
		
}