package entities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Estagiario {
    private ListaCurso listaCurso;
    private ListaCandidato listaCandidato;

    public Estagiario(ListaCurso listaCurso, ListaCandidato listaCandidato) {
        this.listaCurso = listaCurso;
        this.listaCandidato = listaCandidato;
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

            String[] splittedStr = organizador(linha); // VETOR QUE VAI SEPARAR TUDO DAS LINHAS

            int qntCursos = Integer.parseInt(splittedStr[0]);
            int qntCandidatos = Integer.parseInt(splittedStr[1]);

            System.out.println("qnt Cursos " + qntCursos);
            System.out.println("qnt Candidatos " + qntCandidatos);

            /* CURSOS */
            for (int i = 0; i < (qntCursos); i++) {
                linha = bufferedReader.readLine();
                splittedStr = organizador(linha);

                listaCurso.inserirInicio(
                        new Curso(Integer.parseInt(splittedStr[0]), splittedStr[1], Integer.parseInt(splittedStr[2])));
                listaCandidato.mostrar();

            }

            /* CANDIDATOS */

            Candidato[] vetorCandidatos = new Candidato[qntCandidatos];

            for (int i = 0; i < (qntCandidatos); i++) {
                linha = bufferedReader.readLine();
                splittedStr = organizador(linha);

                vetorCandidatos[i] = new Candidato(splittedStr[0], Double.parseDouble(splittedStr[1]),
                        Double.parseDouble(splittedStr[2]), Double.parseDouble(splittedStr[3]),
                        Integer.parseInt(splittedStr[4]), Integer.parseInt(splittedStr[5]));
            }

            listaCandidato = ordenarCandidatos(vetorCandidatos);

            listaCandidato.mostrar();

            leitor.close();
            bufferedReader.close();

        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    private String[] organizador(String linha) {
        return linha.split(";");
    }

    private ListaCandidato ordenarCandidatos(Candidato[] candidatos) {
        quicksort(candidatos, 0, candidatos.length - 1);

        ListaCandidato listaOrdenada = new ListaCandidato();
        for (Candidato candidato : candidatos) {
            listaOrdenada.inserirInicio(candidato);
        }
        return listaOrdenada;
    }

    private void quicksort(Candidato[] array, int esq, int dir) {
        int i = esq, j = dir;
        double pivo = array[(esq + dir) / 2].getNotaMedia();
        Candidato temp;

        while (i <= j) {
            while (array[i].getNotaMedia() < pivo)
                i++;
            while (array[j].getNotaMedia() > pivo)
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


}
