package br.dev.gabriel.classificadora.model;

import java.util.ArrayList;
import java.util.List;

public class CalculosSubRede {

    public List<String> calcularSubRedesDetalhadas(String ipBase, String cidrOriginal, String classe) {
        List<String> detalhes = new ArrayList<>();
        int subRedesExistentes = 0;
        int cidr = Integer.parseInt(cidrOriginal);

        int base = 0;
        if (classe.equalsIgnoreCase("A")) {
            base = 8;
        } else if (classe.equalsIgnoreCase("B")) {
            base = 16;
        } else if (classe.equalsIgnoreCase("C")) {
            base = 24;
        } else {
            detalhes.add("Classe inválida.");
            return detalhes;
        }

        int bitsEmprestados = cidr - base;
        if (bitsEmprestados > 0) {
            subRedesExistentes = (int) Math.pow(2, bitsEmprestados);
            detalhes.add("Você pode ter " + subRedesExistentes + " Sub-redes");
        } else {
            detalhes.add("Você não possui Sub-Redes...");
            return detalhes;
        }

        int ipIntBase = ipToInt(ipBase);
        int mask = ~((1 << (32 - cidr)) - 1);
        int ipDeRede = ipIntBase & mask;
        int tamanhoBloco = (int) Math.pow(2, 32 - cidr);

        detalhes.add("Cada sub-rede possui " + tamanhoBloco + " IPs totais.");
        detalhes.add("IPs utilizáveis por sub-rede: " + (tamanhoBloco - 2));

        for (int i = 0; i < subRedesExistentes; i++) {
            int inicio = ipDeRede + (i * tamanhoBloco);
            int fim = inicio + tamanhoBloco - 1;

            detalhes.add("Sub-rede " + (i + 1) + ":");
            detalhes.add("IP de Rede:     " + intToIp(inicio));
            detalhes.add("Primeiro IP:    " + intToIp(inicio + 1));
            detalhes.add("Último IP:      " + intToIp(fim - 1));
            detalhes.add("IP de Broadcast:" + intToIp(fim));
            detalhes.add("-------------------------------");
        }

        return detalhes;
    }

    private int ipToInt(String ip) {
        String[] partes = ip.trim().split("\\.");
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result |= (Integer.parseInt(partes[i]) << (24 - (8 * i)));
        }
        return result;
    }

    private String intToIp(int ip) {
        return ((ip >> 24) & 0xFF) + "." +
               ((ip >> 16) & 0xFF) + "." +
               ((ip >> 8) & 0xFF) + "." +
               (ip & 0xFF);
    }
}