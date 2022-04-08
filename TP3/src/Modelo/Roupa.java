package Modelo;

public class Roupa extends Produto{
	/**
	 *
	 * 
	 * 
	 * @author Arthur Seppa Reiman
	 * @author Amanda Fernandes Custodio
	 */
	private String categoria;
	private String estilo;
	private String cor;
	private String tecido;
	private String tamanho;
	
	public Roupa(String string) {
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
	public String getTecido() {
		return tecido;
	}
	public void setTecido(String tecido) {
		this.tecido = tecido;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public static void addRoupaCadastrada(int i) {
	}
	
	public static void addRoupaCadastrada(Roupa roupa1) {

	}
	public static Roupa getRoupaCadastrada(int i) {
		return null;
	}
	public static Object quantidadeRoupasCadastradas() {
		return null;
	}
	
	
}
