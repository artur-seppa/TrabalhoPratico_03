package View;
import Controle.*;
import Modelo.Pessoa;
import Modelo.Produto;
import Modelo.Roupa;
import Modelo.CarrinhoDeCompra;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class TelaMenu{
	
	private static JFrame janela = new JFrame("Roupas e Acessorios");
	
	/*
	 * Criacao de Jpanel's
	 */
	private static JPanel panelHome = new JPanel();
	private static JLabel tituloHome = new JLabel("Home");
	
	private static JPanel panelRoupas = new JPanel();
	private static JLabel tituloRoupas = new JLabel("Roupas");
	
	private static JPanel panelCarrinho = new JPanel();
	private static JLabel tituloCarrinho = new JLabel("Carrinho de Compras");
	
	private static JPanel panelFavoritos = new JPanel();
	private static JLabel tituloFavoritos = new JLabel("Lista de Favoritos");
	
	private static JPanel panelPerfil = new JPanel();
	private static JLabel tituloPerfil = new JLabel("Editar perfil");
	
	private static JPanel panelAddProdutos = new JPanel();
	private static JLabel tituloAddProdutos = new JLabel("Adicionar produtos");
	
	private static JPanel panelEditarExcluirProdutos = new JPanel();
	private static JLabel tituloEditarExcluirProdutos = new JLabel("Seus produtos");
	
	private static JPanel panelEditarProdutos = new JPanel();
	private static JLabel tituloEditarProdutos = new JLabel("Editar produtos");
	
	private static JPanel panelPesquisar = new JPanel();
	private static JLabel tituloPesquisar = new JLabel("Pesquisar usuarios");
	
	private static JPanel panelProduto = new JPanel();
	private static JLabel tituloProduto = new JLabel("Inserir produto");
	
	private static TelaMenu telaMenu = new TelaMenu();	//instancia o objeto da telaMenu
	private static ControleUsuario usuario;		//instancia o TIPO ControleUsuario === BD

	/*
	 * Criacao do JList: recebe a String Lista para imprimir no swing)
	 */
	private static String[] listaProdutos = new String[100];
	private JList<String> JlistProdutos;
	private DefaultListModel modelProdutos = new DefaultListModel();
	private JScrollPane srollProdutos = new JScrollPane();
	
	private static String[] ListaCarrinho = new String[100];
	private JList<String> JlistCarrinho;
	private DefaultListModel model = new DefaultListModel();
	private JScrollPane srollCarrinho = new JScrollPane();
	
	private static String[] ListaFavorito = new String[100];
	private JList<String> JlistFavorito;
	private DefaultListModel modelFavorito = new DefaultListModel();
	private JScrollPane srollFavorito = new JScrollPane();
	
	private static String[] ListaEditarProdutos = new String[100];
	private JList<String> JlistEditarProdutos;
	private DefaultListModel modelEditarProdutos = new DefaultListModel();
	private JScrollPane srollEditarProdutos = new JScrollPane();
	
	private static String[] ListaPesquisa = new String[100];
	private JList<String> JlistPesquisa;
	private DefaultListModel modelPesquisa = new DefaultListModel();
	private JScrollPane srollPesquisa = new JScrollPane();
	
	/*
	 * Criacao dos Buttons associados ao JList
	 */
	private static JButton buttonDetalhes = new JButton("Ver detalhes");
	private static JButton buttonCarrinho = new JButton("Inserir no carrinho");
	private static JButton buttonfavoritos = new JButton("Inserir favoritos");
	
	private static JButton compra = new JButton("Fechar compra");
	private static JButton excluirPcarrinho = new JButton("Excluir Produto");
	
	private static JButton FavoritoAddCarrinho = new JButton("Inserir no carrinho");
	private static JButton excluirFavorito = new JButton("Excluir Produto");
	
	/*
	 *	variaveis Globais  
	 */
	private static int idUser;
	private static int qtdRoupas = 0;
	private static int qtdProdutos = 0;
	private static int qtdProdutosFavoritos = 0;
	
	private static int qtdRoupasUsuario = 0;
	private static int indiceRoupa = 0;
	
	/*
	 * JMenu permite instanciar os arquivos clicaveis da
	 * barra de menu 
	 */
	JMenu home = new JMenu("Home");
	JMenu perfil = new JMenu("Usuario");
	JMenu menuCarrinho = new JMenu("carrinho de compras"); 
	JMenu menuFavoritos = new JMenu("Roupas Favoritas");
	JMenu menuPesquisa = new JMenu("Search");
	
	public void imprimirTelaMenu(ControleUsuario u, int idUsuario){
		
		/*
		 * Obtem o "BD" criado na tela anterior, com seus users ja pre fabricados,
		 * e passa essa configuracao ao obj usuario de mesmo tipo ControleUsuario
		 */
		usuario = u;
		idUser = idUsuario;
		System.out.println("IDUSER === "+ idUser);
		
		
		/*
		 * Pega as ROUPAS instanciadas dentro do BD e passa para 
		 * o JList produtos
		 */
			modelProdutos = new DefaultListModel();
			JlistProdutos = new JList<String>(modelProdutos);
			srollProdutos = new JScrollPane(JlistProdutos);
				
				try {
						
						qtdRoupas = usuario.getQtdRoupas();
						
						System.out.println("qtd roupas inicial "+ qtdRoupas);
						
						for(int i=0; i<qtdRoupas; i++) {
							modelProdutos.addElement(usuario.getRoupaDescricao(i));
							System.out.println("ROUPAS ===  "+ usuario.getRoupaDescricao(i));
						}
						
				}catch(Exception ex){
//					JOptionPane.showMessageDialog(null, 
//					"Erro: " + ex + "\n", null, 
//					JOptionPane.INFORMATION_MESSAGE);
				}
		
		/*
		 *	O usuario ao logar ja tem o seu carrinho atualizado com 
		 *	pedidos anteriores 
		 */
		
		//Instancia o Jlist do Carrinho de Compras
		model = new DefaultListModel();
		JlistCarrinho = new JList<String>(model);
		srollCarrinho = new JScrollPane(JlistCarrinho);
		
		try {
			if(usuario.QtdProduto(idUser) != 0) {
				
				qtdProdutos = usuario.QtdProduto(idUser);
				
				System.out.println("qtd produtos inicial "+ qtdProdutos);
				
				for(int i=0; i<qtdProdutos; i++) {
					model.addElement(usuario.getProdutoCarrinho(idUser, i));
				}
				
			}
		}catch(Exception ex){
//			JOptionPane.showMessageDialog(null, 
//			"Erro: " + ex + "\n", null, 
//			JOptionPane.INFORMATION_MESSAGE);
		}
		
		
		/*
		 *	O usuario ao logar ja tem a sua lista de favoritos atualizada com 
		 *	pedidos anteriores 
		 */
		
		//Instancia o Jlist da Lista de Favoritos
		modelFavorito = new DefaultListModel();
		JlistFavorito = new JList<String>(modelFavorito);
		srollFavorito = new JScrollPane(JlistFavorito);
		
		try {
		
			if(usuario.QtdProdutoFavorito(idUser) != 0) {
		
			qtdProdutosFavoritos = usuario.QtdProdutoFavorito(idUser);
			
			for(int i=0; i<qtdProdutosFavoritos; i++) {
				
				System.out.println("favoritos ===== "+ usuario.getProdutoFavorito(idUser, i));
				
				modelFavorito.addElement(usuario.getProdutoFavorito(idUser, i));
			}
			
			}
		
		}catch(Exception ex){
//			JOptionPane.showMessageDialog(null, 
//			"Erro: " + ex + "\n", null, 
//			JOptionPane.INFORMATION_MESSAGE);
		}
		
		/*
		 *	O usuario ao logar ja tem o seu editar produtos atualizado com 
		 *	produtos anteriores 
		 */
		
		//Instancia o Jlist de Produtos cadastardos pelo usuario
		modelEditarProdutos = new DefaultListModel();
		JlistEditarProdutos = new JList<String>(modelEditarProdutos);
		srollEditarProdutos = new JScrollPane(JlistEditarProdutos);
		
		try {
//			if(usuario.getQuantidadeProdutosPessoa(idUser) != 0) {
//				
//				int qtdP = usuario.getQuantidadeProdutosPessoa(idUser);
//				
//				System.out.println("qPRODUTOS DA PESSOA ==== "+ qtdP);
//				
//				for(int i=0; i<qtdP; i++) {
//					System.out.println("PRODUTOS DA PESSOA ===== "+ usuario.getProdutoDescricaoPessoa(idUser, i));
//					modelEditarProdutos.addElement(usuario.getProdutoDescricaoPessoa(idUser, i));
//				}
//				
//			}
			
			//obtem a quantidade total de roupas da pessoa
			int qtd = usuario.getQuantidadeProdutosPessoa(idUser);
			
			//adiciona as roupas nos quais tem o nome do usuario
			for(int i=0; i<qtd; i++) {
				qtdRoupasUsuario++;
				System.out.println("quantiodade de roupa do usuario LOOP =-> " + qtdRoupasUsuario);
				modelEditarProdutos.addElement(usuario.getProdutoPessoa(idUser, i).getDescricao() );
			}
			
		}catch(Exception ex){
//			JOptionPane.showMessageDialog(null, 
//			"Erro: " + ex + "\n", null, 
//			JOptionPane.INFORMATION_MESSAGE);
		}
		
		/*-------------------INSTANCIA A JANELA------------------*/
		
		janela.setVisible(true);
		janela.setSize(600, 400);
		
		//inicia o panel home
		divHome();
		
	}
	
	/*####################### PAINEL HOME ############################*/
	
	public void divHome() {
		janela.add(panelHome);
		
		panelHome.setVisible(true);	
		panelHome.setLayout(null);
		
		/*
		* set o width e height do obj.
		* (loc x, loc y do titulo na window. || width e height do titulo)
		*/
		
		/*impoe a fonte do titulo(fonte, negrito e tamanho em px)*/
		tituloHome.setFont(new Font("Arial", Font.BOLD, 17));
		tituloHome.setBounds(40, 15, 250, 30);
		panelHome.add(tituloHome);
		
		/*----------------JList---------------*/
		/*
		 * Criacao do Jlist com scroll no panel 
		 */
		
		srollProdutos = new JScrollPane(JlistProdutos);
		srollProdutos.setBounds(40, 50, 500, 200);
		
		panelHome.add(srollProdutos);
		
		/*---------------Buttons---------------*/
		buttonDetalhes.setBounds(40, 270, 140, 35);
		panelHome.add(buttonDetalhes);
		
		buttonfavoritos.setBounds(190, 270, 170, 35);
		panelHome.add(buttonfavoritos);
		
		buttonCarrinho.setBounds(370, 270, 170, 35);
		panelHome.add(buttonCarrinho);
		
		
		/*
		* ActionListener: verifica se o usuario clicou em algum dos
		* buttons criados
		*/
	    
		buttonDetalhes.addActionListener(
	      new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	
	        	// Um botão que permite obter o índice do item selecionado
	        	int indice = JlistProdutos.getSelectedIndex();
	          
	          //antes de tudo os JLabels do DetalheProduto sao limpados
	          new DetalheProduto().CloseDetalhes();
	          new DetalheProduto().imprimirTelaDetalhe(usuario, indice);
	        }
	      }
	    );
		
		buttonCarrinho.addActionListener(
			new ActionListener(){
			 public void actionPerformed(ActionEvent e){
				        	
				 // Um botão que permite obter o índice do item selecionado
				 int indice = JlistProdutos.getSelectedIndex();
				 
				 usuario.AdicionarCompra(idUser, indice);
				 qtdProdutos = usuario.QtdProduto(idUser);
				 
				 System.out.println("indice do button carrinho == "+indice);
				 System.out.println("qtd produtos do button carrinho == "+qtdProdutos);
				 System.out.println("produto no carrinh  == "+ usuario.getProdutoCarrinho(idUser, qtdProdutos-1));
				 
				 for(int i=0; i<qtdProdutos; i++) {
						System.out.println("PRODUTOOOOO ======" + usuario.getProdutoCarrinho(idUser, i));
					}
				 
				 //ADICIONA O NOVO PRODUTO NA JLIST DO CARRINHO
				 model.addElement(usuario.getProdutoCarrinho(idUser, qtdProdutos-1));
				 
			}
		  }
	   );
		
		buttonfavoritos.addActionListener(
				new ActionListener(){
				 public void actionPerformed(ActionEvent e){
					        	
					// Um botão que permite obter o índice do item selecionado
					 int indice = JlistProdutos.getSelectedIndex();
					 
					 usuario.AdicionarFavorito(idUser, indice, indice);
					 qtdProdutosFavoritos = usuario.QtdProdutoFavorito(idUser);
					 
					 System.out.println("indice do button favorito == "+indice);
					 System.out.println("qtd produtos do button favorito == "+qtdProdutosFavoritos);
					 System.out.println("produto no favorito  == "+ usuario.getProdutoFavorito(idUser, qtdProdutosFavoritos-1));
					 
					 for(int i=0; i<qtdProdutosFavoritos; i++) {
							System.out.println("FAVORITOOOOOS ======" + usuario.getProdutoFavorito(idUser, i));
						}
					 
					 //ADICIONA O NOVO PRODUTO NA JLIST DE FAVORITOS
					 modelFavorito.addElement(usuario.getProdutoFavorito(idUser, qtdProdutosFavoritos-1));
				}
			  }
		   );
		
	}
	
		/*####################### PAINEL CARRINHO ############################*/
	
		public void painelCarrinho() {
		
		janela.add(panelCarrinho);
		panelCarrinho.setVisible(true);
		
		
		panelCarrinho.setLayout(null);
		
		/*
		* set o width e height do obj.
		* (loc x, loc y do titulo na window. || width e height do titulo)
		*/
		
		/*impoe a fonte do titulo(fonte, negrito e tamanho em px)*/
		tituloCarrinho.setFont(new Font("Arial", Font.BOLD, 17));
		tituloCarrinho.setBounds(40, 15, 250, 30);		
		panelCarrinho.add(tituloCarrinho);
		
		/*-----------------JList-----------------*/
		
		/*
		 * Instancia o scroll do Jlist carrinho no panel 
		 */
		
		srollCarrinho.setBounds(40, 50, 250, 200);
		panelCarrinho.add(srollCarrinho);
		
		
		/*--------------------BUTTONS---------------------*/
		  compra.setBounds(40, 270, 140, 35);
		  panelCarrinho.add(compra);
		  
		  
		  JTextField qtdTotalItens = new JTextField(20);
          qtdTotalItens.setText(null);
          qtdTotalItens.setBounds(320, 40, 200, 30);
          qtdTotalItens.setEditable(false);
          panelCarrinho.add(qtdTotalItens);
		  
		  JTextField valorTotal = new JTextField(20);
		  valorTotal.setText(null);
		  valorTotal.setBounds(320, 80, 200, 30);
		  valorTotal.setEditable(false);
          panelCarrinho.add(valorTotal);
          
          JTextField endereco = new JTextField(120);
          endereco.setText(null);
          endereco.setBounds(320, 120, 200, 30);
          endereco.setEditable(false);
          panelCarrinho.add(endereco);
          
          JTextField enderecoLabel = new JTextField(120);
          enderecoLabel.setText(null);
          enderecoLabel.setBounds(320, 160, 200, 30);
          enderecoLabel.setEditable(false);
          panelCarrinho.add(enderecoLabel);
          
          JTextField frete = new JTextField(120);
          frete.setText(null);
          frete.setBounds(320, 200, 200, 30);
          frete.setEditable(false);
          panelCarrinho.add(frete);
          
          
          //instância um objeto da classe Random usando o construtor básico
          Random geradorAleatorio = new Random();

          //gera um numero inteiro aleatorio de 1 a 15
          int aleatorio = geradorAleatorio.nextInt(14) +1;
          
		  
		  compra.addActionListener(
			      new ActionListener(){
			        public void actionPerformed(ActionEvent e){
			        	
			        	int size = model.getSize();
			        	float total = 0;
			        	System.out.println("size === "+ size );
			        	
//			        	model.getElementAt(size);
			        	
			        try {
			        	
			        	if(size != 0) {
			        	
				        	for(int i=0; i<size; i++) {
//								System.out.println("PRODUTO a ser comprado " + usuario.getProdutoCarrinho(idUser, i));
//								System.out.println("preco === " + usuario.getProdutoValor(idUser, i));
								total = total + usuario.getProdutoValor(idUser, i);
				        	}
//				        	
//				        	System.out.println("endereco : " + usuario.getEndereco(idUser));
//				        	
//				        	System.out.println("total == " + total);
				        	
				        	
				        	qtdTotalItens.setText("Quantidade total de itens: " + size);
				        	valorTotal.setText("Valor total: R$" + total);
				        	endereco.setText("Endereco de entrega :");
				        	enderecoLabel.setText( usuario.getEndereco(idUser));
				        	frete.setText("Valor de frete : " + aleatorio);
				      			        	
				        	new TelaCompra().imprimirTelaCompra();
				        	
				        	/*
				        	 *	Remove todos os produtos do carrinho apos efetuar a compra
				        	 */
				        	model.removeAllElements();
				        	
				        	//todos os produtos sao removidos do obj carrinho
				         	usuario.RemoveTodosCarrinho(qtdProdutos , idUser, size);
				         	
				        	//qtdProdutos--;	        
				        	
			        	}else {
			        		
//			        		JOptionPane.showMessageDialog(null, 
//					    	"Insira produtos no carrinho para efetuar a compra\n", null, 
//					    	JOptionPane.INFORMATION_MESSAGE);
			        		
			        	}
			        }catch(Exception ex){
//			    			JOptionPane.showMessageDialog(null, 
//			    			"Erro: " + ex + "\n", null, 
//			    			JOptionPane.INFORMATION_MESSAGE);
			    	}
			        	
			        	
			        }
			      }
			    );
		  
		  excluirPcarrinho.setBounds(190, 270, 170, 35);
		  panelCarrinho.add(excluirPcarrinho);
		  
		  excluirPcarrinho.addActionListener(
			      new ActionListener(){
			        public void actionPerformed(ActionEvent e){

			        	// Um botão que permite obter o índice do item selecionado
			        	int remover = JlistCarrinho.getSelectedIndex();
			        	
			        	
			        	//exerce a remocao do item no carrinho
			        	try {
				        	usuario.RemoveProdutoCarrinho(idUser, remover, remover);
				        	model.remove(remover);
				        	
				        	//garante que todos os produtos sejam removidos do carrinho
				         	if(qtdProdutos == 1) {
				        		usuario.RemoveTodosCarrinho(qtdProdutos , idUser, remover);
				        	}
				        	
				        	qtdProdutos--;
				        	
//				        	//garante que todos os produtos sejam removidos do carrinho
//				         	if(qtdProdutos == 0) {
//				        		usuario.RemoveTodosCarrinho(qtdProdutos , idUser);
//				        	}
				        	
				        	System.out.println("qtd produtosa agora == " + qtdProdutos);
				        	System.out.println("indice remover agora == " + remover);
				        	
				        	
			        	}catch(Exception ex){
//			    			JOptionPane.showMessageDialog(null, 
//			    					"Erro: " + ex + "\n", null, 
//			    					JOptionPane.INFORMATION_MESSAGE);
			    		}
			   	    
			        }
			      }
			    );
		  
		  for(int i=0; i<qtdProdutos; i++) {
				System.out.println("PRODUTOS NO CARRINHO " + usuario.getProdutoCarrinho(idUser, i));
			}
		
	}
		
	/*####################### PAINEL FAVORITOS ############################*/
	
	public void divFavorito() {
		
		janela.add(panelFavoritos);
		panelFavoritos.setVisible(true);
		
		
		panelFavoritos.setLayout(null);
		
		/*
		* set o width e height do obj.
		* (loc x, loc y do titulo na window. || width e height do titulo)
		*/
		
		/*impoe a fonte do titulo(fonte, negrito e tamanho em px)*/
		tituloFavoritos.setFont(new Font("Arial", Font.BOLD, 17));
		tituloFavoritos.setBounds(40, 15, 250, 30);		
		panelFavoritos.add(tituloFavoritos);
		
		/*-----------------JList-----------------*/
		
		/*
		 * Instancia o scroll do Jlist favoritos no panel 
		 */
		
		srollFavorito.setBounds(40, 50, 500, 200);
		panelFavoritos.add(srollFavorito);
		
		
		/*--------------------BUTTONS---------------------*/
		  
		  excluirFavorito.setBounds(190, 270, 170, 35);
		  panelFavoritos.add(excluirFavorito);
		  
		  excluirFavorito.addActionListener(
				  new ActionListener(){
						 public void actionPerformed(ActionEvent e){
							        	
							// Um botão que permite obter o índice do item selecionado
					        	int remover = JlistFavorito.getSelectedIndex();
					        	
					        	
					        	//exerce a remocao do item na lista de favoritos
					        	try {
						        	usuario.RemoveProdutoFavorito(idUser, remover);
						        	modelFavorito.remove(remover);
						        	
						        	qtdProdutosFavoritos--;
						        	
						        	//garante que todos os produtos sejam removidos do carrinho
						         	if(qtdProdutosFavoritos == 1) {
						        		usuario.RemoveTodosFavoritos(qtdProdutosFavoritos , idUser, remover);
						        	}
						        	
						        	System.out.println("qtd favorito agora == " + qtdProdutosFavoritos);
						        	System.out.println("indice DO FAVORITO agora == " + remover);
						        	
						        	
					        	
					        	}catch(Exception ex){
//					    			JOptionPane.showMessageDialog(null, 
//					    					"Erro: " + ex + "\n", null, 
//					    					JOptionPane.INFORMATION_MESSAGE);
					    		}
					        	
					        	System.out.println("qtd favorito FORA DO TRY == " + qtdProdutosFavoritos);
					        	
					        	for(int i=0; i<qtdProdutosFavoritos; i++) {
									System.out.println("PRODUTO FAVORITO " + usuario.getProdutoFavorito(idUser, i));
								}
					        	
						}
					  }
				   );
		  
	}
	
	/*####################### PAINEL PERFIL ############################*/
	
	public void divPerfil() {
		
		janela.add(panelPerfil);
		panelPerfil.setVisible(true);
		
		panelPerfil.setLayout(null);
		janela.setSize(600, 500);
		
		/*
		* set o width e height do obj.
		* (loc x, loc y do titulo na window. || width e height do titulo)
		*/
		
		/*impoe a fonte do titulo(fonte, negrito e tamanho em px)*/
		tituloPerfil.setFont(new Font("Arial", Font.BOLD, 17));
		tituloPerfil.setBounds(25, 15, 250, 30);		
		panelPerfil.add(tituloPerfil);
		
		
		/*--------------------LABELS E TEXTFILELDS---------------------*/
		
			/***************PESSOA********************/
			JLabel nome = new JLabel("Nome :");
			nome.setFont(new Font("Arial", Font.BOLD, 15));
			nome.setBounds(25, 45, 120, 30);
			panelPerfil.add(nome);
		
			JTextField nomeText = new JTextField(120);
			nomeText.setText(usuario.getNome(idUser));
			nomeText.setBounds(25, 75, 200, 30);
			panelPerfil.add(nomeText);
			
			JLabel senha = new JLabel("Senha :");
			senha.setFont(new Font("Arial", Font.BOLD, 15));
			senha.setBounds(25, 115, 120, 30);
			panelPerfil.add(senha);
		
			JTextField senhaText = new JTextField(120);
			senhaText.setText(usuario.getSenha(idUser));
			senhaText.setBounds(25, 145, 200, 30);
			panelPerfil.add(senhaText);
			
			
			/***************TELEFONE********************/
			JLabel telefone = new JLabel("Telefone :");
			telefone.setFont(new Font("Arial", Font.BOLD, 15));
			telefone.setBounds(255, 45, 120, 30);
			panelPerfil.add(telefone);
		
			JTextField telefoneText = new JTextField(120);
			telefoneText.setText(Integer.toString(usuario.getTelefone(idUser)) );
			telefoneText.setBounds(255, 75, 200, 30);
			panelPerfil.add(telefoneText);
			
			JLabel ddd = new JLabel("DDD :");
			ddd.setFont(new Font("Arial", Font.BOLD, 15));
			ddd.setBounds(255, 115, 120, 30);
			panelPerfil.add(ddd);
		
			JTextField dddText = new JTextField(120);
			dddText.setText(Integer.toString(usuario.getDDD(idUser)) );
			dddText.setBounds(255, 145, 200, 30);
			panelPerfil.add(dddText);
			
			/***************ENDERECO********************/
			JLabel estado = new JLabel("Estado :");
			estado.setFont(new Font("Arial", Font.BOLD, 15));
			estado.setBounds(25, 185, 120, 30);
			panelPerfil.add(estado);
		
			JTextField estadoText = new JTextField(120);
			estadoText.setText(usuario.getEstado(idUser));
			estadoText.setBounds(25, 215, 200, 30);
			panelPerfil.add(estadoText);
			
			JLabel cidade = new JLabel("Cidade :");
			cidade.setFont(new Font("Arial", Font.BOLD, 15));
			cidade.setBounds(25, 255, 120, 30);
			panelPerfil.add(cidade);
		
			JTextField cidadeText = new JTextField(120);
			cidadeText.setText(usuario.getCidade(idUser));
			cidadeText.setBounds(25, 285, 200, 30);
			panelPerfil.add(cidadeText);
			
			JLabel bairro = new JLabel("Bairro :");
			bairro.setFont(new Font("Arial", Font.BOLD, 15));
			bairro.setBounds(25, 325, 120, 30);
			panelPerfil.add(bairro);
		
			JTextField bairroText = new JTextField(120);
			bairroText.setText(usuario.getBairro(idUser));
			bairroText.setBounds(25, 355, 200, 30);
			panelPerfil.add(bairroText);
			
			JLabel endereco = new JLabel("Endereco :");
			endereco.setFont(new Font("Arial", Font.BOLD, 15));
			endereco.setBounds(255, 185, 120, 30);
			panelPerfil.add(endereco);
		
			JTextField enderecoText = new JTextField(120);
			enderecoText.setText(usuario.getEndereco(idUser));
			enderecoText.setBounds(255, 215, 200, 30);
			panelPerfil.add(enderecoText);
			
			JLabel cep = new JLabel("Cep :");
			cep.setFont(new Font("Arial", Font.BOLD, 15));
			cep.setBounds(255, 255, 120, 30);
			panelPerfil.add(cep);
		
			JTextField cepText = new JTextField(120);
			cepText.setText(Integer.toString(usuario.getCep(idUser)) );
			cepText.setBounds(255, 285, 200, 30);
			panelPerfil.add(cepText);
			
			/*--------------------BUTTONS---------------------*/
		
		  JButton ButtonSalvar = new JButton("Salvar");
		  ButtonSalvar.setBounds(285, 335, 140, 35);
		  panelPerfil.add(ButtonSalvar);
		  
		  ButtonSalvar.addActionListener(
				  new ActionListener(){
						 public void actionPerformed(ActionEvent e){
							boolean sucesso;
							 
							int ddd = Integer.parseInt(dddText.getText());
							int telefone = Integer.parseInt(telefoneText.getText());
							int cep = Integer.parseInt(cepText.getText());
							
							sucesso = usuario.editarUsuario(idUser, nomeText.getText(), senhaText.getText(), ddd, telefone, estadoText.getText(), cidadeText.getText(), bairroText.getText(), enderecoText.getText(), cep);
									
								if(sucesso == true) {
									JOptionPane.showMessageDialog(null, 
									"Informacoes editadas com sucesso\n", null, 
									JOptionPane.INFORMATION_MESSAGE);
									
								}else{
									JOptionPane.showMessageDialog(null, 
											"Os campos nao foram preenchidos corretamente\n", null, 
											JOptionPane.INFORMATION_MESSAGE);
								}		
					        	
						}
					  }
				   );
		  
		  JButton ButtonDeletar = new JButton("Deletar user");
		  ButtonDeletar.setBounds(255, 385, 200, 35);
		  panelPerfil.add(ButtonDeletar);
		  
		  ButtonDeletar.addActionListener(
				  new ActionListener(){
						 public void actionPerformed(ActionEvent e){							 
							try {
							
							//Quantidade de produtos associados a pessoa logada	
							 int qtdProdutosPessoa = usuario.getQuantidadeProdutosPessoa(idUser);
							 
							 //deleta o usuario
							 usuario.DeletarUsuario(nomeText.getText(), senhaText.getText(), idUser);
					        
							 String user[] = usuario.escreveUsuarios();
							 String produ[] = usuario.escreveProdutos();
							 int qtd = usuario.getQtdPessoas();						 
													 
							 for(int i=0; i<qtd; i++) {
								 System.out.println("usuarios AGORA ===" + user[i]);
								 System.out.println("produtos AGORA== "+ produ[i]);
							 }
							 
							 //como diminuiu um usuario temos que diminuir a qtd de produtos
							 int size = modelProdutos.getSize();
							 size = size - qtdProdutosPessoa;
							 
							 //remove todos os produtos
							 modelProdutos.removeAllElements();
							 
							 //aloca os novos produtos editados na lista
							 for(int k=0; k<size; k++) {
								 System.out.println("produtos a serem colocados "+ produ[k]);
								 modelProdutos.addElement(produ[k]);
							 }						
							 
							 divHomeNotVisible();
					            panelFavoritoNotVisible();
					            panelCarrinhoNotVisible();
					            panelAddProdutosNotVisible();
					            panelPerfilNotVisible();
					            panelEditarExcluirProdutosNotVisible();
					            panelEditarProdutosNotVisible();
							 
							 //volta a tela principal
							 janela.setVisible(false);
							 new TelaPrincipal().VoltarTelaPrincipal(usuario);
							 
							 int qt = usuario.getQtdPessoas();
							 String us[] =  usuario.escreveUsuarios();
							 for(int i=0; i<qt; i++) {
								 System.out.println("USARIOS NOVOS ::::: "+ us[i]);
							 }
							 
							//passa o valor null para os inputs ao finalizar a operacao
							nomeText.setText(usuario.getNome(idUser));
							senhaText.setText(usuario.getSenha(idUser));
							dddText.setText(Integer.toString(usuario.getDDD(idUser)) );
							telefoneText.setText(Integer.toString(usuario.getTelefone(idUser)) );
							bairroText.setText(usuario.getBairro(idUser));
							cepText.setText(Integer.toString(usuario.getCep(idUser)) );
							cidadeText.setText(usuario.getCidade(idUser));
							estadoText.setText(usuario.getEstado(idUser));
							enderecoText.setText(usuario.getEndereco(idUser));
							 
							}catch(Exception ex){
//				    			JOptionPane.showMessageDialog(null, 
//		    					"Erro: " + ex + "\n", null, 
//		    					JOptionPane.INFORMATION_MESSAGE);
							}
						
						}
					  }
				   );
		  
	}
	
	
