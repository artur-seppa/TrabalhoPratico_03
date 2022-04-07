package Testes;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Roupa;
import View.TelaMenu;
import View.TelaPrincipal;

public class TesteCadastroItems {
	
	/**
	 * Teste dos metodos addItemCadastrado e getItemCadastrado.
	 */
	@Test
	
	//***********ROUPA************/
	public void testGetRoupaCadastrada() {
		Roupa roupa1 = new Roupa("vestido");
		Roupa roupa2 = new Roupa("calca jeans");
		Roupa roupa3 = new Roupa("bota");
		Roupa.addRoupaCadastrada(roupa1);
		Roupa.addRoupaCadastrada(roupa2);
		Roupa.addRoupaCadastrada(roupa3);

		assertEquals(roupa1.getNome(), Roupa.getRoupaCadastrada(0).getNome());
		assertEquals(roupa2.getNome(), Roupa.getRoupaCadastrada(1).getNome());
		assertEquals(roupa3.getNome(), Roupa.getRoupaCadastrada(2).getNome());
	}

	private void assertEquals(int i, Object addRoupaCadastrada) {
		// TODO Stub de m�todo gerado automaticamente
		
	}
	/**
	 * Teste do metodo quantidadeRoupasCadastradas.
	 */
	@Test
	public void testQuantidadeRoupasCadastradas() {
		assertEquals(0, Roupa.quantidadeRoupasCadastradas());
		
		Roupa roupa1 = new Roupa("vestido");
		Roupa roupa2 = new Roupa("cal�a jeans");
		Roupa roupa3 = new Roupa("bota");

		Roupa.addRoupaCadastrada(roupa1);
		Roupa.addRoupaCadastrada(roupa2);
		Roupa.addRoupaCadastrada(roupa3);
		
		assertEquals(3, Roupa.quantidadeRoupasCadastradas());
		
	}
	

}
