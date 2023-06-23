package entities;

public class ListaCandidato {
    private CelulaListaCa primeiro, ultimo;

    public ListaCandidato() {
        primeiro = new CelulaListaCa();
        ultimo = primeiro;
    }

    public void inserirInicio(Candidato x) {
        CelulaListaCa tmp = new CelulaListaCa(x);
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        if (primeiro == ultimo) {
            ultimo = tmp;
        }
        tmp = null;
    }

    public void inserirFim(Candidato x) {
        ultimo.prox = new CelulaListaCa(x);
        ultimo = ultimo.prox;
    }

    public void inserir(Candidato x, int pos) throws Exception {
        int tamanho = tamanho();
        if (pos < 0 || pos > tamanho) {
            throw new Exception("Erro!");
        } else if (pos == 0) {
            inserirInicio(x);
        } else if (pos == tamanho) {
            inserirFim(x);
        } else {
            CelulaListaCa i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox);
            CelulaListaCa tmp = new CelulaListaCa(x);
            tmp.prox = i.prox;
            i.prox = tmp;
            tmp = null;
            i = null;
        }
    }

    public Candidato removerInicio() throws Exception {
        if (primeiro == ultimo) {
            throw new Exception("Erro!");
        }
        CelulaListaCa tmp = primeiro;
        primeiro = primeiro.prox;
        Candidato elemento = primeiro.elemento;
        tmp.prox = null;
        tmp = null;
        return elemento;
    }

    public Candidato removerFim() throws Exception {
        if (primeiro == ultimo)
            throw new Exception("Erro!");
        CelulaListaCa i;
        for (i = primeiro; i.prox != ultimo; i = i.prox);
        Candidato elemento = ultimo.elemento;
        ultimo = i;
        ultimo.prox = null;
        i = null;
        return elemento;
    }

    public Candidato remover(int pos) throws Exception { // remover(1)
        int tamanho = tamanho();
        Candidato elemento;
        if (primeiro == ultimo || pos < 0 || pos >= tamanho) {
            throw new Exception("Erro!");
        } else if (pos == 0) {
            elemento = removerInicio();
        } else if (pos == tamanho - 1) {
            elemento = removerFim();
        } else {
            CelulaListaCa i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox);
            CelulaListaCa tmp = i.prox;
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
        for (CelulaListaCa i = primeiro.prox; i != null; i = i.prox) {
            i.elemento.mostrar();
            System.out.println();
        }
        System.out.println("\n]");
    }

    public int tamanho() {
        int tamanho = 0;
        for (CelulaListaCa i = primeiro; i != ultimo; i = i.prox) {
            tamanho++;
        }
        return tamanho;
    }
}
