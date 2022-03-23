<!-- Escreva um programa para imprimir todos os números inteiros entre dois valores introduzidos pelo
utilizador. O programa deverá verificar qual dos dois valores é o maior. -->
<?php
  $valor1 = readline("Informe o primeiro valor: ");
  $valor2 = readline("Informe o segundo valor: ");
  // Verifica qual eh maior e colocar o valor1 como maior e o valor2 como menor
  if($valor2 > $valor1) {
    $aux = $valor1;
    $valor1 = $valor2;
    $valor2 = $aux;
  }
  $maior = 0;
  for($i = $valor2; $i < $valor1; $i++){
    if($i > $maior){
      $maior = $i;
    }
    print($i . "\n");
  }
  print("O maior valor é: ". $maior . "\n");
?>