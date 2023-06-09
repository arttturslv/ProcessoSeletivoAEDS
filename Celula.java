class CelulaFila {
    public int elemento;
    public CelulaFila prox;
    public CelulaFila() {
        this(0);
    }
    public CelulaFila (int x) {
        this.elemento = x;
        this.prox = null;
    }
}