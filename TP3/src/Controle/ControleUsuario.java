package Controle;

import Modelo.*;

public class ControleUsuario {
	//instancia o objeto array "pessoa" de Pessoa com tamanho de 100.
	private Pessoa pessoa[] = new Pessoa[100]; 
	private Telefone tel[] = new Telefone[100];
	private Endereco endereco[] = new Endereco[100]; 
	
	//Produtos
	private Produto produto[] = new Produto[100]; 
	private Roupa roupa[] = new Roupa[100]; 
	
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
	
	public Pessoa[] retornaStringPessoa() {		
		return pessoa;
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
	
	public int getIdUser(int i) {
		return pessoa[i].getId();
	}
	
	/***********TELEFONE***********/
	
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
	
	
	public boolean editarUsuario(int idUser, String nome, String senha, 
			int ddd, int telefone, 
			String estado, String cidade, String bairro, String adress, int cep) {
				
				if(nome != null && nome.length()>0 && /*sexo != null && sexo.length()>0 &&*/ senha!= null && senha.length()>0 /*&& email != null && email.length()>0 && cpf != null && cpf.length()>0*/
				   && ddd>0 && telefone>0
				   && estado != null && estado.length()>0 && cidade != null && cidade.length()>0 && bairro != null && bairro.length()>0 && adress != null && adress.length() > 0 && cep>0){
					
					/*
					 *	Um novo usuario eh cadastrado com as informacoes passadas pela view
					 *	de cadastro 
					 */
					
					pessoa[idUser].setNome(nome);
					pessoa[idUser].setSenha(senha);
					
					tel[idUser].setDdd(ddd);
					tel[idUser].setTelefone(telefone);
					
					endereco[idUser].setBairro(bairro);
					endereco[idUser].setCep(cep);
					endereco[idUser].setCidade(cidade);
					endereco[idUser].setEstado(estado);
					endereco[idUser].setEndereco(adress);
					
					return true;
				
				}
				
				return false;
	}
	
	
	public int logarUsuario(String nome, String senha) {
		
		//procura pelo mesmo nome e senha nos usuarios cadastrados
		for(int i = 0; i <qtdPessoas; i++) {
			if(nome.equals(pessoa[i].getNome()) ) {
				if(senha.equals(pessoa[i].getSenha()) ) {
					//retorna o id do usuario
					return pessoa[i].getId();
				}
			}
		}
		//caso nao encontre o nome e nem a senha retorna -1
		return -1;
	}
	
	public void DeletarUsuario(String nome, String senha, int IdUser) {
		
		int qtd = 0;
		
		//procura pelo mesmo nome e senha nos usuarios cadastrados
		for(int i = 0; i <qtdPessoas; i++) {
			if(nome.equals(pessoa[i].getNome()) ) {
				if(senha.equals(pessoa[i].getSenha()) ) {
					
					pessoa[i].setNome(null);
					pessoa[i].setSenha(null);
					pessoa[i].getProduto(i).setDescricao(null);
//					qtd = i;
					for(int p = i; p <qtdPessoas; p++) {
						if(pessoa[p+1] == null) {
							break;
						}
						pessoa[p] = pessoa[p+1];
						pessoa[p].setId(pessoa[p+1].getId());
						
						//pega a qtd de produtos associado a essa pessoa
						int qtd1 = pessoa[i].quantidadeProdutos();
						
						for(int j=0; j<qtd1; j++) {
							
							//pega o produto dessa pessoa :
//							pessoa[i].getProduto(i).setDescricao(null);
							
//							//exclui o produto associado a pessoa
//							pessoa[i].excluirProduto(roupa[j]);
						}
						
					}
					
					
					break;
					
					//caso o usuario nao seja o ultimo instanciado, entra no if
//					if(i != qtdPessoas-1 ) {
//						
//						/*
//						 * Percorre por todos os usuarios, passando as informacoes
//						 * do indice a frente para o usuario anterior. 
//						 * 
//						 * o vetor inicia no indice no qual queremos deletar o usuario
//						 */
//						for(int p = i; p <qtdPessoas; p++) {
//							
//							//O usuario anterior recebe as info do usuario a frente
////							pessoa[p].setNome(pessoa[p+1].getNome());
////							pessoa[p].setSenha(pessoa[p+1].getSenha());
////							pessoa[p].setId(p+1);
//							
////							pessoa[i].setNome(null);
////							pessoa[i].setSenha(null);
////							pessoa[i].setId(null);
//							
//							//o usuario anterior recebe o usuario a sua frente
//							pessoa[p] = pessoa[p+2];
//							
//							//pega a qtd de produtos associado a essa pessoa
//							int qtd = pessoa[p].quantidadeProdutos();
//							
//							for(int j=0; j<qtd; j++) {
//								
//								//pega o produto dessa pessoa :
//								//pessoa[p].getProduto(j).getDescricao();
//								
//								//associa o produto dessa pessoa com a do sistema
//								for(int k=0; k<qtdRoupas; k++) {
//									if(roupa[k].getDescricao().equals(pessoa[p].getProduto(j).getDescricao()) ) {
//										//roupa[k].setDescricao(roupa[k+1].getDescricao());
//										pessoa[p].getProduto(k).setDescricao( pessoa[p+1].getProduto(k).getDescricao());
//										
//									}
//								}
//								
//	//							//exclui o produto associado a pessoa
//	//							pessoa[i].excluirProduto(roupa[j]);
//							}		
//								
//						}												
//					}else {
//						
//						//edita as suas informacoes para null
//						pessoa[i].setNome(null);
//						
//						//pega a qtd de produtos associado a essa pessoa
//						int qtd = pessoa[i].quantidadeProdutos();
//						
//						for(int j=0; j<qtd; j++) {
//							
//							//associa o produto dessa pessoa com a do sistema
//							for(int k=0; k<qtdRoupas; k++) {
//								if(roupa[k].getDescricao().equals(pessoa[i].getProduto(j).getDescricao()) ) {
//									roupa[k].setDescricao(roupa[k+1].getDescricao());
//									
//								}
//							}
//							
////							//exclui o produto associado a pessoa
////							pessoa[i].excluirProduto(roupa[j]);
//						}
//					}
//					
//					
				}
			}
		}
		
	//diminui a quantidade de usuarios
		qtdPessoas-- ;
		
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
	 */
	public Roupa getRoupa(int i) {
		return roupa[i];
	}
	
	/***********PRODUTO***********/
	
	public String getRoupaMarca(int i) {
		return roupa[i].getMarca();
	}
	
	public float getRoupaPreco(int i) {
		return roupa[i].getPreco();
	}
	
	public String getRoupaCondicao(int i) {
		return roupa[i].getCondicao();
	}
	
	public String getRoupaDescricao(int i) {
		return roupa[i].getDescricao();
	}
	
	
	/***********ROUPA***********/
	
	public String getRoupaCategoria(int i) {
		return roupa[i].getCategoria();
	}
	
	public String getRoupaEstilo(int i) {
		return roupa[i].getEstilo();
	}
	
	public String getRoupaCor(int i) {
		return roupa[i].getCor();
	}
	
	public String getRoupaTecido(int i) {
		return roupa[i].getEstilo();
	}
	
	public String getRoupaTamanho(int i) {
		return roupa[i].getTamanho();
	}
	
	
	
	
	public String getProdutoMarcaPessoa(int i, int r) {
		return pessoa[i].getProduto(r).getMarca();
	}
	
	public float getProdutoPrecoPessoa(int i, int r) {
		return pessoa[i].getProduto(r).getPreco();
	}
	
	public String getProdutoCondicaoPessoa(int i, int r) {
		return pessoa[i].getProduto(r).getCondicao();
	}
	
	public String getProdutoDescricaoPessoa(int i, int r) {
		return pessoa[i].getProduto(r).getDescricao();
	}
	
	/***********ROUPA***********/
	
	
	public Produto getProdutoPessoa(int i, int r) {
		return pessoa[i].getProduto(r);
	}
	
	public int getQuantidadeProdutosPessoa(int i) {
		return pessoa[i].quantidadeProdutos();
	}
	
	//teste para capturar roupas Usuario	
	public String getProdutoNomePessoa(int i, int r) {
		return pessoa[i].getProduto(r).getPessoa().getNome();
	}
	
<<<<<<< HEAD
=======
	/***********CADASTRAR ROUPAS***********/
>>>>>>> branch 'modAmanda' of https://github.com/artur-seppa/TrabalhoPratico_03.git
	public boolean cadastrarRoupa(int idUser, String descricao , String marca, float preco, String condicao,
			String categoria, String estilo, String cor, String tecido, String tamanho ) {
		
		if(descricao != null && descricao.length()>0 && marca!= null && marca.length()>0 && preco>0 && condicao != null && condicao.length()>0
		  && categoria != null && categoria.length()>0 && estilo != null && estilo.length()>0 && cor != null && cor.length()>0 &&
		  tecido != null && tecido.length()>0 && tamanho != null && tamanho.length()>0) {
			
			roupa[qtdRoupas] = new Roupa();
			roupa[qtdRoupas].setDescricao(descricao);
			roupa[qtdRoupas].setMarca(marca);
			roupa[qtdRoupas].setPreco(preco);
			roupa[qtdRoupas].setCondicao(condicao);
			
			roupa[qtdRoupas].setCategoria(categoria);
			roupa[qtdRoupas].setEstilo(estilo);
			roupa[qtdRoupas].setCor(cor);
			roupa[qtdRoupas].setTecido(tecido);
			roupa[qtdRoupas].setTamanho(tamanho);
			
			
			//ASSOCIA O NOME DA PESSOA AO PRODUTO
			roupa[qtdRoupas].setPessoa(pessoa[idUser]);
			
			//ASSOCIA O PRODUTO A PESSOA
			pessoa[idUser].adicionarProduto(roupa[qtdRoupas]);
			
//			//incrementa o numero de roupas totais
			qtdRoupas++;
			
			return true;
		}
		
		return false;
		
	}
	
	public boolean editarRoupa(int indice, String descricao , String marca, float preco, String condicao,
			String categoria, String estilo, String cor, String tecido, String tamanho ) {
		
		if(descricao != null && descricao.length()>0 && marca!= null && marca.length()>0 && preco>0 && condicao != null && condicao.length()>0
		  && categoria != null && categoria.length()>0 && estilo != null && estilo.length()>0 && cor != null && cor.length()>0 &&
		  tecido != null && tecido.length()>0 && tamanho != null && tamanho.length()>0) {
			
			roupa[indice].setDescricao(descricao);
			roupa[indice].setMarca(marca);
			roupa[indice].setPreco(preco);
			roupa[indice].setCondicao(condicao);
			
			roupa[indice].setCategoria(categoria);
			roupa[indice].setEstilo(estilo);
			roupa[indice].setCor(cor);
			roupa[indice].setTecido(tecido);
			roupa[indice].setTamanho(tamanho);
			
			return true;
		}
		
		return false;
		
	}
	
	public void excluirRoupa(int idUser, int indice) {
			
			//exclui o produto associado a pessoa
			pessoa[idUser].excluirProduto(roupa[indice]);
		
	}
	
	public void excluirProdutoRoupa(int i) {
		
		for(int k=i; k<=qtdRoupas;  k++) {
		
			if(k == 0) {
				break;
			}
			roupa[k] = roupa[k+1];
		}
		
		qtdRoupas--;
	
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
	
//	//ao finalizar a compra o boolean eh acionado
//	boolean sucesso;
//	
//	public void setCompraFinalizada(boolean b) {
//		sucesso = b;
//	}
//	
//	public boolean getCompraFinalizada() {
//		return sucesso;
//	}
	
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

