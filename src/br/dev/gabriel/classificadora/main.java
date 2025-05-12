package br.dev.gabriel.classificadora;

import java.util.Scanner;

import br.dev.gabriel.classificadora.model.CalculosIp;

public class main {

	public static void main(String[] args) {
		System.out.println("Digite um ip seguido de um CIDR (Ex: 192.168.1.1/24)");
		Scanner leitor = new Scanner(System.in);
		String ip = leitor.nextLine();
		System.out.println("Quantas Sub redes você quer?");
		String quantidadeSubRedes = leitor.nextLine();
		
		CalculosIp cla = new CalculosIp();
		cla.EncontraClasse(ip, quantidadeSubRedes);
	}
}