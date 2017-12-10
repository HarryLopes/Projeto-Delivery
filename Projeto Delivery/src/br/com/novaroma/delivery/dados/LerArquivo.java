package br.com.novaroma.delivery.dados;

import java.io.IOException;
import java.util.ArrayList;

public interface LerArquivo<T> {

	public ArrayList<T> lerArquivo()throws IOException, ClassNotFoundException;
}
