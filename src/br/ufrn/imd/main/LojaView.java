package br.ufrn.imd.main;

import java.time.LocalDate;
import java.util.Scanner;

import br.ufrn.imd.domain.Deposito;
import br.ufrn.imd.domain.ProdutoDuravel;
import br.ufrn.imd.domain.ProdutoNaoDuravel;

public class LojaView {
	
	//produtos ja pertencentes ao deposito
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
		
		//adicionando produtos iniciais
		deposito.adicionarProduto(pd1);
		deposito.adicionarProduto(pd2);
		deposito.adicionarProduto(pd3);
		deposito.adicionarProduto(pnd1);
		deposito.adicionarProduto(pnd2);
		deposito.adicionarProduto(pnd3);
		
		try {
			
			//loop para rodar o programa
			while (!end) {
				
				//loop de interface
				do {
					
					System.out.println("Escolha uma opção: ");
					System.out.println("1 - Adicionar um produto ");
					System.out.println("2 - Remover um produto");
					System.out.println("3 - Listar produtos");
					System.out.println("0 - Sair");
					
					opcao = Integer.parseInt(sc.nextLine());
				} while (opcao > 3 || opcao < 0);
				
				//processamento de decisao
				switch (opcao) {
					//Caso 1 - adicionar um produto
					case 1:
						//loop de interface - saber se o produto eh duravel ou nao para usar o equals
						do {
							System.out.println("O produto é do tipo durável?");
							System.out.println("1 - Sim");
							System.out.println("2 - Não");
							System.out.println("0 - Voltar");
							
							opcao = Integer.parseInt(sc.nextLine());
						} while (opcao > 2 || opcao < 1);
						
						//processamento da escolha
						switch (opcao) {
							//Produto duravel
							case 1: 
								//Inicializando um produto duravel
								ProdutoDuravel pd = new ProdutoDuravel();
								
								//Pedindo informacoes do produto a ser adicionado
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
								
								//Verifica se foi possivel adicionar
								if (deposito.adicionarProduto(pd)) {
									//Se foi adicionado - informa ao usuario
									System.out.println(pd.getNome() + " adiconado ao depósito.");
									
								}	else {
									//No caso de produto ser null ou ja estar no deposito
									System.out.println("Produto invalido ou ja cadastrado");
								}
								
								break;
							
							//Produto nao duravel
							case 2:
								//Inicializando um novo produto nao duravel
								ProdutoNaoDuravel pnd = new ProdutoNaoDuravel();
								
								//Pedindo informacoes do produto a ser adicionado
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
								
								//Verifica se foi possivel adicionar o produto
								if (deposito.adicionarProduto(pnd)) {
									//Informa sucesso caso possivel
									System.out.println(pnd.getNome() + " adiconado ao depósito.");
								
								} else {
									//Caso produto seja null ou ja presente no deposito, informar erro
									System.out.println("Produto invalido ou ja cadastrado");
								}
								
								break;
							
							//Caso voltar, nada
							default:
								break;
						}
						
						break;
					
					//Remover um produto
					case 2:	
						String nome;
						int duravel;
						ProdutoDuravel p1 = new ProdutoDuravel();
						ProdutoNaoDuravel p2 = new ProdutoNaoDuravel();
						
						//Pedindo nome e tipo do produto
						System.out.println("Informe o nome do produto:");
						nome = sc.nextLine();
						
						System.out.println("O produto é durável?");
						System.out.println("1 - Sim");
						System.out.println("0 - Não");
						
						duravel = Integer.parseInt(sc.nextLine());
						
						//processamento de opcoes
						switch (duravel) {
							//Caso duravel
							case 1:
								//inicializando o produto duravel com o nome
								p1.setNome(nome);
							
								//Verificando se possivel remover produto
								if (deposito.removerProduto(p1)) {
									
									//Se removido, informa ao usuario
									System.out.println("Produto " + p1.getNome() + " removido do depósito.");
								
								} else {
									//Caso produto == null ou produto nao contido no deposito, informar erro
									System.out.println("Produto " + p1.getNome() + " invalido ou não encontrado.");
								}
							
								break;
							
							//Caso nao duravel
							default:
								//inicializando um produto nao duravel
								p2.setNome(nome);
								
								//Verificando a possibilidade de remover o produto
								if (deposito.removerProduto(p2)) {
									
									//Caso sucesso, informar ao usuario
									System.out.println("Produto " + p2.getNome() + " removido.");
								
								} else {
									//caso produto == null ou nao encontrado o deposito, informar erro
									System.out.println("Produto " + p2.getNome() + " não encontrado no depósito.");
								}
							
								break;
						}
						
						break;
					
					//Listar produtos
					case 3:
						//verifica se o deposito esta vazio
						if (!deposito.estaVazio()) {
							//caso nao esteja, lista os produtos
							deposito.listarProdutos();
							
							//Informar o preco mais caro da loja
							System.out.println();
							
							System.out.println("Preco mais caro: " + String.format("%.2f", deposito.maisCaro().getPreco()));
							
						} else {
							
							//caso esteja, informa ao usuario
							System.out.println("Depósito vazio.");
						}
						
						break;
					
					//Caso sair - end recebe true;
					default:
						end = true;
						
						break;
				}
				
				System.out.println();
			}
			
		//fechando o scanner
		} finally {
			sc.close();
		}

	}
	

}
