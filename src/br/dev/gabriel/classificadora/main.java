package br.dev.gabriel.classificadora;

import java.util.Scanner;
import br.dev.gabriel.classificadora.model.CalculosIp;
import br.dev.gabriel.classificadora.ui.Ui;

public class main {

    public static void main(String[] args) {
//    	Scanner leitor = new Scanner(System.in);
//
//        while (true) {
//            System.out.println("Digite um IP seguido de um CIDR (Ex: 192.168.1.1/24) ou 'sair' para encerrar:");
//            String ip = leitor.nextLine();
//
//            if (ip.equalsIgnoreCase("sair")) {
//                System.out.println("Encerrando o programa.");
//                break;
//            }
//
//            try {
//                CalculosIp cla = new CalculosIp();
//                cla.EncontraClasse(ip);
//
//                System.out.println("Classe: " + cla.getClasse());
//                System.out.println("CIDR padrão da classe: " + cla.getCidrPadraoClasse());
//                System.out.println("CIDR informado: " + cla.getCidrUsuario());
//                System.out.println("Máscara Decimal: " + cla.getMascaraDecimal());
//                System.out.println("Máscara Binária: " + cla.getMascaraBinaria());
//                System.out.println("Total de IPs da rede: " + cla.getTotalIpsRedeOriginal());
//                System.out.println("IPs disponíveis por sub-rede: " + cla.getIpsDisponiveisSubRede());
//                System.out.println("Número de sub-redes existentes: " + cla.getSubRedesExistentes());
//
//                System.out.println("Detalhes das sub-redes:");
//                for (String detalhe : cla.getDetalhesSubRedes()) {
//                    System.out.println(detalhe);
//                }
//                System.out.println("----------------------------");
//            } catch (Exception e) {
//                System.out.println("Entrada inválida. Certifique-se de digitar o IP no formato correto (Ex: 192.168.1.1/24).");
//            }
//        }

   	
    	
    	Ui tela = new Ui();
    	tela.criarTela("Super Calculadora de Ips");
    }
}