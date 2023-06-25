package src.fila;

import src.candidato.Candidato;

class FilaCelEspera {
    public Candidato elemento;
    public FilaCelEspera prox;

    public FilaCelEspera() {
        this(null);
    }
    public FilaCelEspera (Candidato x) {
        this.elemento = x;
        this.prox = null;
    }
}