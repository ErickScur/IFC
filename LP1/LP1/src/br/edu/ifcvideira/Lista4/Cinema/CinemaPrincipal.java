package br.edu.ifcvideira.Lista4.Cinema;

import javax.swing.JOptionPane;

public class CinemaPrincipal {
	public static void main(String[] args) {
		Cinema cinema = new Cinema();
		cinema.adicionarSala(1, 50);
		cinema.adicionarSala(2, 40);
		cinema.adicionarFilme(1,"Senhor do Aneis", "Aventura", 2005, "Marcos", 1);
		cinema.adicionarFilme(2,"Harry Potter", "Ficção", 2010, "Aquele lá", 2);
		cinema.adicionarSessao(1, 10.50, 1);
		cinema.adicionarSessao(2, 10.58, 2);
		
		String[] menu = {"Consultar Sessoes Disponiveis", "Comprar Ingresso", "Acesso Administrativo", "Sair"};
		sistema:
		for(;;) {
			int op = JOptionPane.showOptionDialog(null, "Sistema Cinema",
	                "Cinema",
	                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, menu, menu[0]);
			switch(op) {
			case 0:
				JOptionPane.showMessageDialog(null, cinema.getSessoes());
				break;
			case 1:
				int numeroSessao = Integer.parseInt(JOptionPane.showInputDialog("Informe o numero da sessao:"));
				Sessao sessao = cinema.encontrarSessaoPorNumero(numeroSessao);
				if(sessao.getNumeroSessao()!=-100) {
					int numeroIngressos = Integer.parseInt(JOptionPane.showInputDialog("Sessão n.º "+sessao.getNumeroSessao()+"\n"+
							"Filme: "+sessao.getFilme().getTitulo()+"\n"+
							"Valor Ingresso: "+sessao.getPrecoIngreco()+"\n"+
							"Sala: "+sessao.getFilme().getSala()+"\n \n \n"+
							"Informe o numero de ingressos:"));
					cinema.comprarIngresso(numeroSessao, numeroIngressos);
				}
				break;
			case 2:
				String senha = JOptionPane.showInputDialog("Informe a Senha de Administrador:");
				if(cinema.admLogin(senha)) {
					String[] admMenu = {"Adicionar Sala", "Adicionar Filme", "Adicionar Sessao", "Sair"};
					adm:
					for(;;) {
						op = JOptionPane.showOptionDialog(null, "Escolha a Operação:",
				                "Banco",
				                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, admMenu, admMenu[0]);
						switch(op) {
						case 0 :
							int numero = Integer.parseInt(JOptionPane.showInputDialog("Informe o numero da sala:"));
							if(cinema.getSalas().containsKey(numero)) {
								JOptionPane.showMessageDialog(null, "Numero de sala ja esta em uso!");
							}else {
								int capacidade = Integer.parseInt(JOptionPane.showInputDialog("Informe a capacidade da sala:"));
								if(capacidade > 0) {
									cinema.adicionarSala(numero, capacidade);
								}else {
									JOptionPane.showMessageDialog(null, "Capacidade Invalida!");
								}
							}
							break;
						case 1:
							numero = Integer.parseInt(JOptionPane.showInputDialog("Informe o numero do filme:"));
							String titulo = JOptionPane.showInputDialog("Informe o titulo do filme: ");
							String genero = JOptionPane.showInputDialog("Informe o genero do filme:");
							int ano = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano do filme:"));
							String diretor = JOptionPane.showInputDialog("Informe o diretor do filme:");
							int sala = Integer.parseInt(JOptionPane.showInputDialog("Informe a sala do filme:"));
							cinema.adicionarFilme(numero, titulo, genero, ano, diretor, sala);		
							break;
						case 2:
							int numeroFilme = Integer.parseInt(JOptionPane.showInputDialog("Informe o numero do filme:"));
							if(numeroFilme != -100) {
								double precoIngresso = Double.parseDouble(JOptionPane.showInputDialog("Informe o preço do ingresso:"));
								numeroSessao = Integer.parseInt(JOptionPane.showInputDialog("Informe o numero da sessao:"));
								cinema.adicionarSessao(numeroFilme, precoIngresso, numeroSessao);	
							}
							break;
						case 3:
							break adm;
						}
					}
				}
				break;
			case 3:
				break sistema;
			}
		}
	}
}
