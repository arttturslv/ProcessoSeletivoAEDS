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
import src.lista.ListaCursos;

public class Estagiario {
    private int quantidadeCursos;
    private int quantidadeCandidatos;

    public Candidato[] leituraArquivo(File arq, ListaCursos listaCursos) throws Exception {
        try (FileInputStream fis = new FileInputStream(arq)) {
            InputStreamReader leitor = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(leitor);
            String linha;

            linha = bufferedReader.readLine(); // lê a primeira linha;
            String[] splittedStr = linha.split(";");

            quantidadeCursos = Integer.parseInt(splittedStr[0]);
            quantidadeCandidatos = Integer.parseInt(splittedStr[1]);

            System.out.println(
                    quantidadeCursos + " cursos encontrados.\n" + quantidadeCandidatos + " candidatos encontrados.");

            /* leitura dos cursos e criação dos objetos */
            for (int i = 0; i < quantidadeCursos; i++) {
                linha = bufferedReader.readLine();
                splittedStr = linha.split(";");

                listaCursos.inserirFim(
                        new Curso(
                                Integer.parseInt(splittedStr[0]),
                                splittedStr[1],
                                Integer.parseInt(splittedStr[2])));
            }
            listaCursos.mostrar();

            Candidato[] vetorCandidatos = new Candidato[quantidadeCandidatos];
            /* leitura dos cursos e criação do vetor de candidatos */
            for (int i = 0; i < quantidadeCandidatos; i++) {
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
            System.out.println("\nOs candidatos foram criados e armazenados no vetor de candidatos.");

            leitor.close();
            bufferedReader.close();

            return vetorCandidatos;
        } catch (IOException error) {
            error.printStackTrace();
        }
        return null;
    }

    
    public Candidato[] ordenaCandidatos(Candidato[] vetorCandidatos) {
        mergesortRedacao(vetorCandidatos, 0, vetorCandidatos.length - 1);
        System.out.println(" - Organizado por redação:");

        mergesortMedia(vetorCandidatos, 0, vetorCandidatos.length - 1);
        System.out.println(" - Organizado por notas médias:");

        return vetorCandidatos;
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

        for (iEsq = 0, iDir = 0, i = esq; i <= dir; i++) {
            array[i] = (arrayEsq[iEsq].getNotaRedacao() <= arrayDir[iDir].getNotaRedacao()) ? arrayEsq[iEsq++]
                    : arrayDir[iDir++];
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

        for (iEsq = 0, iDir = 0, i = esq; i <= dir; i++) {
            array[i] = (arrayEsq[iEsq].getNotaMedia() <= arrayDir[iDir].getNotaMedia()) ? arrayEsq[iEsq++]
                    : arrayDir[iDir++];
        }
    }


    public ListaCursos processoSeletivo(Candidato[] vetorCandidatos, ListaCursos listaCursos) throws Exception {
        System.out.println("\nOs candidatos estão sendo selecionados...");

        for (int i = vetorCandidatos.length - 1; i >= 0; i--) { // começa de tras pra frente (as maiores notas estão no
                                                               // fim)
            Candidato candidatoAtual = vetorCandidatos[i];
            Curso primeiraOpcao = listaCursos.pesquisar(candidatoAtual.getPrimeiraOpcao()); // pesquisar retorna null se
                                                                                            // não encontrar
            Curso segundaOpcao = listaCursos.pesquisar(candidatoAtual.getSegundaOpcao());
            boolean InseridoPrimeiraOpcao, InseridoSegundaOpcao;

            if (primeiraOpcao != null) {
                InseridoPrimeiraOpcao = primeiraOpcao.inserirCandidato(candidatoAtual);

                if (InseridoPrimeiraOpcao == true) { // se tiver sido inserido
                    System.out.println(" - O candidato " + candidatoAtual.getNome() + " foi selecionado no curso: "+ primeiraOpcao.getNomeCurso());
                } else if (InseridoPrimeiraOpcao == false && segundaOpcao != null) {
                    InseridoSegundaOpcao = segundaOpcao.inserirCandidato(candidatoAtual);

                    if (InseridoSegundaOpcao) { 
                        System.out.println(" - O candidato " + candidatoAtual.getNome()+ " está na fila de espera e foi selecionado no curso 2º: " + segundaOpcao.getNomeCurso());
                    } else {
                        System.out.println(" - O candidato " + candidatoAtual.getNome() + "está nas duas filas de espera.");
                    }

                } else if (segundaOpcao == null) {
                    System.out.println("O segundo curso escolhido pelo candidato "+candidatoAtual.getNome()+" não existe!");
                }
            } else {
                System.out.println("O primeiro curso escolhido pelo candidato "+candidatoAtual.getNome()+" não existe!");
            }
        
        }
        return listaCursos;
    }


    public void escritaArquivo(ListaCursos listaCursos) throws Exception {
        System.out.println("\nEscrevendo no arquivo...");
        File arq = new File("saida.txt");

        try (FileOutputStream fos = new FileOutputStream(arq);
                OutputStreamWriter saida = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
                BufferedWriter escritor = new BufferedWriter(saida)) {

            escritor.write(listaCursos.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Escrita concluida.\n");
    }
}
