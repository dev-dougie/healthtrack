package br.com.healthtrack.bean;
/**
 * Classe que abstrai Imc (Índice de Massa Corporal)
 * */
public class Imc {
	
	/**
	 *IMC Calculado 
	 */
	double imc;
	
	public Imc() {}
	
	/**
	 * Constructor que recebe as informações contidas abaixo e realiza o calculo.
	 * @param nome Nome do usuário, para exibir as informações
	 * @param altura Altura do usuário
	 * @param peso Peso do usuário
	 */
	public Imc(String nome, double altura, double peso) {
		
		double imc = peso / (altura * altura);
		double c = Math.round(imc);
		if(c >= 18.5 && c < 25) {
			
			System.out.println(nome + ", seu peso é o ideal! IMC: " + c );
		}else {
			System.out.println(nome + ", você está fora do peso. IMC: " + c);
		}
		
		/**
		 * Atribui o valor da variável "c" ao atributo "imc" 
		 */
		this.imc = c;
	}
}
