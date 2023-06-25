package src.curso;

import java.text.DecimalFormat;

import src.candidato.Candidato;
import src.fila.FilaEspera;
import src.lista.ListCandidatos;

public class Curso {
    DecimalFormat formataDouble = new DecimalFormat("###,##0.00"); //usado para formatação das casas decimais (double)
    private String nomeCurso;
    private int codigoCurso;
    private int quantidadeVagas;
    private double notaCorte;
    private ListCandidatos listaSelecionados;
    private FilaEspera filaEspera;

    public Curso(int codigoCurso, String nomeCurso, int quantidadeVagas) {
        this.codigoCurso = codigoCurso;
        this.nomeCurso = nomeCurso;
        this.quantidadeVagas = quantidadeVagas;
        this.listaSelecionados = new ListCandidatos();
        this.filaEspera = new FilaEspera();
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public int getcodigoCurso() {
        return codigoCurso;
    }

    public double getNotaCorte() {
        return notaCorte;
    }

    @Override
    public String toString() {
        return (getNomeCurso() + " " + formataDouble.format(getNotaCorte()) +
                "\nSelecionados" +
                listaSelecionados.toString() +
                "\nFila de espera" +
                filaEspera.toString() +
                "\n\n"
                );
    }

    public void mostrar() {
        System.out.println(" - Nome do curso: " + nomeCurso);
    }

    /*
     * O metodo recebe um candidato, se existir vaga ele entra na lista de selecionados
     * Se não houver vagas, ele entra na fila de espera.
    */
    public boolean inserirCandidato(Candidato candidato) {
        if (existeVaga()) {
            notaCorte = candidato.getNotaMedia(); // Atualiza a nota de corte a cada aluno novo

            listaSelecionados.inserirFim(candidato);
            quantidadeVagas--;
            return true;
        } else {
            filaEspera.inserir(candidato);
            return false;
        }
    }

    public boolean existeVaga() {
        if (quantidadeVagas != 0) {
            return true;
        }
        return false;
    }
}
