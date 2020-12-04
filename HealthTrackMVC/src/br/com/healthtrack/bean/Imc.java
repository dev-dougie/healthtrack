package br.com.healthtrack.bean;
/**
 * Classe que abstrai Imc (�ndice de Massa Corporal)
 * */
public class Imc {
	
	/**
	 *IMC Calculado 
	 */
	double imc;
	
	public Imc() {}
	
	/**
	 * Constructor que recebe as informa��es contidas abaixo e realiza o calculo.
	 * @param nome Nome do usu�rio, para exibir as informa��es
	 * @param altura Altura do usu�rio
	 * @param peso Peso do usu�rio
	 */
	public Imc(String nome, double altura, double peso) {
		
		double imc = peso / (altura * altura);
		double c = Math.round(imc);
		if(c >= 18.5 && c < 25) {
			
			System.out.println(nome + ", seu peso � o ideal! IMC: " + c );
		}else {
			System.out.println(nome + ", voc� est� fora do peso. IMC: " + c);
		}
		
		/**
		 * Atribui o valor da vari�vel "c" ao atributo "imc" 
		 */
		this.imc = c;
	}
}
