package br.com.novaroma.delivery.entidades;

import java.io.Serializable;

public class Produto implements Serializable {

	private String nome;
	private char tamanho;
	private double preco;

	public Produto() {

	}

	public Produto(String nome, char tamanho) {
		if(nome.equals("Acai")){
			switch (tamanho) {
				case 'p':
				case 'P':
					this.nome = nome;
					this.preco = 4.50;
					this.tamanho = tamanho;
					break;
				case 'm':
				case 'M':
					this.nome = nome;
					this.preco = 7.0;
					this.tamanho = tamanho;
					break;
				case 'g':
				case 'G':
					this.nome = nome;
					this.preco = 9.0;
					this.tamanho = tamanho;
					break;
			}
		} else if (nome.equals("Cupuacu")) {
			switch (tamanho) {
				case 'p':
				case 'P':
					this.nome = nome;
					this.preco = 5.50;
					this.tamanho = tamanho;
					break;
				case 'm':
				case 'M':
					this.nome = nome;
					this.preco = 6.0;
					this.tamanho = tamanho;
					break;
				case 'g':
				case 'G':
					this.nome = nome;
					this.preco = 7.0;
					this.tamanho = tamanho;
					break;
			}
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public char getTamanho() {
		return tamanho;
	}

	public void setTamanho(char tamanho) {
		this.tamanho = tamanho;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Produto{" +
				"nome='" + nome + '\'' +
				", tamanho=" + tamanho +
				", preco=" + preco +
				'}';
	}
}
