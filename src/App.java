package src;

import src.auxiliar.Estagiario;
import src.candidato.Candidato;
import src.lista.ListaCursos;

import java.io.File;

public class App {
    public static void main(String[] args) throws Exception {
        ListaCursos listaCurso = new ListaCursos();

        Estagiario estagiario = new Estagiario();

        File arq = new File ("resources/entrada.txt");
        
        if(arq.exists()) {
            System.out.println("O arquivo foi encontrado.\n");

            Candidato [] vetorCandidatos = estagiario.leituraArquivo(arq, listaCurso); 
            estagiario.ordenaCandidatos(vetorCandidatos); 
            estagiario.processoSeletivo(vetorCandidatos, listaCurso); 
            estagiario.escritaArquivo(listaCurso);
        } else {
            System.out.println("O arquivo não foi encontrado.\n");
        }
    }
}
