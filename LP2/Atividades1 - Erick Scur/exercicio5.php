<!-- Escreva um programa em que o utilizador vai introduzindo as idades dos alunos de uma determinada
turma até ser introduzido o número -1. No fim deverá indicar o número de alunos e a média de idades. -->

<?php
  $idade = 0;
  $soma = 0;
  $numeroAlunos = 0;
  do{
    $idade = readline("Informe a idade (insira -1 para parar): ");
    if($idade > 0){
      $numeroAlunos++;
      $soma += $idade;
    }
  }while($idade != -1);

  $media = $soma / $numeroAlunos;

  print("Media de idade: ".$media."\n");
  print("Numero de alunos: ".$numeroAlunos. "\n");
?>