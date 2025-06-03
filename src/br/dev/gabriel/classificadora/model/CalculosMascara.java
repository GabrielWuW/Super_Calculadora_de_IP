package br.dev.gabriel.classificadora.model;

public class CalculosMascara {

    private String mascaraDecimal;
    private String mascaraBinaria;

    public String getMascaraDecimal() {
        return mascaraDecimal;
    }

    public void setMascaraDecimal(String mascaraDecimal) {
        this.mascaraDecimal = mascaraDecimal;
    }

    public String getMascaraBinaria() {
        return mascaraBinaria;
    }

    public void setMascaraBinaria(String mascaraBinaria) {
        this.mascaraBinaria = mascaraBinaria;
    }

    public void TransformaBinario(String cidr) {
        int cidrNumero = Integer.parseInt(cidr);
        StringBuilder parteUm = new StringBuilder();

        while (cidrNumero > 0) {
            cidrNumero--;
            parteUm.append("1");
        }

        while (parteUm.length() < 32) {
            parteUm.append("0");
        }

        String binario = parteUm.toString();
        String[] grupos = new String[4];
        int[] octetos = new int[4];

        for (int i = 0; i < 4; i++) {
            grupos[i] = binario.substring(i * 8, (i + 1) * 8);
            octetos[i] = Integer.parseInt(grupos[i], 2);
        }

        this.mascaraDecimal = octetos[0] + "." + octetos[1] + "." + octetos[2] + "." + octetos[3];
        this.mascaraBinaria = String.join(".", grupos);
    }
}