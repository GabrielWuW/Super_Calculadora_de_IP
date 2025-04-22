package br.dev.gabriel.classificadora.model;

public class CalculoClasse {
    public void EncontraClasse(String ip) {
        String[] ipSeparado = ip.split("\\.");
        String[] CIDR = ip.split("\\/");
        
        int primeiraCasa = Integer.parseInt(ipSeparado[0]);
        
        if (primeiraCasa >= 1 && primeiraCasa <= 127) {
            System.out.println("Seu ip é de classe A");
        } else if (primeiraCasa >= 128 && primeiraCasa <= 191) {
        	System.out.println("Seu ip é de classe B");
        } else if (primeiraCasa >= 192 && primeiraCasa <= 223) {
        	System.out.println("Seu ip é de classe C");
        	System.out.println(CIDR[1]);
        } else {
            System.out.println("Não sei que tipo de IP é esse kkkkkkkk");
        }
    }
}