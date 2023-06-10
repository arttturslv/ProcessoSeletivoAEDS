package application;

import java.util.*;
import java.io.File;
import java.io.IOException;
import entities.*;

public class APP {
    public static void main(String[] args) throws IOException {
        ListaCurso cursos = new ListaCurso();
        ListaCandidato candidatos = new ListaCandidato();

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o nome do arquivo de leitura (que contém dados dos usuarios): ");
        String nomeArq = sc.nextLine();

        File arq = new File (nomeArq);
        if(arq.exists()) {
            System.out.println("O arquivo foi encontrado.");
            Estagiario estagiario = new Estagiario(cursos, candidatos);
            estagiario.ler(arq);

        } else {
            System.out.println("O arquivo não foi encontrado.");
        }
        sc.close();
    }
}