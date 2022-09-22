package br.ufrn.imd.domain;

import java.util.ArrayList;

/**
 * Classe depósito container de produtos
 * @author felipe.holanda.119
 *
 */
public class Deposito {
	private ArrayList<Produto> deposito;
	
	//Construtor
	public Deposito() {
		deposito = new ArrayList<Produto>();
	}
	
	/**
	 * Adiciona um produto no container deposito
	 * @param p - o produto adicionado
	 */
	public void adicionarProduto(Produto p) {
		if (p != null && !deposito.contains(p))
		deposito.add(p);
	}
	
	/**
	 * Remove um produto no container deposito
	 * @param p
	 */
	public void removerProduto(Produto p) {
		if (p != null && deposito.contains(p))
		deposito.remove(p);
	}
	
	/**
	 * Informa a quantidade de produtos no depósito
	 * @return int
	 */
	public int quantidadeProdutos() {
		return deposito.size();
	}
	
	/**
	 * Informa se o depósito contém um produto
	 * @param p - o produto a ser verificado
	 * @return
	 */
	public boolean contem(Produto p) {
		return deposito.contains(p);
	}
	
	/**
	 * Informa se o depósito está vazio
	 * @return
	 */
	public boolean estaVazio() {
		return deposito.isEmpty();
	}
	
	/**
	 * Informa o produto mais caro
	 * @return o produto de maior preço
	 */
	public Produto maisCaro() {
		Produto res = new Produto();
		res.setPreco(0);
		
		for (Produto p : deposito) {
			if (p.getPreco() > res.getPreco()) {
				res = p;
			}
		}
		
		return res;
	}
	
	/**
	 * Imprime produtos no System.out (mudar para retornar container)
	 */
	public void listarProdutos() {
		for (Produto p : deposito) {
			System.out.println(p);
		}
	}
}
