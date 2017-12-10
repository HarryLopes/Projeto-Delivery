package br.com.novaroma.delivery.util;

public class Utils {

	public static boolean validarCep(String i) {

		String padrao = "\\d{5}-\\d{3}";

		if (i.matches(padrao)) {
			System.out.println("cep valido");
			return true;
		} else {
			System.err.println("cep invalido");
		}
		return false;

	}

	public static boolean validarTelefone(String i) {

		String padrao = "\\d{5}-\\d{4}";

		if (i.matches(padrao)) {
			System.out.println("Telefone valido");
			return true;
		} else {
			System.err.println("Telefone invalido");
		}
		return false;

	}

	public static boolean validarCPF(String i) {

		String padrao = "\\d{3}.\\d{3}.\\d{3}-\\d{2}";

		if (i.matches(padrao)) {
			System.out.println("CPF valido");
			return true;
		} else {
			System.err.println("CPF invalido");
		}
		return false;
	}

	public static boolean validarNumeroCartao(String i) {

		String padrao = "\\d{4}.\\d{4}.\\d{4}.\\d{4}";

		if (i.matches(padrao)) {
			System.out.println("Número do Cartão valido");
			return true;
		} else {
			System.err.println("Número do Cartão invalido");
		}
		return false;
	}
	
	public static boolean validarCodigoCartao(String i) {

		String padrao = "\\d{3}";

		if (i.matches(padrao)) {
			System.out.println("Código valido");
			return true;
		} else {
			System.err.println("Código invalido");
		}
		return false;
	}
	

}
