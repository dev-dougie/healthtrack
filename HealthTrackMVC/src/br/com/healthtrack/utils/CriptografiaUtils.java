package br.com.healthtrack.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class CriptografiaUtils {
	public static String criptografar(String senha) throws Exception {
		
		//Obtem instancia de um algoritmo
		MessageDigest md = MessageDigest.getInstance("MD5");
		
		//Passa os dados a serem criptografados e estipula 1 enconding padrão
		md.update(senha.getBytes("ISO-8859-1"));
		
		//Gera chave criptografada em array Bytes
		BigInteger hash = new BigInteger(1, md.digest());
			
		return hash.toString(16);
	}
}
