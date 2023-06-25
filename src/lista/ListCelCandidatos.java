package src.lista;

import src.candidato.Candidato;

class ListCelCandidatos {
    public Candidato elemento;
    public ListCelCandidatos prox;
    
    public ListCelCandidatos() {
        this(null);
    }
    
    public ListCelCandidatos (Candidato candidato) {
        this.elemento = candidato;
        this.prox = null;
    }
}