package br.dev.gabriel.classificadora.model;

import java.util.List;

public class CalculosIp {
    private String classe;
    private int cidrPadraoClasse;
    private int cidrUsuario;
    private long totalIpsRedeOriginal;
    private long ipsDisponiveisSubRede;
    private int subRedesExistentes;
    private List<String> detalhesSubRedes;

    // Novos atributos para armazenar as máscaras
    private String mascaraDecimal;
    private String mascaraBinaria;

    public void EncontraClasse(String ipComCidr) {
        String[] cidrParts = ipComCidr.split("/");
        String ip = cidrParts[0];
        String cidr = cidrParts[1];
        cidrUsuario = Integer.parseInt(cidr);

        String[] ipSeparado = ip.split("\\.");
        int primeiraCasa = Integer.parseInt(ipSeparado[0]);

        // Definir classe e CIDR padrão da classe
        if (primeiraCasa >= 1 && primeiraCasa <= 127) {
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
            return;
        }

        int bitsHost = 32 - cidrUsuario;
        totalIpsRedeOriginal = (long) Math.pow(2, bitsHost);
        ipsDisponiveisSubRede = totalIpsRedeOriginal - 2;

        // Calcular detalhes das sub-redes
        CalculosSubRede sub = new CalculosSubRede();
        detalhesSubRedes = sub.calcularSubRedesDetalhadas(ip, cidr, classe);

        if (cidrUsuario > cidrPadraoClasse) {
            subRedesExistentes = (int) Math.pow(2, cidrUsuario - cidrPadraoClasse);
        } else {
            subRedesExistentes = 0;
        }

        // Aqui fazemos o cálculo da máscara usando CalculosMascara
        CalculosMascara calcMascara = new CalculosMascara();
        calcMascara.TransformaBinario(cidr);
        mascaraDecimal = calcMascara.getMascaraDecimal();
        mascaraBinaria = calcMascara.getMascaraBinaria();
    }

    // Getters para os novos atributos
    public String getMascaraDecimal() {
        return mascaraDecimal;
    }

    public String getMascaraBinaria() {
        return mascaraBinaria;
    }

    // Getters existentes
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
        return totalIpsRedeOriginal;
    }

    public long getIpsDisponiveisSubRede() {
        return ipsDisponiveisSubRede;
    }

    public int getSubRedesExistentes() {
        return subRedesExistentes;
    }

    public List<String> getDetalhesSubRedes() {
        return detalhesSubRedes;
    }
}