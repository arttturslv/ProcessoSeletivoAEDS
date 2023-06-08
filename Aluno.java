public class Aluno {
    private String nome;
    private double notaRedacao, notaMatematica, notaLinguagem;
    private int [] opcoesCursos;

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
    public int[] getOpcoesCursos() {
        return opcoesCursos;
    }

    /* SETTERS */
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setNotaRedacao(double notaRedacao) {
        this.notaRedacao = notaRedacao;
    }
    public void setNotaMatematica(double notaMatematica) {
        this.notaMatematica = notaMatematica;
    }
    public void setNotaLinguagem(double notaLinguagem) {
        this.notaLinguagem = notaLinguagem;
    }
    public void setOpcoesCursos(int[] opcoesCursos) {
        this.opcoesCursos = opcoesCursos;
    }

    
    
}
