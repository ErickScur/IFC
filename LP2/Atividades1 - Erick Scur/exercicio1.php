<!-- Escreva um programa para imprimir os números inteiros entre 1 e 10 na mesma linha, primeiro em ordem 
crescente e depois em ordem decrescente. -->
<?php
  for ($i = 1; $i <= 10; $i++) {
    echo $i . " ";
  }
  echo "<br>";
  for ($i = 10; $i > 0; $i--) {
    echo $i . " ";
  }

?>