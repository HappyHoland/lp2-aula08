package br.ufrn.imd.domain;

import java.time.LocalDate;

/**
 * Subclasse de produtos para produtos não duráveis
 * @author felipe.holanda.119
 *
 */
public class ProdutoNaoDuravel extends Produto {
	private LocalDate dataValidade;
	private String genero;
	
	//Construtores
	public ProdutoNaoDuravel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ProdutoNaoDuravel(String nome, double preco, String marca, String descricao, LocalDate dataFabricacao, LocalDate dataValidade, String genero) {
		super(nome, preco, marca, descricao, dataFabricacao);
		this.dataValidade = dataValidade;
		this.genero = genero;
		// TODO Auto-generated constructor stub
	}
	
	//Getters e Setters
	public LocalDate getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	//toString
	@Override
	public String toString() {
		return super.toString() + " - Data de Validade: " + dataValidade + " - Gênero: " + genero;
	}

}
