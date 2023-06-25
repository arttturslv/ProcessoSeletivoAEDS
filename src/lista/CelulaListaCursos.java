package src.lista;

import src.curso.Curso;

class CelulaListaCursos {
    public Curso elemento;
    public CelulaListaCursos prox;
    
    public CelulaListaCursos() {
        this(null);
    }
    
    public CelulaListaCursos (Curso curso) {
        this.elemento = curso;
        this.prox = null;
    }
}