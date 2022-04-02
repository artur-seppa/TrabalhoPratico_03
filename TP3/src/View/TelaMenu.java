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

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class TelaMenu implements ActionListener{
	
	private static JFrame janela = new JFrame("Roupas e Acessorios");
	
	/*
	 * Criacao de Jpanel's
	 */
	private static JPanel panelHome = new JPanel();
	private static JLabel tituloHome = new JLabel("Home");
	
	private static JPanel panelRoupas = new JPanel();
	private static JLabel tituloRoupas = new JLabel("Roupas");
	
	private static JPanel panelCarrinho = new JPanel();
	private static JLabel tituloCarrinho = new JLabel("Carrinho");
	
	private static TelaMenu telaMenu = new TelaMenu();	//instancia o objeto da telaMenu
	private static ControleUsuario usuario;		//instancia o TIPO ControleUsuario === BD

	/*
	 * Criacao do JList 
	 */
	private static String[] listaProdutos = new String[100];
	/*JList recebe a string listaNomes para ser colocado dentro*/
	private JList<String> JlistProdutos;
	
	private static String[] ListaCarrinho = new String[100];
	/*JList recebe a string listaNomes para ser colocado dentro*/
	private JList<String> JlistCarrinho;
	private DefaultListModel model = new DefaultListModel();
	private JScrollPane srollCarrinho = new JScrollPane();
	
	/*
	 * Criacao dos Buttons associados ao JList
	 */
	private static JButton buttonDetalhes = new JButton("Ver detalhes");
	private static JButton buttonCarrinho = new JButton("Inserir no carrinho");
	private static JButton buttonfavoritos = new JButton("Inserir favoritos");
	
	private static JButton compra = new JButton("Fechar compra");
	private static JButton excluirPcarrinho = new JButton("Excluir Produto");
	
	/*
	 *	variaveis Globais  
	 */
	private static int idUser;
	private static int qtdProdutos;
	private static CarrinhoDeCompra[] compras = new CarrinhoDeCompra[100];
	
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
		 *	O usuario ao logar ja tem o seeu carrinho atualizado com 
		 *	pedidos anteriores 
		 */
		qtdProdutos = usuario.QtdProduto(idUser);
//		int qtdProdutos = usuario.QtdProduto(idUser);
//				ListaCarrinho = usuario.escreveProdutosCarrinho(qtdProdutos, idUser);
		
		model = new DefaultListModel();
		JlistCarrinho = new JList<String>(model);
		srollCarrinho = new JScrollPane(JlistCarrinho);
		
				for(int i=0; i<qtdProdutos; i++) {
					model.addElement(usuario.getProdutoCarrinho(idUser, i));
				}
		
		System.out.println(idUser);
		System.out.println("qtdprodutos do inicio == "+qtdProdutos);
		
		/*
		 * Pega os usuarios instanciados dentro do BD e passa para 
		 * o JList usuarios
		 */
		try {
			
			int qtd = usuario.getQtdRoupas();
			listaProdutos = usuario.escreveProdutos();
			
//			for(int i = 0; i<qtd; i++) {
//				System.out.println(listaUsuarios[i]);
//			}		
				
			
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, 
			"Erro: " + ex + "\n", null, 
			JOptionPane.INFORMATION_MESSAGE);
		}
		
		janela.setVisible(true);
		janela.setSize(600, 400);
		
		//inicia o panel home
		divHome();
		
	}
	
	public void divHomeNotVisible(){
		panelHome.setVisible(false);
		
	}
	
	public void panelCarrinhoNotVisible(){
		panelCarrinho.setVisible(false);
		
	}
	
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
		tituloCarrinho.setBounds(0, 15, 250, 30);		
		panelCarrinho.add(tituloCarrinho);
		
		/*-------------JList------------*/
		
		/*
		 * Instancia o scroll do Jlist carrinho no panel 
		 */
		
		srollCarrinho.setBounds(40, 50, 500, 200);
		panelCarrinho.add(srollCarrinho);
		
		
		/*--------------------BUTTONS---------------------*/
		  compra.setBounds(190, 270, 170, 35);
		  panelCarrinho.add(compra);
		  
		  excluirPcarrinho.addActionListener(
			      new ActionListener(){
			        public void actionPerformed(ActionEvent e){

			        	
			   	    
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
				        	
				        	qtdProdutos--;
				        	
				        	System.out.println("qtd produtosa agora == " + qtdProdutos);
				        	System.out.println("indice remover agora == " + remover);
				        	
				        	for(int i=0; i<qtdProdutos; i++) {
								System.out.println(usuario.getProdutoCarrinho(idUser, i));
							}
			        	
			        	}catch(Exception ex){
//			    			JOptionPane.showMessageDialog(null, 
//			    					"Erro: " + ex + "\n", null, 
//			    					JOptionPane.INFORMATION_MESSAGE);
			    		}
			   	    
			        }
			      }
			    );
		
	}
	
	public void divHome(/*String[] listaUsuarios*/) {
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
		
		/*-------------JList------------*/
		/*
		 * Criacao do Jlist com scroll no panel 
		 */
		
		JlistProdutos = new JList(listaProdutos);
				
		JScrollPane scrollPane = new JScrollPane(JlistProdutos);
		scrollPane.setBounds(40, 50, 500, 200);
		
		panelHome.add(scrollPane);
		
		/*-------------Buttons------------*/
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
					          
					 //antes de tudo os JLabels do DetalheProduto sao limpados
//					 new DetalheProduto().Close();
//					 new DetalheProduto().imprimirTelaDetalhe(usuario, indice);
				}
			  }
		   );
		
	}
	
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
		
		
		//============evento de clique nos itens(submenu)==============
		
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
	
	
	class ListenerMenus implements MenuListener {
		
	    @Override
	    public void menuSelected(MenuEvent e) {
	    	
	    	//getSource pega o nome do Menu que chamou o evento
	        if(e.getSource().equals(menuCarrinho) ) {
	        	
	        	//retira o panel Home
	        	divHomeNotVisible();
	        	
	        	//aloca o panel Carrinho
            	painelCarrinho();

	        }
	        if(e.getSource().equals(menuFavoritos) ) {
	        	System.out.println("favoritos");
	        }
	        
	        if(e.getSource().equals(home) ) {
	        	
	        	panelCarrinhoNotVisible();
	        	
	        	panelHome.setVisible(true);
	        	System.out.println("entrou home");
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
	
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
//		if(src == buttonDetalhes) {
//
//			JOptionPane.showMessageDialog(null, 
//	    			"Entrou button\n", null, 
//	    			JOptionPane.INFORMATION_MESSAGE);
//			System.out.println("entrou carrinho");
			
//			new DetalheProduto().imprimirTelaDetalhe(usuario);
//		}
	}
	
}
