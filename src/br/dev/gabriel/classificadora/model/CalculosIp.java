package br.dev.gabriel.classificadora.model;

public class CalculosIp {

    public void EncontraClasse(String ipComCidr) {
        String[] cidrParts = ipComCidr.split("/");
        String ip = cidrParts[0];
        String cidr = cidrParts[1];
        String classe;

        String[] ipSeparado = ip.split("\\.");
        int primeiraCasa = Integer.parseInt(ipSeparado[0]);
        System.out.println("=================================");

        int cidrPadraoClasse = 0;
        if (primeiraCasa >= 1 && primeiraCasa <= 127) {
            System.out.println("Seu IP é de classe A");
            classe = "A";
            cidrPadraoClasse = 8;
        } else if (primeiraCasa >= 128 && primeiraCasa <= 191) {
            System.out.println("Seu IP é de classe B");
            classe = "B";
            cidrPadraoClasse = 16;
        } else if (primeiraCasa >= 192 && primeiraCasa <= 223) {
            System.out.println("Seu IP é de classe C");
            classe = "C";
            cidrPadraoClasse = 24;
        } else {
            System.out.println("Não sei que tipo de IP é esse...");
            classe = " ";
            return;
        }

        exibirInfoMascara(cidr);

        calcularIpsTotaisSemSubRede(cidrPadraoClasse, classe);

        CalculosSubRede sub = new CalculosSubRede();
        sub.calcularSubRedes(ip, cidr, classe);
    }

    private void exibirInfoMascara(String cidr) {
        CalculosMascara cal = new CalculosMascara();
        cal.TransformaBinario(cidr);

        int cidrNumero = Integer.parseInt(cidr);
        int bitsHost = 32 - cidrNumero;
        long totalIPs = (long) Math.pow(2, bitsHost);
        long IpsDisponiveis = totalIPs - 2;

        System.out.println("Total de IPs disponíveis por Sub-Rede: " + IpsDisponiveis);
    }

    private void calcularIpsTotaisSemSubRede(int cidrPadraoClasse, String classe) {
        if (cidrPadraoClasse == 0) {
            return;
        }

        int bitsHostRedeOriginal = 32 - cidrPadraoClasse;
        long totalIpsRedeOriginal = (long) Math.pow(2, bitsHostRedeOriginal);
        long ipsDisponiveisRedeOriginal = totalIpsRedeOriginal - 2;

        System.out.println("---------------------------------");
        System.out.println("IPs Totais da Rede:");
        System.out.println("Você possui: " + totalIpsRedeOriginal + " Ips totais e " + ipsDisponiveisRedeOriginal + " Ips disponíveis");
        System.out.println("---------------------------------");
    }
}