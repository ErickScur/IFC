<!-- Escreva um programa que leia 10 números inteiros introduzidos pelo utilizador e indique o máximo,
a média, o mínimo e a soma dos valores. -->
<?php
  $soma = 0;
  $menor = PHP_INT_MAX;
  $maior = PHP_INT_MIN;
  $qtd = 0;
  for($i = 0 ; $i < 10; $i++){
    $valor = readline("Informe o valor ".($i+1). ":");
    if($valor > $maior) $maior = $valor;
    if($valor < $menor) $menor = $valor;
    $soma += $valor;
    $qtd++;
  }
  $media = $soma/$qtd;
  print("Maximo: ".$maior."\n");
  print("Minimo: ".$menor."\n");
  print("Media: ".$media."\n"); 
  print("Soma: ".$soma."\n");
?>