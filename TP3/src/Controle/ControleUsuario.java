package Controle;
import java.util.Date;

import Modelo.*;

public class ControleUsuario {
	//instancia o objeto array "pessoa" de Pessoa com tamanho de 100.
	private Pessoa pessoa[] = new Pessoa[100]; 
	private Telefone telefone;
	private Endereco endereco; 
	
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
	}
	
}

