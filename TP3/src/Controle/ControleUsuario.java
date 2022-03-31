package Controle;
import java.util.Date;

import Modelo.*;

public class ControleUsuario {
	//instancia o objeto array "pessoa" de Pessoa com tamanho de 100.
	private Pessoa pessoa[] = new Pessoa[100]; 
	private Telefone telefone;
	private Endereco endereco; 
	
<<<<<<< HEAD
	//Produtos
	private Produto produto[] = new Produto[100]; 
	private Roupa roupa[] = new Roupa[100]; 
	private Acessorio acessorio[] = new Acessorio[100]; 
	private Sapato sapato[] = new Sapato[100];
	
	//quantidade inicial
	private int qtdPessoas = 0;
	private int qtdRoupas = 0;
	
	/*
	 * Contrutor de usuarios, 
	 * sendo iniciado com a criacao de 3 user
	 */
	public ControleUsuario() {
		for(int i=0; i<3; i++) {
			pessoa[i] = new Pessoa();
			pessoa[i].setNome("user"+i);
			pessoa[i].setSenha("123"+i);
			
			roupa[i] = new Roupa();
			roupa[i].setCategoria("roupa");
			roupa[i].setDescricao("camiseta"+i);
			
			//ASSOCIA O NOME DA PESSOA AO PRODUTO
			roupa[i].setPessoa(pessoa[i]);
			
			//ASSOCIA O PRODUTO A PESSOA
			pessoa[i].adicionarProduto(roupa[i]);
		}
		
		qtdPessoas = 3;
		qtdRoupas = 3;
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
	
	
	public String getNome(int i) {		
		return pessoa[i].getNome();
	}
	
	public int getQtdPessoas() {
		return qtdPessoas;
	}
	
	public Pessoa[] retornaStringPessoa() {		
		return pessoa;
	}
	
	
	
	public boolean cadastrarUsuario(String nome, /*String sexo,*/ String senha/*, String email, String cpf, 
	int ddd, int telefone, 
	String estado, String cidade, String endereco*/) {
		
		if(nome != null && nome.length()>0 && /*sexo != null && sexo.length()>0 &&*/ senha!= null && senha.length()>0 /*&& email != null && email.length()>0 && cpf != null && cpf.length()>0
		   && ddd>0 && telefone>0
		   && estado != null && estado.length()>0 && cidade != null && cidade.length()>0 && endereco != null && endereco.length() > 0*/){
			
			/*
			 *	Um novo usuario eh cadastrado com as informacoes passadas pela view
			 *	de cadastro 
			 */
			pessoa[qtdPessoas] = new Pessoa();
			pessoa[qtdPessoas].setNome(nome);
			pessoa[qtdPessoas].setSenha(senha);
			
			//incrementa o numero de usuarios totais
			qtdPessoas++;
			
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
	
	public boolean logarUsuario( String nome, String senha) {
		
		//procura pelo mesmo nome e senha nos usuarios cadastrados
		for(int i = 0; i <qtdPessoas; i++) {
			if(nome.equals(pessoa[i].getNome()) ) {
				if(senha.equals(pessoa[i].getSenha()) ) {
					return true;
				}
			}
		}
		//caso nao encontre o nome e nem a senha retorna false
		return false;
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
=======
	//quantidade inicial de usuarios
	private int qtdPessoas = 3;
	
	/*
	 * Contrutor de usuarios, 
	 * sendo iniciado com a criacao de 3 user
	 */
	public ControleUsuario() {
		for(int i=0; i<=2; i++) {
			pessoa[i] = new Pessoa();
			pessoa[i].setNome("user"+i);
			pessoa[i].setSenha("123"+i);
		}
	}
	
	public Pessoa[] getUsuarios() {
		return pessoa;
	}
	
	
	/*
	 * PEGA TODOS OS NOMES DE USUARIOS E PASSA PARA totalP
	 */
	
	public String[] escreveUsuarios() {
		String[] totalP = new String[qtdPessoas];
		
		for(int i = 0; i < qtdPessoas; i++) {
			totalP[i] = pessoa[i].getNome();
		}
		
		return totalP;
	}
	
	
	public boolean cadastrarUsuario(String nome, /*String sexo,*/ String senha/*, String email, String cpf, 
	int ddd, int telefone, 
	String estado, String cidade, String endereco*/) {
		
		if(nome != null && nome.length()>0 && /*sexo != null && sexo.length()>0 &&*/ senha!= null && senha.length()>0 /*&& email != null && email.length()>0 && cpf != null && cpf.length()>0
		   && ddd>0 && telefone>0
		   && estado != null && estado.length()>0 && cidade != null && cidade.length()>0 && endereco != null && endereco.length() > 0*/){
			
			/*
			 *	Um novo usuario eh cadastrado com as informacoes passadas pela view
			 *	de cadastro 
			 */
			pessoa[qtdPessoas] = new Pessoa();
			pessoa[qtdPessoas].setNome(nome);
			pessoa[qtdPessoas].setSenha(senha);
			
			//incrementa o numero de usuarios totais
			qtdPessoas = qtdPessoas + 1;
			
			return true;
		
		}
		return false;
	}
	
	public boolean logarUsuario( String nome, String senha) {
		
		//procura pelo mesmo nome e senha nos usuarios cadastrados
		for(int i = 0; i <qtdPessoas; i++) {
			if(nome.equals(pessoa[i].getNome()) ) {
				if(senha.equals(pessoa[i].getSenha()) ) {
					return true;
				}
			}
		}
		//caso nao encontre o nome e nem a senha retorna false
		return false;
>>>>>>> branch 'modAmanda' of https://github.com/artur-seppa/TrabalhoPratico_03.git
	}
	
}

