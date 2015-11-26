public class Bike 
{
	private int preco;
	private String cor;
	private String numSerie;
	private EspecBike spec;
	
	public Bike(int preco, String cor, String numSerie, EspecBike spec) {
		this.preco = preco;
		this.cor = cor;
		this.numSerie = numSerie;
		this.spec = spec;
	}

	public int getPreco() 
	{
		return preco;
	}
	
	public void setPreco(int preco) 
	{
		this.preco = preco;
	}
	
	public String getCor() 
	{
		return cor;
	}
	
	public void setCor(String cor) 
	{
		this.cor = cor;
	}
	
	public String getNumSerie() 
	{
		return numSerie;
	}
	
	public void setNumSerie(String numSerie) 
	{
		this.numSerie = numSerie;
	}
	
	public EspecBike getSpec()
	{
		return spec;
	}
	
	public String toString(){
		return "Preco: "+preco+" \nCor: "+cor+" \nNumero de Serie: "+numSerie+" \nEspecificacoes: \n"+spec;
	}
}
