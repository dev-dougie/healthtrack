package br.com.healthtrack.bean;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Superclasse de Usuario e Nutricionista
 * */

public abstract class Pessoa implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
		/**
		 * Identifica��o da pessoa (usu�rio/ nutricionista)
		 * */
		private int id;
	
		/**
		 	Nome do usu�rio ou nutricionista
		 */
		protected String nome;
		
		/**
		 * Telefone do usu�rio ou nutricionista
		 * */
		private String telefone;
		
		/**
		  E-mail do usu�rio ou nutricionista
		 * */
		protected String email;
		
		/**
		  Sexo do usu�rio ou nutricionista
		 * */
		private String sexo;
	
		/**
	 	Indica se o uus�rio ou nutricionista est� ou n�o ativo no sistema
		 */
		protected boolean status;
		
		
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
		
		public String getTelefone() {
			return telefone;
		}

		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getSexo() {
			return sexo;
		}

		public void setSexo(String sexo) {
			this.sexo = sexo;
		}
		

		public boolean isStatus() {
			return status;
		}

		public void setStatus(boolean status) {
			this.status = status;
		}



		/**
		 * M�todo respons�vel por desativar a pessoa (Usu�rio/ Nutricionista) do sistema
		 */
		public void desativar() {
			
			Scanner p = new Scanner(System.in);
			System.out.println("Voc� realmente deseja desativar? S/N");
			String r = p.next();
			r = r.toUpperCase();
			
			if(r.equals("S")) {
				System.out.println("Desativado.");
				this.setStatus(false);
			}
			else {
				this.setStatus(true);
			}
			
			//Fechando minha entrada de dados
			p.close();
		}
		
		public void consultar() {
			
			System.out.println("**DADOS E INFORMA��ES**");
			System.out.print("Nome:" + this.nome + "| Email: " + this.email);
		}
}
