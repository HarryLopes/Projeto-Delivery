package br.com.novaroma.delivery.apresentacao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import br.com.novaroma.delivery.entidades.Funcionario;
import br.com.novaroma.delivery.negocio.NegocioFuncionario;
import br.com.novaroma.delivery.util.Utils;

public class TelaFuncionario extends Funcionario{

	private static Scanner sc = new Scanner(System.in);
	private static Funcionario funcionario = new Funcionario();
	private static Utils clienteNegocios = new Utils();
	
	private static NegocioFuncionario nf = new NegocioFuncionario();
	
	public Funcionario cadastrarFuncionario(){
		
		System.out.println("----------------------------------");
		System.out.println("            FUNCIONARIO           ");
		System.out.println("----------------------------------");
		System.out.println("Nome: ");
		funcionario.setNome(sc.nextLine());
		System.out.println("Sobrenome: ");
		funcionario.setSobrenome((sc.nextLine()));
		System.out.println("CPF no formato 'XXX.XXX.XXX-XX' : ");
		funcionario.setCpf((sc.nextLine()));
		
		while(Utils.validarCPF(funcionario.getCpf()) != true){
			System.out.println("CPF no formato 'XXX.XXX.XXX-XX': ");
			funcionario.setCpf(sc.nextLine());
		}
		
		System.out.println("Senha: ");
		funcionario.setSenha(sc.nextLine());
		
		return funcionario;
	}
	
	public void exibirFuncionariosCadastrados() {

		try {

			FileInputStream arquivo = new FileInputStream("funcionario.data");

			ObjectInputStream input = new ObjectInputStream(arquivo);

			ArrayList<Funcionario> lista = (ArrayList<Funcionario>) input.readObject();

			for (int i = 0; i < lista.size(); i++) {
				System.out.println(lista.get(i));
			}
			
			arquivo.close();
			input.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
