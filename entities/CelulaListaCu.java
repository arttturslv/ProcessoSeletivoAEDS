package entities;

class CelulaListaCu {
    public Curso elemento;
    public CelulaListaCu prox;
    
    public CelulaListaCu() {
        this(null);
    }
    public CelulaListaCu (Curso curso) {
        this.elemento = curso;
        this.prox = null;
    }
}