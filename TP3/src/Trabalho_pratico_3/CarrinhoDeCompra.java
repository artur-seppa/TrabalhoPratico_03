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
	
	
	//o construtor inicia o array list 
	public CarrinhoDeCompra() {
		produtos = new ArrayList<Produto>();
	}

	//permite adicionar produtos associados ao carrinho
	public void adicionarProduto(Produto produto) {
		produtos.add(produto);
	}
			
	//retorna a qauntidade de produtos do carrinho
	public int quantidadeProdutos() {
		return produtos.size();
	}
			
	//exclui o produto associado ao carrinho
	public void excluirProduto(Produto produto) {
		produtos.remove(produto);
	}	
}
