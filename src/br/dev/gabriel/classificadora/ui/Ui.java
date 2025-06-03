package br.dev.gabriel.classificadora.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

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
    private JLabel ipsPorSubRede;

    private JPanel painelSubRede;
    private JLabel tituloSubRedes;
    private List<JLabel> labelsSubRedes = new ArrayList<>();

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

        // Título da página
        tituloPagina = new JLabel("Super Calculadora de IPs");
        tituloPagina.setBounds(0, 30, 1200, 30);
        tituloPagina.setHorizontalAlignment(JLabel.CENTER);
        tituloPagina.setFont(new Font("Segoe UI", Font.BOLD, 24));
        tituloPagina.setForeground(Color.WHITE);

        // Indicacao
        indicacao = new JLabel("Digite um IP e um CIDR (Ex: 192.168.15.1/24):");
        indicacao.setBounds(30, 100, 500, 30);
        indicacao.setFont(new Font("Segoe UI", Font.BOLD, 20));
        indicacao.setForeground(Color.WHITE);

        // Campo texto
        ipFornecido = new JTextField();
        ipFornecido.setBounds(40, 150, 500, 45);
        ipFornecido.setFont(new Font("Segoe UI", Font.BOLD, 20));
        ipFornecido.setBackground(Color.WHITE);
        ipFornecido.setForeground(new Color(50, 50, 50));
        ipFornecido.setCaretColor(new Color(123, 31, 162));
        ipFornecido.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(123, 31, 162), 2));

        // Botao calcular
        btnCalcular = new JButton("Calcular!");
        btnCalcular.setBounds(560, 150, 120, 45);
        btnCalcular.setFont(new Font("Segoe UI", Font.BOLD, 20));
        btnCalcular.setBackground(new Color(123, 31, 162));
        btnCalcular.setForeground(Color.WHITE);
        btnCalcular.setFocusPainted(false);
        btnCalcular.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(100, 20, 140), 2));

        // Painel principal para infos da rede
        JPanel painelResultado = new JPanel();
        painelResultado.setLayout(null);
        painelResultado.setBounds(30, 220, 540, 400);
        painelResultado.setBackground(new Color(100, 20, 140));

        // Painel sub-redes
        painelSubRede = new JPanel();
        painelSubRede.setLayout(null);
        painelSubRede.setBounds(613, 220, 540, 400);
        painelSubRede.setBackground(new Color(100, 20, 140));

        // Labels principais da rede
        classeIp = new JLabel();
        classeIp.setBounds(20, 10, 500, 30);
        classeIp.setFont(new Font("Segoe UI", Font.BOLD, 18));
        classeIp.setForeground(Color.WHITE);

        mascaraNormal = new JLabel();
        mascaraNormal.setBounds(20, 50, 500, 30);
        mascaraNormal.setFont(new Font("Segoe UI", Font.BOLD, 18));
        mascaraNormal.setForeground(Color.WHITE);

        mascaraBinario = new JLabel();
        mascaraBinario.setBounds(20, 90, 500, 30);
        mascaraBinario.setFont(new Font("Segoe UI", Font.BOLD, 18));
        mascaraBinario.setForeground(Color.WHITE);

        numeroSubRedes = new JLabel();
        numeroSubRedes.setBounds(20, 130, 500, 30);
        numeroSubRedes.setFont(new Font("Segoe UI", Font.BOLD, 18));
        numeroSubRedes.setForeground(Color.WHITE);

        ipsPorSubRede = new JLabel();
        ipsPorSubRede.setBounds(20, 170, 500, 30);
        ipsPorSubRede.setFont(new Font("Segoe UI", Font.BOLD, 18));
        ipsPorSubRede.setForeground(Color.WHITE);

        // Título do painel sub-redes
        tituloSubRedes = new JLabel("Detalhes das Sub-redes:");
        tituloSubRedes.setBounds(20, 10, 500, 30);
        tituloSubRedes.setFont(new Font("Segoe UI", Font.BOLD, 20));
        tituloSubRedes.setForeground(Color.WHITE);
        painelSubRede.add(tituloSubRedes);

        // Adiciona labels ao painel principal
        painelResultado.add(classeIp);
        painelResultado.add(mascaraNormal);
        painelResultado.add(mascaraBinario);
        painelResultado.add(numeroSubRedes);
        painelResultado.add(ipsPorSubRede);

        // Ação botão calcular
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ipEscrito = ipFornecido.getText().trim();

                try {
                    CalculosIp cla = new CalculosIp();
                    cla.encontraClasse(ipEscrito);

                    // Atualiza informações principais
                    classeIp.setText("Classe do IP: " + cla.getClasse());
                    mascaraNormal.setText("Máscara Decimal: " + cla.getMascaraDecimal());
                    mascaraBinario.setText("Máscara Binária: " + cla.getMascaraBinaria());
                    numeroSubRedes.setText("Número de Sub-redes possíveis: " + cla.getSubRedesExistentes());

                    if (cla.getSubRedesExistentes() == 0) {
                        ipsPorSubRede.setText("Rede original: " + cla.getTotalIpsRedeOriginal() +
                                              " IPs totais, " + cla.getIpsDisponiveisSubRede() + " utilizáveis");
                    } else {
                        ipsPorSubRede.setText("Por sub-rede: " + cla.getTotalIpsRedeOriginal() +
                                              " IPs totais, " + cla.getIpsDisponiveisSubRede() + " utilizáveis");
                    }

                    // Limpa labels antigas das sub-redes
                    for (JLabel lbl : labelsSubRedes) {
                        painelSubRede.remove(lbl);
                    }
                    labelsSubRedes.clear();

                    // Cria novos labels para cada sub-rede
                    List<String[]> detalhes = cla.getDetalhesSubRedes();
                    if (detalhes == null || detalhes.isEmpty()) {
                        JLabel vazio = new JLabel("<html><i>Nenhuma sub-rede calculada.</i></html>");
                        vazio.setForeground(Color.WHITE);
                        vazio.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                        vazio.setBounds(20, 50, 500, 30);
                        painelSubRede.add(vazio);
                        labelsSubRedes.add(vazio);
                    } else {
                        int y = 50; // posição vertical inicial
                        for (int i = 0; i < detalhes.size(); i++) {
                            String[] infos = detalhes.get(i);

                            // Monta texto formatado em HTML para o JLabel
                            StringBuilder sb = new StringBuilder("<html>");
                            sb.append("<b>Sub-rede #").append(i + 1).append(":</b><br>");
                            for (String info : infos) {
                                sb.append(info).append("<br>");
                            }
                            sb.append("</html>");

                            JLabel labelSubRede = new JLabel(sb.toString());
                            labelSubRede.setForeground(Color.WHITE);
                            labelSubRede.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                            labelSubRede.setBounds(20, y, 500, 70); // altura estimada, ajuste se necessário
                            painelSubRede.add(labelSubRede);
                            labelsSubRedes.add(labelSubRede);

                            y += 80; // espaçamento vertical para próxima label
                        }
                    }

                    // Atualiza o painel para mostrar as mudanças
                    painelSubRede.revalidate();
                    painelSubRede.repaint();

                } catch (Exception ex) {
                    classeIp.setText("Digite um IP seguido de um CIDR válido!");
                    mascaraNormal.setText("");
                    mascaraBinario.setText("");
                    numeroSubRedes.setText("");
                    ipsPorSubRede.setText("");

                    // Limpa painel sub-redes
                    for (JLabel lbl : labelsSubRedes) {
                        painelSubRede.remove(lbl);
                    }
                    labelsSubRedes.clear();

                    painelSubRede.revalidate();
                    painelSubRede.repaint();
                }
            }
        });

        ipFornecido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCalcular.doClick();
            }
        });

        // Adiciona componentes ao container
        container.add(tituloPagina);
        container.add(indicacao);
        container.add(ipFornecido);
        container.add(btnCalcular);
        container.add(painelResultado);
        container.add(painelSubRede);

        tela.setVisible(true);
    }
}