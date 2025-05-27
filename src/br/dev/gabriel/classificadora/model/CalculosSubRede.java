package br.dev.gabriel.classificadora.model;

public class CalculosSubRede {

    public void calcularSubRedes(String ipBase, String cidrOriginal, String classe) {
        int subRedesExistentes = 0;
        int cidr = Integer.parseInt(cidrOriginal);
        
        int base = 0;
        
        if (classe.equals("A")) {
            base = 8;
        } else if (classe.equals("B")) {
            base = 16;
        } else if (classe.equals("C")) {
            base = 24;
        }
        int bitsEmprestados = cidr - base;

        if (bitsEmprestados > 0) {
            subRedesExistentes = (int) Math.pow(2, bitsEmprestados);
            System.out.println("Você pode ter " + subRedesExistentes + " Sub redes" );
        } else {
        	System.out.println("Você não possui Sub-Redes...");
        }
        
        System.out.println("=================================");
        
    }
}