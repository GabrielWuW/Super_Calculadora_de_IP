package br.dev.gabriel.classificadora.model;

public class CalculosSubRede {
    public void calcularSubRedes(String ipBase, String cidrOriginal, int quantidadeSubRedes) {
        // Converte o CIDR para um número inteiro
        int cidr = Integer.parseInt(cidrOriginal);
        System.out.println("CIDR: /" + cidr);

        // Calculando o número de bits necessários para dividir as sub redes
        int bitsParaSubRedes = (int) Math.ceil(Math.log(quantidadeSubRedes) / Math.log(2));
        int novoCidr = cidr + bitsParaSubRedes;

        if (novoCidr > 30) {
            System.out.println("Muitas sub redes.......");
            return;
        }

        // Calculando o número de IPs pra cada sub rede
        int ipsPorSubrede = 1 << (32 - novoCidr);

        System.out.println("cidr de cada sub rede: /" + novoCidr);
        System.out.println("Cada sub rede possui: " + ipsPorSubrede + " IPs");
    }
}