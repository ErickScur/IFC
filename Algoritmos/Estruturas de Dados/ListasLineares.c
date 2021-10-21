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
#define m 5

//! DEFINICAO DA ESTRUTURA LIVRO
typedef struct
{
    int codigo;
    char isDoado;
    char *nome;
    char *autor;
    char *editora;
    int nPaginas;
}Livro;

typedef struct{
    int n; //* n = numero de elementos da lista
    char *nomeLista;
    Livro livros[m];
}Lista;
void criaLivro(Livro *L, int codigo, char isDoado, char nome[50], char autor[50], char editora[50], int nPaginas){
    int op;
    L->codigo=codigo;
    L->isDoado=isDoado;
    L->nome=nome;
    L->autor=autor;
    L->editora=editora;
    L->nPaginas=nPaginas;
}
void inserirFinal(Lista *L, Livro *livro){
    if(L->n > m-1){
        printf("erro: elemento fora dos limites da lista");
    }else{
        L->livros[L->n]=*livro;
        L->n++;
    }
}
void addLivro(Lista* ptExatas,Lista* ptHumanas, Lista* ptBiomedicas){
  char isDoado, nome[50],autor[50],editora[50];
  int codigo, nPaginas,op;
  Livro livro;
  printf("Informe o codigo do livro:\n");
  scanf("%d",&codigo);

  printf("O livro eh doado?(s/n)\n");
  scanf("%c", &isDoado);

  printf("Informe o nome do autor:\n");
  scanf("%[^\n]%*c", autor);

  printf("Informe o nome da editora:\n");
  scanf("%[^\n]%*c", editora);

  printf("Informe o numero de paginas:\n");
  scanf("%d",&nPaginas);
  criaLivro(&livro, codigo,isDoado, nome, autor, editora,nPaginas);
  printf("Informe a Categoria:\n1-Exatas\n2-Humanas\n3-Biomedicas");
  scanf("%d",&op);
  if(op==1)
    inserirFinal(ptExatas, &livro);
  else if(op==2)
    inserirFinal(ptHumanas, &livro);
  else if(op==3)
    inserirFinal(ptBiomedicas, &livro);

}
//! FUNCOES DAS LISTAS
void iniciaLista(Lista *L,char nome[10]){ //! Recebe o endereco da lista e seta o numero de elementos para 0
    L->n=0;
    L->nomeLista=nome;
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
        printf("Numero de Paginas: %d\n",L->livros[index].nPaginas);

    }else{
        printf("Livro nao encontrado!");
    }
}
void listarTodas(Lista *L){
  int i;
  printf("Livros da Categoria %s:\n",L->nomeLista);
  for(i=0;i<L->n;i++){
    printf("%s\n",L->livros[i].nome);
  }
}
void pesquisaNome(Lista *L,char *nome){
    int i, encontrou=0,index;
    char str1[50];
    char str2[50];

    strcpy(str1,L->livros[i].nome);
    strcpy(str2, nome);
    for(i=0;i<L->n;i++){
        if(strcmp(str1,str2)==0){
            encontrou=1;
            index=i;
            break;
        }
    }
    if(encontrou==1){
        printf("Livro Encontrado!\nNome: %s \n",L->livros[index].nome);
        printf("Codigo: %d\n",L->livros[index].codigo);
        printf("Doado: %c\n",L->livros[index].isDoado);
        printf("Autor: %s\n",L->livros[index].autor);
        printf("Numero de Paginas: %d\n",L->livros[index].nPaginas);

    }else{
        printf("Livro nao encontrado!");
    }
}

int main(){
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

    Livro Livro1;
    criaLivro(&Livro1, 1, 's', "A Fuga das Galinhas","Rodrigo","Editora Nova",120);
    inserirFinal(ptHumanas,&Livro1);
    
    addLivro(ptExatas, ptHumanas, ptBiomedicas);
    pesquisaCodigo(ptHumanas, 2);
    
    //listarTodas(ptHumanas);

    return 0;
}