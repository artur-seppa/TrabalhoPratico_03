package Modelo;

public class Sapato extends Produto{
	/**
	 * Possui atributos para sapato
	 * 
	 * 
	 * @author Arthur Seppa Reiman
	 * @author Amanda Fernandes Custodio
	 */
	private String categoria;
	private String estilo;
	private String cor;
	private String tamanho;
	
	public Sapato() {
		this.setCor("vermelho");
		this.setGenero("feminino");
	}
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getEstilo() {
		return estilo;
	}
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
}
