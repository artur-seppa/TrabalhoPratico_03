package Modelo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.text.MaskFormatter;

public class Formatador {
	static Scanner ler = new Scanner(System.in);

	/**teste teste....
	/**
	 * Verifica se a String data é valida. Caso seja, é convertida em tipo Date;
	 * caso nao seja, solicita outra String data e o metodo é chamado novamente.
	 * 
	 * @param data do tipo String.
	 * @return data do tipo Date no formato "##/##/####".
	 */
	public static Date verificarData(String data) {
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		Date dataFormatada = null;

		try {
			dataFormatada = formatoData.parse(data);
		} catch (ParseException e) {
			System.out.println("\nData invalida!\nInsira uma nova data: ");
			data = ler.nextLine();
			dataFormatada = verificarData(data);
		}

		return dataFormatada;
	}

	/**
	 * Verifica se a String cpf é valida. Caso seja, é convertida em outra String no
	 * formato "###.###.###-##"; caso nao seja, solicita outra String cpf e o metodo
	 * é chamado novamente.
	 * 
	 * @param cpf do tipo String contendo apenas numeros.
	 * @return cpf do tipo String no formato "###.###.###-##".
	 */
	public static String verificarCPF(String cpf) {
		String cpfFormatado = null;
		MaskFormatter formatoCPF;

		if (cpf.length() != 11) {
			cpf = "nulo";
		}

		try {
			formatoCPF = new MaskFormatter("###.###.###-##");
			formatoCPF.setValueContainsLiteralCharacters(false);
			cpfFormatado = formatoCPF.valueToString(cpf);

		} catch (ParseException e1) {
			System.out.println("\nCPF invalido!\nInsira um novo CPF: ");
			cpf = ler.next();
			cpfFormatado = verificarCPF(cpf);
		}

		return cpfFormatado;
	}

	/**
	 * Verifica se a String rg é valida. Caso seja, é convertida em outra String no
	 * formato "#.###.###"; caso nao seja, é solicitada outra String rg e o metodo é
	 * chamado novamente.
	 * 
	 * @param rg do tipo String contendo apenas numeros.
	 * @return rg do tipo String no formato "#.###.###".
	 */
	public static String verificarRG(String rg) {
		String rgFormatado = null;
		MaskFormatter formatoRG;

		if (rg.length() != 7) {
			rg = "nulo";
		}

		try {
			formatoRG = new MaskFormatter("#.###.###");
			formatoRG.setValueContainsLiteralCharacters(false);
			rgFormatado = formatoRG.valueToString(rg);

		} catch (ParseException e1) {
			System.out.println("\nRG invalido!\nInsira um novo RG: ");
			rg = ler.next();
			rgFormatado = verificarRG(rg);
		}

		return rgFormatado;
	}

	/**
	 * Verifica se a String telefone é valida. Caso seja, é convertida em outra
	 * String no formato "(##)####-####"; caso nao seja, é solicitada outra String
	 * telefone e o metodo é chamado novamente.
	 * 
	 * @param telefone do tipo String contendo apenas numeros.
	 * @return telefone do tipo String no formato "(##)####-####".
	 */
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
<<<<<<< HEAD
=======
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
>>>>>>> branch 'modAmanda' of https://github.com/artur-seppa/TrabalhoPratico_03.git
}
