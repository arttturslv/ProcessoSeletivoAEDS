package entities;

public class Curso {
    private String nomeCurso;
    private int codCurso, qntVagas;
    private double notaCorte; //calc
    private Fila filaEspera;
    //private Lista listaAprovados;

    public Curso (int codCurso, String nomeCurso, int qntVagas) {
        this.codCurso = codCurso;
        this.nomeCurso = nomeCurso;
        this.qntVagas = qntVagas;
    }

    public void mostrar() {
        System.out.println("id \t- "+codCurso);
        System.out.println("nome \t- "+nomeCurso);
        System.out.println("vagas \t- "+qntVagas);
    }

}
