package Testes;

import static org.junit.Assert.*;

import org.junit.Test;

import Modelo.Formatador;

public class TesteDoFormatador {

//Teste
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
		assertEquals("71200-100", Formatador.verificarCep("71200100"));
	}
}
