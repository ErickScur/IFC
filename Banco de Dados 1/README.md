# DQL (data query language)

## Seleção
### Estrutura básica de uma seleção:
> SELECT coluna1, coluna2 FROM tabela

<br></br>

### Operador Coringa ( * ):
Seleciona todas as colunas
> SELECT * FROM tabela

<br></br>

### ALIAS (nove nome):
Renomear tabela ou coluna
> SELECT nome as funcionario FROM empresa

<br></br>

### DISTINCT 
Seleciona apenas os diferentes valores que existem
> SELECT DISTINCT coluna FROM tabela

> SELECT DISTINCT setor FROM empresa

<br></br>

### OPERADORES ARITMÉTICOS
| Operador | Descrição       |
|----------|-----------------|
| +        | Soma            |
| -        | Subtração       |
| /        | Divisão         |
| *        | Multiplicação   |
| % ou MOD | RESTO           |
| DIV      | Divisão Inteira |  

### Ex: Listar quanto fica o sálarios de cada funcionário com uma redução de 10%
> SELECT * ,(salario * 0.9) as novoSalario FROM empregado

<br></br>

## WHERE
Adiciona condições a seleção

> SELECT * FROM  empregado WHERE setor='financeiro'

<br></br>

### Operadores relacionais
| Operador | Descrição      |
|----------|----------------|
| =        | Igualdade      |
| <>       | Diferente      |
| >        | Maior          |
| <        | Menor          |
| >=       | Maior ou Igual |
| <=       | Menor ou Igual |

> SELECT nome,setor FROM empregado WHERE salario>2000

> SELECT nome,setor FROM empregado WHERE setor<>‘financeiro’

<br></br>

### Operadores Lógicos
| Operador | Descrição      |
|----------|----------------|
| And &&   |   E            |
| OR       |   Ou           |
| NOT !!   |   Não          |
| XOR      |   Ou Exclusivo |

> SELECT nome, setor,salario FROM empregados WHERE setor=‘financeiro’ OR setor=‘administrativo;

> SELECT nome, setor,salario FROM empregado WHERE setor=‘serviços gerais’ AND salario>2000;


<br></br>

### Operadores
| Operador | Descrição           |
|----------|---------------------|
| BETWEEN  | ENTRE               |
| LIKE     | PADRÃO TEXTUAL      |
| IN       | CONJUNTO DE VALORES |

<br></br>

### BETWEEN:
Seleciona os ***valores que estão entre** os valores informados(retorno inclui valor1 e valor2).

> SELECT coluna FROM tabela WHERE coluna BETWEEN valor1 AND valor2;

<br></br>

### LIKE:
Restringe a seleção a apenas valores que correspondam ao padrão textual fornecido.

% - Qualquer quantidade de caracteres

_ - Um único caracter

- Ex: Listar os empregados que tenham silva em seu sobrenome
> SELECT nome,setor FROM empregado WHERE nome LIKE ‘%silva%’;

<br></br>

### IN:
Seleciona **apenas valores informados dentro do in**.

- Ex: Listar os empregados que tenham o id 1,2,3
> SELECT nome,setor FROM empregado WHERE id_empregado IN (1,2,3);

<br></br>

### Odenar os registros retornados:
> SELECT coluna FROM tabela WHERE 1 ORDER BY coluna [ASC/DESC];

DESC - Decrescente;

ASC - Crescente

- Ex: Listar os empregados em ordem alfabética:
> SELECT nome FROM empregado ORDER BY nome;

- Ex: Listar os empregados trazendo primeiro aqueles que ganham mais
> SELECT nome FROM empregado ORDER BY salario DESC

<br></br>

### LIMIT:
Restringe a quantidade de registros retornados

- Ex: Listar os 3 empregados com menor salário da empresa
> SELECT nome FROM empregado ORDER BY salario ASC LIMIT 3

<br></br>

### SUM:
Faz o somatório de determinada coluna
> SELECT SUM(coluna) FROM tabela

 - Ex: Apresentar qual o valor que a empresa gasta com salários atualmente

> SELECT SUM(salario) FROM empregado

<br></br>

### AVG
Faz a média aritmética dos valores retornados
> SELECT AVG(coluna) FROM tabela
- Ex: Apresentar a média de salário do setor financeiro
> SELECT AVG(salario) FROM empregado WHERE setor=‘financeiro’

<br></br>

# DML(data manipulation language)

## INSERT
Insere valores no banco
> INSERT INTO tabela (colunas) VALUES (valores);

<br></br>

## UPDATE
Atualiza registros
> UPDATE tabela SET coluna1=valor1, coluna2=valor2, coluna3=valor3 WHERE condição

<br></br>

## DELETE
Deleta registros
> DELETE FROM tabela WHERE condição
