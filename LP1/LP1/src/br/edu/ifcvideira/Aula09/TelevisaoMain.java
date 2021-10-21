package br.edu.ifcvideira.Aula09;

import javax.swing.JOptionPane;

public class TelevisaoMain {
	public static void main(String[] args) {
		Televisao tv = new Televisao();
		for(;;) {
			String[] options = {"Power","Ir para Canal", "Aumentar Canal","Decrementar Canal","Aumentar Volume","Diminuir Volume","Encerrar Sistema"};
			String status = "";
			if(tv.isLigado()) {
				status+="TV Ligada! \nVolume: "+tv.getVolume()+"\nCanal: "+tv.getCanalAtual();
			}else {
				status+="TV Desligada";
			}
			int op = JOptionPane.showOptionDialog(null, status,
	                "Televisao",
	                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			
			switch(op) {
				case 0:
					tv.power();
					if(tv.isLigado()) 
						JOptionPane.showMessageDialog(null, "Voce ligou a TV");
					else
						JOptionPane.showMessageDialog(null, "Voce desligou a TV");
					break;
				case 1:
					if(tv.isLigado()) {
						int canal = Integer.parseInt(JOptionPane.showInputDialog("Insira o canal"));
						int canalAtual = tv.getCanalAtual();
						tv.setCanal(canal, canalAtual);
						if(tv.getCanalAtual() == canalAtual)
							JOptionPane.showMessageDialog(null, "O canal nao foi encontrado, voce voltou para o canal: "+tv.getCanalAtual());
						else 
							JOptionPane.showMessageDialog(null, "Mudou para o canal: "+tv.getCanalAtual());
					}else {
						JOptionPane.showMessageDialog(null, "A TV esta desligada");
					}
					break;
				case 2:
					if(tv.isLigado()) {
						tv.incrementarCanal();
						JOptionPane.showMessageDialog(null, "Voce foi para o canal: "+tv.getCanalAtual());
					}else {
						JOptionPane.showMessageDialog(null, "A TV esta desligada");
					}	
					break;
				case 3:
					if(tv.isLigado()) {
						tv.decrementarCanal();
						JOptionPane.showMessageDialog(null, "Voce foi para o canal: "+tv.getCanalAtual());
					}else {
						JOptionPane.showMessageDialog(null, "A TV esta desligada");
					}	
					break;
				case 4:
					if(tv.isLigado()) {
						if(tv.getVolume() < tv.getVolumeMax()) {
							tv.aumentarVolume();
							JOptionPane.showMessageDialog(null, "Voce aumentou o volume para: "+tv.getVolume());
						}else {
							JOptionPane.showMessageDialog(null, "A TV esta no volume maximo!");
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "A TV esta desligada");
					}	
					break;
				case 5:
					if(tv.isLigado()) {
						if(tv.getVolume() > 0) {
							tv.diminuirVolume();
							JOptionPane.showMessageDialog(null, "Voce diminuiu o volume para: "+tv.getVolume());
						}else {
							JOptionPane.showMessageDialog(null, "A TV esta no volume minimo!");
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "A TV esta desligada");
					}	
					break;
				case 6:
					System.exit(0);
			}
		}
	}
}
