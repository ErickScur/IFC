package agenda;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

public class AgendaPrincipal {
	public static ContatoController contatoController = new ContatoController();
	
	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		GeradorDeContatos gerador = new GeradorDeContatos();
		for(int i=0; i<10; i++) {
			agenda.adicionarContato(gerador.randomContato());
		}
		menuPrincipal(agenda);
	}
	
	public static void menuPrincipal(Agenda agenda) {
		String[] menu = {"Listar Contatos", "Procurar Contato", "Adicionar Contato", "Sair"};
		
		menuPrincipal:
		for(;;) {
			int op = JOptionPane.showOptionDialog(null, "Agenda", "Agenda",
	                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, menu, menu[0]);
			switch(op) {
				case 0:
					menuSelecaoContato(agenda);
					break;
				case 1:
					procurarContato(agenda);
					break;
				case 2:
					adicionarContato(agenda);
					break;
				case 3:
					break menuPrincipal;
			}
		}
	}
	public static void menuSelecaoContato(Agenda agenda) {
		String[] menu0 = {"Selecionar Contato","Voltar"};
		selecaoContatos:
		for(;;) {
			int op0 = JOptionPane.showOptionDialog(null, agenda.listarContatos(), "Agenda",
	                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, menu0, menu0[0]);
			
			switch(op0) {
				case 0:
					selecaoContato(agenda);
					break;
				case 1:
					break selecaoContatos;
			}
		}
	}
	
	public static void procurarContato(Agenda agenda) {
		try {
			String nome = JOptionPane.showInputDialog("Pesquisa por nome:");
			ArrayList<Integer> contatos = agenda.getContatosNome(nome);
			int size = contatos.size();
			if(size == 0)
				JOptionPane.showMessageDialog(null, "Nenhum contato encontrado");
			else {
				String[] nomes = new String[size];
				for(int i=0; i<size; i++) {
					Contato contato = agenda.getContato(contatos.get(i));
					nomes[i] = contato.getNome() + " " + contato.getSobrenome();
				}
				int contatoIndex = JOptionPane.showOptionDialog(null, "Contatos Encontrados", "Agenda",
		                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, nomes, nomes[0]);
				Contato contato = agenda.getContato(contatos.get(contatoIndex));
				menuContato(agenda, contato, contatos.get(contatoIndex));
			}
		}catch(java.lang.NullPointerException e) {
			return;
		}
		
	}
	
	public static void adicionarContato(Agenda agenda) {
		try {
			Contato contato = new Contato();
			String nome = JOptionPane.showInputDialog("Informe o nome");
			if(!nome.equals(""))
				contato.setNome(nome);
			String sobrenome = JOptionPane.showInputDialog("Informe o sobrenome (deixe em branco caso não queira informar)");
			if(!sobrenome.equals(""))
				contato.setSobrenome(sobrenome);
			int op = JOptionPane.showConfirmDialog(null, "Deseja Adicionar data de nascimento?");
			if(op==0)
				contato.setDataNascimento(dataNascimento());
			agenda.adicionarContato(contato);
			menuContato(agenda, contato, (agenda.getContatos().size()-1));
		}catch(java.lang.NullPointerException e) {
			return;
		}
	}
	@SuppressWarnings("deprecation")
	public static Date dataNascimento() {
		int dia = 0;
		int mes = 0;
		int ano = 0;
		try {
			dia = Integer.parseInt(JOptionPane.showInputDialog("Informe o DIA de nascimento"));
			mes = Integer.parseInt(JOptionPane.showInputDialog("Informe o MES de nascimento"));
			ano = Integer.parseInt(JOptionPane.showInputDialog("Informe o ANO de nascimento"));
		}catch(java.lang.NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Valor Inválido");
			return null;
		}
		System.out.println(dia);
		return new Date(ano,mes,dia);
	}
	public static void selecaoContato(Agenda agenda) {
		String[] contatos = agenda.getContatosStringArray();
		int indexContato = JOptionPane.showOptionDialog(null, "Seleção de Contatos", "Agenda",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, contatos, contatos[0]);
		Contato contato = agenda.getContato(indexContato);
		menuContato(agenda, contato, indexContato);
		
	}
	public static void menuContato(Agenda agenda, Contato contato, int indexContato) {
		String[] menuContato = {"Atualizar Contato", "Excluir Contato", "Voltar"};
		menuContato:
			for(;;) {
				int opContato = JOptionPane.showOptionDialog(null, contato.listarDados(), "Agenda",
		                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, menuContato, menuContato[0]);
				switch(opContato) {
					case 0:
						atualizacaoContato(contato);
						break;
					case 1:
						excluirContato(agenda, indexContato);
						break menuContato;
					case 2:
						break menuContato;
						
				}
		}
	}
	public static void excluirContato(Agenda agenda, int index) {
		Contato contato = agenda.getContato(index);
		int op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o Contato: "+contato.getNome());
		if(op == 0)
			agenda.removeContato(index);
	}
	public static void atualizacaoContato(Contato contato) {
		String[] atualizacaoMenu = {"Alterar Nome/Sobrenome", "Adicionar Telefone", "Atualizar Telefone", "Excluir Telefone", "Adicionar Email", "Atualizar Email", "Excluir Email", "Data de Nascimento","Voltar"};
		atualizacao:
		for(;;) {
			int op = JOptionPane.showOptionDialog(null, contato.listarDados()+" \n Selecione a Opção:", "Agenda",
	                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, atualizacaoMenu, atualizacaoMenu[0]);
			switch(op) {
				case 0:
					ContatoController.atualizarNome(contato);
					break;
				case 1:
					ContatoController.addTelefone(contato);
					break;
				case 2:
					ContatoController.atualizacaoTelefone(contato);
					break;
				case 3:
					ContatoController.excluirTelefone(contato);
					break;
				case 4:
					ContatoController.addEmail(contato);
					break;
				case 5:
					ContatoController.atualizacaoEmail(contato);
					break;
				case 6:
					ContatoController.excluirEmail(contato);
					break;
				case 7:
					Date data = dataNascimento();
					contato.setDataNascimento(data);
					break;
				case 8:
					break atualizacao;
			}
		}
	}
	
	
	
	
	
	
	
}