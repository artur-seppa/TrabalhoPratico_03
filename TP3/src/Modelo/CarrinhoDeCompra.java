package Modelo;

import java.util.ArrayList;

public class CarrinhoDeCompra {
	/*
	 * relacionado ao produto
	 * 
	* @author Arthur Seppa Reiman
	* @author Amanda Fernandes Custodio 
	 */
	private ArrayList<Produto> produtos;
	
	
	/*
	 * o construtor inicia o array list 
	 */
	public CarrinhoDeCompra() {
		produtos = new ArrayList<Produto>();
	}

	/*
	 * permite adicionar produtos associados ao carrinho
	 */
	public void adicionarProduto(Produto produto) {
		produtos.add(produto);
	}
			
	/*
	 * retorna a quantidade de produtos do carrinho
	 */
	public int quantidadeProdutos() {
		return produtos.size();
	}
			
	/*
	 * exclui o produto associado ao carrinho
	 */
	public void excluirProduto(Produto produto) {
		produtos.remove(produto);
	}
	
	/*
	 * pega a posiçao de onde o produto se encontra
	 */
	public Produto getProduto(int posicao) {
		return produtos.get(posicao);
	}
	
}
