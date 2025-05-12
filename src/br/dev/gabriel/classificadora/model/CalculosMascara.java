package br.dev.gabriel.classificadora.model;

public class CalculosMascara {
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

        String mascaraDecimal = octetos[0] + "." + octetos[1] + "." + octetos[2] + "." + octetos[3];
        String mascaraBinaria = String.join(".", grupos);

        System.out.println("Máscara decimal: " + mascaraDecimal);
        System.out.println("Máscara binário: " + mascaraBinaria);
        
    }
}