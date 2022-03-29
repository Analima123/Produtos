package Modelos;

public class Marca {

	private String nomeMarca;
	private double preco;
	
	
	
	
	
	public Marca(String[] dados) {
		
		String[] nomeMarca = dados[2].split("=");
		
		this.nomeMarca = nomeMarca[1].trim();
		
		String[] preco = dados[3].split("=");
		
		this.preco = Double.parseDouble(preco[1].trim());
	}
	
	
	public Marca() {
		
	}
	public String getNomeMarca() {
		return nomeMarca;
	}
	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
	@Override
	public String toString() {
		return nomeMarca + ", Preço =" + preco ;
	}

	
}
