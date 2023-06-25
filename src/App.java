//Main - chama as funções principais.

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

        Estagiario estagiario = new Estagiario(listaCurso, listaCandidato); //cria o objeto que vai ajudar as paradas

        File arq = new File ("resources/entrada.txt");
        
        if(arq.exists()) {
            System.out.println("O arquivo foi encontrado.\n");
            Candidato [] vetorCandidatos = estagiario.leitura(arq); //recebe o vetor de candidatos 
            listaCandidato = estagiario.OrdenaCandidatos(vetorCandidatos); //envia o vetor e recebe a lista ordenada     
            listaCurso = estagiario.processoSeletivo(listaCandidato, listaCurso);//envia a lista de candidatos e de cursos (vazia), recebendo a lista de cursos já preenchidas
            estagiario.escrita(listaCurso); //escreve no arquivo
        } else {
            System.out.println("O arquivo não foi encontrado.\n");
        }
    }
}
