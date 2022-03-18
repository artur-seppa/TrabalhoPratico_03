package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;

//acho q importa o package pacote
//======import controle.*;

public class TelaPrincipal implements ActionListener {
	
	//---->classes swing(GUI)
	/*
	 * 	JFrame == window que abre na tela do usuario
	 * 	Jlabel == permite escreve na window(JFrame) em qualquer lugar
	 * 	JButton == cria os objetos buttons	
	 * 
	 * 	Para cada classe swing chamada, instanciamos os seus objetos
	 * 	com seus respectivos atributos e metodos das classes. 
	 */
	private static JFrame janela = new JFrame("Enjoei");
	private static JLabel titulo = new JLabel("Menu Principal");
	private static JButton usuario = new JButton("Usuario");
	private static JButton roupa = new JButton("Roupas");
	private static JButton favoritos = new JButton("Lista de Favoritos");
	private static JButton carrinho = new JButton("Carrinho de Compras");
	// importa os dados aleatorios no view
	//======public static ControleDados dados = new ControleDados();
	
	
	//----> Construtor da view
	/* impomos os valores default dos atributos dos objetos swing  */
	
	public TelaPrincipal() {
		
		//set a fonte do titulo(fonte, negrito e tamanho em px)
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		
		//set o width e height do obj.
		//(loc x, loc y do titulo na window. || width e height do titulo)
		titulo.setBounds(115, 10, 170, 30);
		usuario.setBounds(130, 60, 140, 30);
		roupa.setBounds(130, 110, 140, 30);
		favoritos.setBounds(130, 160, 140, 30);
		carrinho.setBounds(130, 210, 140, 30);
		
		//a window nao obtem nenhum layout
		janela.setLayout(null);
		
		//adiciona o titulo e botoes para dentro da window
		janela.add(titulo);
		janela.add(usuario);
		janela.add(roupa);
		janela.add(favoritos);
		janela.add(carrinho);
		
		//set o widht e height da window(JFrame)
		janela.setSize(400, 320);
		//Ao clicar no 'x' a janela fecha
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//set a janela como visivel
		janela.setVisible(true);
	}
	
	public static void main(String[] args) {
		/*
		 * Na main instanciamos o obj menu da classe TelaPrincipal
		 * e assim o nosso construtor passa a existir na aplicacao
		*/
		TelaPrincipal menu = new TelaPrincipal();
		
	/*
	* ActionListener: verifica se o usuario clicou em algum dos
	* buttons criados
	*/
		usuario.addActionListener(menu);
		roupa.addActionListener(menu);
		favoritos.addActionListener(menu);
		carrinho.addActionListener(menu);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		/*
		 * getSource: pega o valor de qual button foi clicado pelo
		 * usuario e passa a variavel 'src' este valor
		 */
		Object src = e.getSource();
		
		
		/*
		 * de forma geral, caso entre no if chama o metodo 
		 * mostrarDados da class view TelaPessoa e passa dentro
		 * do metodo os parametros(obj dados, numero). 
		 */
		if(src == usuario) {
			//new TelaPessoa().mostrarDados(dados, 1);
		}
		if(src == roupa) {
			//new TelaPessoa().mostrarDados(dados, 2);
		}
		if(src == favoritos) {
			//new TelaPessoa().mostrarDados(dados, 3);
		}
		if(src == carrinho) {
			
			/*
			 * Janela de dialogo: pra este caso abre uma window com a msg abaixo 
			 * para o usuario
			 */
			JOptionPane.showMessageDialog(null, 
					"Ainda precisam ser implementadas as funcionalidades do carrinho\n", null, 
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
