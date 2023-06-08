public class Fila {
    private Celula primeiro, ultimo;
    public Fila () {
        primeiro = new Celula();
        ultimo = primeiro;
    }
    public void inserir(int x) { //Inserir(3)
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }
        
    public int remover() throws Exception{
        if (primeiro == ultimo) {
        throw new Exception("Erro!");
        }
        Celula tmp = primeiro;
        primeiro = primeiro.prox;
        int elemento = primeiro.elemento;
        tmp.prox = null;
        tmp = null;
        return elemento;
    }

    public void mostrar() {
        System.out.print("[ ");
        for (Celula i = primeiro.prox; i != null; i = i.prox){
            System.out.print(i.elemento + " ");
        }
        System.out.println("]");
    }
}