package br.com.novaroma.delivery.dados;

import br.com.novaroma.delivery.entidades.Cliente;

import java.io.*;
import java.util.ArrayList;

public class DadosCliente<T> implements LerArquivo<T>{

	private File arquivo;

	public DadosCliente() {
		 arquivo = new File("clientes.data");
	}

	public void escreverArquivo(ArrayList<Cliente> clientes) throws IOException {
		FileOutputStream fos = new FileOutputStream(arquivo);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(clientes);

		oos.close();
		fos.close();
	}

	public ArrayList<T> lerArquivo() throws IOException, ClassNotFoundException {
		ArrayList<Cliente> clientes = null;

		if(!arquivo.exists()) {
			arquivo.createNewFile();
			clientes = new ArrayList<>();
		} else {
			FileInputStream fis = new FileInputStream(arquivo);
			ObjectInputStream ois = new ObjectInputStream(fis);

			clientes = (ArrayList<Cliente>) ois.readObject();

			ois.close();
			fis.close();
		}

		return  (ArrayList<T>) clientes;
	}
}
