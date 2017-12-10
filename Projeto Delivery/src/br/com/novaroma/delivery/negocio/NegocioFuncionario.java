package br.com.novaroma.delivery.negocio;

import java.io.IOException;
import java.util.ArrayList;

import br.com.novaroma.delivery.dados.DadosFuncionario;
import br.com.novaroma.delivery.entidades.Funcionario;
import br.com.novaroma.delivery.excecoes.ExcecaoFuncionarioNaoCadastrado;

public class NegocioFuncionario {
	private DadosFuncionario<Funcionario> dados;

	public NegocioFuncionario() {
		this.dados = new DadosFuncionario();
	}

	public void cadastrarFuncionario(Funcionario funcionario) throws IOException, ClassNotFoundException {
		ArrayList<Funcionario> funcionarios = dados.lerArquivo();
		funcionarios.add(funcionario);
		dados.escreverArquivo(funcionarios);
	}

	public void removerFuncionario(String cpf)
			throws IOException, ClassNotFoundException, ExcecaoFuncionarioNaoCadastrado {
		if (existeFuncionario(cpf)) {
			ArrayList<Funcionario> funcionarios = dados.lerArquivo();
			funcionarios.remove(buscarFuncionario(cpf));
			dados.escreverArquivo(funcionarios);
		} else {
			throw new ExcecaoFuncionarioNaoCadastrado("Erro! Funcionario nao cadastrado.");
		}
	}

	public void atualizarFuncionario(Funcionario funcionario)
			throws IOException, ClassNotFoundException, ExcecaoFuncionarioNaoCadastrado {
		if (existeFuncionario(funcionario.getCpf())) {
			ArrayList<Funcionario> funcionarios = dados.lerArquivo();
			funcionarios.remove(buscarFuncionario(funcionario.getCpf()));
			funcionarios.add(funcionario);
			dados.escreverArquivo(funcionarios);
		} else {
			throw new ExcecaoFuncionarioNaoCadastrado("Erro! Funcionario nao cadastrado.");
		}

	}

	public Funcionario buscarFuncionario(String cpf) throws IOException, ClassNotFoundException {
		ArrayList<Funcionario> funcionarios = dados.lerArquivo();

		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getCpf().equals(cpf)) {
				return funcionario;
			}
		}

		return null;
	}

	public boolean existeFuncionario(String cpf) throws IOException, ClassNotFoundException {
		return buscarFuncionario(cpf) != null;
	}
}
