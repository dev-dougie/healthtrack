package br.com.healthtrack.bean;
import java.io.Serializable;
import java.util.Calendar;
	

public class Treino implements Serializable{
	
	private static final long serialVersionUID = 1L;
		private int idTreino;
		private Exercicio exercicioRealizado;
		private int idUsuario;
		private String descricao;
		private double duracaoMin;
		private int freqCardiaca;
		private double kcalQueimadas;
		private String obs;
		private Calendar dataTreino;
		
		
		public Treino() {}

		public Treino(int idTreino, Exercicio exercicioRealizado, int idUsuario, String descricao, double duracaoMin,
				int freqCardiaca, double kcalQueimadas, String obs, Calendar dataTreino) {
			super();
			this.idTreino = idTreino;
			this.exercicioRealizado = exercicioRealizado;
			this.idUsuario = idUsuario;
			this.descricao = descricao;
			this.duracaoMin = duracaoMin;
			this.freqCardiaca = freqCardiaca;
			this.kcalQueimadas = kcalQueimadas;
			this.obs = obs;
			this.dataTreino = dataTreino;
		}
		
		

		public int getIdTreino() {
			return idTreino;
		}

		public void setIdTreino(int idTreino) {
			this.idTreino = idTreino;
		}

		public Exercicio getExercicioRealizado() {
			return exercicioRealizado;
		}

		public void setExercicioRealizado(Exercicio exercicioRealizado) {
			this.exercicioRealizado = exercicioRealizado;
		}

		public int getIdUsuario() {
			return idUsuario;
		}

		public void setIdUsuario(int idUsuario) {
			this.idUsuario = idUsuario;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public double getDuracaoMin() {
			return duracaoMin;
		}

		public void setDuracaoMin(double duracaoMin) {
			this.duracaoMin = duracaoMin;
		}

		public int getFreqCardiaca() {
			return freqCardiaca;
		}

		public void setFreqCardiaca(int freqCardiaca) {
			this.freqCardiaca = freqCardiaca;
		}

		public double getKcalQueimadas() {
			return kcalQueimadas;
		}

		public void setKcalQueimadas(double kcalQueimadas) {
			this.kcalQueimadas = kcalQueimadas;
		}

		public String getObs() {
			return obs;
		}

		public void setObs(String obs) {
			this.obs = obs;
		}

		public Calendar getDataTreino() {
			return dataTreino;
		}

		public void setDataTreino(Calendar dataTreino) {
			this.dataTreino = dataTreino;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		/**
		 * Mostrará as informações sobre o treino em tela e adicionará ao BD
		 * */
		//Pode ser atrelada futuramente a um Wearable Device
		@Override
		public String toString() {
			return "[ID: " + idTreino + "| Exercício Realizado: " + exercicioRealizado.getNome() + "| Duração da atividade(min): "
					+ duracaoMin + "| Calorias queimadas: " + kcalQueimadas + "| Número de BPM: " + freqCardiaca + "| Obs.:" + obs + 
					"| Data: " + dataTreino  + "]";
		}
		
	
}

