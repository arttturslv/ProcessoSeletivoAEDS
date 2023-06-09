public class CelulaListaCa {
    public Candidato elemento;
    public CelulaListaCa prox;
    
    public CelulaListaCa() {
        this(null);
    }
    public CelulaListaCa (Candidato candidato) {
        this.elemento = candidato;
        this.prox = null;
    }
}