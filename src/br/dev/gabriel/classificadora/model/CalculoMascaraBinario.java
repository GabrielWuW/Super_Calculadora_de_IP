package br.dev.gabriel.classificadora.model;

public class CalculoMascaraBinario {
	public void TransformaBinario(String mascara) {
		String[] mascaraSeparada = mascara.split("\\.");
		
		int primeiraCasa = Integer.parseInt(mascaraSeparada[0]);
		int segundaCasa = Integer.parseInt(mascaraSeparada[1]);
		int terceiraCasa = Integer.parseInt(mascaraSeparada[2]);
		int quartaCasa = Integer.parseInt(mascaraSeparada[3]);
		
		String bin1 = String.format("%8s", Integer.toBinaryString(primeiraCasa)).replace(' ', '0');
        String bin2 = String.format("%8s", Integer.toBinaryString(segundaCasa)).replace(' ', '0');
        String bin3 = String.format("%8s", Integer.toBinaryString(terceiraCasa)).replace(' ', '0');
        String bin4 = String.format("%8s", Integer.toBinaryString(quartaCasa)).replace(' ', '0');
        
        System.out.println("Máscara em binário: " + bin1 + "." + bin2 + "." + bin3 + "." + bin4);
	}
}