package br.dev.gabriel.classificadora.model;

import java.util.List;

public class CalculosIp {

    private String classe;
    private int cidrPadraoClasse;
    private int cidrUsuario;
    private long totalIpsRedeOriginal;
    private long ipsDisponiveisSubRede;
    private int subRedesExistentes;
    private List<String[]> detalhesSubRedes;

    private String mascaraDecimal;
    private String mascaraBinaria;

    public void encontraClasse(String ipComCidr) {
        String[] cidrParts = ipComCidr.split("/");

        if (cidrParts.length != 2) {
            throw new IllegalArgumentException("Formato inválido. Use o formato IP/CIDR, ex: 192.168.0.0/24");
        }

        String ip = cidrParts[0];
        String cidrStr = cidrParts[1];

        try {
            cidrUsuario = Integer.parseInt(cidrStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("CIDR inválido: " + cidrStr);
        }

        String[] ipSeparado = ip.split("\\.");
        if (ipSeparado.length != 4) {
            throw new IllegalArgumentException("IP inválido: " + ip);
        }

        int primeiraCasa = Integer.parseInt(ipSeparado[0]);

        if (primeiraCasa >= 1 && primeiraCasa <= 126) {
            classe = "A";
            cidrPadraoClasse = 8;
        } else if (primeiraCasa >= 128 && primeiraCasa <= 191) {
            classe = "B";
            cidrPadraoClasse = 16;
        } else if (primeiraCasa >= 192 && primeiraCasa <= 223) {
            classe = "C";
            cidrPadraoClasse = 24;
        } else {
            classe = "Desconhecida";
            throw new IllegalArgumentException("IP não pertence às classes A, B ou C");
        }

        // Calcula total IPs na rede original (com base no CIDR padrão da classe)
        int bitsHost = 32 - cidrPadraoClasse;
        totalIpsRedeOriginal = (long) Math.pow(2, bitsHost);

        // Calcula total IPs na sub-rede (baseado no CIDR informado)
        int bitsSubRede = 32 - cidrUsuario;
        long totalIpsSubRede = (long) Math.pow(2, bitsSubRede);

        // IPs utilizáveis em cada sub-rede (remove rede e broadcast)
        ipsDisponiveisSubRede = totalIpsSubRede - 2;

        // Quantidade de sub-redes possíveis (se houve subnetting)
        if (cidrUsuario > cidrPadraoClasse) {
            subRedesExistentes = (int) Math.pow(2, cidrUsuario - cidrPadraoClasse);
        } else {
            subRedesExistentes = 0;
        }

        // Agora chamamos CalculosSubRede com tipos corretos: ip (String), cidrOriginal (int), novoCidr (int)
        CalculosSubRede sub = new CalculosSubRede();
        detalhesSubRedes = sub.calcularSubRedesDetalhadas(ip, cidrPadraoClasse, cidrUsuario);

        // Calcula as máscaras decimal e binária
        CalculosMascara calcMascara = new CalculosMascara();
        calcMascara.TransformaBinario(cidrStr);
        mascaraDecimal = calcMascara.getMascaraDecimal();
        mascaraBinaria = calcMascara.getMascaraBinaria();
    }

    public String getClasse() {
        return classe;
    }

    public int getCidrPadraoClasse() {
        return cidrPadraoClasse;
    }

    public int getCidrUsuario() {
        return cidrUsuario;
    }

    public long getTotalIpsRedeOriginal() {
        return totalIpsRedeOriginal;  // Corrigido para retornar o valor já calculado corretamente
    }

    public long getIpsDisponiveisSubRede() {
        return ipsDisponiveisSubRede;
    }

    public int getSubRedesExistentes() {
        return subRedesExistentes;
    }

    public List<String[]> getDetalhesSubRedes() {
        return detalhesSubRedes;
    }

    public String getMascaraDecimal() {
        return mascaraDecimal;
    }

    public String getMascaraBinaria() {
        return mascaraBinaria;
    }
}