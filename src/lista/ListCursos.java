package src.lista;

import src.curso.Curso;

public class ListCursos {
    private ListCelCursos primeiro, ultimo;

    public ListCursos() {
        primeiro = new ListCelCursos();
        ultimo = primeiro;
    }

    public void inserirFim(Curso x) {
        ultimo.prox = new ListCelCursos(x);
        ultimo = ultimo.prox;
    }

    /*
    * O metodo recebe um codigo, se houver curso com o mesmo codigo, retorna o curso
    * Se não curso, retorna null
    */
    public Curso pesquisar(int codigo) {
        for (ListCelCursos i = primeiro.prox; i != null; i = i.prox) {
            if (i.elemento.getcodigoCurso() == codigo) {
                return i.elemento;
            }
        }
        return null;
    }

    /* Método toString armazena todos os cursos e retorna*/
    @Override
    public String toString() {
        String Cursos = "";
        for (ListCelCursos i = primeiro.prox; i != null; i = i.prox) {
            Cursos += i.elemento.toString();
        }
        return Cursos;
    }

    public void mostrar() {
        System.out.print("\nLISTA DE CURSOS:\n");
        for (ListCelCursos i = primeiro.prox; i != null; i = i.prox) {
            i.elemento.mostrar();
        }
    }
}