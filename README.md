<h1> Trabalho Prático AEDS - Gerenciamento de Processo Seletivo da Universidade Stark </h1>

Este projeto consiste na implementação de um programa para gerenciar o processo seletivo da Universidade Stark. O programa é responsável por selecionar candidatos com base em suas notas e disponibilidade de vagas nos cursos. O objetivo é praticar os conceitos abordados durante o semestre letivo e demonstrar o domínio dos seguintes tópicos:


• Utilização de estruturas de dados como listas e filas<br>
• Implementação de algoritmos de ordenação<br>
• Manipulação de arquivos de entrada e saída<br>

<h3>Descrição do Problema</h3>
A Universidade Stark possui cursos com um número limitado de vagas e uma fila de espera para cada curso. O critério de seleção dos candidatos é a média simples das notas obtidas nas provas de Redação, Matemática e Linguagens. Em caso de empate, a nota da Redação é utilizada como critério de desempate.<br>

Cada candidato pode escolher duas opções de curso. Se um candidato for selecionado em sua primeira opção, ele não entra na fila de espera. Caso seja selecionado em sua segunda opção, ele é colocado na fila de espera da primeira opção. Se o candidato não for selecionado em nenhuma das opções, ele entra na fila de espera de ambos os cursos.

O programa deve ler as informações de um arquivo de entrada e, ao final do processamento, gerar um arquivo de saída contendo as seguintes informações:

Nome e nota de corte de cada curso (menor nota média dos selecionados para o curso)
Lista de candidatos selecionados, em ordem decrescente de nota média
Fila de espera, em ordem decrescente de nota média

Arquivo de Entrada (entrada.txt): <br>
![243194908-c9417e0c-5712-48b1-9696-883fc2cc8adc](https://github.com/arttturslv/TB-AEDS/assets/115251355/3fe545d5-3320-45fe-a14f-6ff97ace8ba5)


Arquivo de Saída (saida.txt): <br>
![243194886-bb3bc1d8-15f1-4fdc-8115-9c2b47ed909b](https://github.com/arttturslv/TB-AEDS/assets/115251355/40903299-88fe-496e-b6a3-48fb39ab53f0)


<h3>Classes</h3>:
• App.java - Responsavel por chamar as informações do estagiario.
• ListaCandidato (String nome, double notaRed, double notaMat, double notaLing, int [] opcoesCursos)
+ Cursos (String nomeCurso, int codCurso, double notaCorte, int qntVagas, entities.Fila ````<alunos>```` fila_espera, Lista ````<alunos>```` lista_aprovados) //fila de cursos que armazenam os candidatos.
+ Lista () //lista criada
+ entities.Fila () //fila nativa "queue"
+ entities.Estagiario (Leitura e escrita)
+ QuickSort () //Decrescente 
