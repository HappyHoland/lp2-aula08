package br.ufrn.imd.main;

import java.time.LocalDate;
import java.util.Scanner;

import br.ufrn.imd.domain.Deposito;
import br.ufrn.imd.domain.ProdutoDuravel;
import br.ufrn.imd.domain.ProdutoNaoDuravel;

public class LojaView {
	
	static ProdutoDuravel pd1 = new ProdutoDuravel("O Castelo Animado", 40.00, "Editora", "livro", LocalDate.of(2000, 9, 1), 40);
	static ProdutoDuravel pd2 = new ProdutoDuravel("Gela 4000", 4000.00, "Brastemp", "geladeira", LocalDate.of(2018, 12,28), 10);
	static ProdutoDuravel pd3 = new ProdutoDuravel("Ipad 2 pro", 3500.00, "Apple", "tablet", LocalDate.of(2015, 1, 30), 5);
	static ProdutoNaoDuravel pnd1 = new ProdutoNaoDuravel("Uva Vitória", 15.00, "Nordestão", "pacote de uvas de 30g", LocalDate.now().minusMonths(1), LocalDate.now().plusMonths(2), "Alimentício");
	static ProdutoNaoDuravel pnd2 = new ProdutoNaoDuravel("Rosé Aromaterapia", 125.00, "Natura", "shampoo", LocalDate.now().minusMonths(2), LocalDate.now().plusMonths(8), "Higiene");
	static ProdutoNaoDuravel pnd3 = new ProdutoNaoDuravel("Colgate Sensitive plus", 15.00, "Colgate", "pasta de dentes", LocalDate.now().minusMonths(1), LocalDate.now().plusMonths(4), "Higiene");
	
	public static void main(String[] args) {
		
		Deposito deposito = new Deposito();
		boolean end = false;
		int opcao;
		Scanner sc = new Scanner(System.in);
		
		deposito.adicionarProduto(pd1);
		deposito.adicionarProduto(pd2);
		deposito.adicionarProduto(pd3);
		deposito.adicionarProduto(pnd1);
		deposito.adicionarProduto(pnd2);
		deposito.adicionarProduto(pnd3);
		
		try {
			
			//loop para rodar o programa
			while (!end) {
				
				do {
					System.out.println("Escolha uma opção: ");
					System.out.println("1 - Adicionar um produto ");
					System.out.println("2 - Remover um produto");
					System.out.println("3 - Listar produtos");
					System.out.println("0 - Sair");
					
					opcao = Integer.parseInt(sc.nextLine());
				} while (opcao > 3 || opcao < 0);
				
				switch (opcao) {
					case 1:
						do {
							System.out.println("O produto é do tipo durável?");
							System.out.println("1 - Sim");
							System.out.println("2 - Não");
							System.out.println("0 - Voltar");
							
							opcao = Integer.parseInt(sc.nextLine());
						} while (opcao > 2 || opcao < 1);
						
						switch (opcao) {
							case 1: 
								ProdutoDuravel pd = new ProdutoDuravel();
								
								System.out.println("Informe o nome do produto:");
								pd.setNome(sc.nextLine());
								
								System.out.println("Informe o preço do produto:");
								pd.setPreco(Double.parseDouble(sc.nextLine()));
								
								System.out.println("Informe a marca do produto:");
								pd.setMarca(sc.nextLine());
								
								System.out.println("Adicione uma descrição:");
								pd.setDescricao(sc.nextLine());
								
								System.out.println("Informe a data de fabricação (yyyy-mm-dd):");
								pd.setDataFabricacao(LocalDate.parse(sc.nextLine()));
								
								System.out.println("Informe a durabilidade:");
								pd.setDurabilidade(Integer.parseInt(sc.nextLine()));
								
								deposito.adicionarProduto(pd);
								
								System.out.println(pd.getNome() + " adiconado ao depósito.");
								
								break;
								
							case 2:
								ProdutoNaoDuravel pnd = new ProdutoNaoDuravel();
								
								System.out.println("Informe o nome do produto:");
								pnd.setNome(sc.nextLine());
								
								System.out.println("Informe o preço do produto:");
								pnd.setPreco(Double.parseDouble(sc.nextLine()));
								
								System.out.println("Informe a marca do produto:");
								pnd.setMarca(sc.nextLine());
								
								System.out.println("Adicione uma descrição:");
								pnd.setDescricao(sc.nextLine());
								
								System.out.println("Informe a data de fabricação (yyyy-mm-dd):");
								pnd.setDataFabricacao(LocalDate.parse(sc.nextLine()));
								
								System.out.println("Informe a data de validade (yyyy-mm-dd):");
								pnd.setDataValidade(LocalDate.parse(sc.nextLine()));
								
								System.out.println("Informe o gênero do produto:");
								pnd.setGenero(sc.nextLine());
								
								deposito.adicionarProduto(pnd);
								
								System.out.println(pnd.getNome() + " adiconado ao depósito.");
								
								break;
								
							default:
								break;
						}
						
						break;
						
					case 2:	
						String nome;
						int duravel;
						ProdutoDuravel p1 = new ProdutoDuravel();
						ProdutoNaoDuravel p2 = new ProdutoNaoDuravel();
						
						System.out.println("Informe o nome do produto:");
						nome = sc.nextLine();
						
						System.out.println("O produto é durável?");
						System.out.println("1 - Sim");
						System.out.println("0 - Não");
						
						duravel = Integer.parseInt(sc.nextLine());
						
						switch (duravel) {
							case 1:
								p1.setNome(nome);
							
								if (deposito.contem(p1)) {
								
									deposito.removerProduto(p1);
								
									System.out.println("Produto " + p1.getNome() + " removido.");
								
								} else {
								
									System.out.println("Produto " + p1.getNome() + " não encontrado no depósito.");
								}
							
								break;
							
							default:
								p2.setNome(nome);
								
								if (deposito.contem(p2)) {
								
									deposito.removerProduto(p2);
								
									System.out.println("Produto " + p2.getNome() + " removido.");
								
								} else {
								
									System.out.println("Produto " + p2.getNome() + " não encontrado no depósito.");
								}
							
								break;
						}
						
						break;
						
					case 3:
						
						if (!deposito.estaVazio()) {
							
							deposito.listarProdutos();
							
						} else {
							
						
							System.out.println("Depósito vazio.");
						}
						
						break;
						
					default:
						end = true;
						
						break;
				}
				
				System.out.println();
			}
		} finally {
			sc.close();
		}

	}
	

}
