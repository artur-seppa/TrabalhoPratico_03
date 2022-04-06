<<<<<<< HEAD
package Testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import Modelo.Formatador;

public class TesteFormatador {
	

	/**
	 * Testa o metodo verificarTelefone.
	 */
	@Test
	public void testVerificarTelefone() {
		assertEquals("(61)9331-0277", Formatador.verificarTelefone("6193310277"));
	}
	/**
	 * Testa o metodo verificarCep.
	 */
	@Test
	public void testVerificarCep() {
		assertEquals("71.200-100", Formatador.verificarCep("71200100"));
	}
}
=======
//package Testes;
//
//import static org.junit.Assert.assertEquals;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import org.junit.Test;
//import Modelo.Formatador;
//
//public class TesteFormatador {
//	/**
//	 * Testa o metodo verificarData.
//	 */
//	@Test
//	public void testVerificarData() {
//		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
//		Date data = null;
//
//		try {
//			data = formatoData.parse("22/10/2019");
//		} catch (ParseException e) {
//
//		}
//
//		assertEquals(data, Formatador.verificarData("22/10/2019"));
//	}
//
//	/**
//	 * Testa o metodo verificarCPF.
//	 */
//	@Test
//	public void testVerificarCPF() {
//		assertEquals("114.564.380-99", Formatador.verificarCPF("11456438099"));
//	}
//
//	/**
//	 * Testa o metodo verificarRG.
//	 */
//	@Test
//	public void testVerificarRG() {
//		assertEquals("6.551.892", Formatador.verificarRG("6551892"));
//	}
//
//	/**
//	 * Testa o metodo verificarTelefone.
//	 */
//	@Test
//	public void testVerificarTelefone() {
//		assertEquals("(61)9331-0277", Formatador.verificarTelefone("6193310277"));
//	}
//}
>>>>>>> branch 'modArtur' of https://github.com/artur-seppa/TrabalhoPratico_03.git
