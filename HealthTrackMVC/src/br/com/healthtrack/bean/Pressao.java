package br.com.healthtrack.bean;

import java.io.Serializable;
import java.util.Calendar;

public class Pressao implements Serializable{
	

		private static final long serialVersionUID = 1L;
		private int idPressao;
		private int idUsuario;
		private int sistolica;
		private int diastolica;
		private Calendar dataAfericao;
		
		public Pressao() {};
		
		public Pressao(int idPressao, int idUsuario, int sistolica, int diastolica, Calendar dataAfericao) {
			super();
			this.idPressao = idPressao;
			this.idUsuario = idUsuario;
			this.sistolica = sistolica;
			this.diastolica = diastolica;
			this.dataAfericao = dataAfericao;
		}


		public int getIdPressao() {
			return idPressao;
		}
		public void setIdPressao(int idPressao) {
			this.idPressao = idPressao;
		}
		public int getIdUsuario() {
			return idUsuario;
		}
		public void setIdUsuario(int idUsuario) {
			this.idUsuario = idUsuario;
		}
		public int getSistolica() {
			return sistolica;
		}
		public void setSistolica(int sistolica) {
			this.sistolica = sistolica;
		}
		public int getDiastolica() {
			return diastolica;
		}
		public void setDiastolica(int diastolica) {
			this.diastolica = diastolica;
		}
		public Calendar getDataAfericao() {
			return dataAfericao;
		}
		public void setDataAfericao(Calendar dataAfericao) {
			this.dataAfericao = dataAfericao;
		}
		
		
}
