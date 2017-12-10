package br.com.novaroma.delivery.dados;

import br.com.novaroma.delivery.entidades.Funcionario;

import java.io.*;
import java.util.ArrayList;

public class DadosFuncionario<T> implements LerArquivo<T>{

	private File arquivo;

	public DadosFuncionario() {
		 arquivo = new File("funcionario.data");
	}

	public void escreverArquivo(ArrayList<Funcionario> funcionarios) throws IOException {
		FileOutputStream fos = new FileOutputStream(arquivo);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(funcionarios);

		oos.close();
		fos.close();
	}

	public ArrayList<T> lerArquivo() throws IOException, ClassNotFoundException {
		ArrayList<Funcionario> funcionarios = null;

		if(!arquivo.exists()) {
			arquivo.createNewFile();
			funcionarios = new ArrayList<>();
			funcionarios.add(new Funcionario("Walber", "Adm", "adm", "123"));
			escreverArquivo(funcionarios);
		} else {
			FileInputStream fis = new FileInputStream(arquivo);
			ObjectInputStream ois = new ObjectInputStream(fis);

			funcionarios = (ArrayList<Funcionario>) ois.readObject();

			ois.close();
			fis.close();
		}

		return (ArrayList<T>) funcionarios;
	}
}
