package src.fila;

import src.candidato.Candidato;

public class FilaEspera {
    private CelulaFilaEspera primeiro, ultimo;

    public FilaEspera () {
        primeiro = new CelulaFilaEspera();
        ultimo = primeiro;
    }

    public void inserir(Candidato x) { //Inserir(3)
        ultimo.prox = new CelulaFilaEspera(x);
        ultimo = ultimo.prox;
    }

    /* Método toString armazena todos os candidatos e retorna*/
    @Override
    public String toString() {
        String candidatos="";
        for (CelulaFilaEspera i = primeiro.prox; i != null; i = i.prox) {
            candidatos += i.elemento.toString();
        }
        return candidatos;
    }
}