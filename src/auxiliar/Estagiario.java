//Armazena as principais funções, como a de leitura, escrita, ordenação e processo seletivo.
package src.auxiliar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import src.candidato.Candidato;
import src.curso.Curso;
import src.lista.ListCandidatos;
import src.lista.ListCursos;

public class Estagiario {
    private ListCursos listaCurso;
    private ListCandidatos listaCandidato;
    private int qntCursos;
    private int qntCandidatos;

    //CONSTRUTOR
    public Estagiario(ListCursos listaCurso, ListCandidatos listaCandidato) {
        this.listaCurso = listaCurso;
        this.listaCandidato = listaCandidato;
    }

    //METODOS
    /*
        Leitura do arquivo em UTF.
        Armazena a qntCursos e qntCandidatos.
        Lê cursos e cria os objs & Lê candidatos e cria objs, armazenando no vetor.
        Retorna vetor de candidatos
     */
    public Candidato [] leitura(File arq) throws Exception {
        try (FileInputStream fis = new FileInputStream(arq)) {
            InputStreamReader leitor = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(leitor);
            String linha;

            linha = bufferedReader.readLine(); // lê a primeira linha;
            String[] splittedStr = linha.split(";");

            qntCursos = Integer.parseInt(splittedStr[0]);
            qntCandidatos = Integer.parseInt(splittedStr[1]);

            System.out.println(qntCursos + " cursos encontrados.");
            System.out.println(qntCandidatos + " candidatos encontrados.");

            /* Leitura dos cursos */
            for (int i = 0; i < qntCursos; i++) {
                linha = bufferedReader.readLine();
                splittedStr = linha.split(";");

                listaCurso.inserirFim(
                        new Curso(
                                Integer.parseInt(splittedStr[0]),
                                splittedStr[1],
                                Integer.parseInt(splittedStr[2])));
            }
            System.out.println("Os cursos foram criados e armazenados na lista de cursos.");
                listaCurso.mostrar();

            Candidato[] vetorCandidatos = new Candidato[qntCandidatos]; // vetor de candidatos
            /* Leitura dos candidatos e armazenamento no vetor */
            for (int i = 0; i < qntCandidatos; i++) {
                linha = bufferedReader.readLine();
                splittedStr = linha.split(";");

                vetorCandidatos[i] = new Candidato(
                        splittedStr[0],
                        Double.parseDouble(splittedStr[1]),
                        Double.parseDouble(splittedStr[2]),
                        Double.parseDouble(splittedStr[3]),
                        Integer.parseInt(splittedStr[4]),
                        Integer.parseInt(splittedStr[5]));
            }
            System.out.println("\nOs candidatos foram cadastrados e armazenados no vetor de candidatos.");

            leitor.close();
            bufferedReader.close();

            return vetorCandidatos;

        } catch (IOException error) {
            error.printStackTrace();
        }
        return null;
    }

    /*
        Recebe vetor de candidatos.
        Ordena o vetor utilizando Merge pela Redação & Nota média.
        Retorna lista de candidatos ordenada.
     */
    public ListCandidatos OrdenaCandidatos (Candidato[] candidatos) {
        return OrdenaCandidatos(candidatos, listaCandidato);
    }
        private ListCandidatos OrdenaCandidatos(Candidato[] candidatos, ListCandidatos listaCandidato) {
            mergesortRedacao(candidatos, 0, candidatos.length - 1);
            System.out.println(" - Organizado por redação:");

            mergesortMedia(candidatos, 0, candidatos.length - 1);
            System.out.println(" - Organizado por notas médias:");

            /* Depois de ordenado, insere nas listas. */
            for (int i = 0; i < candidatos.length; i++) { 
                listaCandidato.inserirFim(candidatos[i]);
            }
            
            return listaCandidato;
        }

    private void mergesortRedacao(Candidato[] array, int esq, int dir) {
        if (esq < dir) {
            int meio = (esq + dir) / 2;
            mergesortRedacao(array, esq, meio);
            mergesortRedacao(array, meio + 1, dir);
            intercalarRedacao(array, esq, meio, dir);
        }
    }
        private void intercalarRedacao(Candidato[] array, int esq, int meio, int dir) {
            int nEsq = meio - esq + 1;
            int nDir = dir - meio;

            Candidato[] arrayEsq = new Candidato[nEsq + 1];
            Candidato[] arrayDir = new Candidato[nDir + 1];

            Candidato limite = new Candidato("saojoao", Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, 10, 10);

            arrayEsq[nEsq] = limite;
            arrayDir[nDir] = limite;

            int iEsq, iDir, i;

            for (iEsq = 0; iEsq < nEsq; iEsq++) {
                arrayEsq[iEsq] = array[esq + iEsq];
            }

            for (iDir = 0; iDir < nDir; iDir++) {
                arrayDir[iDir] = array[(meio + 1) + iDir];
            }

            for (iEsq = 0, iDir = 0, i = esq; i <= dir; i++) {// SUBSTITUIDO
                if (iEsq < arrayEsq.length && iDir < arrayDir.length) {
                    array[i] = (arrayEsq[iEsq].getNotaRedacao() <= arrayDir[iDir].getNotaRedacao()) ? arrayEsq[iEsq++]
                            : arrayDir[iDir++];
                } else if (iEsq < arrayEsq.length) {
                    array[i] = arrayEsq[iEsq++];
                } else if (iDir < arrayDir.length) {
                    array[i] = arrayDir[iDir++];
                }
            }
        }

