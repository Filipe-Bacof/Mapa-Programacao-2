package ui;

import dominio.Responsavel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela1 extends JFrame {
    private JTextField nomeField, cpfField, telefoneField, emailField, enderecoField, idadeField;
    private JButton avancarButton;

    public Tela1() {
        setTitle("Cadastro do Responsável - Etapa 1 de 3");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Criando e adicionando Labels e TextFields
        panel.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        panel.add(nomeField);

        panel.add(new JLabel("CPF:"));
        cpfField = new JTextField();
        panel.add(cpfField);

        panel.add(new JLabel("Telefone:"));
        telefoneField = new JTextField();
        panel.add(telefoneField);

        panel.add(new JLabel("Email:"));
        emailField = new JTextField();
        panel.add(emailField);

        panel.add(new JLabel("Endereço:"));
        enderecoField = new JTextField();
        panel.add(enderecoField);

        panel.add(new JLabel("Idade:"));
        idadeField = new JTextField();
        panel.add(idadeField);

        avancarButton = new JButton("Avançar");
        avancarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome = nomeField.getText();
                    String cpf = cpfField.getText();
                    String telefone = telefoneField.getText();
                    String email = emailField.getText();
                    String endereco = enderecoField.getText();
                    int idade = Integer.parseInt(idadeField.getText());

                    Responsavel responsavel = new Responsavel(nome, cpf, telefone, email, endereco, idade);
                    Tela2 tela2 = new Tela2(responsavel);
                    tela2.setVisible(true);
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
                }
            }
        });

        panel.add(avancarButton);
        add(panel);
    }

    public static void main(String[] args) {
        Tela1 tela1 = new Tela1();
        tela1.setVisible(true);
    }
}