/*####################### PAINEL ADD PRODUTOS ############################*/
	
	public void divAddProdutos() {
		
		janela.add(panelAddProdutos);
		panelAddProdutos.setVisible(true);
		
		panelAddProdutos.setLayout(null);
		janela.setSize(600, 500);
		
		/*
		* set o width e height do obj.
		* (loc x, loc y do titulo na window. || width e height do titulo)
		*/
		
		/*impoe a fonte do titulo(fonte, negrito e tamanho em px)*/
		tituloAddProdutos.setFont(new Font("Arial", Font.BOLD, 17));
		tituloAddProdutos.setBounds(25, 15, 250, 30);		
		panelAddProdutos.add(tituloAddProdutos);
		
		
		/*--------------------LABELS E TEXTFILELDS---------------------*/
		
			/***************PRODUTO********************/
			JLabel descricao = new JLabel("Descricao :");
			descricao.setFont(new Font("Arial", Font.BOLD, 15));
			descricao.setBounds(25, 45, 120, 30);
			panelAddProdutos.add(descricao);
		
			JTextField descricaoText = new JTextField(120);
			descricaoText.setBounds(25, 75, 200, 30);
			panelAddProdutos.add(descricaoText);
			
			JLabel marca = new JLabel("Marca :");
			marca.setFont(new Font("Arial", Font.BOLD, 15));
			marca.setBounds(25, 185, 120, 30);
			panelAddProdutos.add(marca);
		
			JTextField marcaText = new JTextField(120);
			marcaText.setBounds(25, 215, 200, 30);
			panelAddProdutos.add(marcaText);
			
			JLabel preco = new JLabel("Preco :");
			preco.setFont(new Font("Arial", Font.BOLD, 15));
			preco.setBounds(255, 45, 120, 30);
			panelAddProdutos.add(preco);
		
			JTextField precoText = new JTextField(120);
			precoText.setBounds(255, 75, 200, 30);
			panelAddProdutos.add(precoText);
			
			JLabel condicao = new JLabel("Condicao :");
			condicao.setFont(new Font("Arial", Font.BOLD, 15));
			condicao.setBounds(255, 115, 120, 30);
			panelAddProdutos.add(condicao);
		
			JTextField condicaoText = new JTextField(120);
			condicaoText.setBounds(255, 145, 200, 30);
			panelAddProdutos.add(condicaoText);
			
			/***********************************/
			
			JLabel categoria = new JLabel("Categoria :");
			categoria.setFont(new Font("Arial", Font.BOLD, 15));
			categoria.setBounds(25, 115, 120, 30);
			panelAddProdutos.add(categoria);
			
			String vetor[] = {"Roupa","Sapato","Acessorio"};
			
			JComboBox combobox = new JComboBox(vetor);
			combobox.setBounds(25, 145, 200, 30);
			panelAddProdutos.add(combobox);
			
			JLabel estilo = new JLabel("Estilo :");
			estilo.setFont(new Font("Arial", Font.BOLD, 15));
			estilo.setBounds(25, 255, 120, 30);
			panelAddProdutos.add(estilo);
		
			JTextField estiloText = new JTextField(120);
			estiloText.setBounds(25, 285, 200, 30);
			panelAddProdutos.add(estiloText);
			
			JLabel cor = new JLabel("Cor :");
			cor.setFont(new Font("Arial", Font.BOLD, 15));
			cor.setBounds(25, 325, 120, 30);
			panelAddProdutos.add(cor);
		
			JTextField corText = new JTextField(120);
			corText.setBounds(25, 355, 200, 30);
			panelAddProdutos.add(corText);
			
			JLabel tecido = new JLabel("Tecido :");
			tecido.setFont(new Font("Arial", Font.BOLD, 15));
			tecido.setBounds(255, 185, 120, 30);
			panelAddProdutos.add(tecido);
		
			JTextField tecidoText = new JTextField(120);
			tecidoText.setBounds(255, 215, 200, 30);
			panelAddProdutos.add(tecidoText);
			
			JLabel tamanho = new JLabel("Tamanho :");
			tamanho.setFont(new Font("Arial", Font.BOLD, 15));
			tamanho.setBounds(255, 255, 120, 30);
			panelAddProdutos.add(tamanho);
		
			String tam[] = {"P", "M", "G"
					,"35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52"};
			
			JComboBox comboTam = new JComboBox(tam);
			comboTam.setBounds(255, 285, 200, 30);
			panelAddProdutos.add(comboTam);
			
//			JTextField tamanhoText = new JTextField(120);
//			tamanhoText.setBounds(255, 285, 200, 30);
//			panelAddProdutos.add(tamanhoText);
			
			/*--------------------BUTTONS---------------------*/
		
		  JButton AddRoupa = new JButton("Adicionar roupa");
		  AddRoupa.setBounds(255, 345, 200, 35);
		  panelAddProdutos.add(AddRoupa);
		  
		  AddRoupa.addActionListener(
				  new ActionListener(){
						 public void actionPerformed(ActionEvent e){
							
					try {
							boolean sucesso;
						
							float valor = Float.parseFloat(precoText.getText());
							int itemCombo = combobox.getSelectedIndex();
							int itemcomboTam = comboTam.getSelectedIndex();
							
							String category = null;
							String tam = null;
							
							if(itemCombo == 0) {
								category = "roupa";
							}
							
							if(itemcomboTam != -1) {
								if(itemcomboTam == 0) {
									tam = "P";
								}
								if(itemcomboTam == 1) {
									tam = "M";
								}
								if(itemcomboTam == 2) {
									tam = "G";
								}
							}
							
							sucesso = usuario.cadastrarRoupa(idUser, descricaoText.getText(), marcaText.getText(), valor, condicaoText.getText(), category, estiloText.getText(), corText.getText(), tecidoText.getText(), tam);
									
								if(sucesso == true) {
									JOptionPane.showMessageDialog(null, 
									"Roupa adicionada com sucesso\n", null, 
									JOptionPane.INFORMATION_MESSAGE);
									
									//obtem a qtd roupas atualizada
									qtdRoupas = usuario.getQtdRoupas();
									
									//adiciona a nova roupa no JList do home
									modelProdutos.addElement(usuario.getRoupaDescricao(qtdRoupas-1));
									
									//adiciona a nova roupa no JList de ROUPA DE USUARIO
//									int qtd = usuario.getQuantidadeProdutosPessoa(idUser);
//									
//									System.out.println("quantodadeeee = "+ qtd);
									System.out.println("quantiodade de roupa do usuario =-> " + qtdRoupasUsuario);
									modelEditarProdutos.addElement(usuario.getProdutoDescricaoPessoa(idUser, qtdRoupasUsuario));
									qtdRoupasUsuario++;
									
									//passa o valor null para os inputs ao finalizar a operacao
									descricaoText.setText(null);
									marcaText.setText(null);
									precoText.setText(null);
									condicaoText.setText(null);
									estiloText.setText(null);
									corText.setText(null);
									tecidoText.setText(null);
									
								}
							
					}catch(Exception ex){
								JOptionPane.showMessageDialog(null, 
								"Os campos nao foram preenchidos corretamente\n", null, 
								JOptionPane.INFORMATION_MESSAGE);
					}
					        	
						}
					  }
				   );
		  
	}
	
	
