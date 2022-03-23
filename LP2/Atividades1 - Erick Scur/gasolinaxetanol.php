<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Gasolina x Etanol</title>
</head>
<body>
  <h1>Cálculo Rendimento Etanol</h1>
  <form action="" method="post">
    <label for="">Desempenho do Etanol(km/l):</label> <br>
    <input type="number" name="desempenhoEtanol" required step="0.01"> <br>
    <label for="">Desempenho da Gasolina(km/l):</label> <br>
    <input type="number" name="desempenhoGasolina" required step="0.01">
    <br> <br>
    <input type="submit" value="Calcular">
  </form>
  <br>
  <?php 
    if(isset($_POST['desempenhoEtanol']) && isset($_POST['desempenhoGasolina'])) {
      $desempenhoEtanol = $_POST['desempenhoEtanol'];
      $desempenhoGasolina = $_POST['desempenhoGasolina'];
      $rendimentoEtanol = $desempenhoEtanol / $desempenhoGasolina;
      echo "<p>Rendimento do Etanol: " . $rendimentoEtanol." ou ".($rendimentoEtanol*100)."%</p>";
    }
  ?>

  <h1>Cálculo Relação Preço Etanol/Gasolina</h1>
  <form action="" method="post">
    <label for="">Preço do Etanol(R$):</label> <br>
    <input type="number" name="precoEtanol" required step="0.01"> <br>
    <label for="">Preço da Gasolina (R$):</label> <br>
    <input type="number" name="precoGasolina" required step="0.01">
    <br> <br>
    <input type="submit" value="Calcular">
  </form>
  <?php 
    if(isset($_POST['precoEtanol']) && isset($_POST['precoGasolina'])) {
      $precoEtanol = $_POST['precoEtanol'];
      $precoGasolina = $_POST['precoGasolina'];
      $relacaoPreco = $precoEtanol / $precoGasolina;
      echo "<p>Relação preco etanol/gasolina: " . $relacaoPreco. " ou ".($relacaoPreco*100)."%</p>";
    }
  ?>
</body>
</html>

