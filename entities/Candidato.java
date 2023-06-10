package entities;

public class Candidato {
    private String nome;
    private double notaRedacao;
    private double notaMatematica;
    private double notaLinguagem;
    private int opcao1;
    private int opcao2;

    public Candidato () {}
    public Candidato (String nome, double notaRedacao, double notaMatematica, double notaLinguagem, int opcao1, int opcao2) {
        this.nome = nome;
        this.notaRedacao = notaRedacao;
        this.notaMatematica = notaMatematica;
        this.notaLinguagem = notaLinguagem;
        this.opcao1 = opcao1;
        this.opcao2 = opcao2;
    }

    @Override
    public String toString() {
        return "Candidato{" +
                "nome='" + nome + '\'' +
                ", notaRedacao=" + notaRedacao +
                ", notaMatematica=" + notaMatematica +
                ", notaLinguagem=" + notaLinguagem +
                ", opcao1=" + opcao1 +
                ", opcao2=" + opcao2 +
                '}';
    }

    public void mostrar() {
        System.out.println("nome \t- "+nome);
        System.out.println("redacao \t- "+notaRedacao);
        System.out.println("matematica \t- "+notaMatematica);
        System.out.println("linguagem \t- "+notaLinguagem);
        System.out.println("1ª opcao \t- "+opcao1);
        System.out.println("2ª opcao \t- "+opcao2);
    }


    /* GETTERS */
    public String getNome() {
        return nome;
    }
    public double getNotaRedacao() {
        return notaRedacao;
    }
    public double getNotaMatematica() {
        return notaMatematica;
    }
    public double getNotaLinguagem() {
        return notaLinguagem;
    }
    public int getOpcao1 () {
        return opcao1;
    }
    public int getOpcao2 () {
        return opcao2;
    }

    /* SETTERS */
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setOpcao1 (int opcao1) {
        this.opcao1 = opcao1;
    }
    public void setOpcao2 (int opcao2) {
        this.opcao2 = opcao2;
    }

    
    
}
