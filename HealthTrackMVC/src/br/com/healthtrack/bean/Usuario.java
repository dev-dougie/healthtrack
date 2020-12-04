package br.com.healthtrack.bean;

import java.io.Serializable;
import java.util.Calendar;

import br.com.healthtrack.utils.CriptografiaUtils;


public class Usuario implements Serializable {

		private static final long serialVersionUID = 1L;
		
		
		private int id;
		private String nome;
		private String cpf;
		private String email;
		private Calendar dataNascimento;
		private String sexo;
		private double altura;
		private double peso;
		private String nickname;
		private String endereco;
		private String nrTelefone;
		private double imc;
		private String senha;
		
		public Usuario() {};
		
		public Usuario(int id, String nome, String cpf, String email, Calendar dataNascimento, String sexo, double altura,
				double peso, String nickname, String endereco, String nrTelefone, double imc, String senha) {
			super();
			this.id = id;
			this.nome = nome;
			this.cpf = cpf;
			this.email = email;
			this.dataNascimento = dataNascimento;
			this.sexo = sexo;
			this.altura = altura;
			this.peso = peso;
			this.nickname = nickname;
			this.endereco = endereco;
			this.nrTelefone = nrTelefone;
			this.imc = (peso / (altura * altura));
			setSenha(senha);
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

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Calendar getDataNascimento() {
			return dataNascimento;
		}

		public void setDataNascimento(Calendar dataNascimento) {
			this.dataNascimento = dataNascimento;
		}

		public String getSexo() {
			return sexo;
		}

		public void setSexo(String sexo) {
			this.sexo = sexo;
		}

		public double getAltura() {
			return altura;
		}

		public void setAltura(double altura) {
			this.altura = altura;
		}

		public double getPeso() {
			return peso;
		}

		public void setPeso(double peso) {
			this.peso = peso;
		}

		public String getNickname() {
			return nickname;
		}

		public void setNickname(String nickname) {
			this.nickname = nickname;
		}

		public String getEndereco() {
			return endereco;
		}

		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}

		public String getNrTelefone() {
			return nrTelefone;
		}

		public void setNrTelefone(String nrTelefone) {
			this.nrTelefone = nrTelefone;
		}

		public double getImc() {
			return imc;
		}

		public void setImc(double imc) {
			this.imc = imc;
		}
		
		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
					try{
				this.senha = CriptografiaUtils.criptografar(senha);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public String toString() {
			return "Usuario [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", dataNascimento="
					+ dataNascimento + ", sexo=" + sexo + ", altura=" + altura + ", peso=" + peso + ", nickname="
					+ nickname + ", endereco=" + endereco + ", nrTelefone=" + nrTelefone + ", imc=" + imc+ "]";
		}
		
		
		
}
