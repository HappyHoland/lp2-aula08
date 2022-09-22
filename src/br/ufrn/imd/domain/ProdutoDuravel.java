package br.ufrn.imd.domain;

import java.time.LocalDate;

public class ProdutoDuravel extends Produto {
	private int durabilidade;
	
	public ProdutoDuravel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProdutoDuravel(String nome, double preco, String marca, String descricao, LocalDate dataFabricacao, int durabilidade) {
		super(nome, preco, marca, descricao, dataFabricacao);
		this.durabilidade = durabilidade;
		// TODO Auto-generated constructor stub
	}

	public int getDurabilidade() {
		return durabilidade;
	}

	public void setDurabilidade(int durabilidade) {
		this.durabilidade = durabilidade;
	}
	
	@Override
	public String toString() {
		return super.toString() + " - Durabilidade: " + durabilidade + " anos";
	}

}
