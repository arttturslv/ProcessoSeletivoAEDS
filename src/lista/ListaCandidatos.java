package src.lista;

import src.candidato.Candidato;

public class ListaCandidatos {
    private CelulaListaCandidatos primeiro, ultimo;

    public ListaCandidatos() {
        primeiro = new CelulaListaCandidatos();
        ultimo = primeiro;
    }

    public void inserirFim(Candidato x) {
        ultimo.prox = new CelulaListaCandidatos(x);
        ultimo = ultimo.prox;
    }

    public Candidato removerFim() throws Exception {
        if (primeiro == ultimo)
            throw new Exception("Erro!");
        CelulaListaCandidatos i;
        for (i = primeiro; i.prox != ultimo; i = i.prox)
            ;
        Candidato elemento = ultimo.elemento;
        ultimo = i;
        ultimo.prox = null;
        i = null;
        return elemento;
    }

    /* Método toString armazena todos os candidatos e retorna */
    @Override
    public String toString() {
        String candidatos = "";
        for (CelulaListaCandidatos i = primeiro.prox; i != null; i = i.prox) {
            candidatos += i.elemento.toString();
        }
        return candidatos;
    }

    public boolean isVazia() {
        if (primeiro == ultimo) {
            return true;
        }
        return false;
    }
}
