package src;

import src.lista.ListCandidatos;
import src.auxiliar.Estagiario;
import src.candidato.Candidato;
import src.lista.ListCursos;

import java.io.File;

public class App {
    public static void main(String[] args) throws Exception {
        ListCursos listaCurso = new ListCursos();
        ListCandidatos listaCandidato = new ListCandidatos();

        Estagiario estagiario = new Estagiario(); //cria o objeto que vai ajudar as paradas

        File arq = new File ("resources/entrada.txt");
        
        if(arq.exists()) {
            System.out.println("O arquivo foi encontrado.\n");

            Candidato [] vetorCandidatos = estagiario.leituraArquivo(arq, listaCurso); //recebe o vetor de candidatos da leitura do arquivo.
            listaCandidato = estagiario.ordenaCandidatos(vetorCandidatos, listaCandidato); //recebe o vetor e retorna a lista ordenada.
            listaCurso = estagiario.processoSeletivo(listaCandidato, listaCurso);//recebe a lista de candidatos e de cursos, preenchendo os cursos que possuem 
            estagiario.escritaArquivo(listaCurso); //escreve o curso no arquivo
        } else {
            System.out.println("O arquivo não foi encontrado.\n");
        }
    }
}
