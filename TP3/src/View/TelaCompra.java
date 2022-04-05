package View;

import Controle.*;
import Modelo.Roupa;

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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaCompra{
	
	//---->classes swing(GUI)
	
	/*
	* 	JFrame == window que abre na tela do usuario
	* 	Jlabel == permite escreve na window(JFrame) em qualquer lugar
	* 	JButton == cria os objetos buttons	
	* 
	* 	Para cada classe swing chamada, instanciamos os seus objetos
	* 	com seus respectivos atributos e metodos das classes. 
	*/
	
	private static JFrame janela = new JFrame("Compra");
	private static JPanel panel = new JPanel();
	
	private static JTextField nomeText = new JTextField(20);
	private static JPasswordField passwordText = new JPasswordField(20);
	private static JTextField telefoneText = new JTextField(9);
	private static JTextField dddText = new JTextField(3);
	
	//instancia o TIPO ControleUsuario === BD
	private static ControleUsuario usuario;
	private static DetalheProduto objCadastro = new DetalheProduto();
	private static int idUser;
	private static int qtdProdutos;
	
	public void imprimirTelaCompra(/*ControleUsuario u, int id, int size*/){
	    
//		/*
//		 * Obtem o "BD" criado na tela anterior, com seus users ja pre fabricados,
//		 * e passa essa configuracao ao obj usuario de mesmo tipo ControleUsuario
//		 */
//		usuario = u;
//		idUser = id;
//		qtdProdutos = size;
		
		janela.setVisible(true);
		
		janela.setSize(300, 300);
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
		
		/*=========Compra==========*/
		JLabel titulo = new JLabel("Finalizando Compra");
		titulo.setBounds(80, 20, 160, 30);
		panel.add(titulo);
		
		JLabel pagamentoLabel = new JLabel("Forma de pagamento : ");
		pagamentoLabel.setBounds(30, 60, 180, 30);
		panel.add(pagamentoLabel);
		
		String vetor[] = {"cartao de credito", "cartao de debito"};
		
		JComboBox combobox = new JComboBox(vetor);
		combobox.setBounds(30, 100, 160, 30);
		panel.add(combobox);
		
		JTextField pagamento = new JTextField();
		pagamento.setBounds(30, 140, 160, 30);
		panel.add(pagamento);
		
		JButton FinalizaPagamento = new JButton("Finalizar Pagamento");
		FinalizaPagamento.setBounds(30, 180, 160, 30);
		panel.add(FinalizaPagamento);
		
		FinalizaPagamento.addActionListener(
				new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	if(pagamento.getText() != null && pagamento.getText().length()>0) {
		            		
		            	
			            	JOptionPane.showMessageDialog(null, 
			    			"Obrigado pela compra, volte sempre !! \n", null, 
			    			JOptionPane.INFORMATION_MESSAGE);
			            	
			            	janela.setVisible(false);
		            	
		            	}else {
		            		
		            		JOptionPane.showMessageDialog(null, 
					    	"Por favor, insira a forma de pagamento\n", null, 
					    	JOptionPane.INFORMATION_MESSAGE);
		            		
		            	}
		            	
		            }
		        });

		
	}



	
//
//		/*=========Cor==========*/
//		JLabel fraseCor = new JLabel("cor :");
//		fraseCor.setBounds(20, 90, 160, 30);
//		panel.add(fraseCor);
//		
//		cor = new JLabel(roupa[cont].getCor());
//		cor.setBounds(100, 90, 160, 30);
//		panel.add(cor);
//;
//		/*=========estilo==========*/
//		JLabel fraseEstilo = new JLabel("estilo :");
//		fraseEstilo.setBounds(20, 130, 160, 30);
//		panel.add(fraseEstilo);
//
//		estilo = new JLabel(roupa[cont].getEstilo());
//		estilo.setBounds(100, 130, 160, 30);
//		panel.add(estilo);
//		
//		/*=========tecido==========*/
//		JLabel fraseTecido = new JLabel("tecido :");
//		fraseTecido.setBounds(20, 170, 160, 30);
//		panel.add(fraseTecido);
//		
//		tecido = new JLabel(roupa[cont].getTecido());
//		tecido.setBounds(100, 170, 160, 30);
//		panel.add(tecido);
//		
//		/*=========genero==========*/
//		JLabel fraseGenero = new JLabel("genero :");
//		fraseGenero.setBounds(20, 210, 160, 30);
//		panel.add(fraseGenero);
//		
//		genero = new JLabel(roupa[cont].getGenero());
//		genero.setBounds(100, 210, 160, 30);
//		panel.add(genero);
//		
//		/*=========preco==========*/
//		JLabel frasePreco = new JLabel("preco :");
//		frasePreco.setBounds(20, 250, 160, 30);
//		panel.add(frasePreco);
//		
//		preco = new JLabel("R$ " + roupa[cont].getPreco());
//		preco.setBounds(100, 250, 160, 30);
//		panel.add(preco);

//	}
//	
//	public static void CloseDetalhes() {
//		//passa o valor null para os inputs ao finalizar a operacao
//		descricao.setText(null);
//		tamanho.setText(null);
//		cor.setText(null);
//		estilo.setText(null);
//		tecido.setText(null);
//		genero.setText(null);
//		preco.setText(null);
//		
//		janela.setVisible(false);
//		
//	}

}


