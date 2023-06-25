package src.lista;

import src.curso.Curso;

class ListCelCursos {
    public Curso elemento;
    public ListCelCursos prox;
    
    public ListCelCursos() {
        this(null);
    }
    
    public ListCelCursos (Curso curso) {
        this.elemento = curso;
        this.prox = null;
    }
}