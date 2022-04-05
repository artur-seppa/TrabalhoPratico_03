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
	
	private static TelaMenu telaMenu = new TelaMenu();	//instancia o objeto da telaMenu
	private static ControleUsuario usuario;		//instancia o TIPO ControleUsuario === BD

	/*
	 * Criacao do JList: recebe a String Lista para imprimir no swing)
	 */
	private static String[] listaProdutos = new String[100];
	private JList<String> JlistProdutos;
	
	private static String[] ListaCarrinho = new String[100];
	private JList<String> JlistCarrinho;
	private DefaultListModel model = new DefaultListModel();
	private JScrollPane srollCarrinho = new JScrollPane();
	
	private static String[] ListaFavorito = new String[100];
	private JList<String> JlistFavorito;
	private DefaultListModel modelFavorito = new DefaultListModel();
	private JScrollPane srollFavorito = new JScrollPane();
	
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
	private static int qtdProdutos = 0;
	private static int qtdProdutosFavoritos = 0;
	
	/*
	 * JMenu permite instanciar os arquivos clicaveis da
	 * barra de menu 
	 */
	JMenu home = new JMenu("Home");
	JMenu perfil = new JMenu("Perfil");
	JMenu menuCarrinho = new JMenu("carrinho de compras"); 
	JMenu menuFavoritos = new JMenu("Roupas Favoritas");
	
	
	public void imprimirTelaMenu(ControleUsuario u, int idUsuario){
		
		/*
		 * Obtem o "BD" criado na tela anterior, com seus users ja pre fabricados,
		 * e passa essa configuracao ao obj usuario de mesmo tipo ControleUsuario
		 */
		usuario = u;
		idUser = idUsuario;
		
		
		/*
		 * Pega os usuarios instanciados dentro do BD e passa para 
		 * o JList usuarios
		 */
		try {
			
			int qtd = usuario.getQtdRoupas();
			listaProdutos = usuario.escreveProdutos();
			
			System.out.println("ddd do user == "+ usuario.getCep(idUser));
			
			String[] user = usuario.escreveUsuarios();
			int qtdpessoa = usuario.getQtdPessoas();
			
			for(int i = 0; i<qtdpessoa; i++) {
				System.out.println(user[i]);
			}		
				
			
		}catch(Exception ex){
//			JOptionPane.showMessageDialog(null, 
//			"Erro: " + ex + "\n", null, 
//			JOptionPane.INFORMATION_MESSAGE);
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
		
		JlistProdutos = new JList(listaProdutos);
				
		JScrollPane scrollPane = new JScrollPane(JlistProdutos);
		scrollPane.setBounds(40, 50, 500, 200);
		
		panelHome.add(scrollPane);
		
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
					 
					 usuario.AdicionarFavorito(idUser, indice);
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
				      			        	
				        	new TelaCompra().imprimirTelaCompra(/*usuario, idUser, size*/);
			        	
			        	}else {
			        		
			        		JOptionPane.showMessageDialog(null, 
					    	"Insira produtos no carrinho para efetuar a compra\n", null, 
					    	JOptionPane.INFORMATION_MESSAGE);
			        		
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
				        	usuario.RemoveProdutoCarrinho(idUser, remover);
				        	model.remove(remover);
				        	
				        	//garante que todos os produtos sejam removidos do carrinho
				         	if(qtdProdutos == 1) {
				        		usuario.RemoveTodosCarrinho(qtdProdutos , idUser);
				        	}
				        	
				        	qtdProdutos--;
				        	
//				        	//garante que todos os produtos sejam removidos do carrinho
//				         	if(qtdProdutos == 0) {
//				        		usuario.RemoveTodosCarrinho(qtdProdutos , idUser);
//				        	}
				        	
				        	System.out.println("qtd produtosa agora == " + qtdProdutos);
				        	System.out.println("indice remover agora == " + remover);
				        	
				        	/*
				        	 * AO EXCLUIR UM PRODUTO, ATUALIZA O FECHAMENTO DA COMPRA
				        	 */
				        	
				        	int size = model.getSize();
				        	float total = 0;
				        	
				        	if(size != 0) {
					        	
						        	for(int i=0; i<size; i++) {
		//								System.out.println("PRODUTO a ser comprado " + usuario.getProdutoCarrinho(idUser, i));
		//								System.out.println("preco === " + usuario.getProdutoValor(idUser, i));
										total = total + usuario.getProdutoValor(idUser, i);
						        	}
						        	
						        	//instancia o valor total dos produto
						        	valorTotal.setText("total == " + total);
						        	valorTotal.setText("Valor total: R$" + total);
						        	endereco.setText("Endereco de entrega :");
						        	enderecoLabel.setText( usuario.getEndereco(idUser));
						        	frete.setText("Valor de frete : " + aleatorio);
						        	
						        	new TelaCompra().imprimirTelaCompra(/*usuario, idUser, size*/);
				        	}else {
					        		
				        	}
				        	
				        	
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
		  
//		FavoritoAddCarrinho.setBounds(190, 270, 170, 35);
//		  panelFavoritos.add(FavoritoAddCarrinho);
		  
		  //NAO ESTA FUNCIONANDO DIREITO, VERIFICAR O PORQUE
		  
//		  FavoritoAddCarrinho.addActionListener(
//				  new ActionListener(){
//						 public void actionPerformed(ActionEvent e){
//							        	
//							 // Um botão que permite obter o índice do item selecionado
//							 int indice = JlistFavorito.getSelectedIndex();
//							 
//							 usuario.AdicionarCompra(idUser, indice);
//							 qtdProdutos = usuario.QtdProduto(idUser);
//							 
//							 System.out.println("indice do button carrinho == "+indice);
//							 System.out.println("qtd produtos do button carrinho == "+qtdProdutos);
//							 System.out.println("produto no carrinh  == "+ usuario.getProdutoCarrinho(idUser, qtdProdutos-1));
//							 
//							 for(int i=0; i<qtdProdutos; i++) {
//									System.out.println("PRODUTOOOOO ======" + usuario.getProdutoCarrinho(idUser, i));
//								}
//							 
//							 //ADICIONA O NOVO PRODUTO NA JLIST DO CARRINHO
//							 model.addElement(usuario.getProdutoCarrinho(idUser, qtdProdutos-1));
//							 
//						}
//					  }
//				   );
		  
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
						        		usuario.RemoveTodosFavoritos(qtdProdutosFavoritos , idUser);
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
		JMenuItem itemConfiguracao = new JMenuItem("Configuracao");
		JMenuItem itemSair = new JMenuItem("Sair");
		
		//adiciona os itens submenu em cada componente do menu
		perfil.add(itemConfiguracao);
		perfil.add(itemSair);
		
		//acrescenta os componentes na barra de menu
		barraMenu.add(home);
		barraMenu.add(perfil);
		barraMenu.add(menuCarrinho);
		barraMenu.add(menuFavoritos);
		
		
		//-------------evento de clique nos itens(submenu)----------------
		
		/*
		* ActionListener: verifica se o usuario clicou em algum dos
		* buttons criados
		*/
		itemSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//            	JOptionPane.showMessageDialog(null, 
//    			"Entrou\n", null, 
//    			JOptionPane.INFORMATION_MESSAGE);
            	divHomeNotVisible();
            	
            	painelCarrinho();
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
	        	
	        	//aloca o panel Carrinho
            	painelCarrinho();

	        }
	        if(e.getSource().equals(menuFavoritos) ) {
	        	
	        	//retira os panels
	        	divHomeNotVisible();
	        	panelCarrinhoNotVisible();
	        	
	        	//aloca o panel Favoritos
	        	divFavorito();
	        }
	        
	        if(e.getSource().equals(home) ) {
	        	
	        	//retira os panels
	        	panelCarrinhoNotVisible();
	        	panelFavoritoNotVisible();
	        	
	        	//instancia a visibilidade do panelHome
	        	panelHome.setVisible(true);
	        	
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
