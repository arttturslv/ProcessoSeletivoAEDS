package entities;

public class ListaCurso {
    private CelulaListaCu primeiro, ultimo;

    public ListaCurso() {
        primeiro = new CelulaListaCu();
        ultimo = primeiro;
    }

    public void inserirInicio(Curso x) {
        CelulaListaCu tmp = new CelulaListaCu(x);
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        if (primeiro == ultimo) {
            ultimo = tmp;
        }
        tmp = null;
    }

    public void inserirFim(Curso x) {
        ultimo.prox = new CelulaListaCu(x);
        ultimo = ultimo.prox;
    }

    public void inserir(Curso x, int pos) throws Exception {
        int tamanho = tamanho();
        if (pos < 0 || pos > tamanho) {
            throw new Exception("Erro!");
        } else if (pos == 0) {
            inserirInicio(x);
        } else if (pos == tamanho) {
            inserirFim(x);
        } else {
            CelulaListaCu i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;
            CelulaListaCu tmp = new CelulaListaCu(x);
            tmp.prox = i.prox;
            i.prox = tmp;
            tmp = null;
            i = null;
        }
    }

    public Curso removerInicio() throws Exception {
        if (primeiro == ultimo) {
            throw new Exception("Erro!");
        }
        CelulaListaCu tmp = primeiro;
        primeiro = primeiro.prox;
        Curso elemento = primeiro.elemento;
        tmp.prox = null;
        tmp = null;
        return elemento;
    }

    public Curso removerFim() throws Exception {
        if (primeiro == ultimo)
            throw new Exception("Erro!");
        CelulaListaCu i;
        for (i = primeiro; i.prox != ultimo; i = i.prox)
            ;
        Curso elemento = ultimo.elemento;
        ultimo = i;
        ultimo.prox = null;
        i = null;
        return elemento;
    }

    public Curso remover(int pos) throws Exception { // remover(1)
        int tamanho = tamanho();
        Curso elemento;
        if (primeiro == ultimo || pos < 0 || pos >= tamanho) {
            throw new Exception("Erro!");
        } else if (pos == 0) {
            elemento = removerInicio();
        } else if (pos == tamanho - 1) {
            elemento = removerFim();
        } else {
            CelulaListaCu i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;
            CelulaListaCu tmp = i.prox;
            elemento = tmp.elemento;
            i.prox = tmp.prox;
            tmp.prox = null;
            tmp = null;
            i = null;
        }
        return elemento;
    }

    public void mostrar() {
        System.out.print("[\n");
        for (CelulaListaCu i = primeiro.prox; i != null; i = i.prox) {
            i.elemento.mostrar();
        }
        System.out.println("\n]");
    }

    public int tamanho() {
        int tamanho = 0;
        for (CelulaListaCu i = primeiro; i != ultimo; i = i.prox) {
            tamanho++;
        }
        return tamanho;
    }
}
