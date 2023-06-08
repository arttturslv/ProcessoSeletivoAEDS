import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Estagiario {

    /* 
     * Lê arquivo e armazena valores nos objetos já determinados.
     */

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
            String [] [] qntCur = new String [qntCursos] [3];
            for(int i=0; i<(qntCursos); i++) {
                linha = bufferedReader.readLine();
                linhaTemporaria = organizador(linha);

                    qntCur[i][0] = linhaTemporaria[0];
                    qntCur[i][1] = linhaTemporaria[1];
                    qntCur[i][2] = linhaTemporaria[2];
                } 
                System.out.println("Cursos");
                for (int i = 0; i < qntCur.length; i++) {
                    System.out.println("id = "+qntCur[i][0]+" "+qntCur[i][1]+ " "+qntCur[i][2]);
                    
                }
            /* CANDIDATOS */
            String [] [] qntCand = new String [qntCandidatos] [6];
            for(int i=0; i<(qntCandidatos); i++) {
                linha = bufferedReader.readLine();
                linhaTemporaria = organizador(linha);

                qntCand[i][0] = linhaTemporaria[0];
                qntCand[i][1] = linhaTemporaria[1];
                qntCand[i][2] = linhaTemporaria[2];
                qntCand[i][3] = linhaTemporaria[3];
                qntCand[i][4] = linhaTemporaria[4];
                qntCand[i][5] = linhaTemporaria[5];
                }
                System.out.println("Candidadtos");
                for (int i = 0; i < qntCand.length; i++) {
                    System.out.println("->"+qntCand[i][0]+" "+qntCand[i][1]+ " "+qntCand[i][2]+" "+qntCand[i][3]+ " "+qntCand[i][4]+ " "+qntCand[i][5]);
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
