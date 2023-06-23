package entities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Estagiario {
    private ListaCurso listaCurso;
    private List<Candidato> listaCandidato;
    private int qntCursos;
    private int qntCandidatos;

    public Estagiario(ListaCurso listaCurso, List<Candidato> listaCandidato) {
        this.listaCurso = listaCurso;
        this.listaCandidato = listaCandidato;
    }

    public ListaCurso getListaCurso() {
        return listaCurso;
    }

    public List<Candidato> getListaCandidato() {
        return listaCandidato;
    }

    public int getQntCursos() {
        return qntCursos;
    }

    public int getQntCandidatos() {
        return qntCandidatos;
    }

    /*
     * Lê arquivo e armazena valores nos objetos já determinados.
     */

    public void ler(File arq) {
        try {
            FileReader leitor = new FileReader(arq);
            BufferedReader bufferedReader = new BufferedReader(leitor);
            String linha;

            linha = bufferedReader.readLine(); // leitura da primeira linha;
            String[] splittedStr = linha.split(";"); // VETOR QUE VAI SEPARAR EM CADA POSIÇÃO ATÉ O CARACTER ';'

            qntCursos = Integer.parseInt(splittedStr[0]);
            qntCandidatos = Integer.parseInt(splittedStr[1]);

            System.out.println("qnt Cursos " + qntCursos);
            System.out.println("qnt Candidatos " + qntCandidatos);

            /* CURSOS */
            for (int i = 0; i < qntCursos; i++) {
                linha = bufferedReader.readLine();
                splittedStr = linha.split(";");

                listaCurso.inserirInicio(
                        new Curso(
                                Integer.parseInt(splittedStr[0]),
                                splittedStr[1],
                                Integer.parseInt(splittedStr[2]))
                );
            }

            /* CANDIDATOS */

            Candidato[] vetorCandidatos = new Candidato[qntCandidatos];

            for (int i = 0; i < qntCandidatos; i++) {
                linha = bufferedReader.readLine();
                splittedStr = linha.split(";");

                vetorCandidatos[i] = new Candidato(
                        splittedStr[0],
                        Double.parseDouble(splittedStr[1]),
                        Double.parseDouble(splittedStr[2]),
                        Double.parseDouble(splittedStr[3]),
                        Integer.parseInt(splittedStr[4]),
                        Integer.parseInt(splittedStr[5])
                );
            }
            listaCandidato = ordenarCandidatos(vetorCandidatos);
            leitor.close();
            bufferedReader.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    private List<Candidato> ordenarCandidatos(Candidato[] candidatos) {
        quicksort(candidatos, 0, candidatos.length - 1);

        List<Candidato> listaOrdenada = new ArrayList<>();
        Collections.addAll(listaOrdenada, candidatos);
        return listaOrdenada;
    }

    private void quicksort(Candidato[] array, int esq, int dir) {
        int i = esq, j = dir;
        double pivo = array[(esq + dir) / 2].getNotaMedia();
        Candidato temp;

        while (i <= j) {
            while (array[i].getNotaMedia() > pivo)
                i++;
            while (array[j].getNotaMedia() < pivo)
                j--;
            if (i <= j) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
            if (esq < j)
                quicksort(array, esq, j);
            if (i < dir)
                quicksort(array, i, dir);
    }

    public void calcularClassificacao() {
        Curso cursoOpcao1;
        Candidato candidato;
        for (int i = 0; i < qntCandidatos; i++) {
            candidato = listaCandidato.get(i);
            cursoOpcao1 = listaCurso.pesquisar(candidato.getOpcao1());
            cursoOpcao1.inserirSelecionado(candidato);
        }
    }


}