/*####################### PAINEL EDITAR/EXCLUIR PRODUTOS ############################*/
	
	public void divEditarExcluirProdutos() {
		
		janela.add(panelEditarExcluirProdutos);
		panelEditarExcluirProdutos.setVisible(true);
		
		panelEditarExcluirProdutos.setLayout(null);
		
		/*
		* set o width e height do obj.
		* (loc x, loc y do titulo na window. || width e height do titulo)
		*/
		
		/*impoe a fonte do titulo(fonte, negrito e tamanho em px)*/
		tituloEditarExcluirProdutos.setFont(new Font("Arial", Font.BOLD, 17));
		tituloEditarExcluirProdutos.setBounds(40, 10, 140, 30);		
		panelEditarExcluirProdutos.add(tituloEditarExcluirProdutos);
		
		/*----------------JList---------------*/
		/*
		 * Criacao do Jlist com scroll no panel 
		 */
		

		srollEditarProdutos.setBounds(40, 50, 500, 200);
		panelEditarExcluirProdutos.add(srollEditarProdutos);
			
		/*--------------------BUTTONS---------------------*/
		
		  JButton EditarRoupa = new JButton("Editar roupa");
		  EditarRoupa.setBounds(65, 280, 180, 35);
		  panelEditarExcluirProdutos.add(EditarRoupa);
		  
		  EditarRoupa.addActionListener(
				  new ActionListener(){
						 public void actionPerformed(ActionEvent e){
							
							// Um botão que permite obter o índice do item selecionado
					        indiceRoupa = JlistEditarProdutos.getSelectedIndex(); 
							 
							divHomeNotVisible();
				            panelFavoritoNotVisible();
				            panelCarrinhoNotVisible();
				            panelAddProdutosNotVisible();
				            panelPerfilNotVisible();
				            panelEditarExcluirProdutosNotVisible();
				            	
				            
				            divEditarProdutos();
					        
					        										        									
							
						}
					  }
				   );
		  
		  JButton ExcluirRoupa = new JButton("Excluir roupa");
		  ExcluirRoupa.setBounds(240, 280, 180, 35);
		  panelEditarExcluirProdutos.add(ExcluirRoupa);
		  
		  ExcluirRoupa.addActionListener(
				  new ActionListener(){
						 public void actionPerformed(ActionEvent e){
							 
							// Um botão que permite obter o índice do item selecionado
						    indiceRoupa = JlistEditarProdutos.getSelectedIndex();
						    
							System.out.println("indice de roupa do usuario =-> " + indiceRoupa);
//						    if(modelEditarProdutos.getElementAt(indiceRoupa).equals(usuario.getProdutoDescricaoPessoa(idUser, indiceRoupa) ) ) {
						    	
							 //obtem a qtd roupas atualizada
							   qtdRoupas = usuario.getQtdRoupas();
							   System.out.println("qtd = " + qtdRoupas);
							  
							   /*
							    * Exerce a elmininacao das roupas no JList home
							    */
							   for(int i=0; i<qtdRoupas; i++) {
									//adiciona a nova roupa no JList do home
								   if(usuario.getProdutoDescricaoPessoa(idUser, indiceRoupa).equals(usuario.getRoupaDescricao(i)) ) {
									   System.out.println("indice i = " + i);
									   usuario.excluirProdutoRoupa(i);
									   modelProdutos.remove(i);
								   }
							   }
							   
							   	//elimina a roupa do home e do usuario
						    	modelEditarProdutos.remove(indiceRoupa);
						    	usuario.excluirRoupa(idUser, indiceRoupa);
						    	
						    	qtdRoupasUsuario--;
						    	
//						    int qtd = usuario.getQuantidadeProdutosPessoa(idUser);
						    System.out.println("qtd de roupas  ==-=@ "+ qtdRoupasUsuario);
						    
//						    for(int k=0; k<qtdRoupasUsuario; k++) {
//						    	System.out.println(usuario.getProdutoDescricaoPessoa(idUser, k));
//						    }
						    
						 
					        	
						}
					  }
				   );
		  
	}
	
	
