package br.dev.gabriel.classificadora.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.dev.gabriel.classificadora.model.CalculosIp;

public class Ui {
	private JLabel tituloPagina;
	private JLabel indicacao;
	private JTextField ipFornecido;
	private JButton btnCalcular;
	private JLabel classeIp;
	private JLabel mascaraNormal;
	private JLabel mascaraBinario;
	private JLabel numeroSubRedes;
	private JLabel ipsTotaisDaSubRede;
	private JLabel ipsPorSubRede;
	private String tituloDaTela;

	public void criarTela(String nomeDaTela) {
		this.tituloDaTela = nomeDaTela;
		JFrame tela = new JFrame();
		tela.setTitle(this.tituloDaTela);
		tela.setSize(1200, 700);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);

		Container container = tela.getContentPane();
		container.setBackground(new Color(0xBA68C8));

		// Título da página //
		tituloPagina = new JLabel("Super Calculadora de IPs");
		tituloPagina.setBounds(0, 30, 1200, 30);
		tituloPagina.setHorizontalAlignment(JLabel.CENTER);
		tituloPagina.setFont(new Font("Sugoe Ui", Font.BOLD, 24));
		tituloPagina.setForeground(Color.WHITE);

		// Digite seu ip texto //
		indicacao = new JLabel("Digite um ip e um CIDR (Ex: 192.168.15.1/24):");
		indicacao.setBounds(30, 100, 500, 30);
		indicacao.setFont(new Font("Sugoe Ui", Font.BOLD, 20));
		indicacao.setForeground(Color.WHITE);

		// Jtext do Ip//
		ipFornecido = new JTextField();
		ipFornecido.setBounds(40, 150, 500, 45);
		ipFornecido.setFont(new Font("Segoe UI", Font.BOLD, 20));
		ipFornecido.setBackground(Color.WHITE);
		ipFornecido.setForeground(new Color(50, 50, 50));
		ipFornecido.setCaretColor(new Color(123, 31, 162));
		ipFornecido.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(123, 31, 162), 2));

		// Botão para calcular o ip//
		btnCalcular = new JButton("Calcular!");
		btnCalcular.setBounds(560, 150, 120, 45);
		btnCalcular.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnCalcular.setBackground(new Color(123, 31, 162));
		btnCalcular.setForeground(Color.WHITE);
		btnCalcular.setFocusPainted(false);
		btnCalcular.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(100, 20, 140), 2));

		// Painel de fundo roxo
		JPanel painelResultado = new JPanel();
		painelResultado.setLayout(null);
		painelResultado.setBounds(30, 220, 540, 400);
		painelResultado.setBackground(new Color(100, 20, 140));

		// Classe do ip//
		classeIp = new JLabel();
		classeIp.setBounds(20, 10, 500, 30);
		classeIp.setFont(new Font("Segoe UI", Font.BOLD, 18));
		classeIp.setForeground(Color.WHITE);

		// mascara normal//
		mascaraNormal = new JLabel();
		mascaraNormal.setBounds(20, 50, 500, 30);
		mascaraNormal.setFont(new Font("Segoe UI", Font.BOLD, 18));
		mascaraNormal.setForeground(Color.WHITE);

		// mascara binaria//
		mascaraBinario = new JLabel();
		mascaraBinario.setBounds(20, 90, 500, 30);
		mascaraBinario.setFont(new Font("Segoe UI", Font.BOLD, 18));
		mascaraBinario.setForeground(Color.WHITE);
		
		// Quantidade de sub-redes //
		numeroSubRedes = new JLabel();
		numeroSubRedes.setBounds(20, 130, 500, 30);
		numeroSubRedes.setFont(new Font("Segoe UI", Font.BOLD, 18));
		numeroSubRedes.setForeground(Color.WHITE);
		
		// IPs totais da sub-rede //
		ipsTotaisDaSubRede = new JLabel();
		ipsTotaisDaSubRede.setBounds(20, 170, 500, 30);
		ipsTotaisDaSubRede.setFont(new Font("Segoe UI", Font.BOLD, 18));
		ipsTotaisDaSubRede.setForeground(Color.WHITE);
		
		// Quantidade de ips por sub rede //
		ipsPorSubRede = new JLabel();
		ipsPorSubRede.setBounds(20, 170, 500, 30);
		ipsPorSubRede.setFont(new Font("Segoe UI", Font.BOLD, 18));
		ipsPorSubRede.setForeground(Color.WHITE);
		

		// Adicionando as Labels ao painel de fundo
		painelResultado.add(classeIp);
		painelResultado.add(mascaraNormal);
		painelResultado.add(mascaraBinario);
		painelResultado.add(numeroSubRedes);
		painelResultado.add(ipsPorSubRede);
		painelResultado.add(ipsTotaisDaSubRede);

		btnCalcular.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String ipEscrito = ipFornecido.getText();
				CalculosIp cla = new CalculosIp();
				cla.EncontraClasse(ipEscrito);

				// Mostra a classe do ip
				classeIp.setText("Classe do ip: " + cla.getClasse() + ";");

				// Mostra a mascara normal
				mascaraNormal.setText("Máscara Decimal: " + cla.getMascaraDecimal() + ";");

				// Mostra a mascara binaria
				mascaraBinario.setText("Máscara Binário: " + cla.getMascaraBinaria() + ";");
				
				// Mostra a quantidade de sub redes disponiveis
				numeroSubRedes.setText("Você tem: " + cla.getSubRedesExistentes() + " Sub-redes;");
				
				// Mostra a quantidade de ips que cada sub rede tem
				ipsPorSubRede.setText("Cada Sub-Rede tem: " + cla.getTotalIpsRedeOriginal() + " Ips totais e " + cla.getIpsDisponiveisSubRede() + " utilizaveis;");
				
				
			}
		});

		container.add(tituloPagina);
		container.add(indicacao);
		container.add(ipFornecido);
		container.add(btnCalcular);
		container.add(painelResultado);
		

		tela.setVisible(true);
	}
}