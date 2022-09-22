package br.ufrn.imd.domain;

import java.time.LocalDate;

/**
 * Subclasse de produtos para produtos duŕaveis
 * @author felipe.holanda.119
 *
 */
public class ProdutoDuravel extends Produto {
	private int durabilidade;
	
	//Construtores
	public ProdutoDuravel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProdutoDuravel(String nome, double preco, String marca, String descricao, LocalDate dataFabricacao, int durabilidade) {
		super(nome, preco, marca, descricao, dataFabricacao);
		this.durabilidade = durabilidade;
		// TODO Auto-generated constructor stub
	}
	
	//Getters e Setters
	public int getDurabilidade() {
		return durabilidade;
	}

	public void setDurabilidade(int durabilidade) {
		this.durabilidade = durabilidade;
	}
	
	//toString
	@Override
	public String toString() {
		return super.toString() + " - Durabilidade: " + durabilidade + " anos";
	}

}