/*####################### PAINEL EDITAR PRODUTOS ############################*/
	
	public void divEditarProdutos() {
		
		janela.add(panelEditarProdutos);
		panelEditarProdutos.setVisible(true);
		
		panelEditarProdutos.setLayout(null);
		janela.setSize(600, 500);
		
		/*
		* set o width e height do obj.
		* (loc x, loc y do titulo na window. || width e height do titulo)
		*/
		
		/*impoe a fonte do titulo(fonte, negrito e tamanho em px)*/
		tituloEditarProdutos.setFont(new Font("Arial", Font.BOLD, 17));
		tituloEditarProdutos.setBounds(25, 15, 250, 30);		
		panelEditarProdutos.add(tituloEditarProdutos);
		
		/*--------------------LABELS E TEXTFILELDS---------------------*/		
		
		/****************PRODUTO*******************/
		JLabel descricao = new JLabel("Descricao :");
		descricao.setFont(new Font("Arial", Font.BOLD, 15));
		descricao.setBounds(25, 45, 120, 30);
		panelEditarProdutos.add(descricao);
	
		JTextField descricaoText = new JTextField(120);
		descricaoText.setText(usuario.getProdutoDescricaoPessoa(idUser, indiceRoupa));
		descricaoText.setBounds(25, 75, 200, 30);
		panelEditarProdutos.add(descricaoText);
		
		JLabel marca = new JLabel("Marca :");
		marca.setFont(new Font("Arial", Font.BOLD, 15));
		marca.setBounds(25, 185, 120, 30);
		panelEditarProdutos.add(marca);
	
		JTextField marcaText = new JTextField(120);
		marcaText.setText(usuario.getProdutoMarcaPessoa(idUser, indiceRoupa));
		marcaText.setBounds(25, 215, 200, 30);
		panelEditarProdutos.add(marcaText);
		
		JLabel preco = new JLabel("Preco :");
		preco.setFont(new Font("Arial", Font.BOLD, 15));
		preco.setBounds(255, 45, 120, 30);
		panelEditarProdutos.add(preco);
	
		JTextField precoText = new JTextField(120);
		precoText.setText(Float.toString(usuario.getProdutoPrecoPessoa(idUser, indiceRoupa)) );
		precoText.setBounds(255, 75, 200, 30);
		panelEditarProdutos.add(precoText);
		
		JLabel condicao = new JLabel("Condicao :");
		condicao.setFont(new Font("Arial", Font.BOLD, 15));
		condicao.setBounds(255, 115, 120, 30);
		panelEditarProdutos.add(condicao);
	
		JTextField condicaoText = new JTextField(120);
		condicaoText.setText(usuario.getProdutoCondicaoPessoa(idUser, indiceRoupa));
		condicaoText.setBounds(255, 145, 200, 30);
		panelEditarProdutos.add(condicaoText);
		
		/***********************************/
		
		Roupa roupa = (Roupa) usuario.getProdutoPessoa(idUser, indiceRoupa);
		String desc = roupa.getDescricao();
		
		System.out.println("cor==== " + roupa.getCor());
		
		JLabel categoria = new JLabel("Categoria :");
		categoria.setFont(new Font("Arial", Font.BOLD, 15));
		categoria.setBounds(25, 115, 120, 30);
		panelEditarProdutos.add(categoria);
		
		String vetor[] = {"Roupa"};
		
		JComboBox combobox = new JComboBox(vetor);
		combobox.setBounds(25, 145, 200, 30);
		panelEditarProdutos.add(combobox);
		
		JLabel estilo = new JLabel("Estilo :");
		estilo.setFont(new Font("Arial", Font.BOLD, 15));
		estilo.setBounds(25, 255, 120, 30);
		panelEditarProdutos.add(estilo);
	
		JTextField estiloText = new JTextField(120);
		estiloText.setText(roupa.getEstilo());
		estiloText.setBounds(25, 285, 200, 30);
		panelEditarProdutos.add(estiloText);
		
		JLabel cor = new JLabel("Cor :");
		cor.setFont(new Font("Arial", Font.BOLD, 15));
		cor.setBounds(25, 325, 120, 30);
		panelEditarProdutos.add(cor);
	
		JTextField corText = new JTextField(120);
		corText.setText(roupa.getCor());
		corText.setBounds(25, 355, 200, 30);
		panelEditarProdutos.add(corText);
		
		JLabel tecido = new JLabel("Tecido :");
		tecido.setFont(new Font("Arial", Font.BOLD, 15));
		tecido.setBounds(255, 185, 120, 30);
		panelEditarProdutos.add(tecido);
	
		JTextField tecidoText = new JTextField(120);
		tecidoText.setText(roupa.getTecido());
		tecidoText.setBounds(255, 215, 200, 30);
		panelEditarProdutos.add(tecidoText);
		
		JLabel tamanho = new JLabel("Tamanho :");
		tamanho.setFont(new Font("Arial", Font.BOLD, 15));
		tamanho.setBounds(255, 255, 120, 30);
		panelEditarProdutos.add(tamanho);
	
		String tam[] = {"P", "M", "G"};
		
		JComboBox comboTam = new JComboBox(tam);
		comboTam.setBounds(255, 285, 200, 30);
		panelEditarProdutos.add(comboTam);
		
			
		/*--------------------BUTTONS---------------------*/
		
		  JButton SalvarRoupa = new JButton("Salvar roupa");
		  SalvarRoupa.setBounds(255, 345, 200, 35);
		  panelEditarProdutos.add(SalvarRoupa);
		  
		  SalvarRoupa.addActionListener(
				  new ActionListener(){
						 public void actionPerformed(ActionEvent e){
							 
							 try {
									boolean sucesso;
								
									float valor = Float.parseFloat(precoText.getText());
									int itemCombo = combobox.getSelectedIndex();
									int itemcomboTam = comboTam.getSelectedIndex();
									
									String category = null;
									String tam = null;
									
									if(itemCombo == 0) {
										category = "roupa";
									}
									
									if(itemcomboTam != -1) {
										if(itemcomboTam == 0) {
											tam = "P";
										}
										if(itemcomboTam == 1) {
											tam = "M";
										}
										if(itemcomboTam == 2) {
											tam = "G";
										}
									}
									
									//obtem a qtd roupas atualizada
									qtdRoupas = usuario.getQtdRoupas();;
									System.out.println("size === "+ qtdRoupas);
									int indice;
									
									for(indice = 0; indice < qtdRoupas; indice++) {
										
										System.out.println("elemento no home === "+ usuario.getRoupaDescricao(indice) );
																				
										if(desc.equals(usuario.getRoupaDescricao(indice)) )
										{
											break;
										}
									}
									
									System.out.println("indiceeeeeeee " + indice);
									
									sucesso = usuario.editarRoupa(indice, descricaoText.getText(), marcaText.getText(), valor, condicaoText.getText(), category, estiloText.getText(), corText.getText(), tecidoText.getText(), tam);
											
										if(sucesso == true) {
											JOptionPane.showMessageDialog(null, 
											"Roupa editada com sucesso\n", null, 
											JOptionPane.INFORMATION_MESSAGE);							
											
											
											modelEditarProdutos.setElementAt(usuario.getProdutoDescricaoPessoa(idUser, indiceRoupa), 0);
											for(int i=0; i<=indiceRoupa; i++) {
												System.out.println( "teste de bug == " +usuario.getProdutoDescricaoPessoa(idUser, i) );
											}
											
											//Atualiza o painel home da mudanca de roupa
											modelProdutos.setElementAt(usuario.getProdutoDescricaoPessoa(idUser, indiceRoupa), indice);
											
											//passa o valor null para os inputs ao finalizar a operacao
											descricaoText.setText(null);
											marcaText.setText(null);
											precoText.setText(null);
											condicaoText.setText(null);
											estiloText.setText(null);
											corText.setText(null);
											tecidoText.setText(null);
											
										}
									
							}catch(Exception ex){
										JOptionPane.showMessageDialog(null, 
										"Os campos nao foram preenchidos corretamente\n", null, 
										JOptionPane.INFORMATION_MESSAGE);
							}
					        	
						}
					  }
				   );
		  
	}
	
	
	/*####################### PAINEL PESQUISAR ############################*/
	
	public void divPesquisar() {
		
		janela.add(panelPesquisar);
		panelPesquisar.setVisible(true);
		
		panelPesquisar.setLayout(null);
		
		/*
		* set o width e height do obj.
		* (loc x, loc y do titulo na window. || width e height do titulo)
		*/
		
		/*impoe a fonte do titulo(fonte, negrito e tamanho em px)*/
		tituloPesquisar.setFont(new Font("Arial", Font.BOLD, 17));
		tituloPesquisar.setBounds(40, 10, 280, 30);		
		panelPesquisar.add(tituloPesquisar);
		
		/*----------------JList---------------*/
		/*
		 * Criacao do Jlist com scroll no panel 
		 */
		
		//Instancia o Jlist de Produtos cadastardos pelo usuario
		modelPesquisa = new DefaultListModel();
		JlistPesquisa = new JList<String>(modelPesquisa);
		srollPesquisa = new JScrollPane(JlistPesquisa);
		
		srollPesquisa.setBounds(280, 45, 150, 150);
		panelPesquisar.add(srollPesquisa);
		
		/*--------------------LABELS E TEXTFILELDS---------------------*/
		
		/***************PESSOA********************/
		JLabel nome = new JLabel("Nome do usuario procurado :");
		nome.setFont(new Font("Arial", Font.BOLD, 15));
		nome.setBounds(25, 45, 240, 30);
		panelPesquisar.add(nome);
	
		JTextField nomeText = new JTextField(120);
		nomeText.setBounds(25, 75, 200, 30);
		panelPesquisar.add(nomeText);
		
		JLabel nomeBuscado = new JLabel("Nome :");
		nomeBuscado.setFont(new Font("Arial", Font.BOLD, 15));
		nomeBuscado.setBounds(25, 115, 120, 30);
		panelPesquisar.add(nomeBuscado);
	
		JTextField nomeBuscadoText = new JTextField(120);
		nomeBuscadoText.setBounds(25, 145, 200, 30);
		panelPesquisar.add(nomeBuscadoText);
		
		
		/*--------------------BUTTONS---------------------*/
		
		  JButton Pesquisar = new JButton("Pesquisar");
		  Pesquisar.setBounds(65, 280, 180, 35);
		  panelPesquisar.add(Pesquisar);
		  
		  Pesquisar.addActionListener(
				  new ActionListener(){
						 public void actionPerformed(ActionEvent e){
							
							 //remove todos os elementos da lista ao iniciar
							 modelPesquisa.removeAllElements();
							 
							//obtem os nomes e a quantidade de usuarios no sistema 
							String user[] = usuario.escreveUsuarios();
							int qtdUser = usuario.getQtdPessoas();
							
							//caso um dos nomes seja igual ao do textfield, retorna para nomeBuscadoText
							for(int i=0; i<qtdUser; i++) {
								if(nomeText.getText().equals(user[i])) {
									nomeBuscadoText.setText(user[i]);
									
									int iduser = usuario.getIdUser(i);
									int qtdProdPessoa = usuario.getQuantidadeProdutosPessoa(iduser);
									
									for(int k=0; k<qtdProdPessoa; k++) {
										modelPesquisa.addElement(usuario.getProdutoDescricaoPessoa(iduser, k) );
									}
									
								}
							}
							
							
							
						}
					  }
				   );
		  
	}
	
	
	/*====================Metodos SETVISIBLE(FALSE)=======================*/
	
	public void divHomeNotVisible(){
		panelHome.setVisible(false);
		
	}
	
	public void panelCarrinhoNotVisible(){
		panelCarrinho.setVisible(false);	
	}
	
	public void panelFavoritoNotVisible(){
		panelFavoritos.setVisible(false);	
	}
	
	public void panelPerfilNotVisible(){
		panelPerfil.setVisible(false);
		janela.setSize(600, 400);
	}
	
	public void panelAddProdutosNotVisible(){
		panelAddProdutos.setVisible(false);
		janela.setSize(600, 400);
	}
	
	public void panelEditarExcluirProdutosNotVisible(){
		panelEditarExcluirProdutos.setVisible(false);
	}
	
	public void panelEditarProdutosNotVisible(){
		panelEditarProdutos.setVisible(false);
		janela.setSize(600, 400);
	}
	
	public void panelPesquisarNotVisible(){
		panelPesquisar.setVisible(false);
	}
	
	/*=======================CONSTRUTOR DA TELA===========================*/
	
	/*
	 * O CONSTRUTOR INSTANCIA O MENU JUNTO COM SEUS COMPONENTES 
	 */
	
	public TelaMenu(){	
		
		/*
		 *	JMenuBar == instancia a barra de menu  
		 */
		JMenuBar barraMenu = new JMenuBar();
		
		
		/*
		 * Acrescenta a barra de menu no frame
		 */
		janela.setJMenuBar(barraMenu);
		
		
		//isntancia os itens submenu
		JMenuItem itemPerfil = new JMenuItem("Perfil");
		JMenuItem itemAddProdutos = new JMenuItem("Adicionar produtos");
		JMenuItem itemEditarProdutos = new JMenuItem("Editar produtos");
		
		//adiciona os itens submenu em cada componente do menu
		perfil.add(itemPerfil);
		perfil.add(itemAddProdutos);
		perfil.add(itemEditarProdutos);
		
		//acrescenta os componentes na barra de menu
		barraMenu.add(home);
		barraMenu.add(perfil);
		barraMenu.add(menuCarrinho);
		barraMenu.add(menuFavoritos);
		barraMenu.add(menuPesquisa);
		
		
		//-------------evento de clique nos itens(submenu)----------------
		
		/*
		* ActionListener: verifica se o usuario clicou em algum dos
		* buttons criados
		*/
		
		itemPerfil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            	divHomeNotVisible();
            	panelFavoritoNotVisible();
            	panelCarrinhoNotVisible();
            	panelAddProdutosNotVisible();
            	panelEditarExcluirProdutosNotVisible();
            	panelEditarProdutosNotVisible();
            	panelPesquisarNotVisible();

            	divPerfil();
            }
        });
		
		itemAddProdutos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            	divHomeNotVisible();
            	panelFavoritoNotVisible();
            	panelCarrinhoNotVisible();
            	panelPerfilNotVisible();
            	panelEditarExcluirProdutosNotVisible();
            	panelEditarProdutosNotVisible();
            	panelPesquisarNotVisible();

            	divAddProdutos();
            }
        });
		
		itemEditarProdutos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	divHomeNotVisible();
            	panelFavoritoNotVisible();
            	panelCarrinhoNotVisible();
            	panelAddProdutosNotVisible();
            	panelPerfilNotVisible();
            	panelEditarProdutosNotVisible();
            	panelPesquisarNotVisible();
            	
            	divEditarExcluirProdutos();
            }
        });
		
		
		//----------------evento de clique nos Menus------------------
		
		/*
		* addMenuListener: verfica se o usuario clicou no Jmenu.
		* O menu ao ser clicado chama o metodo ListenerMenus
		*/
		menuCarrinho.addMenuListener(new ListenerMenus());
		menuFavoritos.addMenuListener(new ListenerMenus());
		home.addMenuListener(new ListenerMenus());
		menuPesquisa.addMenuListener(new ListenerMenus());
		
	}
	
	
	/*=====================METODO LISTENER DO MENU=========================*/
	
	class ListenerMenus implements MenuListener {
		
	    @Override
	    public void menuSelected(MenuEvent e) {
	    	
	    	//getSource pega o nome do Menu que chamou o evento
	        if(e.getSource().equals(menuCarrinho) ) {
	        	
	        	//retira os panels
	        	divHomeNotVisible();
	        	panelFavoritoNotVisible();
	        	panelPerfilNotVisible();
	        	panelAddProdutosNotVisible();
	        	panelEditarExcluirProdutosNotVisible();
            	panelEditarProdutosNotVisible();
            	panelPesquisarNotVisible();
	        	
	        	//aloca o panel Carrinho
            	painelCarrinho();

	        }
	        if(e.getSource().equals(menuFavoritos) ) {
	        	
	        	//retira os panels
	        	divHomeNotVisible();
	        	panelCarrinhoNotVisible();
	        	panelPerfilNotVisible();
	        	panelAddProdutosNotVisible();
	        	panelEditarExcluirProdutosNotVisible();
            	panelEditarProdutosNotVisible();
            	panelPesquisarNotVisible();
	        	
	        	//aloca o panel Favoritos
	        	divFavorito();
	        }
	        
	        if(e.getSource().equals(home) ) {
	        	
	        	//retira os panels
	        	panelCarrinhoNotVisible();
	        	panelFavoritoNotVisible();
	        	panelPerfilNotVisible();
	        	panelAddProdutosNotVisible();
	        	panelEditarExcluirProdutosNotVisible();
            	panelEditarProdutosNotVisible();
            	panelPesquisarNotVisible();
	        	
	        	//instancia a visibilidade do panelHome
	        	panelHome.setVisible(true);
	        	
	        }
	        
	        if(e.getSource().equals(menuPesquisa) ) {
	        	
	        	//retira os panels
	        	divHomeNotVisible();
	        	panelCarrinhoNotVisible();
	        	panelFavoritoNotVisible();
	        	panelPerfilNotVisible();
	        	panelAddProdutosNotVisible();
	        	panelEditarExcluirProdutosNotVisible();
            	panelEditarProdutosNotVisible();
	        	
	        	//instancia a visibilidade do panelHome
            	divPesquisar();
	        	
	        }
	    }

	    @Override
	    public void menuDeselected(MenuEvent e) {
	    	if(e.getSource().equals(menuCarrinho) ) {
	        	System.out.println("saiu carrinho");

	        }
	        if(e.getSource().equals(menuFavoritos) ) {
	        	System.out.println("saiu favoritos");
	        }
	    }

	    @Override
	    public void menuCanceled(MenuEvent e) {
	        System.out.println("menuCanceled");
	    }
	}	
	
}
