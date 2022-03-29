package Modelos;

public class Produto {

	private String cat;
	private String nome;
	private Marca marca;
	
	
	
	
	public Produto(String dados) {
		
		
		String[] atributos = dados.split(",");
		
		String[]  cat = atributos[0].split("=");
		String[]  nome = atributos[1].split("=");
		
		Marca marcaProduto = new Marca(atributos);
		
		this.cat = cat[1].trim();
		this.nome = nome[1].trim();
		this.marca = marcaProduto;
	}
	
	public Produto() {
		
	}
	
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	
	@Override
	public String toString() {
		return "Categoria = " + cat + ", Nome= " + nome + ", Marca = " + marca;
	}
	
	
	
	

	
	
	
}
