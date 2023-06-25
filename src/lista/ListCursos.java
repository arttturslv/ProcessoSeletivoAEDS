//Armazena a lista de objetos do tipo Curso.
package src.lista;

import src.curso.Curso;

public class ListCursos {
    private ListCelCursos primeiro, ultimo;

    //CONSTRUTOR
    public ListCursos() {
        primeiro = new ListCelCursos();
        ultimo = primeiro;
    }

    //METODOS
    /* Como os cursos estão organizados, apenas o inserirFim é necessário */
    public void inserirFim(Curso x) {
        ultimo.prox = new ListCelCursos(x);
        ultimo = ultimo.prox;
    }

  /* Método pesquisar retorna o curso, caso não encontre ele retorna null */
    public Curso pesquisar(int codigo) {
        for (ListCelCursos i = primeiro.prox; i != null; i = i.prox) {
            if (i.elemento.getCodCurso() == codigo) {
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
            System.out.print("\n");
            i.elemento.mostrar();
        }
    }

}