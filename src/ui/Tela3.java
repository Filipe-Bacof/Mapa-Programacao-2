package ui;

import dominio.Crianca;
import dominio.Estadia;
import dominio.Responsavel;

import javax.swing.*;

public class Tela3 extends JFrame {
    private JTextField minutosField;
    private Responsavel responsavel;
    private Crianca crianca;

    public Tela3(Responsavel responsavel, Crianca crianca) {
        this.responsavel = responsavel;
        this.crianca = crianca;
        setTitle("Cadastro de Estadia e Resumo");
        setSize(300, 200);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        minutosField = new JTextField("Tempo (minutos)");

        JButton finalizarButton = new JButton("Finalizar");
        finalizarButton.addActionListener(e -> {
            try {
                int minutos = Integer.parseInt(minutosField.getText());
                Estadia estadia = new Estadia(responsavel, crianca, minutos);
                double valor = estadia.calcularValor();

                JOptionPane.showMessageDialog(this, "Resumo:\n" +
                        "Responsável: " + responsavel.getNome() + "\n" +
                        "Criança: " + crianca.getNome() + "\n" +
                        "Tempo: " + minutos + " minutos\n" +
                        "Valor: R$ " + valor);
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            }
        });

        panel.add(minutosField);
        panel.add(finalizarButton);
        add(panel);
    }
}
