package br.com.novaroma.delivery.entidades;

public class Funcionario extends Pessoa {

	private String cpf, senha;

	public Funcionario() {
	}

	public Funcionario(String nome, String sobrenome, String cpf, String senha) {
		super(nome, sobrenome);
		this.cpf = cpf;
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Funcionario{" +
				"cpf='" + cpf + '\'' +
				", senha='" + senha + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Funcionario that = (Funcionario) o;

		if (cpf != null ? !cpf.equals(that.cpf) : that.cpf != null) return false;
		return senha != null ? senha.equals(that.senha) : that.senha == null;
	}

	@Override
	public int hashCode() {
		int result = cpf != null ? cpf.hashCode() : 0;
		result = 31 * result + (senha != null ? senha.hashCode() : 0);
		return result;
	}
}
