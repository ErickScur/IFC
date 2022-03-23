<!-- Escreva um programa que peça ao utilizador um nome e um número inteiro (entre 1 e 20). Deverá 
mostrar esse nome um número de vezes igual a esse valor inteiro. -->
<?php
  $nome = readline("Informe um nome: ");
  $qtd = readline("Informe um numero inteiro: ");
  for($i = 0; $i < $qtd; $i++){
    print($nome . "\n");
  }
?>