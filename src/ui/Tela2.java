package ui;

import dominio.Crianca;
import dominio.Responsavel;
import javax.swing.*;

public class Tela2 extends JFrame {
    private JTextField nomeField, idadeField, sexoField, responsavelField;
    private JButton avancarButton;
    private Responsavel responsavel;

    public Tela2(Responsavel responsavel) {
        this.responsavel = responsavel;
        setTitle("Cadastro da Criança - Etapa 2 de 3");
        setSize(300, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("Nome do Responsável:"));
        responsavelField = new JTextField(responsavel.getNome());
        responsavelField.setEditable(false);
        panel.add(responsavelField);

        panel.add(new JLabel("Nome da Criança:"));
        nomeField = new JTextField();
        panel.add(nomeField);

        panel.add(new JLabel("Idade da Criança:"));
        idadeField = new JTextField();
        panel.add(idadeField);

        panel.add(new JLabel("Sexo da Criança:"));
        sexoField = new JTextField();
        panel.add(sexoField);

        avancarButton = new JButton("Avançar");
        avancarButton.addActionListener(e -> {
            try {
                String nome = nomeField.getText();
                int idade = Integer.parseInt(idadeField.getText());
                String sexo = sexoField.getText();

                Crianca crianca = new Crianca(responsavel, nome, idade, sexo);
                Tela3 tela3 = new Tela3(responsavel, crianca);
                tela3.setVisible(true);
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            }
        });

        panel.add(avancarButton);
        add(panel);
    }
}
