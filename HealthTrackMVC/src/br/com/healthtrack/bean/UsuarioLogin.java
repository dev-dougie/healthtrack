package br.com.healthtrack.bean;

import java.io.Serializable;

import br.com.healthtrack.utils.CriptografiaUtils;

public class UsuarioLogin implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
		private String email;
		private String senha;
		
		
		public UsuarioLogin() {
			super();
		}
		


		public UsuarioLogin(String email, String senha) {
			super();
			this.email = email;
			setSenha(senha);
		}




		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getSenha() {
			return senha;
		}


		public void setSenha(String senha) {
			try {
				this.senha = CriptografiaUtils.criptografar(senha);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		
}
