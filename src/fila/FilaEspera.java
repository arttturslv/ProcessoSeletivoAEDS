//Armazena a fila de espera dos objetos candidatos
package src.fila;

import src.candidato.Candidato;

public class FilaEspera {
    private FilaCelEspera primeiro, ultimo;

    //CONSTRUTOR
    public FilaEspera () {
        primeiro = new FilaCelEspera();
        ultimo = primeiro;
    }

    //METODOS
    public void inserir(Candidato x) { //Inserir(3)
        ultimo.prox = new FilaCelEspera(x);
        ultimo = ultimo.prox;
    }

    /* Método toString armazena todos os candidatos e retorna*/
    @Override
    public String toString() {
        String candidatos="";
        for (FilaCelEspera i = primeiro.prox; i != null; i = i.prox) {
            candidatos += i.elemento.toString();
        }
        return candidatos;
    }
    public void mostrar() {
        System.out.print("[ ");
        for (FilaCelEspera i = primeiro.prox; i != null; i = i.prox){
            System.out.print(i.elemento + " ");
        }
    }
}