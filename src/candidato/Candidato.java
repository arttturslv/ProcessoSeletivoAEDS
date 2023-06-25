//possui informações dos candidatos
package src.candidato;

import java.text.DecimalFormat;

public class Candidato {
    DecimalFormat df = new DecimalFormat("###,##0.00");
    private String nome;
    private double notaRedacao;
    private double notaMatematica;
    private double notaLinguagem;
    private double notaMedia;
    private int primeiraOpcao;
    private int segundaOpcao;
    private boolean [] CursoSelecionado = {false, false}; //determina se já foi selecionado (true, false | false, true | false, false)

    //CONSTRUTOR
    public Candidato (String nome, double notaRedacao, double notaMatematica, double notaLinguagem, int primeiraOpcao, int segundaOpcao) {
        this.nome = nome;
        this.notaRedacao = notaRedacao;
        this.notaMatematica = notaMatematica;
        this.notaLinguagem = notaLinguagem;
        this.notaMedia = (notaRedacao + notaMatematica + notaLinguagem) / 3;
        this.primeiraOpcao = primeiraOpcao;
        this.segundaOpcao = segundaOpcao;
    }

    //GETTERS
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
    public double getNotaMedia() {
        return notaMedia;
    }
    public int getPrimeiraOpcao () {
        return primeiraOpcao;
    }
    public int getSegundaOpcao () {
        return segundaOpcao;
    }
    public boolean [] getCursoSelecionado () {
        return CursoSelecionado;
    }

    //SETTERS
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setprimeiraOpcao (int primeiraOpcao) {
        this.primeiraOpcao = primeiraOpcao;
    }
    public void setsegundaOpcao (int segundaOpcao) {
        this.segundaOpcao = segundaOpcao;
    }

    public void setNotaMedia (double valor) {
        this.notaMedia = valor;
    }
    public void setNotaRedacao (double valor) {
        this.notaMedia = valor;
    }
    public void setCursoSelecionado (int pos) { //pos recebe 1 ou 2, ou seja, foi selecionado na opcao 1 ou na opcao 2 do curso.
        this.CursoSelecionado[pos] = true;
    }

    //METODOS
    @Override
    public String toString() {
        return "\n" + nome +" "+ df.format(notaMedia);
    }
    public void mostrar() {
        System.out.println(getNome() + " "+getNotaMedia()+" \n- opção 1: "+primeiraOpcao+" \n- opção 2: "+segundaOpcao+"\n");
    }

}
