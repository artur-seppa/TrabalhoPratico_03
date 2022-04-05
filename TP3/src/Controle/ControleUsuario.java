package Controle;
import java.util.Date;

import Modelo.*;

public class ControleUsuario {
	//instancia o objeto array "pessoa" de Pessoa com tamanho de 100.
	private Pessoa pessoa[] = new Pessoa[100]; 
	private Telefone tel[] = new Telefone[100];
	private Endereco endereco[] = new Endereco[100]; 
	
	//Produtos
	private Produto produto[] = new Produto[100]; 
	private Roupa roupa[] = new Roupa[100]; 
	private Acessorio acessorio[] = new Acessorio[100]; 
	private Sapato sapato[] = new Sapato[100];
	
	//Carrinho e Favoritos
	private CarrinhoDeCompra carrinho[] = new CarrinhoDeCompra[100];
	private RoupaFavorita favorito[] = new RoupaFavorita[100];
	
	//quantidade inicial
	private int qtdPessoas = 0;
	private int qtdRoupas = 0;
	private int qtdID = 0;
	
	/*
	 * Contrutor de usuarios, 
	 * sendo iniciado com a criacao de 3 user
	 */
	public ControleUsuario() {
		for(int i=0; i<3; i++) {
			pessoa[i] = new Pessoa();
			pessoa[i].setNome("user"+i);
			pessoa[i].setSenha("123"+i);
			pessoa[i].setId(i);
			
			tel[i] = new Telefone();
			tel[i].setDdd(061);
			tel[i].setTelefone(912345678);
			
			endereco[i] = new Endereco();
			endereco[i].setEstado("DF");
			endereco[i].setCidade("Brasilia");
			endereco[i].setBairro("Aguas Claras");
			endereco[i].setEndereco("Residencial BlaBla " + i);
			endereco[i].setCep(1234567*(i+1));
			
			roupa[i] = new Roupa();
			roupa[i].setCategoria("roupa");
			roupa[i].setDescricao("camiseta"+i);
			roupa[i].setCor("vermelha");
			roupa[i].setEstilo("formal");
			roupa[i].setTecido("algodao");
			roupa[i].setTamanho("p");
			roupa[i].setGenero("masculino");
			roupa[i].setPreco(i+1.99f);
			
			//ASSOCIA O NOME DA PESSOA AO PRODUTO
			roupa[i].setPessoa(pessoa[i]);
			
			//ASSOCIA O PRODUTO A PESSOA
			pessoa[i].adicionarProduto(roupa[i]);
			
			//ASSOCIA O NOME DA PESSOA AO TELEFONE
			tel[i].setPessoa(pessoa[i]);
			
			//ASSOCIA O NOME DA PESSOA AO ENDERECO
			endereco[i].setPessoa(pessoa[i]);
			
			//ASSOCIA O PRODUTO AO CARRINHO E A LISTA DE FAVORITOS
			carrinho[i] = new CarrinhoDeCompra();
			carrinho[i].adicionarProduto(roupa[i]);
			
			favorito[i] = new RoupaFavorita();
			favorito[i].adicionarProduto(roupa[i]);
		}
		
		qtdPessoas = 3;
		qtdRoupas = 3;
		qtdID = 3;
	}
	
	
	/*
	 * PEGA TODOS OS NOMES DE USUARIOS E PASSA PARA totalP
	 */
	
	
	public String[] escreveUsuarios() {
		
		String[] totalP = new String[qtdPessoas];
		
		for(int i = 0; i < qtdPessoas /*qtdPessoas*/; i++) {
			totalP[i] = pessoa[i].getNome();
		}
		
		return totalP;
	}
	
	/***********PESSOA***********/
	
	public String getNome(int i) {		
		return pessoa[i].getNome();
	}
	
	public String getSenha(int i) {		
		return pessoa[i].getSenha();
	}
	
	public int getQtdPessoas() {
		return qtdPessoas;
	}
	
	public Pessoa[] retornaStringPessoa() {		
		return pessoa;
	}
	
	/***********PESSOA***********/
	
	public int getDDD(int i) {		
		return tel[i].getDdd();
	}
	
	public int getTelefone(int i) {		
		return tel[i].getTelefone();
	}
	
	/***********ENDERECO***********/
	
	public int getCep(int i) {		
		return endereco[i].getCep();
	}
	
	public String getEndereco(int i) {		
		return endereco[i].getEndereco();
	}
	
	public String getEstado(int i) {		
		return endereco[i].getEstado();
	}
	
	public String getCidade(int i) {		
		return endereco[i].getCidade();
	}
	
	public String getBairro(int i) {		
		return endereco[i].getBairro();
	}
	
