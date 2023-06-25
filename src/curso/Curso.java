//Armazena os cursos
package src.curso;

import java.text.DecimalFormat;

import src.candidato.Candidato;
import src.fila.FilaEspera;
import src.lista.ListCandidatos;

public class Curso {
    private String nomeCurso;
    private int codCurso;
    private int qntVagas;
    private double notaCorte;
    private ListCandidatos listaSelecionados;
    private FilaEspera filaEspera;

    DecimalFormat df = new DecimalFormat("###,##0.00"); //usado para formatação das casas decimais (double)

    //CONSTRUTOR
    public Curso(int codCurso, String nomeCurso, int qntVagas) {
        this.codCurso = codCurso;
        this.nomeCurso = nomeCurso;
        this.qntVagas = qntVagas;
        this.listaSelecionados = new ListCandidatos();
        this.filaEspera = new FilaEspera();
    }

    //GETTERS
    public String getNomeCurso() {
        return nomeCurso;
    }

    public int getCodCurso() {
        return codCurso;
    }

    public double getNotaCorte() {
        return notaCorte;
    }

    public ListCandidatos getListaSelecionados() {
        return listaSelecionados;
    }

    public FilaEspera getFilaEspera() {
        return filaEspera;
    }

    //METODOS
    @Override
    public String toString() {
        return (getNomeCurso() + " " + df.format(getNotaCorte()) +
                "\nSelecionados" +
                listaSelecionados.toString() +
                "\nFila de espera" +
                filaEspera.toString() +
                "\n\n"
                );
    }

    public void mostrar() {
        System.out.println("Codigo do curso: " + codCurso);
        System.out.println("Nome do curso: " + nomeCurso);
        System.out.println("Vagas disponiveis: " + qntVagas);
    }

    /* O método insere na lista de selecionados se houver vagas, caso contrario, ele vai para a fila de espera */
    public boolean inserirCandidato(Candidato candidato) {
        if (existeVaga()) {
            listaSelecionados.inserirFim(candidato);
            qntVagas--;
            
            notaCorte = candidato.getNotaMedia(); //atualiza a nota de corte a cada aluno novo
            return true;
        } else {
            filaEspera.inserir(candidato);
            return false;
        }
    }

    /* Verifica se existe vagas livres*/
    public boolean existeVaga() {
        if (qntVagas != 0) {
            return true;
        }
        return false;
    }
}
