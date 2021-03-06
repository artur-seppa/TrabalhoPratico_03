package Modelo;
import java.text.ParseException;
import java.util.Scanner;
import javax.swing.text.MaskFormatter;

public class Formatador {
	private static Object Endereco = null;
	static Scanner ler = new Scanner(System.in);
/*
 * Verifica Telefone e formata
 * 
* @author Arthur Seppa Reiman
* @author Amanda Fernandes Custodio
 */
	public static String verificarTelefone(String telefone) {
		String telefoneFormatado = null;
		MaskFormatter formatoTelefone;

		if (telefone.length() != 8) {
			telefone = "nulo";
		}

		try {
			formatoTelefone = new MaskFormatter("####-####");
			formatoTelefone.setValueContainsLiteralCharacters(false);
			telefoneFormatado = formatoTelefone.valueToString(telefone);

		} catch (ParseException e1) {
			System.out.println("\nTelefone invalido!\nInsira um novo telefone: ");
			telefone = ler.next();
			telefoneFormatado = verificarTelefone(telefone);
		}

		return telefoneFormatado;
	}
	/*
	 * Verifica cep e formata
	 */
	public static String verificarCep(Object endereco2) {
		String cepFormatado = null;
		MaskFormatter formatoCep;
		
		if (((String) Endereco).length() != 8) {
			Endereco = "nulo";
		}
		
		try {
			formatoCep = new MaskFormatter("##.###-###");
			formatoCep.setValueContainsLiteralCharacters(false);
			cepFormatado = formatoCep.valueToString(Endereco);
		} catch (ParseException e1) {
			System.out.println("\nCEP invalido!\nInsira um novo CEP: ");
			Endereco = ler.next();
			cepFormatado = verificarCep(Endereco);
		}

		return cepFormatado;
	}
}
