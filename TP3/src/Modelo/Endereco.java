package Modelo;

public class Endereco {
	/*
	 * 
	 * 
	* @author Arthur Seppa Reiman
	* @author Amanda Fernandes Custodio
	*/
	private Pessoa pessoa;
	
	private int cep;
	private String bairro;
	private String estado;
	private String cidade; 
	private String endereco;
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public static int length() {
		/*
		 *  tipo referente a formatar cep
		 */
		return 0;
	}
	
	
}
