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
}
