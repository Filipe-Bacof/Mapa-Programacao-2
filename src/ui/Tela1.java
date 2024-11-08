package ui;

import dominio.Responsavel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela1 extends JFrame {
    private JTextField nomeField, cpfField, telefoneField, emailField, enderecoField, idadeField;

    public Tela1() {
        setTitle("Cadastro do Responsável");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        nomeField = new JTextField("Nome");
        cpfField = new JTextField("CPF");
        telefoneField = new JTextField("Telefone");
        emailField = new JTextField("Email");
        enderecoField = new JTextField("Endereço");
        idadeField = new JTextField("Idade");

        JButton nextButton = new JButton("Próximo");
        nextButton.addActionListener(new ActionListener() {
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

        panel.add(nomeField);
        panel.add(cpfField);
        panel.add(telefoneField);
        panel.add(emailField);
        panel.add(enderecoField);
        panel.add(idadeField);
        panel.add(nextButton);

        add(panel);
    }

    public static void main(String[] args) {
        Tela1 tela1 = new Tela1();
        tela1.setVisible(true);
    }
}
