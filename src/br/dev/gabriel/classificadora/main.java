package br.dev.gabriel.classificadora;

import java.util.List;
import java.util.Scanner;
import br.dev.gabriel.classificadora.model.CalculosIp;
import br.dev.gabriel.classificadora.ui.Ui;

public class main {

    public static void main(String[] args) {
//    	Scanner leitor = new Scanner(System.in);
//
//    	while (true) {
//    	    System.out.println("Digite um IP seguido de um CIDR (Ex: 192.168.1.0/24) ou 'sair' para encerrar:");
//    	    String entrada = leitor.nextLine().trim();
//
//    	    if (entrada.equalsIgnoreCase("sair")) {
//    	        System.out.println("Encerrando o programa.");
//    	        break;
//    	    }
//
//    	    try {
//    	        CalculosIp calc = new CalculosIp();
//    	        calc.encontraClasse(entrada);
//
//    	        System.out.println("\n--- INFORMAÇÕES DA REDE ---");
//    	        System.out.println("Classe: " + calc.getClasse());
//    	        System.out.println("CIDR padrão da classe: /" + calc.getCidrPadraoClasse());
//    	        System.out.println("CIDR informado: /" + calc.getCidrUsuario());
//    	        System.out.println("Máscara Decimal: " + calc.getMascaraDecimal());
//    	        System.out.println("Máscara Binária: " + calc.getMascaraBinaria());
//    	        System.out.println("Total de IPs da rede original: " + calc.getTotalIpsRedeOriginal());
//    	        System.out.println("IPs disponíveis por sub-rede: " + calc.getIpsDisponiveisSubRede());
//    	        System.out.println("Número de sub-redes possíveis: " + calc.getSubRedesExistentes());
//
//    	        System.out.println("\n--- DETALHES DAS SUB-REDES ---");
//    	        List<String[]> detalhes = calc.getDetalhesSubRedes();
//
//    	        if (detalhes.isEmpty()) {
//    	            System.out.println("Nenhuma sub-rede calculada.");
//    	        } else {
//    	            for (int i = 0; i < detalhes.size(); i++) {
//    	                System.out.println("Sub-rede #" + (i + 1) + ":");
//    	                for (String info : detalhes.get(i)) {
//    	                    System.out.println("  " + info);
//    	                }
//    	                System.out.println("-----------------------------");
//    	            }
//    	        }
//
//    	    } catch (Exception e) {
//    	        System.out.println("Erro: " + e.getMessage());
//    	        System.out.println("Entrada inválida. Use o formato IP/CIDR (ex: 192.168.0.0/24).");
//    	    }
//    	}
//
//    	leitor.close();
        
        Ui tela = new Ui();
        tela.criarTela("Super Calculadora");
    }
}