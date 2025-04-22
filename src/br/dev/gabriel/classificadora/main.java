package br.dev.gabriel.classificadora;

import java.util.Scanner;

import br.dev.gabriel.classificadora.model.CalculoClasse;
import br.dev.gabriel.classificadora.model.CalculoMascaraBinario;

public class main {

	public static void main(String[] args) {
		System.out.println("Qual o IP você vai calcular?");
		Scanner leitor = new Scanner(System.in);
		String ip = leitor.nextLine();
		System.out.println("Agora me diga a Mascara: ");
		String mascara = leitor.nextLine();
		
		CalculoClasse cla = new CalculoClasse();
		cla.EncontraClasse(ip);
		
		CalculoMascaraBinario masc = new CalculoMascaraBinario();
		masc.TransformaBinario(mascara);
	}
}