package ui;

import dominio.Crianca;
import dominio.Responsavel;

import javax.swing.*;

public class Tela2 extends JFrame {
    private JTextField nomeField, idadeField, sexoField;
    private Responsavel responsavel;

    public Tela2(Responsavel responsavel) {
        this.responsavel = responsavel;
        setTitle("Cadastro da Criança");
        setSize(300, 200);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        nomeField = new JTextField("Nome");
        idadeField = new JTextField("Idade");
        sexoField = new JTextField("Sexo");

        JButton nextButton = new JButton("Próximo");
        nextButton.addActionListener(e -> {
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

        panel.add(nomeField);
        panel.add(idadeField);
        panel.add(sexoField);
        panel.add(nextButton);

        add(panel);
    }
}
