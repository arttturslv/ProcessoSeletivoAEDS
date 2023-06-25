package src.fila;

import src.candidato.Candidato;

class CelulaFilaEspera {
    public Candidato elemento;
    public CelulaFilaEspera prox;

    public CelulaFilaEspera() {
        this(null);
    }
    public CelulaFilaEspera (Candidato x) {
        this.elemento = x;
        this.prox = null;
    }
}