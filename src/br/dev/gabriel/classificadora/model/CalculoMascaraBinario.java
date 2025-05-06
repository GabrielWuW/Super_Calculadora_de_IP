package br.dev.gabriel.classificadora.model;

public class CalculoMascaraBinario {
	public void TransformaBinario(String cidr) {

		int cidrNumero = Integer.parseInt(cidr);
		StringBuilder parteUm = new StringBuilder();
		
		while(cidrNumero > 0) {
			cidrNumero --;
			parteUm.append("1");
		}
		
		while(parteUm.length() < 32) {
			parteUm.append("0");
		}
		
		System.out.println(parteUm);
	}
}