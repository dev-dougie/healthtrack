package br.com.healthtrack.bean;

import java.util.Calendar;

public class Peso {
	private int idPeso;
	private int idUser;
	private double valPesagem;
	private Calendar dataPesagem;
	
	
	public Peso() {}
	
	public Peso(int idPeso, int idUser, double valPesagem, Calendar dataPesagem) {
		super();
		this.idPeso = idPeso;
		this.idUser = idUser;
		this.valPesagem = valPesagem;
		this.dataPesagem = dataPesagem;
	}


	public int getIdPeso() {
		return idPeso;
	}
	public void setIdPeso(int idPeso) {
		this.idPeso = idPeso;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public double getValPesagem() {
		return valPesagem;
	}

	public void setValPesagem(double valPesagem) {
		this.valPesagem = valPesagem;
	}

	public Calendar getDataPesagem() {
		return dataPesagem;
	}

	public void setDataPesagem(Calendar dataPesagem) {
		this.dataPesagem = dataPesagem;
	}

	@Override
	public String toString() {
		return "[ID:" + idPeso + "| ID usuário: " + idUser + "| Peso: " + valPesagem + "| Data: "
				+ dataPesagem + "]";
	}
	
	
	
	
	
}
