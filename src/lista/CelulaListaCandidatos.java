package src.lista;

import src.candidato.Candidato;

class CelulaListaCandidatos {
    public Candidato elemento;
    public CelulaListaCandidatos prox;
    
    public CelulaListaCandidatos() {
        this(null);
    }
    
    public CelulaListaCandidatos (Candidato candidato) {
        this.elemento = candidato;
        this.prox = null;
    }
}