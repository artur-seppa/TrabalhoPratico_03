package Modelo;

public class Telefone {
	/**
	 * Possui atributos com apenas dados pessoais, como ddd, telefone.
	 * 
	 * 
	 * @author Arthur Seppa Reiman
	 * @author Amanda Fernandes Custodio
	 */
	private Pessoa pessoa;
	
	private int ddd;
	private int telefone;
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public int getDdd() {
		return ddd;
	}
	public void setDdd(int ddd) {
		this.ddd = ddd;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	 
	
}
