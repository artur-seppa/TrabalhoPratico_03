package Trabalho_pratico_3;

import java.util.ArrayList;

public class CarrinhoDeCompra {
	private float valorTotal;
	private int quantidadeItens;
	private String formaPagamento;
	private String cupomDesconto;
	//relacionado ao endereco
	private float valorFrete;
	private Endereco endereco;
	//relacionado ao produto
	private ArrayList<Produto> produtos;
	private ArrayList<Roupa> roupas;
	
	
	//o construtor inicia o array list 
	public CarrinhoDeCompra() {
		produtos = new ArrayList<Produto>();
		roupas = new ArrayList<Roupa>();
	}

	//permite adicionar produtos associados ao carrinho
	public void adicionarProduto(Produto produto) {
		produtos.add(produto);
	}
			
	//retorna a quantidade de produtos do carrinho
	public int quantidadeProdutos() {
		return produtos.size();
	}
			
	//exclui o produto associado ao carrinho
	public void excluirProduto(Produto produto) {
		produtos.remove(produto);
	}
	
	//permite adicionar produtos associados ao carrinho
		public void adicionarRoupa(Roupa roupa) {
			roupas.add(roupa);
		}
				
		//retorna a quantidade de produtos do carrinho
		public int quantidadeRoupas() {
			return roupas.size();
		}
				
		//exclui o produto associado ao carrinho
		public void excluirRoupa(Roupa roupa) {
			roupas.remove(roupa);
		}
}
