package br.edu.ifcvideira.Lista3;

public class ConversaoDeUnidadesDeVolume {
	public static double LitroParaCmCubico(double litro) {
		double cmCubicos = litro * 1000;
		return cmCubicos;
	}
	public static double CmCubicoParaLitro(double cmCubico) {
		double litro = cmCubico / 1000;
		return litro;
	}
	public static double MetroCubicoParaLitro(double mCubico) {
		double litro = mCubico*1000;
		return litro;
	}
	public static double LitroParaMetroCubico(double litro) {
		double mCubico = litro / 1000;
		return mCubico;
	}
	public static double MetroCubicoParaPesCubicos(double mCubico) {
		double pesCubicos = mCubico* 35.32;
		return pesCubicos;
	}
	public static double PesCubicosParaMetroCubico(double pesCubicos) {
		double mCubico = pesCubicos / 35.32;
		return mCubico;
	}
	public static double GalaoAmericanoParaPolegadasCubicas(double galaoAmericano) {
		double polegadasCubicas = galaoAmericano * 231;
		return polegadasCubicas;
	}
	public static double PolegadasCubicasParaGalaoAmericano(double polegadasCubicas) {
		double galaoAmericano = polegadasCubicas / 231;
		return galaoAmericano;
	}
	public static double GalaoAmericanoParaLitro(double galaoAmericano) {
		double litro = galaoAmericano * 3.785;
		return litro;
	}
	public static double LitroParaGalaoAmericano(double litro) {
		double galaoAmericano = litro / 3.875;
		return galaoAmericano;
	}
}
