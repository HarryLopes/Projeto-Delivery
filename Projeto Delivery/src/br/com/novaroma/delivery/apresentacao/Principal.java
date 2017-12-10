	package br.com.novaroma.delivery.apresentacao;

import br.com.novaroma.delivery.entidades.Funcionario;
import br.com.novaroma.delivery.negocio.NegocioFuncionario;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Principal {
	private static NegocioFuncionario nf = new NegocioFuncionario();

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Scanner in = new Scanner(System.in);

		System.out.println("Entre com seu login (CPF):");
		String login = in.nextLine();

		System.out.println("Entre com sua senha:");
		String senha = in.nextLine();

		if(nf.existeFuncionario(login)) {
			Funcionario funcionario = nf.buscarFuncionario(login);
			if(funcionario.getSenha().equals(senha)) {
				TelaMenu telaMenu = new TelaMenu();
				
				telaMenu.menu();
				
			} else {
				System.out.println("Senha incorreta.");
			}
		} else {
			System.out.println("Login inexistente.");
		}
	}

}
