-package br.com.novaroma.delivery.apresentacao;

import br.com.novaroma.delivery.entidades.Cliente;
import br.com.novaroma.delivery.entidades.Pedido;
import br.com.novaroma.delivery.entidades.Produto;
import br.com.novaroma.delivery.excecoes.ExcecaoClienteNaoCadastrado;
import br.com.novaroma.delivery.negocio.NegocioCliente;
import br.com.novaroma.delivery.util.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TelaCliente extends Cliente {

	private static Scanner sc = new Scanner(System.in);
	private static Cliente cliente = new Cliente();
	private static Utils clienteNegocios = new Utils();

	private static NegocioCliente nc = new NegocioCliente();

	public Cliente preencherCliente() {

		System.out.println("----------------------------------");
		System.out.println("             CLIENTE              ");
		System.out.println("----------------------------------");
		System.out.println("Nome: ");
		cliente.setNome(sc.nextLine());
		System.out.println("Sobrenome: ");
		cliente.setSobrenome((sc.nextLine()));
		System.out.println("CPF no formato 'XXX.XXX.XXX-XX' : ");
		cliente.setCpf((sc.nextLine()));

		while (Utils.validarCPF(cliente.getCpf()) != true) {
			System.out.println("CPF no formato 'XXX.XXX.XXX-XX': ");
			cliente.setCpf(sc.nextLine());
		}

		System.out.println("Telefone no formato 'XXXXX-XXXX': ");
		cliente.setTelefone(sc.nextLine());

		while (Utils.validarTelefone(cliente.getTelefone()) != true) {
			System.out.println("Telefone no formato 'XXXXX-XXXX': ");
			cliente.setTelefone(sc.nextLine());
		}

		System.out.println("Rua: ");
		cliente.setRua(sc.nextLine());
		System.out.println("Numero: ");
		cliente.setNumero(sc.nextLine());
		System.out.println("Complemento: ");
		cliente.setComplemento(sc.nextLine());
		System.out.println("Bairro: ");
		cliente.setBairro(sc.nextLine());
		System.out.println("Cidade: ");
		cliente.setCidade(sc.nextLine());
		System.out.println("CEP no formato: XXXXX-XXX");
		cliente.setCep(sc.nextLine());

		while (Utils.validarCep(cliente.getCep()) != true) {
			System.out.println("CEP no formato 'XXXXX-XXX': ");
			cliente.setCep(sc.nextLine());
		}

		System.out.println(cliente.toString());
		return cliente;
	}

	public void exibirCLientesCadastrados() throws IOException, ClassNotFoundException {

		FileInputStream arquivo = new FileInputStream("cliente.data");
		ObjectInputStream input = new ObjectInputStream(arquivo);

		ArrayList<Cliente> clientes = (ArrayList<Cliente>) input.readObject();

		for (int i = 0; i < clientes.size(); i++) {
			System.out.println(clientes.get(i));
		}
	}

	public void iniciarPedido() {
		int sair = 0;
		double totPedido = 0;
		ArrayList<Produto> produtos = new ArrayList<>();

		System.out.println("Entre com o CPF do Cliente:");

		Cliente cliente = null;
		try {
			cliente = nc.buscarCliente(sc.nextLine());
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		while (sair == 0) {
			System.out.println("Qual das opcoes abaixo o cliente deseja?");
			System.out.println("1..Acai.................................");
			System.out.println("2..Cupuacu..............................");
			System.out.print("> ");
			int opcNome = Integer.parseInt(sc.nextLine());

			String nomeProduto = (opcNome == 1) ? "Acai" : "Cupuacu";

			System.out.println("Qual o tamanho?");
			System.out.println("1..Pequeno (p/P).................................");
			System.out.println("2..Medio (m/M)...................................");
			System.out.println("3..Grande (g/G)..................................");
			System.out.print("> ");
			char tamanho = sc.nextLine().charAt(0);

			Produto produto = new Produto(nomeProduto, tamanho);
			produtos.add(produto);
			totPedido += produto.getPreco();

			System.out.println("Deseja adicionar mais produtos?");
			System.out.println("1..Sim.................................");
			System.out.println("2..Nao.................................");
			System.out.print("> ");
			int opc = Integer.parseInt(sc.nextLine());

			if (opc == 2)
				sair = opc;
		}

		System.out.println("Valor do pedido: R$ " + totPedido);

		while (sair == 0) {

			System.out.println("Escolha a forma de pagamento:");
			System.out.println("1..Cartão Débito.............");
			System.out.println("2..Dinheiro..................");
			System.out.println("> ");
			int opc = sc.nextInt();

			if (opc == 1) {

				System.out.println("Insira o Número do Cartão: ");
				System.out.println("Exemplo: 0000.0000.0000.0000");
				cliente.setNumeroCartao(sc.nextLine());

				while (Utils.validarNumeroCartao(cliente.getNumeroCartao()) != true) {
					System.out.println("Insira o Número do Cartão: ");
					System.out.println("Exemplo: 0000.0000.0000.0000");
					cliente.setNumeroCartao(sc.nextLine());
				}

				System.out.println("Insira o Código de Segurança: ");
				System.out.println("Exemplo: 000");
				cliente.setCodigoCartao(sc.nextLine());

				while (Utils.validarCodigoCartao(cliente.getCodigoCartao()) != true) {
					System.out.println("Insira o Código de Segurança: ");
					System.out.println("Exemplo: 000");
					cliente.setCodigoCartao(sc.nextLine());
				}
				

				System.out.println("Compra Aprovada!");
				System.out.println("Foram Débitados: R$ " + totPedido);
				System.out.println("Pedido Finalizado!");

			}else {
				
				System.out.println("Valor do Pedido: " + totPedido);
				
				System.out.println("Insira a Quantia de Dinheiro: ");
				double qtdDinheiro = sc.nextDouble();
				
				if(qtdDinheiro > totPedido) {
					
					double troco = qtdDinheiro - totPedido;
					System.out.println("Valor do Pedido: " + totPedido + " || Valor Pago: R$" + qtdDinheiro);
					System.out.println("Seu troco foi de R$" + troco);
					System.out.println("Pagamento Efetuado!");
					
				}else {
					
					System.out.println("Valor do Pedido: R$" + totPedido + " || Valor Pago: R$" + qtdDinheiro);
					System.out.println("Pagamento Efetuado!");
					
				}
				
			}
		}
		
		bonusFuncionario(totPedido);
		
		Pedido pedido = new Pedido(produtos);
		cliente.getPedidos().add(pedido);
		
		try {
			nc.atualizarCliente(cliente);
		} catch (IOException | ClassNotFoundException | ExcecaoClienteNaoCadastrado e) {
			e.printStackTrace();
		}
	}
	
	public void bonusFuncionario(double totPedido) {
		
		double porcentagem = 0.5;
		double bonificacao = (porcentagem * totPedido);
		double bonificacaoTotal = 0;
		
		bonificacaoTotal += bonificacao;
		
		System.out.println("Você recebeu R$" + bonificacao + " desta venda.");
		System.out.println("Você totalizou R$" + bonificacaoTotal + "de bonificação no dia.");
		
	}
}
