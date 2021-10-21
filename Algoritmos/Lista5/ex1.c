/*Uma determinada biblioteca possui obras de ciências exatas, ciências humanas e ciências biomédicas, totalizando 1.500 volumes, 500 de cada área. O proprietário resolveu informatiza-la e, para tal, agrupou as informações sobre cada livro do seguinte modo:

Código de catalogação:__________________________ Doado(Sim/Não):_______________
Nome da obra: _____________________________________________________________
Nome do autor: _____________________________________________________________
Editora: _____________________________ Nº. De Páginas: ________________________

Construa um algoritmo que declare tal estrutura e que reúna todas as informações de todas as obras em três vetores distintos para cada área;
Elabore um trecho de algoritmo que, utilizando como premissa o que foi feito no item a, realize uma consulta às informações. O usuário fornecerá código da obra e sua área; existindo tal livro, informa seus campos; do contrário, envia mensagem de aviso. A consulta repete-se até que o usuário introduza código finalizador com o valor -1;
Idem ao item b, porém o usuário simplesmente informa o nome e a área do livro e deseja consultar;
Escreva um trecho de algoritmo que liste todas as obras de cada área que representem livros doados;
Idem ao item d, porém, obras cujos livros sejam comprados e cujo número de páginas se encontre entre 100 e 300;
Elabore um trecho de algoritmo que faça a alteração de um registro; para tal, o usuário fornece o código, a área e as demais informações sobre o livro;
Construa um trecho de algoritmo que efetue a exclusão de algum livro; o usuário fornecerá o código e a área. Lembre-se de que somente pode ser excluído um livro existente
*/
#include <stdio.h>
#include <string.h> 
#include <stdlib.h>
#define m 5

//! DEFINICAO DA ESTRUTURA LIVRO
typedef struct
{
  int codigo;
  char isDoado;
  char nome[50];
  char autor[50];
  char editora[50];
  int nPaginas;
}Livro;

typedef struct{
  int n; //* n = numero de elementos da lista
  char *nomeLista;
  Livro livros[m];
}Lista;

//Prototipacao
void inserirFinal(Lista *L, Livro *livro);
Lista* perguntarCategoria(Lista* ptExatas,Lista* ptHumanas, Lista* ptBiomedicas);
void novoLivro(Lista* ptExatas,Lista* ptHumanas, Lista* ptBiomedicas);
void iniciaLista(Lista *L,char nome[10]);
void alterar(int codigo, Lista *L);
void pesquisaCodigo(Lista *L, int codigo);
void listarTodosDoados(Lista *L);
void listarEntre100e300pg(Lista *L);
void listarTodosCategoria(Lista *L);
void pesquisaNome(Lista *L,char nome[50]);
void deletarLivro(Lista* L, int codigo);

int main(){
  int op,op2,cod;
  char nome[50],temp;
  //Criacao das listas
  Lista Exatas;
  Lista Humanas;
  Lista Biomedicas;
  //Criacao dos ponteiros
  Lista* ptExatas = &Exatas;
  Lista* ptHumanas = &Humanas;
  Lista* ptBiomedicas = &Biomedicas;
  //Inicializao das listas
  iniciaLista(ptExatas,"Exatas");
  iniciaLista(ptHumanas,"Humanas");
  iniciaLista(ptBiomedicas,"Biomedicas");
  do{
    printf("Funcionalidades:\n1-Adicionar Livro\n2-Consultar Categorias\n3-Alterar Livro\n4-Excluir Livro\n5-Pesquisar Livro\n0-Encerrar Sistema\n");
    scanf("%d",&op);
    if(op==1){
      novoLivro(ptExatas, ptHumanas, ptBiomedicas);
    }else if(op==2){
      printf("Oq deseja consultar:\n1-Todos os Livros da Categoria\n2-Livros Doados da Categoria\n3-Livros que tenham entre 100 e 300 paginas e sejam comprados\n");
      scanf("%d",&op2);
      Lista *categoria=perguntarCategoria(ptExatas, ptHumanas, ptBiomedicas);
      if(op2==1)
        listarTodosCategoria(categoria);
      else if(op2==2)
        listarTodosDoados(categoria);
      else if(op2==3)
        listarEntre100e300pg(categoria);
    }else if(op==3){
      Lista *categoria=perguntarCategoria(ptExatas, ptHumanas, ptBiomedicas);
      printf("Informe o codigo do livro:\n");
      scanf("%d",&cod);
      alterar(cod, categoria);
    }else if(op==4){
      Lista *categoria=perguntarCategoria(ptExatas, ptHumanas, ptBiomedicas);
      printf("Informe o codigo do livro:\n");
      scanf("%d",&cod);
      deletarLivro(categoria,cod);
    }else if(op==5){
      printf("Como deseja pesquisa:\n1-Pesquisa por Codigo\n2-Pesquisa por Nome\n");
      scanf("%d",&op2);
      Lista *categoria=perguntarCategoria(ptExatas, ptHumanas, ptBiomedicas);
      if(op2==1){
        printf("Por favor, informe o codigo do livro:\n");
        scanf("%d",&cod);
        pesquisaCodigo(categoria, cod);
      }else if(op2==2){
        printf("Por favor, informe o nome do livro:\n");
        scanf("%c",&temp);
        scanf("%[^\n]",nome);
        pesquisaNome(categoria, nome);
      }
    }else if(op==0){
      printf("Sistema encerrado");
      break;
    }
  }while(op!=0);
  return 0;
}

