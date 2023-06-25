package src.candidato;

import java.text.DecimalFormat;

public class Candidato {
    DecimalFormat formataDouble = new DecimalFormat("###,##0.00");
    private String nome;
    private double notaRedacao;
    private double notaMatematica;
    private double notaLinguagem;
    private double notaMedia;
    private int primeiraOpcao;
    private int segundaOpcao;

    public Candidato(String nome, double notaRedacao, double notaMatematica, double notaLinguagem, int primeiraOpcao, int segundaOpcao) {
        this.nome = nome;
        this.notaRedacao = notaRedacao;
        this.notaMatematica = notaMatematica;
        this.notaLinguagem = notaLinguagem;
        this.notaMedia = (notaRedacao + notaMatematica + notaLinguagem) / 3;
        this.primeiraOpcao = primeiraOpcao;
        this.segundaOpcao = segundaOpcao;
    }

    public String getNome() {
        return nome;
    }

    public double getNotaRedacao() {
        return notaRedacao;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    public int getPrimeiraOpcao() {
        return primeiraOpcao;
    }

    public int getSegundaOpcao() {
        return segundaOpcao;
    }

    public double getNotaMatematica() { //não utilizados, mas excluir deixa erro "not used"
        return notaMatematica;
    }
    public double getNotaLinguagem() { //não utilizados, mas excluir deixa erro "not used"
        return notaLinguagem;
    }

    @Override
    public String toString() {
        return "\n" + nome + " " + formataDouble.format(notaMedia);
    }
}
