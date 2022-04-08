package Modelo;

import java.util.ArrayList;


public class Pessoa {
	/**
	 * Possui atributos com apenas dados pessoais, alem de gets, sets, e
	 * construtores.
	 * 
	 * @author Arthur Seppa Reiman
	 * @author Amanda Fernandes Custodio
	 */
		
		private String nome;
		private String senha; 
		private int id;
		
		private Telefone telefone;
		private Endereco endereco; 
		
		private ArrayList<Produto> produtos;
		
		/*
		 * o construtor inicia o array list 
		 */
		public Pessoa() {
			produtos = new ArrayList<Produto>();
		}

		/*
		 * permite adicionar produtos associados a pessoa
		 */
		public void adicionarProduto(Produto produto) {
			produtos.add(produto);
		}
		
		/*
		 * retorna a qauntidade de produtos dessa pessoa
		 */
		public int quantidadeProdutos() {
			return produtos.size();
		}
		
		/*
		 * exclui o produto associado a pessoa
		 */
		public void excluirProduto(Produto produto) {
			produtos.remove(produto);
		}
		
		/*
		 * pega a posiçao de onde o produto se encontra
		 */
		public Produto getProduto(int qtdsapatosusuario) {
			return produtos.get(qtdsapatosusuario);
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		
		/*======getter e setter dos objetos especiais=======*/

		public Telefone getTelefone() {
			return telefone;
		}

		public void setTelefone(Telefone telefone) {
			this.telefone = telefone;
		}

		public Endereco getEndereco() {
			return endereco;
		}

		public void setEndereco(Endereco endereco) {
			this.endereco = endereco;
		}

		public static Object verificarPessoa(String string) {
			return null;
		}

		public Produto getProduto(String qtdsapatosusuario) {
			return null;
		}
		
}
