package View;

import Controle.*;
import Modelo.Roupa;

import java.awt.Font;

/*
 * 	JFrame == window que abre na tela do usuario
 * 	Jlabel == permite escreve na window(JFrame) em qualquer lugar
 * 	JButton == cria os objetos buttons	
 * 
 * 	Para cada classe swing chamada, instanciamos os seus objetos
 * 	com seus respectivos atributos e metodos das classes. 
 */

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DetalheProduto{
	
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
	 * @author Arthur Seppa Reiman
	 * @author Amanda Fernandes Custodio
	*/
	
	private static JFrame janela = new JFrame("Detalhes do produto");
	private static JPanel panel = new JPanel();
	
	
	private static JLabel descricao = new JLabel();
	private static JLabel tamanho = new JLabel();
	private static JLabel cor = new JLabel();
	private static JLabel estilo = new JLabel();
	private static JLabel tecido = new JLabel();
	private static JLabel user = new JLabel();
	private static JLabel preco = new JLabel();
	private static JLabel categoria = new JLabel();
	private static JLabel marca = new JLabel();
	private static JLabel condicao = new JLabel();
	
	
	
	/*
	 * instancia o TIPO ControleUsuario === BD
	 */
	private static ControleUsuario usuario;
	private static DetalheProduto objCadastro = new DetalheProduto();
	private static int cont;
	
	public void imprimirTelaDetalhe(ControleUsuario u, int i){
	    
		/*
		 * Obtem o "BD" criado na tela anterior, com seus users ja pre fabricados,
		 * e passa essa configuracao ao obj usuario de mesmo tipo ControleUsuario
		 */
		usuario = u;
		cont = i;
		
		janela.setVisible(true);
		
		janela.setSize(300, 450);
		janela.add(panel);
		placeComponents(panel);
		
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
		
		Roupa roupa[] = new Roupa[100];
		roupa[cont] = usuario.getRoupa(cont);
		
		descricao = new JLabel(roupa[cont].getDescricao());
		descricao.setFont(new Font("Arial", Font.BOLD, 14));
		descricao.setBounds(100, 10, 250, 30);		
		panel.add(descricao);
		
		/*=========Tamanho==========*/
		JLabel fraseTamanho = new JLabel("tamanho :");
		fraseTamanho.setBounds(20, 50, 160, 30);
		panel.add(fraseTamanho);
		
		tamanho = new JLabel(roupa[cont].getTamanho());
		tamanho.setBounds(100, 50, 160, 30);
		panel.add(tamanho);

		/*=========Cor==========*/
		JLabel fraseCor = new JLabel("cor :");
		fraseCor.setBounds(20, 90, 160, 30);
		panel.add(fraseCor);
		
		cor = new JLabel(roupa[cont].getCor());
		cor.setBounds(100, 90, 160, 30);
		panel.add(cor);
;
		/*=========estilo==========*/
		JLabel fraseEstilo = new JLabel("estilo :");
		fraseEstilo.setBounds(20, 130, 160, 30);
		panel.add(fraseEstilo);

		estilo = new JLabel(roupa[cont].getEstilo());
		estilo.setBounds(100, 130, 160, 30);
		panel.add(estilo);
		
		/*=========tecido==========*/
		JLabel fraseTecido = new JLabel("tecido :");
		fraseTecido.setBounds(20, 170, 160, 30);
		panel.add(fraseTecido);
		
		tecido = new JLabel(roupa[cont].getTecido());
		tecido.setBounds(100, 170, 160, 30);
		panel.add(tecido);
		
		/*=========User==========*/
		JLabel fraseusuario = new JLabel("Usuario :");
		fraseusuario.setBounds(20, 210, 160, 30);
		panel.add(fraseusuario);
		
		user = new JLabel(roupa[cont].getPessoa().getNome());
		user.setBounds(100, 210, 160, 30);
		panel.add(user);
		
		/*=========preco==========*/
		JLabel frasePreco = new JLabel("preco :");
		frasePreco.setBounds(20, 250, 160, 30);
		panel.add(frasePreco);
		
		preco = new JLabel("R$ " + roupa[cont].getPreco());
		preco.setBounds(100, 250, 160, 30);
		panel.add(preco);
		
		/*=========categoria==========*/
		JLabel fraseCategoria = new JLabel("Categoria:");
		fraseCategoria.setBounds(20, 290, 160, 30);
		panel.add(fraseCategoria);
		
		categoria = new JLabel(roupa[cont].getCategoria());
		categoria.setBounds(100, 290, 160, 30);
		panel.add(categoria);
		
		/*=========marca==========*/
		JLabel fraseMarca = new JLabel("Marca :");
		fraseMarca.setBounds(20, 330, 160, 30);
		panel.add(fraseMarca);
		
		marca = new JLabel(roupa[cont].getMarca());
		marca.setBounds(100, 330, 160, 30);
		panel.add(marca);
		
		/*=========condicao==========*/
		JLabel fraseCondicao = new JLabel("Condicao :");
		fraseCondicao.setBounds(20, 370, 160, 30);
		panel.add(fraseCondicao);
		
		condicao = new JLabel(roupa[cont].getMarca());
		condicao.setBounds(100, 370, 160, 30);
		panel.add(condicao);

	}
	
	public static void CloseDetalhes() {
		/*
		 * passa o valor null para os inputs ao finalizar a operacao
		 */
		descricao.setText(null);
		tamanho.setText(null);
		cor.setText(null);
		estilo.setText(null);
		tecido.setText(null);
		user.setText(null);
		preco.setText(null);
		categoria.setText(null);
		marca.setText(null);
		condicao.setText(null);
		
		janela.setVisible(false);
		
	}

	public static DetalheProduto getObjCadastro() {
		return objCadastro;
	}

	public static void setObjCadastro(DetalheProduto objCadastro) {
		DetalheProduto.objCadastro = objCadastro;
	}

}


