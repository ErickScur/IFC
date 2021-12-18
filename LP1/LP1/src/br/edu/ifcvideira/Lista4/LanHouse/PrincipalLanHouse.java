package br.edu.ifcvideira.Lista4.LanHouse;

public class PrincipalLanHouse {
	public static void main(String[] args) {
		LanHouse lan = new LanHouse();
		lan.adicionarComputador(1, 0, "Dell G5", 8, "Geforce GTX 1080 TI", "Intel Core i7 5590");
		lan.adicionarComputador(2, 0, "Acer 98789", 8, "Geforce GTX 2060", "Intel Core i7 5590");
		System.out.println(lan.getComputadorPorMemoria(8));
		lan.marcarDefeito(2, "Fonte Queimada");
		System.out.println(lan.getDefeitos());
	}
}
