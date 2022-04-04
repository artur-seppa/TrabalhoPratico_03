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

public class CadastroUsuario implements ActionListener{
	
	//---->classes swing(GUI)
	
	/*
	* 	JFrame == window que abre na tela do usuario
	* 	Jlabel == permite escreve na window(JFrame) em qualquer lugar
	* 	JButton == cria os objetos buttons	
	* 
	* 	Para cada classe swing chamada, instanciamos os seus objetos
	* 	com seus respectivos atributos e metodos das classes. 
	*/
	
//	private static ControleUsuario pessoa = new ControleUsuario();
	
	private static JFrame janela = new JFrame("Cadastrar");
	private static JPanel panel = new JPanel();
	private static JLabel titulo = new JLabel("Cadastro de usuario");
	
	private static JButton cadastroUsuario = new JButton("Cadastrar");
	private static JButton loginButton = new JButton("Entrar");
	
	private static JTextField nomeText = new JTextField(20);
	private static JPasswordField passwordText = new JPasswordField(20);
	
	private static JTextField telefoneText = new JTextField(9);
	private static JTextField dddText = new JTextField(3);
	
	private static JTextField enderecoText = new JTextField(50);
	private static JTextField cidadeText = new JTextField(20);
	private static JTextField estadoText = new JTextField(20);
	private static JTextField bairroText = new JTextField(20);
	private static JTextField cepText = new JTextField(9);
	
	
	//instancia o TIPO ControleUsuario === BD
	private static ControleUsuario usuario;
//	private static ControleDados dados;
	private static CadastroUsuario objCadastro = new CadastroUsuario();
//									ControleDados
	public void imprimirTelaCadastro(ControleUsuario u){
	    
		/*
		 * Obtem o "BD" criado na tela anterior, com seus users ja pre fabricados,
		 * e passa essa configuracao ao obj usuario de mesmo tipo ControleUsuario
		 */
		usuario = u;
//		dados = u;
		
		janela.setVisible(true);
		
		janela.setSize(400, 710);
		janela.add(panel);
		placeComponents(panel);
		
	}

	//nao pode ter main, procure na tela pessoa

	private static void placeComponents(JPanel panel) {

		panel.setLayout(null);
		
		/*
		* set o width e height do obj.
		* (loc x, loc y do titulo na window. || width e height do titulo)
		*/
		
		/*impoe a fonte do titulo(fonte, negrito e tamanho em px)*/
		titulo.setFont(new Font("Arial", Font.BOLD, 17));
		titulo.setBounds(100, 10, 250, 30);		
		panel.add(titulo);

		/*=========Nome==========*/
		JLabel userLabel = new JLabel("Digite o seu nome :");
		userLabel.setFont(new Font("Arial", Font.BOLD, 15));
		userLabel.setBounds(20, 50, 160, 30);
		panel.add(userLabel);

		nomeText.setBounds(20, 80, 160, 30);
		panel.add(nomeText);

		/*=========Senha==========*/
		JLabel passwordLabel = new JLabel("digite a senha :");
		passwordLabel.setFont(new Font("Arial", Font.BOLD, 15));
		passwordLabel.setBounds(20, 120, 160, 30);
		panel.add(passwordLabel);

		passwordText.setBounds(20, 150, 160, 30);
		panel.add(passwordText);
		
		/*=========DDD==========*/
		JLabel dddlabel = new JLabel("DDD :");
		dddlabel.setFont(new Font("Arial", Font.BOLD, 15));
		dddlabel.setBounds(20, 190, 160, 30);
		panel.add(dddlabel);

		dddText.setBounds(20, 220, 50, 30);
		panel.add(dddText);
		
		/*=========telefone==========*/
		JLabel telelabel = new JLabel("Telefone :");
		telelabel.setFont(new Font("Arial", Font.BOLD, 15));
		telelabel.setBounds(90, 190, 140, 30);
		panel.add(telelabel);

		telefoneText.setBounds(90, 220, 140, 30);
		panel.add(telefoneText);
		
		/*=========estado==========*/
		JLabel estadolabel = new JLabel("Estado :");
		estadolabel.setFont(new Font("Arial", Font.BOLD, 15));
		estadolabel.setBounds(20, 260, 140, 30);
		panel.add(estadolabel);

		estadoText.setBounds(20, 290, 140, 30);
		panel.add(estadoText);
		
		/*=========cidade==========*/
		JLabel cidadelabel = new JLabel("Cidade :");
		cidadelabel.setFont(new Font("Arial", Font.BOLD, 15));
		cidadelabel.setBounds(20, 330, 140, 30);
		panel.add(cidadelabel);

		cidadeText.setBounds(20, 360, 140, 30);
		panel.add(cidadeText);
		
		/*=========bairro==========*/
		JLabel bairrolabel = new JLabel("Bairro :");
		bairrolabel.setFont(new Font("Arial", Font.BOLD, 15));
		bairrolabel.setBounds(20, 400, 140, 30);
		panel.add(bairrolabel);

		bairroText.setBounds(20, 430, 140, 30);
		panel.add(bairroText);
		
		/*=========endereco==========*/
		JLabel enderecolabel = new JLabel("Endereco :");
		enderecolabel.setFont(new Font("Arial", Font.BOLD, 15));
		enderecolabel.setBounds(20, 470, 140, 30);
		panel.add(enderecolabel);

		enderecoText.setBounds(20, 500, 140, 30);
		panel.add(enderecoText);
		
		/*=========cep==========*/
		JLabel ceplabel = new JLabel("Cep :");
		ceplabel.setFont(new Font("Arial", Font.BOLD, 15));
		ceplabel.setBounds(20, 540, 140, 30);
		panel.add(ceplabel);

		cepText.setBounds(20, 570, 140, 30);
		panel.add(cepText);
		
		/*---------Button---------*/
		cadastroUsuario.setBounds(20, 620, 140, 30);
		panel.add(cadastroUsuario);
		
		/*
		* ActionListener: verifica se o usuario clicou em algum dos
		* buttons criados
		*/
		cadastroUsuario.addActionListener(objCadastro);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		boolean sucesso;
		
		if(src == cadastroUsuario) {
			
			try {
				String password = String.valueOf(passwordText.getPassword());
				int ddd = Integer.parseInt(dddText.getText());
				int telefone = Integer.parseInt(telefoneText.getText());
				int cep = Integer.parseInt(cepText.getText());
				
				sucesso = usuario.cadastrarUsuario(nomeText.getText(), /*sexo,*/ password, ddd, telefone, estadoText.getText(), cidadeText.getText(), bairroText.getText(), enderecoText.getText(), cep);
				
				if(sucesso == true) {
					JOptionPane.showMessageDialog(null, 
					"Usuario cadastrado com sucesso\n", null, 
					JOptionPane.INFORMATION_MESSAGE);
					
					//fecha a janela quando cadastrar o usuario
					janela.setVisible(false);
					
					
					//passa o valor null para os inputs ao finalizar a operacao
					nomeText.setText(null);
					passwordText.setText(null);
					telefoneText.setText(null);
					dddText.setText(null);
					estadoText.setText(null);
					cidadeText.setText(null);
					bairroText.setText(null);
					enderecoText.setText(null);
					cepText.setText(null);
					
				}else{
					JOptionPane.showMessageDialog(null, 
					"Os campos nao foram preenchidos corretamente\n", null, 
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

