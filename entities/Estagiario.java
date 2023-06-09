package entities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Estagiario {
    /* 
     * Lê arquivo e armazena valores nos objetos já determinados.
     */

    ListaCurso listaCursos = new ListaCurso();
    ListaCandidato listaCandidatos = new ListaCandidato();

    public void ler(File arq) throws IOException {
        lerPrivado(arq);
     }
        private void lerPrivado(File arq) throws IOException  {
        try {
            FileReader leitor = new FileReader(arq);
            BufferedReader bufferedReader = new BufferedReader(leitor);
            String linha = "";
            linha = bufferedReader.readLine(); //leitura da primeira linha;

            String [] linhaTemporaria = organizador (linha); //VETOR QUE VAI SEPARAR TUDO DAS LINHAS

            int qntCursos = Integer.parseInt(linhaTemporaria[0]);
            int qntCandidatos = Integer.parseInt(linhaTemporaria[1]);

            System.out.println("qnt Cursos " +qntCursos ); 
            System.out.println("qnt Candidatos " +qntCandidatos );


            /* CURSOS */
            for(int i=0; i<(qntCursos); i++) {
                linha = bufferedReader.readLine();
                linhaTemporaria = organizador(linha);

                listaCursos.inserirInicio(new Curso (Integer.parseInt(linhaTemporaria[0]), linhaTemporaria[1], Integer.parseInt(linhaTemporaria[2])));
                listaCandidatos.mostrar();    
                
            } 

            /* CANDIDATOS */
            for(int i=0; i<(qntCandidatos); i++) {
                linha = bufferedReader.readLine();
                linhaTemporaria = organizador(linha);

                listaCandidatos.inserirInicio(new Candidato (linhaTemporaria[0], Integer.parseInt(linhaTemporaria[1]), Integer.parseInt(linhaTemporaria[2]), Integer.parseInt(linhaTemporaria[3]), Integer.parseInt(linhaTemporaria[4]), Integer.parseInt(linhaTemporaria[5])));
                listaCandidatos.mostrar();    
            }


            leitor.close();
            bufferedReader.close();

        } catch (IOException error) {
            error.printStackTrace();
        } 
    }

    private String[] organizador (String linha) {
        String [] vetorLinha = linha.split(";");
        return vetorLinha;
    }

}