void inserirFinal(Lista *L, Livro *livro){
  if(L->n > m-1){
    printf("erro: elemento fora dos limites da lista");
  }else{
    L->livros[L->n]=*livro;
    L->n++;
  }
}
Lista* perguntarCategoria(Lista* ptExatas,Lista* ptHumanas, Lista* ptBiomedicas){
  int op;
  printf("Informe a Categoria:\n1-Exatas\n2-Humanas\n3-Biomedicas\n");
  //scanf("%d",&temp2);
  scanf("%d",&op);
  if(op==1){
    return(ptExatas);
  }else if(op==2){
    return(ptHumanas);
  }else if(op==3){
    return(ptBiomedicas);
  }else{
    printf("Codigo Invalido\n");
    return NULL;
  }
}
void novoLivro(Lista* ptExatas,Lista* ptHumanas, Lista* ptBiomedicas){
  char isDoado, nome[50],autor[50],editora[50],temp;
  int codigo, nPaginas,op,temp2;
  printf("Informe o codigo do livro:\n");
  scanf("%d",&codigo);

  printf("Eh doado?(s/n)\n");
  scanf("%c",&temp);
  scanf("%c",&isDoado);

  printf("Informe o nome do livro:\n");
  scanf("%c",&temp);
  scanf("%[^\n]",nome);

  printf("Informe o nome do autor:\n");
  scanf("%c",&temp);
  scanf("%[^\n]",autor);

  printf("Informe o nome da editora:\n");
  scanf("%c",&temp);
  scanf("%[^\n]",editora);

  printf("Informe o numero de paginas:\n");
  scanf("%d",&nPaginas);

  Livro *livro=malloc(sizeof(Livro));
  livro->codigo=codigo;
  livro->isDoado=isDoado;
  strcpy(livro->nome,nome);
  strcpy(livro->autor,autor);
  strcpy(livro->editora,editora);
  livro->nPaginas=nPaginas;
  
  Lista*categoria = perguntarCategoria(ptExatas, ptHumanas, ptBiomedicas);
  inserirFinal(categoria, livro);
}
void iniciaLista(Lista *L,char nome[10]){ //! Recebe o endereco da lista e seta o numero de elementos para 0
  L->n=0;
  L->nomeLista=nome;
}
void alterar(int codigo, Lista *L){
  char isDoado, nome[50],autor[50],editora[50],temp;
  int nPaginas,op;
  int i, encontrou=0,index;
  for(i=0;i<L->n;i++){
    if(L->livros[i].codigo==codigo){
      encontrou=1;
      index=i;
      break;
    }
  }
  if(encontrou==1){
    printf("Livro Encontrado!\nNome: %s \n",L->livros[index].nome);
    printf("Doado: %c\n",L->livros[index].isDoado);
    printf("Autor: %s\n",L->livros[index].autor);
    printf("Editora: %s\n",L->livros[index].editora);
    printf("Numero de Paginas: %d\n",L->livros[index].nPaginas);

    printf("Insira as novas informacoes:\n");

    printf("Eh doado?(s/n)\n");
    scanf("%c",&temp);
    scanf("%c",&isDoado);

    printf("Informe o nome do livro:\n");
    scanf("%c",&temp);
    scanf("%[^\n]",nome);

    printf("Informe o nome do autor:\n");
    scanf("%c",&temp);
    scanf("%[^\n]",autor);

    printf("Informe o nome da editora:\n");
    scanf("%c",&temp);
    scanf("%[^\n]",editora);

    printf("Informe o numero de paginas:\n");
    scanf("%d",&nPaginas);

    L->livros[index].isDoado=isDoado;
    strcpy(L->livros[index].nome,nome);
    strcpy(L->livros[index].autor,autor);
    strcpy(L->livros[index].editora,editora);
    L->livros[index].nPaginas=nPaginas;
  }else{
    printf("Livro nao encontrado!");
  }
}
void pesquisaCodigo(Lista *L, int codigo){
  int i, encontrou=0,index;
  for(i=0;i<L->n;i++){
    if(L->livros[i].codigo==codigo){
        encontrou=1;
        index=i;
    }
  }
  if(encontrou==1){
    printf("Livro Encontrado!\nNome: %s \n",L->livros[index].nome);
    printf("Doado: %c\n",L->livros[index].isDoado);
    printf("Autor: %s\n",L->livros[index].autor);
    printf("Editora: %s\n",L->livros[index].editora);
    printf("Numero de Paginas: %d\n",L->livros[index].nPaginas);
    printf("\n");
  }else{
      printf("Livro nao encontrado!");
  }
}
void listarTodosDoados(Lista *L){
  int i;
  printf("Livros da Categoria %s que foram doados:\n",L->nomeLista);
  for(i=0;i<L->n;i++){
    if(L->livros[i].isDoado=='s')
      printf("Cod.%d - %s\n",L->livros[i].codigo,L->livros[i].nome);
  }
  printf("\n");
}
void listarEntre100e300pg(Lista *L){
  int i;
  printf("Livros da Categoria %s que foram comprados e tem entre 100 e 300 paginas:\n",L->nomeLista);
  for(i=0;i<L->n;i++){
    if((L->livros[i].isDoado=='n')&&((L->livros[i].nPaginas>=100)&&(L->livros[i].nPaginas<=300)))
      printf("Cod.%d - %s\n",L->livros[i].codigo,L->livros[i].nome);
  }
  printf("\n");
}
void listarTodosCategoria(Lista *L){
  int i;
  printf("Livros da Categoria %s:\n",L->nomeLista);
  for(i=0;i<L->n;i++){
    printf("Cod.%d - %s\n",L->livros[i].codigo,L->livros[i].nome);
  }
  printf("\n");
}
void pesquisaNome(Lista *L,char nome[50]){
  int i, encontrou=0,index;
  char str1[50];
  char str2[50];
  for(i=0;i<L->n;i++){
    strcpy(str1,L->livros[i].nome);
    strcpy(str2, nome);
    if(strcmp(str1,str2)==0){
        encontrou=1;
        index=i;
        break;
    }
  }
  if(encontrou==1){
    printf("\n");
    printf("Livro Encontrado!\nNome: %s \n",L->livros[index].nome);
    printf("Codigo: %d\n",L->livros[index].codigo);
    printf("Doado: %c\n",L->livros[index].isDoado);
    printf("Autor: %s\n",L->livros[index].autor);
    printf("Editora: %s\n",L->livros[index].editora);
    printf("Numero de Paginas: %d\n",L->livros[index].nPaginas);
    printf("\n");
  }else{
    printf("Livro nao encontrado!\n");
  }
}
void deletarLivro(Lista* L, int codigo){
  int i, encontrou=0,index;
  for(i=0;i<L->n;i++){
    if(L->livros[i].codigo==codigo){//Acha o index do codigo na lista
        encontrou=1;
        index=i;
        break;
    }
  }
  if(encontrou==1){
    int k=index;
    for(i=k; i<L->n;i++){
      L->livros[i]=L->livros[i+1];
    }
    L->n--;
  }else{
    printf("Livro nao encontrado!");
  }
}