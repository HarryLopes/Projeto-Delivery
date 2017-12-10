package br.com.novaroma.delivery.negocio;

import java.io.IOException;
import java.util.ArrayList;

import br.com.novaroma.delivery.dados.DadosCliente;
import br.com.novaroma.delivery.entidades.Cliente;
import br.com.novaroma.delivery.excecoes.ExcecaoClienteNaoCadastrado;

public class NegocioCliente {
	private DadosCliente<Cliente> dados;

	public NegocioCliente() {
		this.dados = new DadosCliente();
	}

	public void cadastrarCliente(Cliente cliente) throws IOException, ClassNotFoundException {
		ArrayList<Cliente> clientes = dados.lerArquivo();
		clientes.add(cliente);
		dados.escreverArquivo(clientes);
	}

	public void removerCliente(String cpf) 
			throws IOException, ClassNotFoundException, ExcecaoClienteNaoCadastrado {
		if(existeCliente(cpf)) {
			ArrayList<Cliente> clientes = dados.lerArquivo();
			clientes.remove(buscarCliente(cpf));
			dados.escreverArquivo(clientes);
		} else {
			throw new ExcecaoClienteNaoCadastrado("Erro! Cliente nao cadastrado.");
		}
	}

	public void atualizarCliente(Cliente cliente) 
			throws IOException, ClassNotFoundException, ExcecaoClienteNaoCadastrado {
		if(existeCliente(cliente.getCpf())) {
			ArrayList<Cliente> clientes = dados.lerArquivo();
			clientes.remove(buscarCliente(cliente.getCpf()));
			clientes.add(cliente);
			dados.escreverArquivo(clientes);
		} else {
			throw new ExcecaoClienteNaoCadastrado("Erro! Cliente nao cadastrado.");
		}

	}

	public Cliente buscarCliente(String cpf) throws IOException, ClassNotFoundException {
		ArrayList<Cliente> clientes = dados.lerArquivo();

		for(Cliente cliente : clientes) {
			if(cliente.getCpf().equals(cpf)) {
				return cliente;
			}
		}

		return null;
	}

	public boolean existeCliente(String cpf) throws IOException, ClassNotFoundException {
		return buscarCliente(cpf) != null;
	}
}
