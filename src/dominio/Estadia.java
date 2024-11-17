package dominio;

import java.text.DecimalFormat;

public class Estadia {
    private Responsavel responsavel;
    private Crianca crianca;
    private int minutosUtilizados;

    public Estadia(Responsavel responsavel, Crianca crianca, int minutosUtilizados) {
        this.responsavel = responsavel;
        this.crianca = crianca;
        this.minutosUtilizados = minutosUtilizados;
    }

    public String calcularValor() {
        double valorPorMinuto = 1.5;
        double valorTotal = minutosUtilizados * valorPorMinuto;

        if (minutosUtilizados > 60) {
            valorTotal *= 0.85;
        } else if (minutosUtilizados > 40) {
            valorTotal *= 0.90;
        } else if (minutosUtilizados > 20) {
            valorTotal *= 0.95;
        }

        DecimalFormat formatoMonetario = new DecimalFormat("0.00");
        return formatoMonetario.format(valorTotal);
    }

    public Responsavel getResponsavel() { return responsavel; }
    public Crianca getCrianca() { return crianca; }
    public int getMinutosUtilizados() { return minutosUtilizados; }
}
