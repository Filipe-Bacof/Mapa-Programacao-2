package ui;

import dominio.Crianca;
import dominio.Estadia;
import dominio.Responsavel;
import javax.swing.*;

public class Tela3 extends JFrame {
    private JTextField minutosField, responsavelField, criancaField;
    private JButton calcularEMostrarResumoButton;
    private Responsavel responsavel;
    private Crianca crianca;

    public Tela3(Responsavel responsavel, Crianca crianca) {
        this.responsavel = responsavel;
        this.crianca = crianca;
        setTitle("Cadastro de Estadia e Resumo - Etapa 3 de 3");
        setSize(300, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("Nome do Responsável:"));
        responsavelField = new JTextField(responsavel.getNome());
        responsavelField.setEditable(false);
        panel.add(responsavelField);

        panel.add(new JLabel("Nome da Criança:"));
        criancaField = new JTextField(crianca.getNome());
        criancaField.setEditable(false);
        panel.add(criancaField);

        panel.add(new JLabel("Tempo no Brinquedo (minutos):"));
        minutosField = new JTextField();
        panel.add(minutosField);

        calcularEMostrarResumoButton = new JButton("Calcular e Mostrar Resumo");
        calcularEMostrarResumoButton.addActionListener(e -> {
            try {
                int minutos = Integer.parseInt(minutosField.getText());
                Estadia estadia = new Estadia(responsavel, crianca, minutos);
                String valor = estadia.calcularValor();

                JOptionPane.showMessageDialog(this, "Resumo:\n" +
                        "Nome Responsável: " + responsavel.getNome() + "\n" +
                        "CPF Responsável: " + responsavel.getCpf() + "\n" +
                        "Telefone Responsável: " + responsavel.getTelefone() + "\n" +
                        "Email Responsável: " + responsavel.getEmail() + "\n" +
                        "Endereço Responsável: " + responsavel.getEndereco() + "\n" +
                        "Idade Responsável: " + responsavel.getIdade() + "\n" +
                        "Nome Criança: " + crianca.getNome() + "\n" +
                        "Idade Criança: " + crianca.getIdade() + "\n" +
                        "Sexo Criança: " + crianca.getSexo() + "\n" +
                        "Tempo no Brinquedo: " + minutos + " minutos\n" +
                        "Valor a Pagar: R$ " + valor);
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            }
        });

        panel.add(calcularEMostrarResumoButton);
        add(panel);
    }
}
