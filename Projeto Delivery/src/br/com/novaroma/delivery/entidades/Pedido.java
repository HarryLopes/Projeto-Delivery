package br.com.novaroma.delivery.entidades;

import java.io.Serializable;
import java.util.ArrayList;

public class Pedido implements Serializable {
	private String id;
	private ArrayList<Produto> produtos;

	public Pedido(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public String toString() {
		String string = new String("{ ");

		for(int i = 0; i < produtos.size(); i++) {
			if(i < produtos.size() - 1) {
				string += '[' + produtos.get(i).getNome() + " (" + produtos.get(i).getTamanho() + ") - " + produtos.get(i).getPreco() + "], ";
			} else {
				string += '[' + produtos.get(i).getNome() + " (" + produtos.get(i).getTamanho() + ") - " + produtos.get(i).getPreco() + "] }";
			}
		}

		return string;
	}
}
