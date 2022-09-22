package br.ufrn.imd.domain;

import java.util.ArrayList;

public class Deposito {
	private ArrayList<Produto> deposito;
	
	public Deposito() {
		deposito = new ArrayList<Produto>();
	}
	
	public void adicionarProduto(Produto p) {
		deposito.add(p);
	}
	
	public void removerProduto(Produto p) {
		deposito.remove(p);
	}
	
	public int quantidadeProdutos() {
		return deposito.size();
	}
	
	public boolean contem(Produto p) {
		return deposito.contains(p);
	}
	
	public boolean estaVazio() {
		return deposito.isEmpty();
	}
	
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
	
	public void listarProdutos() {
		for (Produto p : deposito) {
			System.out.println(p);
		}
	}
}
