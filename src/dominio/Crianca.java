package dominio;

public class Crianca {
    private Responsavel responsavel;
    private String nome;
    private int idade;
    private String sexo;

    public Crianca(Responsavel responsavel, String nome, int idade, String sexo) {
        if (idade > 10) {
            throw new IllegalArgumentException("A criança deve ter 10 anos ou menos.");
        }
        this.responsavel = responsavel;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }

    public Responsavel getResponsavel() { return responsavel; }
    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public String getSexo() { return sexo; }
}
