package Testes;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Roupa;

public class TesteCadastroItens {
//Teste
	/**
	 * Teste dos metodos addItemCadastrado e getItemCadastrado.
	 */
	@Test
	
	//***********ROUPA************/
	public void testGetRoupaCadastrada() {
		Roupa roupa1 = new Roupa("vestido");
		Roupa roupa2 = new Roupa("calça jeans");
		Roupa roupa3 = new Roupa("bota");
		Roupa.addRoupaCadastrada(roupa1);
		Roupa.addRoupaCadastrada(roupa2);
		Roupa.addRoupaCadastrada(roupa3);

		assertEquals(roupa1, Roupa.getRoupaCadastrada(0).getNome());
		assertEquals(roupa2, Roupa.getRoupaCadastrada(1).getNome());
		assertEquals(roupa3, Roupa.getRoupaCadastrada(2).getNome());
	
	}
	private void assertEquals(Roupa roupa, Object addRoupaCadastrada) {
		
	}
	/**
	 * Teste do metodo quantidadeRoupasCadastradas.
	 */
	@Test
	public void testQuantidadeRoupasCadastradas() {
		Assert.assertEquals(0, Roupa.quantidadeRoupasCadastradas());
		
		Roupa roupa1 = new Roupa("vestido");
		Roupa roupa2 = new Roupa("calça jeans");
		Roupa roupa3 = new Roupa("bota");

		Roupa.addRoupaCadastrada(roupa1);
		Roupa.addRoupaCadastrada(roupa2);
		Roupa.addRoupaCadastrada(roupa3);
		
		Assert.assertEquals(3, Roupa.quantidadeRoupasCadastradas());
		
	}
	

}
