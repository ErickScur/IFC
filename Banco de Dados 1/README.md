# Banco de Dados 1

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
Restringe a seleção a apenas valores distintos
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
Restrição com maior flexibilidade

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
