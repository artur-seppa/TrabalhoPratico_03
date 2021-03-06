package View;
import Controle.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * 	JFrame == window que abre na tela do usuario
 * 	Jlabel == permite escreve na window(JFrame) em qualquer lugar
 * 	JButton == cria os objetos buttons	
 * 
 * 	Para cada classe swing chamada, instanciamos os seus objetos
 * 	com seus respectivos atributos e metodos das classes. 
 */

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaPrincipal implements ActionListener{
	
	/*
	 * ---->classes swing(GUI)
	 */
	
	/*
	* 	JFrame == window que abre na tela do usuario
	* 	Jlabel == permite escreve na window(JFrame) em qualquer lugar
	* 	JButton == cria os objetos buttons	
	* 
	* 	Para cada classe swing chamada, instanciamos os seus objetos
	* 	com seus respectivos atributos e metodos das classes. 
	* 
	* @author Arthur Seppa Reiman
	* @author Amanda Fernandes Custodio
	*/
	
	/*Banco de dados instanciado*/
	private static ControleUsuario usuario = new ControleUsuario();
//	private static ControleDados dados = new ControleDados();
//	private static ControlePessoaTeste cpessoa = new ControlePessoaTeste(dados);
	
	private static JFrame janela = new JFrame("Menu");
	private static JButton cadastroUsuario = new JButton("Cadastrar");
	private static JButton loginButton = new JButton("Entrar");
	private static JTextField userText = new JTextField(20);
	private static JPasswordField passwordText = new JPasswordField(20);
	private static JLabel titulo = new JLabel("Roupas e Acessorios");
	private static JPanel panel = new JPanel();
	
	public void VoltarTelaPrincipal(ControleUsuario u) {
		usuario = u;
	}
	
	public TelaPrincipal(){		
		janela.setVisible(true);
		
		janela.setSize(400, 340);
		janela.add(panel);
		placeComponents(panel);
		
		/*
		 * Ao clicar no 'x' a janela fecha
		 */
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/*
	 * nao pode ter main, procure na tela pessoa
	 */

	private static void placeComponents(JPanel panel) {

		panel.setLayout(null);
		
		/*
		* set o width e height do obj.
		* (loc x, loc y do titulo na window. || width e height do titulo)
		*/
		
		/*impoe a fonte do titulo(fonte, negrito e tamanho em px)*/
		titulo.setFont(new Font("Arial", Font.BOLD, 19));
		titulo.setBounds(90, 10, 250, 30);		
		panel.add(titulo);

		JLabel userLabel = new JLabel("Usuario:");
		userLabel.setFont(new Font("Arial", Font.BOLD, 15));
		userLabel.setBounds(130, 50, 140, 30);
		panel.add(userLabel);

        //JTextField userText = new JTextField(20);
		//userText.setFont(new Font("Arial", Font.BOLD, 16));
		userText.setBounds(130, 80, 140, 30);
		panel.add(userText);

		JLabel passwordLabel = new JLabel("Senha:");
		passwordLabel.setFont(new Font("Arial", Font.BOLD, 15));
		passwordLabel.setBounds(130, 120, 140, 30);
		panel.add(passwordLabel);

//		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(130, 150, 140, 30);
		panel.add(passwordText);

//		JButton loginButton = new JButton("Entrar");
		loginButton.setBounds(50, 210, 140, 30);
		panel.add(loginButton);
		
		//JButton cadastroUsuario = new JButton("register");
		cadastroUsuario.setBounds(210, 210, 140, 30);
		panel.add(cadastroUsuario);
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
		cadastroUsuario.addActionListener(menu);
		loginButton.addActionListener(menu);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == cadastroUsuario) {
			/*
			 * TEM QUE PASSAR O BD PARA NAO PERDER A CONFIGURACAO do construtor
			 */
			/*
			 * e usuarios ja fabricados
			 */
			new CadastroUsuario().imprimirTelaCadastro(usuario);
//			new CadastroUsuario().imprimirTelaCadastro(dados);
		}
		
		if(src == loginButton) {
			int sucesso;
			
			try {
				String password = String.valueOf(passwordText.getPassword());
				sucesso = usuario.logarUsuario(userText.getText(), /*sexo,*/ password/*, email, cpf, ddd, telefone, estado, cidade, endereco*/);

				if(sucesso != -1) {
					
					/*
					 * fecha a janela quando logar o usuario
					 */
					janela.setVisible(false);
					
					/*
					 * TEM QUE PASSAR O BD PARA NAO PERDER A CONFIGURACAO do construtor
					 */
					/*
					 * e usuarios ja fabricados
					 */
					new TelaMenu().imprimirTelaMenu(usuario, sucesso);
					
//					String teste;
//					Pessoa pessoa[] = new Pessoa[100]; 
//					pessoa = usuario.retornaStringPessoa();
//					int qtd = usuario.getQtdPessoas();
//					
//					for(int i = 0; i<qtd; i++) {
//						System.out.println(pessoa[i].getNome());
//					}
					
					
				}else{
					JOptionPane.showMessageDialog(null, 
					"tente novamente\n", null, 
					JOptionPane.INFORMATION_MESSAGE);
				}
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, 
				"Erro: " + ex + "\n", null, 
				JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
