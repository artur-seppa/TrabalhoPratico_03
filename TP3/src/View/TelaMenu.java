package View;
import Controle.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaMenu implements ActionListener{
	
	private static JFrame janela = new JFrame("Roupas e Acessorios");
	
	private static TelaMenu telaMenu = new TelaMenu();	//instancia o objeto da telaMenu
	private static ControleUsuario usuario;		//instancia o TIPO ControleUsuario === BD
	
	public void imprimirTelaMenu(ControleUsuario u){
		
		/*
		 * Obtem o "BD" criado na tela anterior, com seus users ja pre fabricados,
		 * e passa essa configuracao ao obj usuario de mesmo tipo ControleUsuario
		 */
		usuario = u;
		
		janela.setVisible(true);
		janela.setSize(600, 400);
		
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
		
		
		/*
		 * JMenu permite instanciar os arquivos clicaveis da
		 * barra de menu 
		 */
		JMenu perfil = new JMenu("Perfil");
		JMenu menuCarrinho = new JMenu("carrinho de compras"); 
		JMenu menuFavoritos = new JMenu("Roupas Favoritas");
		
		//isntancia os itens submenu
		JMenuItem itemConfiguracao = new JMenuItem("Configuracao");
		JMenuItem itemSair = new JMenuItem("Sair");
		
		//adiciona os itens submenu em cada componente do menu
		perfil.add(itemConfiguracao);
		perfil.add(itemSair);
		
		//acrescenta os componentes na barra de menu
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
            	JOptionPane.showMessageDialog(null, 
    			"Entrou\n", null, 
    			JOptionPane.INFORMATION_MESSAGE);
            }
        });
		
	}
	

	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
//		if(src == itemSair) {
//			
//		}
	}	
}
