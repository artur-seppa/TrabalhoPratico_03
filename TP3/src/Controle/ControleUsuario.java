package Controle;
import java.util.Date;

import Modelo.*;

public class ControleUsuario {
	//instancia o objeto array "pessoa" de Pessoa
	Pessoa pessoa[] = new Pessoa[100]; 
	private Telefone telefone;
	private Endereco endereco; 
	
	//quantidade inicial de usuarios
	static int qtdPessoas = 1;
	static int cont = 1;
	
	public ControleUsuario() {
		pessoa[cont] = new Pessoa();
		pessoa[cont].setNome("artur");
		pessoa[cont].setSenha("123");
	}
	
	
	/*
	 * PEGA TODOS OS NOMES DE USUARIOS E PASSA PARA totalP
	 */
	
	public String[] escreveUsuarios() {
		String[] totalP = new String[qtdPessoas];
		
		for(int i = 1; i <= qtdPessoas; i++) {
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
//			pessoa[cont] = new Pessoa();
			pessoa[cont].setNome(nome);
			pessoa[cont].setSenha(senha);
			
			//incrementa o numero do contador ao criar o usuario
			cont = cont + 1;
			
			//incrementa o numero de usuarios totais
			qtdPessoas = qtdPessoas + 1;
			
			return true;
		
		}
		return false;
	}
	
	public boolean logarUsuario(String nome, String senha) {
		
		for(int i = 1; i <= qtdPessoas; i++) {
			if(pessoa[i].getNome() == nome) {
				//if(senha == pessoa[i].getSenha()) {
					return true;
				//}
			}
		}
		//caso nao encontre o nome e nem a senha retorna false
		return false;
	}
	
}

