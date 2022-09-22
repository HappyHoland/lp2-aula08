package br.ufrn.imd.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Produto {
	
	private String nome;
	private double preco;
	private String marca;
	private String descricao;
	private LocalDate dataFabricacao;
	
	public Produto() {}
	
	public Produto(String nome, double preco, String marca, String descricao, LocalDate dataFabricacao) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.marca = marca;
		this.descricao = descricao;
		this.dataFabricacao = dataFabricacao;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDate getDataFabricacao() {
		return dataFabricacao;
	}
	public void setDataFabricacao(LocalDate dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}
	
	@Override
	public String toString() {
		return "Nome: " + nome + " - Marca: " + marca + " - Preço: " + preco + " - Descrição: " + descricao + " - Data de Fabricação: " + dataFabricacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(nome, other.nome);
	}
	
}