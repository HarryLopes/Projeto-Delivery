package br.com.novaroma.delivery.apresentacao;

import br.com.novaroma.delivery.entidades.Cliente;
import br.com.novaroma.delivery.entidades.Funcionario;
import br.com.novaroma.delivery.excecoes.ExcecaoClienteNaoCadastrado;
import br.com.novaroma.delivery.excecoes.ExcecaoFuncionarioNaoCadastrado;
import br.com.novaroma.delivery.negocio.NegocioCliente;
import br.com.novaroma.delivery.negocio.NegocioFuncionario;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class TelaMenu {

	static Scanner sc = new Scanner(System.in);
	static TelaCliente telaCliente = new TelaCliente();
	static TelaFuncionario telafuncionario = new TelaFuncionario();
	private NegocioCliente nc = new NegocioCliente();
	private NegocioFuncionario nf = new NegocioFuncionario();

	public void menu() throws ClassNotFoundException, IOException {

		int escolha = 999;

		while (escolha != 0) {
			System.out.println("----------------------------------");
			System.out.println("               MENU               ");
			System.out.println("----------------------------------");
			System.out.println("1..Cadastrar Cliente..............");
			System.out.println("2..Pesquisar Cliente..............");
			System.out.println("3..Atualizar Cliente..............");
			System.out.println("4..Deletar Cliente................");
			System.out.println("5..Exibir todos os Clientes.......");
			System.out.println("6..Cadastrar Funcionario..........");
			System.out.println("7..Pesquisar Funcionario..........");
			System.out.println("8..Remover Funcionario............");
			System.out.println("9..Exibir todos os Funcionarios...");
			System.out.println("10.Iniciar Pedido.................");

			System.out.println("0..Sair...........................");
			System.out.println("----------------------------------");
			escolha = Integer.parseInt(sc.nextLine());

			switch (escolha) {
				case 1:
					nc.cadastrarCliente(telaCliente.preencherCliente());
					System.out.println("========================================");
					break;
				case 2:
					System.out.println("Digite o CPF Cliente:");
					String dado = sc.nextLine();
					Cliente cliente = nc.buscarCliente(dado);
					System.out.println(cliente);
					System.out.println("========================================");
					break;
				case 3:
					try {
						nc.atualizarCliente(telaCliente.preencherCliente());
					} catch (ExcecaoClienteNaoCadastrado e) {
						System.out.println(e.getMessage());
					}
					System.out.println("========================================");
					break;
				case 4:
					System.out.println("Digite o CPF do Cliente:");
					String cpf = sc.nextLine();
					try {
						Cliente cli = nc.buscarCliente(cpf);
						nc.removerCliente(cli.getCpf());
						System.out.println("Cliente removido: " + cli);
					} catch (ExcecaoClienteNaoCadastrado e) {
						System.out.println(e.getMessage());
					}
					System.out.println("==================================");
					break;
				case 5:
					try{
						telaCliente.exibirCLientesCadastrados();
					}catch (FileNotFoundException e) {
						System.out.println("Nenhum cadastro encontrado!");
					}
					System.out.println("==================================");
					break;
				case 6:
					nf.cadastrarFuncionario(telafuncionario.cadastrarFuncionario());
					System.out.println("==================================");
					break;
				case 7:
					System.out.println("Digite o CPF do funcionario:");
					String dados = sc.nextLine();
					Funcionario funcionario = nf.buscarFuncionario(dados);
					System.out.println(funcionario);
					System.out.println("==================================");
					break;
				case 8:
					System.out.println("Digite o CPF do Funcionario:");
					String cpf2 = sc.nextLine();
					try {
						Funcionario fun = nf.buscarFuncionario(cpf2);
						nf.removerFuncionario(fun.getCpf());
						System.out.println("Funcionario removido: " + fun);
					} catch (ExcecaoFuncionarioNaoCadastrado e) {
						System.out.println(e.getMessage());
					}
					System.out.println("==================================");
					break;
				case 9:
					telafuncionario.exibirFuncionariosCadastrados();
					System.out.println("==================================");
					break;
				case 10:
					telaCliente.iniciarPedido();
					System.out.println("==================================");
					break;

				case 0:
					System.out.println("Programa encerrado!");
					System.out.println("==================================");
					break;
			}
		}


	}

}