	public boolean cadastrarUsuario(String nome, /*String sexo,*/ String senha/*, String email, String cpf*/, 
	int ddd, int telefone, 
	String estado, String cidade, String bairro, String adress, int cep) {
		
		if(nome != null && nome.length()>0 && /*sexo != null && sexo.length()>0 &&*/ senha!= null && senha.length()>0 /*&& email != null && email.length()>0 && cpf != null && cpf.length()>0*/
		   && ddd>0 && telefone>0
		   && estado != null && estado.length()>0 && cidade != null && cidade.length()>0 && bairro != null && bairro.length()>0 && adress != null && adress.length() > 0 && cep>0){
			
			/*
			 *	Um novo usuario eh cadastrado com as informacoes passadas pela view
			 *	de cadastro 
			 */
			pessoa[qtdPessoas] = new Pessoa();
			pessoa[qtdPessoas].setNome(nome);
			pessoa[qtdPessoas].setSenha(senha);
			pessoa[qtdPessoas].setId(qtdID);
			
			tel[qtdPessoas] = new Telefone();
			tel[qtdPessoas].setDdd(ddd);
			tel[qtdPessoas].setTelefone(telefone);
			
			//ASSOCIA O NOME DA PESSOA AO TELEFONE
			tel[qtdPessoas].setPessoa(pessoa[qtdPessoas]);
			
			endereco[qtdPessoas] = new Endereco();
			endereco[qtdPessoas].setBairro(bairro);
			endereco[qtdPessoas].setCep(cep);
			endereco[qtdPessoas].setCidade(cidade);
			endereco[qtdPessoas].setEstado(estado);
			endereco[qtdPessoas].setEndereco(adress);
			
			//ASSOCIA O NOME DA PESSOA AO ENDERECO
			endereco[qtdPessoas].setPessoa(pessoa[qtdPessoas]);

			carrinho[qtdPessoas] = new CarrinhoDeCompra();
			favorito[qtdPessoas] = new RoupaFavorita();
			
			//incrementa o numero de usuarios totais
			qtdPessoas++;
			qtdID++;
			
			return true;
		
		}
		
		//procura pelo mesmo nome e senha nos usuarios cadastrados
//				for(int i = 0; i <qtdPessoas; i++) {
//					if(nome.equals(pessoa[i].getNome()) ) {
//						if(senha.equals(pessoa[i].getSenha()) ) {
//							return false;
//						}
//					}
//				}
		
		return false;
	}
	
	public int logarUsuario( String nome, String senha) {
		
		//procura pelo mesmo nome e senha nos usuarios cadastrados
		for(int i = 0; i <qtdPessoas; i++) {
			if(nome.equals(pessoa[i].getNome()) ) {
				if(senha.equals(pessoa[i].getSenha()) ) {
					return pessoa[i].getId();
				}
			}
		}
		//caso nao encontre o nome e nem a senha retorna false
		return -1;
	}
	
	public int DeletarUsuario(String nome, String senha) {
		
		//procura pelo mesmo nome e senha nos usuarios cadastrados
		for(int i = 0; i <qtdPessoas; i++) {
			if(nome.equals(pessoa[i].getNome()) ) {
				if(senha.equals(pessoa[i].getSenha()) ) {
					
//					for(int i)
					
				}
			}
		}
		
		//caso nao encontre o nome e nem a senha retorna false
		return -1;
	}
	
	/*==========================PRODUTOS===============================*/
	
	public String[] escreveProdutos() {
		
		String[] totalR = new String[qtdRoupas];
		
		for(int i = 0; i < qtdRoupas; i++) {
			totalR[i] = roupa[i].getDescricao();
		}
		
		return totalR;
	}
	
	public int getQtdRoupas() {
		return qtdRoupas;
	}
	
	/*
	 * return da Peça 
	 * */
	public Roupa getRoupa(int i) {
		return roupa[i];
	}
	
	/*==========================CARRINHO===============================*/
	
	//int i associado ao id do usuario e int r associado ao id da roupa
	public void AdicionarCompra(int i, int r) {	
		carrinho[i].adicionarProduto(roupa[r]);
	}
	
	public int QtdProduto(int i) {
		return carrinho[i].quantidadeProdutos();
	}
	
	public String[] escreveProdutosCarrinho(int qtd, int r) {
		String[] roupa = new String[qtd];
		
		for(int i = 0; i < qtd; i++) {
			roupa[i] = carrinho[r].getProduto(i).getDescricao();
		}
		
		return roupa;
	}
	
	public void RemoveTodosCarrinho(int qtd, int r) {
		
		for(int i = qtd; i >= 0; i--) {
			carrinho[r].excluirProduto(roupa[i]);
		}
	}
	
	public void RemoveProdutoCarrinho(int c, int i) {
		carrinho[c].excluirProduto(roupa[i]);
	}
	
	public String getProdutoCarrinho(int c, int i) {
		return carrinho[c].getProduto(i).getDescricao();
	}
	
	public float getProdutoValor(int c, int i) {
		return carrinho[c].getProduto(i).getPreco();
	}
	
/*==========================LISTA DE FAVORITOS===============================*/
	
	//int i associado ao id do usuario e int r associado ao id da roupa
	public void AdicionarFavorito(int i, int r) {	
		favorito[i].adicionarProduto(roupa[r]);
	}
	
	public int QtdProdutoFavorito(int i) {
		return favorito[i].quantidadeProdutos();
	}
	
//	public String[] escreveProdutosFavoritos(int qtd, int r) {
//		String[] roupa = new String[qtd];
//		
//		for(int i = 0; i < qtd; i++) {
//			roupa[i] = favorito[r].getProduto(i).getDescricao();
//		}
//		
//		return roupa;
//	}
	
	public void RemoveTodosFavoritos(int qtd, int r) {
		
		for(int i = qtd+1; i >= 0; i--) {
			favorito[r].excluirProduto(roupa[i]);
		}
	}
	
	public void RemoveProdutoFavorito(int c, int i) {
		favorito[c].excluirProduto(roupa[i]);
	}
	
	public String getProdutoFavorito(int c, int i) {
		return favorito[c].getProduto(i).getDescricao();
	}
	
}

