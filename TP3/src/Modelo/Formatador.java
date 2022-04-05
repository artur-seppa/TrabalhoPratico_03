package Modelo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.text.MaskFormatter;

public class Formatador {
	static Scanner ler = new Scanner(System.in);

	public static String verificarTelefone(String telefone) {
		String telefoneFormatado = null;
		MaskFormatter formatoTelefone;

		if (telefone.length() != 10) {
			telefone = "nulo";
		}

		try {
			formatoTelefone = new MaskFormatter("(##)####-####");
			formatoTelefone.setValueContainsLiteralCharacters(false);
			telefoneFormatado = formatoTelefone.valueToString(telefone);

		} catch (ParseException e1) {
			System.out.println("\nTelefone invalido!\nInsira um novo telefone: ");
			telefone = ler.next();
			telefoneFormatado = verificarTelefone(telefone);
		}

		return telefoneFormatado;
	}
}
