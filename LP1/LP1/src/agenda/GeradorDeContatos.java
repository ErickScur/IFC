package agenda;

public class GeradorDeContatos {
	private String[] nomes = {"Pedro", "Maria", "José", "Erick", "Fábio", "Julia", "Ana", "Gustavo", "Vinicius", "Antônio", "Francisco", "Luiz","Paulo", "Paulo", "Adriana"};
	private String[] sobrenomes = {"Silva", "Santos", "Oliveira", "Souza", "Rodrigues", "Ferreira", "Alvez", "Pereira", "Lima","Gomes", "Ribeiro","Martins"};
	private String[] emails = {"gmail","yahoo","hotmail","outlook","uol"};
	public Contato randomContato() {
		String nome = nomeAleatorio();
		String sobrenome = sobrenomeAleatorio();
		Contato contato = new Contato(nome, sobrenome);
		String email = emailAleatorio(nome, sobrenome);
		Email mail = new Email(email, "Principal");
		contato.addEmail(mail);
		String tel = telefoneAleatorio();
		Telefone telefone = new Telefone(tel, "Principal");
		contato.addTelefone(telefone);
		return contato;
	}
	public String nomeAleatorio() {
		return this.nomes[numeroAleatorio(0, this.nomes.length)];
	}
	public String sobrenomeAleatorio() {
		return this.sobrenomes[numeroAleatorio(0, this.sobrenomes.length)];
	}
	public String emailAleatorio(String nome, String sobrenome) {
		return (nome+"."+sobrenome+"@"+this.emails[numeroAleatorio(0, this.emails.length)]+".com").toLowerCase();
	}
	public int numeroAleatorio(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}
	public String telefoneAleatorio() {
		String telefone = "";
		for(int i=0; i<11; i++) {
			telefone += numeroAleatorio(0, 9);
		}
		return telefone;
	}
}
