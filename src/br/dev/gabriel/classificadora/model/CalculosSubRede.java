package br.dev.gabriel.classificadora.model;

import org.apache.commons.net.util.SubnetUtils;
import org.apache.commons.net.util.SubnetUtils.SubnetInfo;

import java.util.ArrayList;
import java.util.List;

public class CalculosSubRede {

	public List<String[]> calcularSubRedesDetalhadas(String ipBase, int cidrOriginal, int novoCidr) {
	    List<String[]> subredes = new ArrayList<>();

	    int numSubredes = (int) Math.pow(2, novoCidr - cidrOriginal);

	    String[] octetos = ipBase.split("\\.");
	    int[] base = new int[] {
	        Integer.parseInt(octetos[0]),
	        Integer.parseInt(octetos[1]),
	        Integer.parseInt(octetos[2]),
	        Integer.parseInt(octetos[3])
	    };

	    int ipsPorSubrede = (int) Math.pow(2, 32 - novoCidr);

	    for (int i = 0; i < numSubredes; i++) {
	        int totalIp = i * ipsPorSubrede;
	        int[] ipSubRede = base.clone();
	        ipSubRede[3] += totalIp;

	        for (int j = 3; j > 0; j--) {
	            if (ipSubRede[j] > 255) {
	                ipSubRede[j - 1] += ipSubRede[j] / 256;
	                ipSubRede[j] %= 256;
	            }
	        }

	        String subRedeIp = String.format("%d.%d.%d.%d", ipSubRede[0], ipSubRede[1], ipSubRede[2], ipSubRede[3]);
	        SubnetUtils utils = new SubnetUtils(subRedeIp + "/" + novoCidr);
	        utils.setInclusiveHostCount(true);
	        SubnetInfo info = utils.getInfo();

	        subredes.add(new String[] {
	            "Sub-rede: " + info.getCidrSignature(),
	            "Endereço de rede: " + info.getNetworkAddress(),
	            "Broadcast: " + info.getBroadcastAddress(),
	            "Primeiro IP utilizável: " + info.getLowAddress(),
	            "Último IP utilizável: " + info.getHighAddress(),
	            "IPs utilizáveis por sub-rede: " + (info.getAddressCountLong() - 2)
	        });
	    }

	    return subredes;
	}
}