package br.com.healthtrack.bean;

public class Contato {
	
		private int idContato;
		private String nome;
		private String email;
		private String mensagem;
		
		public Contato() {};
		
		public Contato(int idContato, String nome, String email, String mensagem) {
			super();
			this.idContato = idContato;
			this.nome = nome;
			this.email = email;
			this.mensagem = mensagem;
		}
		

		public int getIdContato() {
			return idContato;
		}

		public void setIdContato(int idContato) {
			this.idContato = idContato;
		}

		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getMensagem() {
			return mensagem;
		}
		public void setMensagem(String mensagem) {
			this.mensagem = mensagem;
		}

		@Override
		public String toString() {
			return "[NOME: " + nome + "| EMAIL: " + email + "| MENSAGEM: " + mensagem
					+ "]";
		}
		
		
		
		
}