    private void mergesortMedia(Candidato[] array, int esq, int dir) {
        if (esq < dir) {
            int meio = (esq + dir) / 2;
            mergesortMedia(array, esq, meio);
            mergesortMedia(array, meio + 1, dir);
            intercalarMedia(array, esq, meio, dir);
        }
    }
        private void intercalarMedia(Candidato[] array, int esq, int meio, int dir) {
            int nEsq = meio - esq + 1;
            int nDir = dir - meio;

            Candidato[] arrayEsq = new Candidato[nEsq + 1];
            Candidato[] arrayDir = new Candidato[nDir + 1];

            Candidato limite = new Candidato("saojoao", Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, 10, 10);

            arrayEsq[nEsq] = limite;
            arrayDir[nDir] = limite;

            int iEsq, iDir, i;

            for (iEsq = 0; iEsq < nEsq; iEsq++) {
                arrayEsq[iEsq] = array[esq + iEsq];
            }

            for (iDir = 0; iDir < nDir; iDir++) {
                arrayDir[iDir] = array[(meio + 1) + iDir];
            }

            for (iEsq = 0, iDir = 0, i = esq; i <= dir; i++) {// SUBSTITUIDO
                if (iEsq < arrayEsq.length && iDir < arrayDir.length) {
                    array[i] = (arrayEsq[iEsq].getNotaMedia() <= arrayDir[iDir].getNotaMedia()) ? arrayEsq[iEsq++]
                            : arrayDir[iDir++];
                } else if (iEsq < arrayEsq.length) {
                    array[i] = arrayEsq[iEsq++];
                } else if (iDir < arrayDir.length) {
                    array[i] = arrayDir[iDir++];
                }
            }
        }

    /*
        Recebe lista de candidatos e a lista de cursos.
        Insere os candidatos nos devidos cursos enquanto remove da lista aqueles que foram inseridos.
        Retorna lista de candidatos ordenada.
     */
    public ListCursos processoSeletivo(ListCandidatos listaCandidato, ListCursos listaCursos) throws Exception {
        System.out.println("\nOs candidatos estão sendo selecionados.");

        while (!(listaCandidato.isVazia())) { // Enquanto a lista de candidatos não está vazia.

            Candidato candidatoAtual = listaCandidato.removerFim();
            Curso primeiraOpcao = listaCursos.pesquisar(candidatoAtual.getPrimeiraOpcao());
            Curso segundaOpcao = listaCursos.pesquisar(candidatoAtual.getSegundaOpcao()); 

            if(primeiraOpcao == null) { 
                System.out.println("O curso escolhido pelo candidato "+candidatoAtual.getNome()+" não existe!");
            } 
            else {
                if ((primeiraOpcao.inserirCandidato(candidatoAtual))) { 
                    System.out.println(" - O candidato " + candidatoAtual.getNome() + " foi selecionado no curso: " + primeiraOpcao.getNomeCurso());
                    candidatoAtual.setCursoSelecionado(0); // Envia 0, mostrando que foi selecionado na primeira opcao.
                } else {                     
                    if ((segundaOpcao.inserirCandidato(candidatoAtual))) {
                        candidatoAtual.setCursoSelecionado(1); // Envia 1, mostrando que foi selecionado na segunda opcao.
                        System.out.println(" - O candidato " + candidatoAtual.getNome() + " foi para a fila de espera do curso: " + primeiraOpcao.getNomeCurso()); 
                        System.out.println(" - O candidato " + candidatoAtual.getNome() + " foi selecionado no curso: " + segundaOpcao.getNomeCurso());
                    }
                }
                
                if (!candidatoAtual.getCursoSelecionado()[0] & !candidatoAtual.getCursoSelecionado()[1]) {
                    System.out.println(" - O candidato " + candidatoAtual.getNome() + " foi para a fila de espera do curso: " + primeiraOpcao.getNomeCurso()); 
                    System.out.println(" - O candidato " + candidatoAtual.getNome() + " foi para a fila de espera do curso: " + segundaOpcao.getNomeCurso());
                }
            }
        }
        return listaCursos;
    }

    /*
        Recebe lista de cursos.
        Escreve no arquivo
     */
    public void escrita(ListCursos listaCursos) throws Exception {
        System.out.println("\nEscrevendo no arquivo...");
        File arq = new File("saida.txt");

        try (FileOutputStream fos = new FileOutputStream(arq);
                OutputStreamWriter saida = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
                BufferedWriter escritor = new BufferedWriter(saida)) {

            escritor.write(listaCursos.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nEscrita concluida.");

    }

}
