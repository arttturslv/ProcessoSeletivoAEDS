package entities;

import java.util.Queue;

public class Curso {
    private String nomeCurso;
    private int codCurso;
    private int qntVagas;
    private double notaCorte; //calc
    private Queue<Candidato> filaEspera;
    //private Lista listaAprovados;

    public Curso () {}
    public Curso (int codCurso, String nomeCurso, int qntVagas) {
        this.codCurso = codCurso;
        this.nomeCurso = nomeCurso;
        this.qntVagas = qntVagas;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nomeCurso='" + nomeCurso + '\'' +
                ", codCurso=" + codCurso +
                ", qntVagas=" + qntVagas +
                ", notaCorte=" + notaCorte +
                ", filaEspera=" + filaEspera +
                '}';
    }

    public void mostrar() {
        System.out.println("id \t- "+codCurso);
        System.out.println("nome \t- "+nomeCurso);
        System.out.println("vagas \t- "+qntVagas);
    }

}
