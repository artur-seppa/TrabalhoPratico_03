package Modelo;

public class Acessorio extends Produto{
	/**
	 * Possui atributos para acessorio
	 * 
	 * 
	 * @author Arthur Seppa Reiman
	 * @author Amanda Fernandes Custodio
	 */
	private String categoria;
	private String material;
	private String cor;
	private String tamanho;
	
	public Acessorio() {
		this.setTipo("colar");
		this.setMaterial("ouro");
	}
	
	
	public String getTipo() {
		return categoria;
	}

	public void setTipo(String tipo) {
		this.categoria = tipo;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
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
