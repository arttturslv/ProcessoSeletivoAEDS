package entities;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Curso {
    private String nomeCurso;
    private int codCurso;
    private int qntVagas;
    private double notaCorte; //calc
    private List<Candidato> listaSelecionados;
    private Queue<Candidato> filaEspera;
    //private Lista listaAprovados;

    public Curso () {}
    public Curso (int codCurso, String nomeCurso, int qntVagas) {
        this.codCurso = codCurso;
        this.nomeCurso = nomeCurso;
        this.qntVagas = qntVagas;
        this.listaSelecionados = new ArrayList<>();
        this.filaEspera = new LinkedList<>();
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public int getCodCurso() {
        return codCurso;
    }

    public int getQntVagas() {
        return qntVagas;
    }

    public double getNotaCorte() {
        return notaCorte;
    }

    public List<Candidato> getListaSelecionados() {
        return listaSelecionados;
    }

    public Queue<Candidato> getFilaEspera() {
        return filaEspera;
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

    public boolean inserirSelecionado (Candidato candidato){
        if (qntVagas > 0){
            listaSelecionados.add(candidato);
            qntVagas--;
            return true;
        }
        return false;
    }
}
