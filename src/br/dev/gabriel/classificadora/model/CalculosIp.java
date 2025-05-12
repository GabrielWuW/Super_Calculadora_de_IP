package br.dev.gabriel.classificadora.model;

public class CalculosIp {
    public void EncontraClasse(String ipComCidr, String subRedes) {
        String[] cidrParts = ipComCidr.split("/");  // Separando IP e CIDR
        String ip = cidrParts[0];
        String cidr = cidrParts[1];

        String[] ipSeparado = ip.split("\\.");
        int primeiraCasa = Integer.parseInt(ipSeparado[0]);

        // Classificação do IP e ajuste do CIDR conforme a classe
        if (primeiraCasa >= 1 && primeiraCasa <= 127) {
            System.out.println("Seu IP é de classe A");
            cidr = ajustarCidrParaClasse(cidr, 8);  // Classe A recomenda CIDR mínimo 8
        } else if (primeiraCasa >= 128 && primeiraCasa <= 191) {
            System.out.println("Seu IP é de classe B");
            cidr = ajustarCidrParaClasse(cidr, 16);  // Classe B recomenda CIDR mínimo 16
        } else if (primeiraCasa >= 192 && primeiraCasa <= 223) {
            System.out.println("Seu IP é de classe C");
            cidr = ajustarCidrParaClasse(cidr, 24);  // Classe C recomenda CIDR mínimo 24
        } else {
            System.out.println("Não sei que tipo de IP é esse.");
            return;
        }
        
        // Calculando e exibindo máscara de rede
        exibirInfoMascara(cidr);

        // Calculando as sub-redes com base no CIDR ajustado e na quantidade de sub-redes
        CalculosSubRede sub = new CalculosSubRede();
        sub.calcularSubRedes(ip, cidr, Integer.parseInt(subRedes));
    }

    private void exibirInfoMascara(String cidr) {
        CalculosMascara cal = new CalculosMascara();
        cal.TransformaBinario(cidr);

        int cidrNumero = Integer.parseInt(cidr);
        int bitsHost = 32 - cidrNumero;
        int totalIPs = (int) Math.pow(2, bitsHost);
        int IpsDisponiveis = totalIPs - 2;

        System.out.println("Total de IPs disponíveis: " + IpsDisponiveis);
    }

    // Método para ajustar o CIDR conforme a classe do IP
    private String ajustarCidrParaClasse(String cidr, int cidrMinimo) {
        int cidrInt = Integer.parseInt(cidr);
        
        // Se o CIDR for menor que o valor mínimo recomendado para a classe, ajusta
        if (cidrInt < cidrMinimo) {
            System.out.println("CIDR fornecido é menor que o mínimo recomendado para a classe. Ajustando CIDR para " + cidrMinimo + ".");
            return String.valueOf(cidrMinimo);  // Retorna o CIDR ajustado para o valor mínimo recomendado
        }

        return cidr;
    }
}