package br.com.novaroma.delivery.entidades;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente extends Pessoa implements Serializable {

	private String cpf, rua, bairro, cidade, numero, complemento, cep, telefone, numeroCartao, codigoCartao;
	private ArrayList<Pedido> pedidos;

	public Cliente() {
		super();
		this.pedidos = new ArrayList<>();
	}

	public Cliente(String cpf, String rua, String bairro, String cidade, String numero, String complemento, String cep,
			String telefone, String numeroCartao, String codigoCartao, ArrayList<Pedido> pedidos) {
		super();
		this.cpf = cpf;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.telefone = telefone;
		this.numeroCartao = numeroCartao;
		this.codigoCartao = codigoCartao;
		this.pedidos = pedidos;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getCodigoCartao() {
		return codigoCartao;
	}

	public void setCodigoCartao(String codigoCartao) {
		this.codigoCartao = codigoCartao;
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Cliente cliente = (Cliente) o;

		if (cpf != null ? !cpf.equals(cliente.cpf) : cliente.cpf != null)
			return false;
		if (rua != null ? !rua.equals(cliente.rua) : cliente.rua != null)
			return false;
		if (bairro != null ? !bairro.equals(cliente.bairro) : cliente.bairro != null)
			return false;
		if (cidade != null ? !cidade.equals(cliente.cidade) : cliente.cidade != null)
			return false;
		if (numero != null ? !numero.equals(cliente.numero) : cliente.numero != null)
			return false;
		if (complemento != null ? !complemento.equals(cliente.complemento) : cliente.complemento != null)
			return false;
		if (cep != null ? !cep.equals(cliente.cep) : cliente.cep != null)
			return false;
		if (telefone != null ? !telefone.equals(cliente.telefone) : cliente.telefone != null)
			return false;
		if (numeroCartao != null ? !numeroCartao.equals(cliente.numeroCartao) : cliente.numeroCartao != null)
			return false;
		if (codigoCartao != null ? !codigoCartao.equals(cliente.codigoCartao) : cliente.codigoCartao != null)
			return false;
		return pedidos != null ? pedidos.equals(cliente.pedidos) : cliente.pedidos == null;
	}

	@Override
	public int hashCode() {
		int result = cpf != null ? cpf.hashCode() : 0;
		result = 31 * result + (rua != null ? rua.hashCode() : 0);
		result = 31 * result + (bairro != null ? bairro.hashCode() : 0);
		result = 31 * result + (cidade != null ? cidade.hashCode() : 0);
		result = 31 * result + (numero != null ? numero.hashCode() : 0);
		result = 31 * result + (complemento != null ? complemento.hashCode() : 0);
		result = 31 * result + (cep != null ? cep.hashCode() : 0);
		result = 31 * result + (telefone != null ? telefone.hashCode() : 0);
		result = 31 * result + (pedidos != null ? pedidos.hashCode() : 0);
		result = 31 * result + (numeroCartao != null ? numeroCartao.hashCode() : 0);
		result = 31 * result + (codigoCartao != null ? codigoCartao.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Cliente {" + "cpf='" + cpf + '\'' + ", rua='" + rua + '\'' + ", bairro='" + bairro + '\'' + ", cidade='"
				+ cidade + '\'' + ", numero='" + numero + '\'' + ", complemento='" + complemento + '\'' + ", cep='"
				+ cep + '\'' + ", telefone='" + telefone + '\'' + ", pedidos=" + pedidos + '}';
	}
}