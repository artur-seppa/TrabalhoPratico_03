package Trabalho_pratico_3;

import java.util.ArrayList;
import java.util.Date;

public class Pessoa {

	/**
	 * Possui atributos com apenas dados pessoais, alem de gets, sets, e
	 * construtores.
	 * 
	 * @author Amanda Fernandes Custodio
	 */
		
		private String nome;
		private String sexo;
		private String senha; 
		private String email;
		private String cpf;
		private Date dataNascimento;
		
		private Telefone telefone;
		private Endereco endereco; 
		
		private ArrayList<Produto> produtos;
		
		//o construtor inicia o array list 
		public Pessoa() {
			produtos = new ArrayList<Produto>();
		}

		//permite adicionar produtos associados a pessoa
		public void adicionarProduto(Produto produto) {
			produtos.add(produto);
		}
		
		//retorna a qauntidade de produtos dessa pessoa
		public int quantidadeProdutos() {
			return produtos.size();
		}
		
		//exclui o produto associado a pessoa
		public void excluirProduto(Produto produto) {
			produtos.remove(produto);
		}
		
		//pega a posiçao de onde o produto se encontra
		public Produto getProduto(int posicao) {
			return produtos.get(posicao);
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getSexo() {
			return sexo;
		}

		public void setSexo(String sexo) {
			this.sexo = sexo;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
		
		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

		public Date getDataNascimento() {
			return dataNascimento;
		}

		public void setDataNascimento(Date dataNascimento) {
			this.dataNascimento = dataNascimento;
		}
		
		//======getter e setter dos objetos especiais=======//

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
		
}
