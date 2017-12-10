package br.com.novaroma.delivery.excecoes;

public class ExcecaoFuncionarioNaoCadastrado extends Exception {

	public ExcecaoFuncionarioNaoCadastrado(String message) {
		super(message);
	}
}
